import { useEffect, useState } from "react";
import axios from "axios";
import Spinner from "../components/Spinner";
import { Link } from "react-router-dom";
import { AiOutlineEdit } from "react-icons/ai";
import { BsInfoCircle } from "react-icons/bs";
import { MdOutlineAddBox, MdOutlineDelete } from "react-icons/md";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(false);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);

    useEffect(() => {
        fetchProducts(page);
    }, [page]);

    const fetchProducts = (page) => {
        setLoading(true);
        axios
            .get(`http://localhost:8080/products?page=${page}&size=10`)
            .then((res) => {
                console.log("response data: ", res.data);
                if (res.data && Array.isArray(res.data.content)) {
                    setProducts(res.data.content);
                    setTotalPages(res.data.totalPages);
                } else {
                    console.error('Unexpected data structure: ', res.data);
                }
                setLoading(false);
            })
            .catch((error) => {
                console.error('Error fetching data: ', error);
                setLoading(false);
            });
    };

    const handlePrevious = () => {
        setPage((prevPage) => Math.max(prevPage - 1, 0));
    };

    const handleNext = () => {
        setPage((prevPage) => Math.min(prevPage + 1, totalPages - 1));
    };

    return (
        <div className="p-4">
            <div className="flex justify-between items-center">
                <h1 className="text-3xl my-8">Product List</h1>
                <Link to="/products/create">
                    <MdOutlineAddBox className="text-sky-800 text-4xl" />
                </Link>
            </div>

            {loading ? (
                <Spinner />
            ) : (
                <div>
                    <table className="w-full border-separate border-spacing-2">
                        <thead>
                        <tr>
                            <th className="border border-slate-600 rounded-md">No</th>
                            <th className="border border-slate-600 rounded-md">Name</th>
                            <th className="border border-slate-600 rounded-md max-md:hidden">Description</th>
                            <th className="border border-slate-600 rounded-md">Price</th>
                            <th className="border border-slate-600 rounded-md">Category</th>
                            <th className="border border-slate-600 rounded-md">Quantity</th>
                            <th className="border border-slate-600 rounded-md">Operations</th>
                        </tr>
                        </thead>
                        <tbody>
                        {products.map((product, index) => (
                            <tr key={product.id} className="h-8">
                                <td className="border border-slate-700 rounded-md text-center">
                                    {index + 1 + page * 10}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center">
                                    {product.name}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center max-md:hidden">
                                    {product.description}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center max-md:hidden">
                                    {product.price.toString()}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center max-md:hidden">
                                    {product.category}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center max-md:hidden">
                                    {product.quantity.toString()}
                                </td>
                                <td className="border border-slate-700 rounded-md text-center">
                                    <div className="flex justify-center gap-x-4">
                                        <Link to={`/products/details/${product.id}`}>
                                            <BsInfoCircle className="text-2xl text-green-800" />
                                        </Link>
                                        <Link to={`/products/edit/${product.id}`}>
                                            <AiOutlineEdit className="text-2xl text-yellow-600" />
                                        </Link>
                                        <Link to={`/products/delete/${product.id}`}>
                                            <MdOutlineDelete className="text-2xl text-red-600" />
                                        </Link>
                                    </div>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                    <div className="flex justify-between mt-4">
                        <button
                            onClick={handlePrevious}
                            disabled={page === 0}
                            className="bg-gray-300 p-2 rounded disabled:opacity-50"
                        >
                            Previous
                        </button>
                        <button
                            onClick={handleNext}
                            disabled={page === totalPages - 1}
                            className="bg-gray-300 p-2 rounded disabled:opacity-50"
                        >
                            Next
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
};

export default Home;

