db.restaurants.insertOne(
 {
  "address": {
     "building": "1007",
     "coord": [ -73.856077, 40.848447 ],
     "street": "Morris Park Ave",
     "zipcode": "10462"
  },
  "borough": "Bronx",
  "cuisine": "Bakery",
  "grades": [
     { "date": { "$date": 1393804800000 }, "grade": "A", "score": 2 },
     { "date": { "$date": 1378857600000 }, "grade": "A", "score": 6 },
     { "date": { "$date": 1358985600000 }, "grade": "A", "score": 10 },
     { "date": { "$date": 1322006400000 }, "grade": "A", "score": 9 },
     { "date": { "$date": 1299715200000 }, "grade": "B", "score": 14 }
  ],
  "name": "Morris Park Bake Shop",
  "restaurant_id": "30075445"
 })

-- 1. Inserte un mínimo de 3 documento a la colección restaurantes con datos que faciliten la
-- interpretación de las consultas.
db.restaurants.insertMany([
  {
    address: {
      "building": "726",
      "coord": [-58.2440, -35.7565],
      "street": "Estrada",
      "zipcode": "7223"
    },
    "borough": "General Belgrano",
    "cuisine": "Pizza",
    "grades": [
      { date: new Date("2024-01-10"), "grade": "A", "score": 4 }
    ],
    name: "Lolo - horno de barro",
    "restaurant_id": "AR20001"
  },
  {
    address: {
      "building": "592",
      "coord": [-58.2435, -35.7568],
      "street": "Av. 2 de Septiembre",
      "zipcode": "7223"
    },
    "borough": "General Belgrano",
    "cuisine": "Restaurante",
    "grades": [
      { date: new Date("2024-02-15"), "grade": "A", "score": 6 }
    ],
    name: "El Almacén",
    "restaurant_id": "AR20002"
  },
  {
    address: {
      "building": "410",
      "coord": [-58.2438, -35.7560],
      "street": "Gral. Belgrano",
      "zipcode": "7223"
    },
    "borough": "General Belgrano",
    "cuisine": "Restaurante",
    "grades": [
      { date: new Date("2024-03-12"), "grade": "A", "score": 5 }
    ],
    name: "Restó - Bar. BARSOVIA",
    "restaurant_id": "AR20003"
  }
])

db.restaurants.insertMany([
  {
    name: "Sabor Latino",
    borough: "Manhattan",
    cuisine: "Latina",
    grades: [
      { date: new Date("2023-12-01"), grade: "B", score: 2 },
      { date: new Date("2024-01-15"), grade: "A", score: 6 }
    ],
    restaurant_id: "NY10001",
    address: {
      street: "Broadway",
      building: "101",
      zipcode: "10027",
      coord: [-73.950, 40.810]
    }
  },
  {
    name: "Pizza del Rey",
    borough: "Brooklyn",
    cuisine: "Italiana",
    grades: [
      { date: new Date("2024-03-01"), grade: "A", score: 6 },
      { date: new Date("2024-04-01"), grade: "C", score: 2 }
    ],
    restaurant_id: "NY10002",
    address: {
      street: "Flatbush Ave",
      building: "202",
      zipcode: "11226",
      coord: [-73.955, 40.640]
    }
  },
  {
    name: "Chinatown Express",
    borough: "Manhattan",
    cuisine: "China",
    grades: [
      { date: new Date("2023-11-11"), grade: "C", score: 5 }
    ],
    restaurant_id: "NY10003",
    address: {
      street: "Canal St",
      building: "303",
      zipcode: "10013",
      coord: [-73.998, 40.716]
    }
  },
  {
    name: "Veggie Delight",
    borough: "Brooklyn",
    cuisine: "Vegetariana",
    grades: [
      { date: new Date("2024-02-02"), grade: "B", score: 2 },
      { date: new Date("2024-02-28"), grade: "A", score: 3 }
    ],
    restaurant_id: "NY10004",
    address: {
      street: "Bedford Ave",
      building: "404",
      zipcode: "11211",
      coord: [-73.957, 40.720]
    }
  },
  {
    name: "Meat Lovers",
    borough: "Queens",
    cuisine: "Carnes",
    grades: [
      { date: new Date("2024-02-10"), grade: "A", score: 2 },
      { date: new Date("2024-04-10"), grade: "A", score: 6 }
    ],
    restaurant_id: "NY10005",
    address: {
      street: "Queens Blvd",
      building: "505",
      zipcode: "11373",
      coord: [-73.869, 40.737]
    }
  }
])

-- 2.
db.restaurants.find({
  borough: { $in: ["Manhattan", "Brooklyn"] },
  grades: { 
    $all: [
      { $elemMatch: { score: 2 } },
      { $elemMatch: { score: 6 } }
    ]
  }
});

-- 3.
db.restaurants.aggregate([
  { $unwind: "$grades" },
  { $match: { "grades.grade": "A" } },
  { 
    $group: {
      _id: "$name",
      cantidadCalificacionesA: { $sum: 1 }
    }
  }
]);
-- 4.
db.restaurants.find({
  grades: { $elemMatch: { score: { $lte: 10 } } }
}, {
  restaurant_id: 1,
  name: 1,
  borough: 1,
  cuisine: 1
});
-- 5.
db.owners.insertMany([
  { _id: ObjectId("665f1ee70a9b0d001b6f0001"), name: "Mario Rossi" },
  { _id: ObjectId("665f1ee70a9b0d001b6f0002"), name: "Carla Gómez" },
  { _id: ObjectId("665f1ee70a9b0d001b6f0003"), name: "Ana Fernández" }
]);
db.restaurants.updateOne(
  { restaurant_id: "30075445" },
  { $set: { owner_id: ObjectId("665f1ee70a9b0d001b6f0001") } }
);

db.restaurants.updateOne(
  { restaurant_id: "30085432" },
  { $set: { owner_id: ObjectId("665f1ee70a9b0d001b6f0002") } }
);

db.restaurants.updateOne(
  { restaurant_id: "30096421" },
  { $set: { owner_id: ObjectId("665f1ee70a9b0d001b6f0003") } }
);

db.restaurants.aggregate([
  {
    $lookup: {
      from: "owners",
      localField: "owner_id",
      foreignField: "_id",
      as: "owner"
    }
  },
  { $unwind: "$grades" },
  { $match: { "grades.score": { $lte: 10 } } },
  {
    $project: {
      restaurant_id: 1,
      name: 1,
      borough: 1,
      cuisine: 1,
      owner: { $arrayElemAt: ["$owner.name", 0] }
    }
  },
  { $group: {
    _id: "$restaurant_id",
    name: { $first: "$name" },
    borough: { $first: "$borough" },
    cuisine: { $first: "$cuisine" },
    owner: { $first: "$owner" }
  }}
]);

-- 6.
db.restaurants.find({ "borough": "Bronx" }).forEach(function (rest) {
  db.restaurants.updateOne(
    { _id: rest._id },
    { $set: { "address.zipcode": "10463" } }
  );
});


