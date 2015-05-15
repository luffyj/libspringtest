package org.luffy.lib.libspringtest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 * Created by luffy on 2015/5/15.
 * <p>Spring web测试基类</p> *
 * <p>典型测试如下</p>
 * <pre class="code">
 *     <code>@</code>ActiveProfiles("test")
 *     <code>@</code>ContextConfiguration(loader = Abc.class)
 *     <code>@</code>RunWith(SpringJUnit4ClassRunner.class)
 * </pre>
 * @see SpringContextLoader
 * @see org.springframework.test.context.ContextConfiguration
 * @author luffy luffy.ja at gmail.com
 */
@WebAppConfiguration
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringWebTest {

    @Inject
    protected WebApplicationContext context;
    @Inject
    protected ServletContext servletContext;
    @Autowired
    protected FilterChainProxy springSecurityFilter;
    @Autowired
    protected MockHttpServletRequest request;
//    @Autowired
//    private FilterChainProxy springSecurityFilter;

    protected MockMvc mockMvc;
}
