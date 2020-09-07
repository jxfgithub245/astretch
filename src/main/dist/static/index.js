var MyTabModel = Backbone.Collection.extend({
    url: 'data/myplugindata.json'
})

class MyLayout extends allure.components.AppLayout {

    initialize() {
        this.model = new MyTabModel();
    }

    loadData() {
        return this.model.fetch();
    }

    getContentView() {
        const template = function (data) {
            this.html = '<h3 class="pane__title">My Tab</h3>';
            for (var item of data.items) {
                this.html += '<p>' + item.attributes.name + ' says: ' + item.attributes.sounds + '</p>';
            }
            return html;
        }

        var MyView = Backbone.Marionette.View.extend({
            template: template,

            render: function () {
                this.$el.html(this.template(this.options));
                return this;
            }
        })

    }
}

allure.api.addTab('mytab', {
    title: 'My Tab', icon: 'fa fa-trophy',
    route: 'mytab',
    onEnter: (function () {
        return new MyLayout()
    })
});

class MyWidget extends Backbone.Marionette.View {

    template(data) {
        return widgetTemplate(data)
    }

    serializeData() {
        return {
            items: this.model.get('items'),
        }
    }
}

allure.api.addWidget('mywidget', MyWidget);