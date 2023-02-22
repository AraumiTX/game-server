package jp.assasans.araumi.tx.server.ecs

interface IEntityBuilder {
  val id: Long
  var templateAccessor: TemplateAccessor?
  val components: MutableSet<IComponent>

  fun build(): IEntity
}

fun IEntityBuilder.templateAccessor(templateAccessor: TemplateAccessor) {
  this.templateAccessor = templateAccessor
}

fun IEntityBuilder.templateAccessor(id: Long, configPath: String?) {
  this.templateAccessor = TemplateAccessor(id, configPath)
}

fun IEntityBuilder.component(component: IComponent) {
  components.add(component)
}
