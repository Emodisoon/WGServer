<template>

      <v-footer
          absolute
          app
          class="font-weight-medium"
          color="blue"
      >
        <v-col
            class="text-center"
            cols="12"
        >
          {{ new Date().getFullYear() }} — <strong>BMSTU WGServer</strong>
        </v-col>
      </v-footer>

</template>

<script>
export default {
  name: "MyFooter"
}
</script>

<style scoped>

</style>