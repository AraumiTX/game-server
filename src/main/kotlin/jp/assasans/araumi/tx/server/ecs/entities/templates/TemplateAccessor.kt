package jp.assasans.araumi.tx.server.ecs.entities.templates

data class TemplateAccessor(
  var template: IEntityTemplate,
  val configPath: String?
)