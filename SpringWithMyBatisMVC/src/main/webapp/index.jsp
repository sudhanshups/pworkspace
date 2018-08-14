<a href=spring/viewemp>View New Employees!!!</a>

<pre>
Steps:

Create data source bean
Inject the dta source in SqlSessionFactoryBean
This SqlSessionFactoryBean will have information of sql configuration where we can specify our
mapper resource and each sql mapper (where we will write the query) will have namespace associated with it
So in a way SqlSessionFactory will have information of all the namespace (namespace will be used to fire a query).

This SqlSessionFactoryBean is then inject to SqlSessionTemplate (sqlSession) which is then injected to dao class


Note:
In the given example in data-mapper the result from query is auto binded to Emp class because the field name of the class
is same otherwise we had to define resultMap 

Life cycle:
the SqlSessionFactory should exist for the duration of your application execution

SqlSession
Each thread should have its own instance of SqlSession. Instances of SqlSession are not to be shared
Each thread should have one instance of SqlSession.
ref: http://www.samuelsimon.me/blog/2014/03/spring-mvc-tutorial-1-simple-mvc-with-postgresql/
</pre>