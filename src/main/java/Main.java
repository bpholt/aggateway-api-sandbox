import generated.Link;
import generated.Links;
import generated.ObjectFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class Main {

    private static final ObjectFactory objectFactory = new ObjectFactory();

    public static void main(final String... args) throws Exception {
        final Links links = buildLinks();

        final String json = writeJson(links);
        System.out.println(json);

        final String xml = writeXml(links);
        System.out.println(xml);
    }

    private static String writeXml(final Links links) throws JAXBException {
        final Marshaller marshaller = JAXBContext.newInstance(links.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final StringWriter writer = new StringWriter();
        marshaller.marshal(links, writer);
        return writer.toString();
    }

    private static String writeJson(final Links links) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().withAnnotationIntrospector(new JaxbAnnotationIntrospector());
        final StringWriter jsonWriter = new StringWriter();
        final JsonGenerator gen = mapper.getJsonFactory().createJsonGenerator(jsonWriter);
        gen.useDefaultPrettyPrinter();

        mapper.writeValue(gen, links);
        return jsonWriter.toString();
    }

    private static Links buildLinks() {
        final Links links = objectFactory.createLinks();
        links.getLink().add(buildLink("http://www.aggateway.org", "aggateway-home", "AgGateway Home Page"));
        links.getLink().add(buildLink("https://aggateway.atlassian.net/", "aggateway-wiki", "AgGateway Wiki"));
        return links;
    }

    private static Link buildLink(final String href, final String rel, final String value) {
        final Link link = objectFactory.createLink();
        link.setHref(href);
        link.setRel(rel);
        link.setValue(value);
        return link;
    }
}
