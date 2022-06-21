package tech.jhipster.lite.generator.client.vue.core.domain;

import static tech.jhipster.lite.generator.module.infrastructure.secondary.JHipsterModulesAssertions.*;

import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.common.domain.FileUtils;
import tech.jhipster.lite.generator.module.domain.JHipsterModule;
import tech.jhipster.lite.generator.module.domain.JHipsterModulesFixture;
import tech.jhipster.lite.generator.module.domain.properties.JHipsterModuleProperties;

@UnitTest
class VueModulesFactoryTest {

  private static final VueModulesFactory factory = new VueModulesFactory();

  @Test
  void shouldCreateVueModule() {
    JHipsterModuleProperties properties = JHipsterModulesFixture
      .propertiesBuilder(FileUtils.tmpDirForTest())
      .basePackage("com.jhipster.test")
      .build();

    JHipsterModule module = factory.buildVueModule(properties);

    //@formatter:off
    assertThatModuleWithFiles(module, packageJsonFile())
      .createFile("package.json")
        .containing(nodeDependency("vue"))
        .containing(nodeDependency("@rushstack/eslint-patch"))
        .containing(nodeDependency("@types/jest"))
        .containing(nodeDependency("@typescript-eslint/parser"))
        .containing(nodeDependency("@vitejs/plugin-vue"))
        .containing(nodeDependency("@vue/eslint-config-typescript"))
        .containing(nodeDependency("@vue/test-utils"))
        .containing(nodeDependency("eslint"))
        .containing(nodeDependency("eslint-config-prettier"))
        .containing(nodeDependency("eslint-plugin-vue"))
        .containing(nodeDependency("jest"))
        .containing(nodeDependency("jest-sonar-reporter"))
        .containing(nodeDependency("jest-transform-stub"))
        .containing(nodeDependency("ts-jest"))
        .containing(nodeDependency("typescript"))
        .containing(nodeDependency("vite"))
        .containing(nodeDependency("vue-jest"))
        .containing(nodeDependency("vue-tsc"))
        .containing(nodeDependency("@types/sinon"))
        .containing(nodeDependency("sinon"))
        .containing(nodeDependency("axios"))
        .containing(nodeDependency("vue-router"))
        .containing("\"build\": \"vue-tsc --noEmit && vite build --emptyOutDir\"")
        .containing("\"dev\": \"vite\"")
        .containing("\"jest\": \"jest src/test/javascript/spec --logHeapUsage --maxWorkers=2 --no-cache\"")
        .containing("\"preview\": \"vite preview\"")
        .containing("\"start\": \"vite\"")
        .containing("\"test\": \"npm run jest --\"")
        .containing("\"test:watch\": \"npm run jest -- --watch\"")
        .containing("  \"jestSonar\": {\n    \"reportPath\": \"target/test-results/jest\",\n    \"reportFile\": \"TESTS-results-sonar.xml\"\n  },")
        .and()
      .createPrefixedFiles("", ".eslintrc.js", "jest.config.js", "tsconfig.json", "vite.config.ts")
      .createFiles("src/main/webapp/app/http/AxiosHttp.ts")
      .createPrefixedFiles("src/test/javascript/spec/http", "AxiosHttp.spec.ts", "AxiosHttpStub.ts", "AxiosStub.ts")
      .createFiles("src/main/webapp/index.html")
      .createPrefixedFiles("src/main/webapp/app", "env.d.ts")
      .createPrefixedFiles("src/main/webapp/app/common/primary/app", "App.component.ts", "index.ts", "App.html", "App.vue")
      .createPrefixedFiles("src/main/webapp/content/images", "JHipster-Lite-neon-green.png", "VueLogo.png")
      .createFiles("src/test/javascript/spec/common/primary/app/App.spec.ts")
      .createPrefixedFiles("src/main/webapp/app/common/primary/homepage", "Homepage.component.ts", "Homepage.html","Homepage.vue", "index.ts")
      .createFiles("src/test/javascript/spec/common/primary/homepage/Homepage.spec.ts")
      .createFiles("src/main/webapp/app/router/router.ts", "src/test/javascript/spec/router/Router.spec.ts")
      .createFile("src/main/webapp/app/main.ts")
        .containing("import router from './router/router';")
        .containing("app.use(router);")
        .and()
      .createPrefixedFiles("src/main/webapp/app/common/domain", "Logger.ts", "Message.ts")
      .createFiles("src/main/webapp/app/common/secondary/ConsoleLogger.ts")
      .createFiles("src/test/javascript/spec/common/domain/Logger.fixture.ts")
      .createFiles("src/test/javascript/spec/common/secondary/ConsoleLogger.spec.ts");
    //@formatter:on
  }

  private static String nodeDependency(String dependency) {
    return "\"" + dependency + "\": \"1.1.1\"";
  }

  @Test
  void shouldCreatePiniaModule() {
    JHipsterModuleProperties properties = JHipsterModulesFixture
      .propertiesBuilder(FileUtils.tmpDirForTest())
      .basePackage("com.jhipster.test")
      .build();

    JHipsterModule module = factory.buildPiniaModule(properties);

    assertThatModuleWithFiles(
      module,
      packageJsonFile(),
      new ModuleFile("src/test/resources/projects/vue/main.ts.template", "src/main/webapp/app/main.ts")
    )
      .createFile("package.json")
      .containing("\"pinia\": \"1.1.1\"")
      .containing("\"pinia-plugin-persist\": \"1.1.1\"")
      .containing("\"@pinia/testing\": \"1.1.1\"")
      .and()
      .createFile("src/main/webapp/app/main.ts")
      .containing("import {createPinia} from 'pinia';")
      .containing("import piniaPersist from 'pinia-plugin-persist'")
      .containing(
        """
                const pinia = createPinia();
                pinia.use(piniaPersist);
                app.use(pinia);
                """
      );
  }
}
