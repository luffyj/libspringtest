package org.luffy.lib.libspringtest;

import org.luffy.lib.libspring.config.JpaConfig;
import org.luffy.lib.libspring.config.RuntimeConfig;
import org.luffy.lib.libspring.config.SecurityConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by luffy on 2015/5/15.
 * <p>需要作为ContextLoader参数放置在 {@link org.springframework.test.context.ContextConfiguration}中 比如：</p>
 *
 * <pre class="code">
 *     <code>@</code>ContextConfiguration(loader = Abc.class)
 *     <code>@</code>RunWith(SpringJUnit4ClassRunner.class)
 * </pre>
 * @author luffy luffy.ja at gmail.com
 */
public abstract class SpringContextLoader extends AnnotationConfigContextLoader {

    protected abstract Class<? extends SecurityConfig> securityConfig();

    protected abstract Class<? extends RuntimeConfig> runtimeConfig();

    protected abstract Class<?>[] getCoreRootConfigClasses();

    @Override
    protected Class<?>[] detectDefaultConfigurationClasses(Class<?> declaringClass) {
        ArrayList<Class<?>> list = new ArrayList(Arrays.asList(super.detectDefaultConfigurationClasses(declaringClass)));

        list.add(securityConfig());
        list.add(runtimeConfig());
        list.add(JpaConfig.class);
        list.addAll(Arrays.asList(getCoreRootConfigClasses()));

        return list.toArray(new Class[list.size()]);
    }
}
