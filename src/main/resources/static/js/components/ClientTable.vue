<template>
  <v-card
      elevation="2"
  >
    <v-card-title> Список всех устройств</v-card-title>
    <v-simple-table
        fixed-header
    >
      <thead>
      <tr>
        <th class="text-left">
          Название
        </th>
        <th class="text-left">
          IP-адрес
        </th>
        <th class="text-left">
          Описание
        </th>
        <th class="text-left">
          Статус
        </th>

      </tr>
      </thead>
      <tbody>
      <tr
          v-for="client in sortedClients"
          :key="client.id"
      >
        <td><router-link :to="{name: 'client', params: {id: client.id}}">{{client.name}}</router-link></td>
        <td>{{client.localIp}}</td>
        <td>{{client.description}}</td>
        <td>offline</td>

      </tr>
      </tbody>

    </v-simple-table>

  </v-card>
</template>

<script>
import {mapGetters} from "vuex";


export default {
  computed:    mapGetters(['sortedClients']),


}
</script>

<style scoped>

</style>