<template>
  <div id="google-map"></div>
</template>

<script>
export default {
  name: "googleMap",
  mounted() {
    const element = document.getElementById("google-map")
    const options = {
      zoom: 14,
      center: new google.maps.LatLng(59.93, 30.32)
    }
    this.map = new google.maps.Map(element, options)
  }
}
</script>

<style scoped>
.google-map {
  width: 640px;
  height: 480px;
  margin: 0 auto;
  background: gray;
}
</style>