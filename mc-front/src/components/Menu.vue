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
        }
      ]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#menu {
  background-color: #e0e0eb;
}
</style>
