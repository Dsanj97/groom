interface Car {
    id: number;
    name: string;
    brand: {
        popularity: number;
        logo: string;
        history: string;
    }
}

function updateCarBrand(id: Car['id'], newBrand: Car['brand']){}