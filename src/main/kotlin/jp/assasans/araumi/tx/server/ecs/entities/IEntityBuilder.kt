package jp.assasans.araumi.tx.server.ecs.entities

import jp.assasans.araumi.tx.server.ecs.entities.templates.TemplateAccessor
import jp.assasans.araumi.tx.server.ecs.components.IComponent
import jp.assasans.araumi.tx.server.ecs.entities.templates.IEntityTemplate

interface IEntityBuilder {
    val id: Long
    var templateAccessor: TemplateAccessor?
    val components: MutableSet<IComponent>

    fun build(): IEntity
}

fun IEntityBuilder.templateAccessor(templateAccessor: TemplateAccessor) {
    this.templateAccessor = templateAccessor
}

fun IEntityBuilder.templateAccessor(template: IEntityTemplate, configPath: String?) {
    this.templateAccessor = TemplateAccessor(template, configPath)
}

fun IEntityBuilder.component(component: IComponent) {
    components.add(component)
}
