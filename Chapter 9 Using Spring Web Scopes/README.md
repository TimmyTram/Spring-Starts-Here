- Singleton - The default scope for a bean, is unique
- Prototype - Scope of bean when it is created for every new request

# Bean Scopes relevant to web apps
- Request Scopes - Spring creates a bean for every http request and only exists for that specific http request
- Session Scope - Spring creates a bean and bean stays in server memory for entire http session.
- Application Scope - Bean is unique, exists and only available while app is running