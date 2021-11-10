package tech.jhipster.forge.generator.server.springboot.banner.domain;

import tech.jhipster.forge.generator.project.domain.Project;

public interface BannerService {
  void addBannerJHipsterV7(Project project);
  void addBannerJHipsterV7React(Project project);
  void addBannerJHipsterV7Vue(Project project);
  void addBannerJHipsterV2(Project project);
  void addBannerJHipsterV3(Project project);
}
