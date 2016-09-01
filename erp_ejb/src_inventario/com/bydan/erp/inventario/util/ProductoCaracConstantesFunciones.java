/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.inventario.util.ProductoCaracConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoCaracParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoCaracParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoCaracConstantesFunciones extends ProductoCaracConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ProductoCarac";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoCarac"+ProductoCaracConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoCaracHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoCaracHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoCaracConstantesFunciones.SCHEMA+"_"+ProductoCaracConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoCaracHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoCaracConstantesFunciones.SCHEMA+"_"+ProductoCaracConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoCaracConstantesFunciones.SCHEMA+"_"+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoCaracHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoCaracConstantesFunciones.SCHEMA+"_"+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoCaracHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoCaracHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoCaracConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoCaracConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoCaracConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoCaracConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoCaracConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caracteristicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caracteristica";
	public static final String SCLASSWEBTITULO_LOWER="Producto Carac";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoCarac";
	public static final String OBJECTNAME="productocarac";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_carac";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productocarac from "+ProductoCaracConstantesFunciones.SPERSISTENCENAME+" productocarac";
	public static String QUERYSELECTNATIVE="select "+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".id,"+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".version_row,"+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".id_empresa,"+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".id_producto,"+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME+".caracteristica from "+ProductoCaracConstantesFunciones.SCHEMA+"."+ProductoCaracConstantesFunciones.TABLENAME;//+" as "+ProductoCaracConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoCaracConstantesFuncionesAdditional productocaracConstantesFuncionesAdditional=null;
	
	public ProductoCaracConstantesFuncionesAdditional getProductoCaracConstantesFuncionesAdditional() {
		return this.productocaracConstantesFuncionesAdditional;
	}
	
	public void setProductoCaracConstantesFuncionesAdditional(ProductoCaracConstantesFuncionesAdditional productocaracConstantesFuncionesAdditional) {
		try {
			this.productocaracConstantesFuncionesAdditional=productocaracConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String CARACTERISTICA= "caracteristica";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_CARACTERISTICA= "Caracteristica";
		public static final String LABEL_CARACTERISTICA_LOWER= "Caracteristica";
	
		
		
		
		
		
	public static final String SREGEXCARACTERISTICA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCARACTERISTICA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoCaracLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoCaracConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoCaracConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoCaracConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoCaracConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoCaracConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoCaracConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoCaracConstantesFunciones.CARACTERISTICA)) {sLabelColumna=ProductoCaracConstantesFunciones.LABEL_CARACTERISTICA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
	
	public static String getProductoCaracDescripcion(ProductoCarac productocarac) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productocarac !=null/* && productocarac.getId()!=0*/) {
			if(productocarac.getId()!=null) {
				sDescripcion=productocarac.getId().toString();
			}//productocaracproductocarac.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoCaracDescripcionDetallado(ProductoCarac productocarac) {
		String sDescripcion="";
			
		sDescripcion+=ProductoCaracConstantesFunciones.ID+"=";
		sDescripcion+=productocarac.getId().toString()+",";
		sDescripcion+=ProductoCaracConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productocarac.getVersionRow().toString()+",";
		sDescripcion+=ProductoCaracConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productocarac.getid_empresa().toString()+",";
		sDescripcion+=ProductoCaracConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productocarac.getid_sucursal().toString()+",";
		sDescripcion+=ProductoCaracConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productocarac.getid_producto().toString()+",";
		sDescripcion+=ProductoCaracConstantesFunciones.CARACTERISTICA+"=";
		sDescripcion+=productocarac.getcaracteristica()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoCaracDescripcion(ProductoCarac productocarac,String sValor) throws Exception {			
		if(productocarac !=null) {
			//productocaracproductocarac.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductoCarac(ProductoCarac productocarac,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productocarac.setcaracteristica(productocarac.getcaracteristica().trim());
	}
	
	public static void quitarEspaciosProductoCaracs(List<ProductoCarac> productocaracs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoCarac productocarac: productocaracs) {
			productocarac.setcaracteristica(productocarac.getcaracteristica().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoCarac(ProductoCarac productocarac,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productocarac.getConCambioAuxiliar()) {
			productocarac.setIsDeleted(productocarac.getIsDeletedAuxiliar());	
			productocarac.setIsNew(productocarac.getIsNewAuxiliar());	
			productocarac.setIsChanged(productocarac.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productocarac.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productocarac.setIsDeletedAuxiliar(false);	
			productocarac.setIsNewAuxiliar(false);	
			productocarac.setIsChangedAuxiliar(false);
			
			productocarac.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoCaracs(List<ProductoCarac> productocaracs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoCarac productocarac : productocaracs) {
			if(conAsignarBase && productocarac.getConCambioAuxiliar()) {
				productocarac.setIsDeleted(productocarac.getIsDeletedAuxiliar());	
				productocarac.setIsNew(productocarac.getIsNewAuxiliar());	
				productocarac.setIsChanged(productocarac.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productocarac.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productocarac.setIsDeletedAuxiliar(false);	
				productocarac.setIsNewAuxiliar(false);	
				productocarac.setIsChangedAuxiliar(false);
				
				productocarac.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoCarac(ProductoCarac productocarac,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductoCaracs(List<ProductoCarac> productocaracs,Boolean conEnteros) throws Exception  {
		
		for(ProductoCarac productocarac: productocaracs) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoCarac(List<ProductoCarac> productocaracs,ProductoCarac productocaracAux) throws Exception  {
		ProductoCaracConstantesFunciones.InicializarValoresProductoCarac(productocaracAux,true);
		
		for(ProductoCarac productocarac: productocaracs) {
			if(productocarac.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoCarac(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoCaracConstantesFunciones.getArrayColumnasGlobalesProductoCarac(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoCarac(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoCaracConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoCaracConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoCaracConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoCaracConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoCarac(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoCarac> productocaracs,ProductoCarac productocarac,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoCarac productocaracAux: productocaracs) {
			if(productocaracAux!=null && productocarac!=null) {
				if((productocaracAux.getId()==null && productocarac.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productocaracAux.getId()!=null && productocarac.getId()!=null){
					if(productocaracAux.getId().equals(productocarac.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoCarac(List<ProductoCarac> productocaracs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductoCarac productocarac: productocaracs) {			
			if(productocarac.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoCarac() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_ID, ProductoCaracConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_VERSIONROW, ProductoCaracConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_IDEMPRESA, ProductoCaracConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_IDSUCURSAL, ProductoCaracConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_IDPRODUCTO, ProductoCaracConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoCaracConstantesFunciones.LABEL_CARACTERISTICA, ProductoCaracConstantesFunciones.CARACTERISTICA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoCarac() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoCaracConstantesFunciones.CARACTERISTICA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCarac() throws Exception  {
		return ProductoCaracConstantesFunciones.getTiposSeleccionarProductoCarac(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCarac(Boolean conFk) throws Exception  {
		return ProductoCaracConstantesFunciones.getTiposSeleccionarProductoCarac(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoCarac(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCaracConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoCaracConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCaracConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoCaracConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCaracConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoCaracConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoCaracConstantesFunciones.LABEL_CARACTERISTICA);
			reporte.setsDescripcion(ProductoCaracConstantesFunciones.LABEL_CARACTERISTICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoCarac(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoCarac(ProductoCarac productocaracAux) throws Exception {
		
			productocaracAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productocaracAux.getEmpresa()));
			productocaracAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productocaracAux.getSucursal()));
			productocaracAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productocaracAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoCarac(List<ProductoCarac> productocaracsTemp) throws Exception {
		for(ProductoCarac productocaracAux:productocaracsTemp) {
			
			productocaracAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productocaracAux.getEmpresa()));
			productocaracAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productocaracAux.getSucursal()));
			productocaracAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productocaracAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoCarac(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoCarac(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoCarac(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoCaracConstantesFunciones.getClassesRelationshipsOfProductoCarac(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoCarac(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoCarac(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoCaracConstantesFunciones.getClassesRelationshipsFromStringsOfProductoCarac(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoCarac(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ProductoCarac productocarac,List<ProductoCarac> productocaracs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoCarac productocaracEncontrado=null;
			
			for(ProductoCarac productocaracLocal:productocaracs) {
				if(productocaracLocal.getId().equals(productocarac.getId())) {
					productocaracEncontrado=productocaracLocal;
					
					productocaracLocal.setIsChanged(productocarac.getIsChanged());
					productocaracLocal.setIsNew(productocarac.getIsNew());
					productocaracLocal.setIsDeleted(productocarac.getIsDeleted());
					
					productocaracLocal.setGeneralEntityOriginal(productocarac.getGeneralEntityOriginal());
					
					productocaracLocal.setId(productocarac.getId());	
					productocaracLocal.setVersionRow(productocarac.getVersionRow());	
					productocaracLocal.setid_empresa(productocarac.getid_empresa());	
					productocaracLocal.setid_sucursal(productocarac.getid_sucursal());	
					productocaracLocal.setid_producto(productocarac.getid_producto());	
					productocaracLocal.setcaracteristica(productocarac.getcaracteristica());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productocarac.getIsDeleted()) {
				if(!existe) {
					productocaracs.add(productocarac);
				}
			} else {
				if(productocaracEncontrado!=null && permiteQuitar)  {
					productocaracs.remove(productocaracEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoCarac productocarac,List<ProductoCarac> productocaracs) throws Exception {
		try	{			
			for(ProductoCarac productocaracLocal:productocaracs) {
				if(productocaracLocal.getId().equals(productocarac.getId())) {
					productocaracLocal.setIsSelected(productocarac.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoCarac(List<ProductoCarac> productocaracsAux) throws Exception {
		//this.productocaracsAux=productocaracsAux;
		
		for(ProductoCarac productocaracAux:productocaracsAux) {
			if(productocaracAux.getIsChanged()) {
				productocaracAux.setIsChanged(false);
			}		
			
			if(productocaracAux.getIsNew()) {
				productocaracAux.setIsNew(false);
			}	
			
			if(productocaracAux.getIsDeleted()) {
				productocaracAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoCarac(ProductoCarac productocaracAux) throws Exception {
		//this.productocaracAux=productocaracAux;
		
			if(productocaracAux.getIsChanged()) {
				productocaracAux.setIsChanged(false);
			}		
			
			if(productocaracAux.getIsNew()) {
				productocaracAux.setIsNew(false);
			}	
			
			if(productocaracAux.getIsDeleted()) {
				productocaracAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoCarac productocaracAsignar,ProductoCarac productocarac) throws Exception {
		productocaracAsignar.setId(productocarac.getId());	
		productocaracAsignar.setVersionRow(productocarac.getVersionRow());	
		productocaracAsignar.setid_empresa(productocarac.getid_empresa());
		productocaracAsignar.setempresa_descripcion(productocarac.getempresa_descripcion());	
		productocaracAsignar.setid_sucursal(productocarac.getid_sucursal());
		productocaracAsignar.setsucursal_descripcion(productocarac.getsucursal_descripcion());	
		productocaracAsignar.setid_producto(productocarac.getid_producto());
		productocaracAsignar.setproducto_descripcion(productocarac.getproducto_descripcion());	
		productocaracAsignar.setcaracteristica(productocarac.getcaracteristica());	
	}
	
	public static void inicializarProductoCarac(ProductoCarac productocarac) throws Exception {
		try {
				productocarac.setId(0L);	
					
				productocarac.setid_empresa(-1L);	
				productocarac.setid_sucursal(-1L);	
				productocarac.setid_producto(-1L);	
				productocarac.setcaracteristica("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoCarac(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCaracConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCaracConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCaracConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoCaracConstantesFunciones.LABEL_CARACTERISTICA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoCarac(String sTipo,Row row,Workbook workbook,ProductoCarac productocarac,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productocarac.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocarac.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocarac.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productocarac.getcaracteristica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoCarac=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoCarac() {
		return this.sFinalQueryProductoCarac;
	}
	
	public void setsFinalQueryProductoCarac(String sFinalQueryProductoCarac) {
		this.sFinalQueryProductoCarac= sFinalQueryProductoCarac;
	}
	
	public Border resaltarSeleccionarProductoCarac=null;
	
	public Border setResaltarSeleccionarProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoCarac= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoCarac() {
		return this.resaltarSeleccionarProductoCarac;
	}
	
	public void setResaltarSeleccionarProductoCarac(Border borderResaltarSeleccionarProductoCarac) {
		this.resaltarSeleccionarProductoCarac= borderResaltarSeleccionarProductoCarac;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoCarac=null;
	public Boolean mostraridProductoCarac=true;
	public Boolean activaridProductoCarac=true;

	public Border resaltarid_empresaProductoCarac=null;
	public Boolean mostrarid_empresaProductoCarac=true;
	public Boolean activarid_empresaProductoCarac=true;
	public Boolean cargarid_empresaProductoCarac=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoCarac=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoCarac=null;
	public Boolean mostrarid_sucursalProductoCarac=true;
	public Boolean activarid_sucursalProductoCarac=true;
	public Boolean cargarid_sucursalProductoCarac=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoCarac=false;//ConEventDepend=true

	public Border resaltarid_productoProductoCarac=null;
	public Boolean mostrarid_productoProductoCarac=true;
	public Boolean activarid_productoProductoCarac=true;
	public Boolean cargarid_productoProductoCarac=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoCarac=false;//ConEventDepend=true

	public Border resaltarcaracteristicaProductoCarac=null;
	public Boolean mostrarcaracteristicaProductoCarac=true;
	public Boolean activarcaracteristicaProductoCarac=true;

	
	

	public Border setResaltaridProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltaridProductoCarac= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoCarac() {
		return this.resaltaridProductoCarac;
	}

	public void setResaltaridProductoCarac(Border borderResaltar) {
		this.resaltaridProductoCarac= borderResaltar;
	}

	public Boolean getMostraridProductoCarac() {
		return this.mostraridProductoCarac;
	}

	public void setMostraridProductoCarac(Boolean mostraridProductoCarac) {
		this.mostraridProductoCarac= mostraridProductoCarac;
	}

	public Boolean getActivaridProductoCarac() {
		return this.activaridProductoCarac;
	}

	public void setActivaridProductoCarac(Boolean activaridProductoCarac) {
		this.activaridProductoCarac= activaridProductoCarac;
	}

	public Border setResaltarid_empresaProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoCarac= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoCarac() {
		return this.resaltarid_empresaProductoCarac;
	}

	public void setResaltarid_empresaProductoCarac(Border borderResaltar) {
		this.resaltarid_empresaProductoCarac= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoCarac() {
		return this.mostrarid_empresaProductoCarac;
	}

	public void setMostrarid_empresaProductoCarac(Boolean mostrarid_empresaProductoCarac) {
		this.mostrarid_empresaProductoCarac= mostrarid_empresaProductoCarac;
	}

	public Boolean getActivarid_empresaProductoCarac() {
		return this.activarid_empresaProductoCarac;
	}

	public void setActivarid_empresaProductoCarac(Boolean activarid_empresaProductoCarac) {
		this.activarid_empresaProductoCarac= activarid_empresaProductoCarac;
	}

	public Boolean getCargarid_empresaProductoCarac() {
		return this.cargarid_empresaProductoCarac;
	}

	public void setCargarid_empresaProductoCarac(Boolean cargarid_empresaProductoCarac) {
		this.cargarid_empresaProductoCarac= cargarid_empresaProductoCarac;
	}

	public Border setResaltarid_sucursalProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoCarac= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoCarac() {
		return this.resaltarid_sucursalProductoCarac;
	}

	public void setResaltarid_sucursalProductoCarac(Border borderResaltar) {
		this.resaltarid_sucursalProductoCarac= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoCarac() {
		return this.mostrarid_sucursalProductoCarac;
	}

	public void setMostrarid_sucursalProductoCarac(Boolean mostrarid_sucursalProductoCarac) {
		this.mostrarid_sucursalProductoCarac= mostrarid_sucursalProductoCarac;
	}

	public Boolean getActivarid_sucursalProductoCarac() {
		return this.activarid_sucursalProductoCarac;
	}

	public void setActivarid_sucursalProductoCarac(Boolean activarid_sucursalProductoCarac) {
		this.activarid_sucursalProductoCarac= activarid_sucursalProductoCarac;
	}

	public Boolean getCargarid_sucursalProductoCarac() {
		return this.cargarid_sucursalProductoCarac;
	}

	public void setCargarid_sucursalProductoCarac(Boolean cargarid_sucursalProductoCarac) {
		this.cargarid_sucursalProductoCarac= cargarid_sucursalProductoCarac;
	}

	public Border setResaltarid_productoProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoCarac= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoCarac() {
		return this.resaltarid_productoProductoCarac;
	}

	public void setResaltarid_productoProductoCarac(Border borderResaltar) {
		this.resaltarid_productoProductoCarac= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoCarac() {
		return this.mostrarid_productoProductoCarac;
	}

	public void setMostrarid_productoProductoCarac(Boolean mostrarid_productoProductoCarac) {
		this.mostrarid_productoProductoCarac= mostrarid_productoProductoCarac;
	}

	public Boolean getActivarid_productoProductoCarac() {
		return this.activarid_productoProductoCarac;
	}

	public void setActivarid_productoProductoCarac(Boolean activarid_productoProductoCarac) {
		this.activarid_productoProductoCarac= activarid_productoProductoCarac;
	}

	public Boolean getCargarid_productoProductoCarac() {
		return this.cargarid_productoProductoCarac;
	}

	public void setCargarid_productoProductoCarac(Boolean cargarid_productoProductoCarac) {
		this.cargarid_productoProductoCarac= cargarid_productoProductoCarac;
	}

	public Border setResaltarcaracteristicaProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productocaracBeanSwingJInternalFrame.jTtoolBarProductoCarac.setBorder(borderResaltar);
		
		this.resaltarcaracteristicaProductoCarac= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcaracteristicaProductoCarac() {
		return this.resaltarcaracteristicaProductoCarac;
	}

	public void setResaltarcaracteristicaProductoCarac(Border borderResaltar) {
		this.resaltarcaracteristicaProductoCarac= borderResaltar;
	}

	public Boolean getMostrarcaracteristicaProductoCarac() {
		return this.mostrarcaracteristicaProductoCarac;
	}

	public void setMostrarcaracteristicaProductoCarac(Boolean mostrarcaracteristicaProductoCarac) {
		this.mostrarcaracteristicaProductoCarac= mostrarcaracteristicaProductoCarac;
	}

	public Boolean getActivarcaracteristicaProductoCarac() {
		return this.activarcaracteristicaProductoCarac;
	}

	public void setActivarcaracteristicaProductoCarac(Boolean activarcaracteristicaProductoCarac) {
		this.activarcaracteristicaProductoCarac= activarcaracteristicaProductoCarac;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridProductoCarac(esInicial);
		this.setMostrarid_empresaProductoCarac(esInicial);
		this.setMostrarid_sucursalProductoCarac(esInicial);
		this.setMostrarid_productoProductoCarac(esInicial);
		this.setMostrarcaracteristicaProductoCarac(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCaracConstantesFunciones.ID)) {
				this.setMostraridProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.CARACTERISTICA)) {
				this.setMostrarcaracteristicaProductoCarac(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridProductoCarac(esInicial);
		this.setActivarid_empresaProductoCarac(esInicial);
		this.setActivarid_sucursalProductoCarac(esInicial);
		this.setActivarid_productoProductoCarac(esInicial);
		this.setActivarcaracteristicaProductoCarac(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCaracConstantesFunciones.ID)) {
				this.setActivaridProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.CARACTERISTICA)) {
				this.setActivarcaracteristicaProductoCarac(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoCarac(esInicial);
		this.setResaltarid_empresaProductoCarac(esInicial);
		this.setResaltarid_sucursalProductoCarac(esInicial);
		this.setResaltarid_productoProductoCarac(esInicial);
		this.setResaltarcaracteristicaProductoCarac(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoCaracConstantesFunciones.ID)) {
				this.setResaltaridProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoCarac(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoCaracConstantesFunciones.CARACTERISTICA)) {
				this.setResaltarcaracteristicaProductoCarac(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaProductoCarac=true;

	public Boolean getMostrarFK_IdEmpresaProductoCarac() {
		return this.mostrarFK_IdEmpresaProductoCarac;
	}

	public void setMostrarFK_IdEmpresaProductoCarac(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoCarac= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoCarac=true;

	public Boolean getMostrarFK_IdProductoProductoCarac() {
		return this.mostrarFK_IdProductoProductoCarac;
	}

	public void setMostrarFK_IdProductoProductoCarac(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoCarac= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoCarac=true;

	public Boolean getMostrarFK_IdSucursalProductoCarac() {
		return this.mostrarFK_IdSucursalProductoCarac;
	}

	public void setMostrarFK_IdSucursalProductoCarac(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoCarac= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaProductoCarac=true;

	public Boolean getActivarFK_IdEmpresaProductoCarac() {
		return this.activarFK_IdEmpresaProductoCarac;
	}

	public void setActivarFK_IdEmpresaProductoCarac(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoCarac= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoCarac=true;

	public Boolean getActivarFK_IdProductoProductoCarac() {
		return this.activarFK_IdProductoProductoCarac;
	}

	public void setActivarFK_IdProductoProductoCarac(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoCarac= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoCarac=true;

	public Boolean getActivarFK_IdSucursalProductoCarac() {
		return this.activarFK_IdSucursalProductoCarac;
	}

	public void setActivarFK_IdSucursalProductoCarac(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoCarac= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaProductoCarac=null;

	public Border getResaltarFK_IdEmpresaProductoCarac() {
		return this.resaltarFK_IdEmpresaProductoCarac;
	}

	public void setResaltarFK_IdEmpresaProductoCarac(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoCarac= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoCarac= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoCarac=null;

	public Border getResaltarFK_IdProductoProductoCarac() {
		return this.resaltarFK_IdProductoProductoCarac;
	}

	public void setResaltarFK_IdProductoProductoCarac(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoCarac= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoCarac= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoCarac=null;

	public Border getResaltarFK_IdSucursalProductoCarac() {
		return this.resaltarFK_IdSucursalProductoCarac;
	}

	public void setResaltarFK_IdSucursalProductoCarac(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoCarac= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoCarac(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoCaracBeanSwingJInternalFrame productocaracBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoCarac= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}