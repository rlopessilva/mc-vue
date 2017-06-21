<template>
  <div class="home">
    <menuComp></menuComp>
    <infoCollabComp></infoCollabComp>
    <infoMissionComp></infoMissionComp>
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
</style>
