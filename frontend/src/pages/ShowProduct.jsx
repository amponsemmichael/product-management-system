import { useEffect, useState } from "react";
import axios from "axios";
import Spinner from "../components/Spinner";
import { useParams, Link } from "react-router-dom";
import { AiOutlineArrowLeft } from "react-icons/ai";

const ShowProduct = () => {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    axios
        .get(`http://localhost:8080/products/${id}`)
        .then((res) => {
          setProduct(res.data);
          setLoading(false);
        })
        .catch((error) => {
          console.error("Error fetching product details: ", error);
          setLoading(false);
        });
  }, [id]);

  if (loading) {
    return <Spinner />;
  }

  if (!product) {
    return <div>Product not found</div>;
  }

  return (
      <div className="p-4">
        <Link to="/" className="text-lg">
          <AiOutlineArrowLeft className="inline-block" /> Back to Product List
        </Link>
        <h1 className="text-3xl my-4">Product Details</h1>
        <div className="border-2 border-sky-400 rounded-xl p-4 w-[600px] mx-auto">
          <p><strong>Name:</strong> {product.name}</p>
          <p><strong>Description:</strong> {product.description}</p>
          <p><strong>Price:</strong> {product.price}</p>
          <p><strong>Category:</strong> {product.category}</p>
          <p><strong>Quantity:</strong> {product.quantity}</p>
        </div>
      </div>
  );
};

export default ShowProduct;

