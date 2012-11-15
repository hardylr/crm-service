Get Customer Info

Projeto de exemplo do uso do Apache CXF com Spring 3.1.1 e WSS4J para a criação de Web Services com atributo WS-Security. 

Exemplo de XML de Teste do SoapUI

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.crm.alexandre.com.br/">
   <soapenv:Header>
    <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
      <wsse:UsernameToken>
        <wsse:Username>alexandre</wsse:Username>
        <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">root</wsse:Password>        
      </wsse:UsernameToken>
    </wsse:Security>   
   </soapenv:Header>

   <soapenv:Body>
      <ser:getCustomerInfo>         
         <customerServiceRequest>
            <customerId>11.111.111-1</customerId>
         </customerServiceRequest>
      </ser:getCustomerInfo>
   </soapenv:Body>
</soapenv:Envelope>