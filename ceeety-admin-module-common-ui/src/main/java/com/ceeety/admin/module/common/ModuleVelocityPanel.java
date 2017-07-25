package com.ceeety.admin.module.common;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.IMarkupCacheKeyProvider;
import org.apache.wicket.markup.IMarkupResourceStreamProvider;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.resource.ResourceUtil;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;
import org.apache.wicket.util.string.Strings;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月24日
 */
public abstract class ModuleVelocityPanel extends Panel
        implements IMarkupResourceStreamProvider, IMarkupCacheKeyProvider {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("rawtypes")
    public static ModuleVelocityPanel forTemplateResource(final String id, final IModel<? extends Map> model,
            final IResourceStream templateResource) {
        if (templateResource == null) {
            throw new IllegalArgumentException("argument templateResource must be not null");
        }

        return new ModuleVelocityPanel(id, model) {
            private static final long serialVersionUID = 1L;

            @Override
            protected IResourceStream getTemplateResource() {
                return templateResource;
            }
        };
    }

    private transient String stackTraceAsString;

    private transient String evaluatedTemplate;

    /**
     * Construct.
     * 
     * @param id
     *            Component id
     * @param templateResource
     *            The velocity template as a string resource
     * @param model
     *            Model with variables that can be substituted by Velocity.
     */
    @SuppressWarnings("rawtypes")
    public ModuleVelocityPanel(final String id, final IModel<? extends Map> model) {
        super(id, model);
    }

    /**
     * Gets a reader for the velocity template.
     * 
     * @return reader for the velocity template
     */
    private Reader getTemplateReader() {
        final IResourceStream resource = getTemplateResource();
        if (resource == null) {
            throw new IllegalArgumentException("getTemplateResource must return a resource");
        }

        final String template = ResourceUtil.readString(resource, Charset.forName("utf-8"));
        if (template != null) {
            return new StringReader(template);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
        if (!Strings.isEmpty(stackTraceAsString)) {
            replaceComponentTagBody(markupStream, openTag, Strings.toMultilineMarkup(stackTraceAsString));
        } else if (!parseGeneratedMarkup()) {
            if (size() > 0) {
                throw new WicketRuntimeException("Components cannot be added if the generated markup should not be parsed.");
            }

            if (evaluatedTemplate == null) {
                getMarkupResourceStream(null, null);
            }
            replaceComponentTagBody(markupStream, openTag, evaluatedTemplate);
        } else {
            super.onComponentTagBody(markupStream, openTag);
        }
    }

    /**
     * Either print or rethrow the throwable.
     * 
     * @param exception
     *            the cause
     * @param markupStream
     *            the markup stream
     * @param openTag
     *            the open tag
     */
    private void onException(final Exception exception) {
        if (!throwVelocityExceptions()) {
            stackTraceAsString = Strings.toString(exception);
        } else {
            throw new WicketRuntimeException(exception);
        }
    }

    /**
     * Gets whether to escape HTML characters.
     * 
     * @return whether to escape HTML characters. The default value is false.
     */
    protected boolean escapeHtml() {
        return false;
    }

    /**
     * Returns the template resource passed to the constructor.
     * 
     * @return The template resource
     */
    protected abstract IResourceStream getTemplateResource();

    /**
     * Evaluates the template and returns the result.
     * 
     * @param templateReader
     *            used to read the template
     * @return the result of evaluating the velocity template
     */
    private String evaluateVelocityTemplate(final Reader templateReader) {
        if (evaluatedTemplate == null) {
            @SuppressWarnings("rawtypes")
            final Map map = (Map) getDefaultModelObject();

            final VelocityContext ctx = new VelocityContext(map);

            StringWriter writer = new StringWriter();

            final String logTag = getId();
            try {
                Properties properties = new Properties();
                properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
                properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
                properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
                properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
                Velocity.init(properties);
                Velocity.evaluate(ctx, writer, logTag, templateReader);

                evaluatedTemplate = writer.toString();

                if (escapeHtml()) {
                    evaluatedTemplate = Strings.escapeMarkup(evaluatedTemplate).toString();
                }
                return evaluatedTemplate;
            } catch (Exception e) {
                onException(e);
            }
            return null;
        }
        return evaluatedTemplate;
    }

    /**
     * Gets whether to parse the resulting Wicket markup.
     * 
     * @return whether to parse the resulting Wicket markup. The default is
     *         false.
     */
    protected boolean parseGeneratedMarkup() {
        return false;
    }

    /**
     * Whether any velocity exception should be trapped and displayed on the
     * panel (false) or thrown up to be handled by the exception mechanism of
     * Wicket (true). The default is false, which traps and displays any
     * exception without having consequences for the other components on the
     * page.
     * <p>
     * Trapping these exceptions without disturbing the other components is
     * especially useful in CMS like applications, where 'normal' users are
     * allowed to do basic scripting. On errors, you want them to be able to
     * have them correct them while the rest of the application keeps on
     * working.
     * 
     * @return Whether any velocity exceptions should be thrown or trapped. The
     *         default is false.
     */
    protected boolean throwVelocityExceptions() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final IResourceStream getMarkupResourceStream(final MarkupContainer container,
            final Class<?> containerClass) {
        Reader reader = getTemplateReader();
        if (reader == null) {
            throw new WicketRuntimeException("could not find velocity template for panel: " + this);
        }

        // evaluate the template and return a new StringResourceStream
        StringBuilder sb = new StringBuilder();
        sb.append("<wicket:panel>");
        sb.append(evaluateVelocityTemplate(reader));
        sb.append("</wicket:panel>");
        return new StringResourceStream(sb.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getCacheKey(final MarkupContainer container, final Class<?> containerClass) {
        // don't cache the evaluated template
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDetach() {
        super.onDetach();
        stackTraceAsString = null;
        evaluatedTemplate = null;
    }
}
