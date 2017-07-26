<template>
  <div class="home">
    <md-layout md-align="left" md-gutter="8">
      <md-layout md-flex="15" id="menu">
        <span id="color5">
          <menuComp></menuComp>
        </span>
      </md-layout>

      <md-layout md-column>
        <md-layout>
          <infoCollabComp></infoCollabComp>
        </md-layout>
        <md-layout>
          <infoMissionComp></infoMissionComp>
        </md-layout>
      </md-layout>
    </md-layout>
  </div>
</template>

<script>

import Menu from './Menu.vue'
import infoCollab from './infoCollab.vue'
import infoMission from './infoMission.vue'

export default {
  components: {
    'menuComp': Menu,
    'infoCollabComp': infoCollab,
    'infoMissionComp': infoMission
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#menu {
  background-color: #e0e0eb;
}
#color6 {
  background-color: #006699;
}
</style>
