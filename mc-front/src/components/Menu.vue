<template>
  <div class="menu">
    <span>Menu</span>
    <ul id="repeat-object" class="demo">
      <li v-for="collab in collabList">
        {{collab.lastName}}{{ collab.lastName}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'menu',
  data () {
    return {
      collabList: [
        {
          firstName: 'firstName User1',
          lastName: 'LastName User1'
        },
        {
          firstName: 'firstName User2',
          lastName: 'LastName User2'
        },
        {
          firstName: 'firstName User3',
          lastName: 'LastName User3'
        },
        {
          firstName: 'firstName User4',
          lastName: 'LastName User4'
        }
      ]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}
</style>
