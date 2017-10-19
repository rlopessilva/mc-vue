<template>
  <div class="main">
    <v-layout column>
        <v-flex xs12 sm12>
          <v-toolbar color="indigo" dark>
            <v-toolbar-side-icon></v-toolbar-side-icon>
            <v-toolbar-title>Discover</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn icon>
              <v-icon>search</v-icon>
            </v-btn>
          </v-toolbar>
          <v-container fluid grid-list-md class="grey lighten-4">
            <v-layout row>
             <v-flex xs12 sm12>
              <v-card height="200px">
                <div class="headline text-xs-center pa-5">Active: {{ e1 }}</div>
                <v-bottom-nav absolute :value="true" :active.sync="e1" class="transparent">
                  <v-btn flat color="teal" value="recent">
                    <span>Recent</span>
                    <v-icon>history</v-icon>
                  </v-btn>
                  <v-btn flat color="teal" value="favorites">
                    <span>Favorites</span>
                    <v-icon>favorite</v-icon>
                  </v-btn>
                  <v-btn flat color="teal" value="nearby">
                    <span>Nearby</span>
                    <v-icon>place</v-icon>
                  </v-btn>
                </v-bottom-nav>
              </v-card>
              </v-flex>
            </v-layout>
          </v-container>
        </v-flex>
    </v-layout>
  </div>
</template>

<script>

export default {
  name: 'Main',
  data () {
    return {
      e1: 'recent'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

</style>
