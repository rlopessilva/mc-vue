<template>
  <div class="menu">
    <md-list v-for="collab in collabList" id="menu">
      <md-list-item>
        <md-avatar class="md-avatar-icon md-primary">
          <md-icon md-iconset="fa fa-home"></md-icon>
        </md-avatar>
        <span>{{collab.firstName}}  {{ collab.lastName}}</span>
      </md-list-item>
    </md-list>
    <md-button class="md-icon-button md-raised md-accent button-add">
      <md-icon @click.native="openDialog('dialog4')">
        +
      </md-icon>
    </md-button>

    <md-dialog-alert
      :md-title="alert.title"
      :md-content-html="alert.contentHtml"
      @open="onOpen"
      @close="onClose"
      ref="dialog4">
    </md-dialog-alert>

  </div>
</template>

<script>
export default {
  name: 'menu',
  data () {
    return {
      collabList: [
        {
          firstName: 'firstName1',
          lastName: 'LastName1'
        },
        {
          firstName: 'firstName2',
          lastName: 'LastName2'
        },
        {
          firstName: 'firstName3',
          lastName: 'LastName3'
        },
        {
          firstName: 'firstName4',
          lastName: 'LastName4'
        },
        {
          firstName: 'firstName5',
          lastName: 'LastName5'
        },
        {
          firstName: 'firstName6',
          lastName: 'LastName6'
        },
        {
          firstName: 'firstName7',
          lastName: 'LastName7'
        },
        {
          firstName: 'firstName8',
          lastName: 'LastName8'
        }
      ],
      showModal: false,
      alert: {
        title: 'Nouveau collaborateur',
        contentHtml: "Formulaire pour la création d'un collaborateur"
      }
    }
  },
  methods: {
    openDialog (ref) {
      this.$refs[ref].open()
    },
    closeDialog (ref) {
      this.$refs[ref].close()
    },
    onOpen () {
      console.log('Opened')
    },
    onClose (type) {
      console.log('Closed', type)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#menu {
  background-color: #e0e0eb;
}
.button-add {
  margin-left: 123px;
}
</style>
