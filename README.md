Sample code to serialize the XSD in src/main/resources using JAXB and Jackson.

JSON Output:

    {
      "links" : [ {
        "value" : "AgGateway Home Page",
        "rel" : "aggateway-home",
        "href" : "http://www.aggateway.org"
      }, {
        "value" : "AgGateway Wiki",
        "rel" : "aggateway-wiki",
        "href" : "https://aggateway.atlassian.net/"
      } ]
    }

XML Output:

    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <links>
        <link rel="aggateway-home" href="http://www.aggateway.org">AgGateway Home Page</link>
        <link rel="aggateway-wiki" href="https://aggateway.atlassian.net/">AgGateway Wiki</link>
    </links>

