<template>
  <div>
    <NuxtRouteAnnouncer />
    <h1>SweetAlert2 in Nuxt!</h1>
    <button @click="showAlert">Hello world</button>
  </div>
</template>

<script setup lang="ts">
import { useNuxtApp } from '#app';

const { $swal } = useNuxtApp();

const showAlert = () => {
  $swal.fire({
    title: 'Success!',
    text: 'SweetAlert2 is working!',
    icon: 'success',
    confirmButtonText: 'Cool'
  });
};
</script>
