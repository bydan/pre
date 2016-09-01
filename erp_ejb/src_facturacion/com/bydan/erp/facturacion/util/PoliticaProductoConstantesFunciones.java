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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.PoliticaProductoConstantesFunciones;
import com.bydan.erp.facturacion.util.PoliticaProductoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PoliticaProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PoliticaProductoConstantesFunciones extends PoliticaProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PoliticaProducto";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PoliticaProducto"+PoliticaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PoliticaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PoliticaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PoliticaProductoConstantesFunciones.SCHEMA+"_"+PoliticaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PoliticaProductoConstantesFunciones.SCHEMA+"_"+PoliticaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PoliticaProductoConstantesFunciones.SCHEMA+"_"+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PoliticaProductoConstantesFunciones.SCHEMA+"_"+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PoliticaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PoliticaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PoliticaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PoliticaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Politica Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Politica Producto";
	public static final String SCLASSWEBTITULO_LOWER="Politica Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PoliticaProducto";
	public static final String OBJECTNAME="politicaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="politica_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select politicaproducto from "+PoliticaProductoConstantesFunciones.SPERSISTENCENAME+" politicaproducto";
	public static String QUERYSELECTNATIVE="select "+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".id,"+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".version_row,"+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".id_empresa,"+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".id_sucursal,"+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".id_bodega,"+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME+".id_producto from "+PoliticaProductoConstantesFunciones.SCHEMA+"."+PoliticaProductoConstantesFunciones.TABLENAME;//+" as "+PoliticaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PoliticaProductoConstantesFuncionesAdditional politicaproductoConstantesFuncionesAdditional=null;
	
	public PoliticaProductoConstantesFuncionesAdditional getPoliticaProductoConstantesFuncionesAdditional() {
		return this.politicaproductoConstantesFuncionesAdditional;
	}
	
	public void setPoliticaProductoConstantesFuncionesAdditional(PoliticaProductoConstantesFuncionesAdditional politicaproductoConstantesFuncionesAdditional) {
		try {
			this.politicaproductoConstantesFuncionesAdditional=politicaproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
	
		
		
		
		
		
		
	
	public static String getPoliticaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PoliticaProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PoliticaProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PoliticaProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PoliticaProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PoliticaProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=PoliticaProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(PoliticaProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PoliticaProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getPoliticaProductoDescripcion(PoliticaProducto politicaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(politicaproducto !=null/* && politicaproducto.getId()!=0*/) {
			if(politicaproducto.getId()!=null) {
				sDescripcion=politicaproducto.getId().toString();
			}//politicaproductopoliticaproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPoliticaProductoDescripcionDetallado(PoliticaProducto politicaproducto) {
		String sDescripcion="";
			
		sDescripcion+=PoliticaProductoConstantesFunciones.ID+"=";
		sDescripcion+=politicaproducto.getId().toString()+",";
		sDescripcion+=PoliticaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=politicaproducto.getVersionRow().toString()+",";
		sDescripcion+=PoliticaProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=politicaproducto.getid_empresa().toString()+",";
		sDescripcion+=PoliticaProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=politicaproducto.getid_sucursal().toString()+",";
		sDescripcion+=PoliticaProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=politicaproducto.getid_bodega().toString()+",";
		sDescripcion+=PoliticaProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=politicaproducto.getid_producto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPoliticaProductoDescripcion(PoliticaProducto politicaproducto,String sValor) throws Exception {			
		if(politicaproducto !=null) {
			//politicaproductopoliticaproducto.getId().toString();
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
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

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosPoliticaProducto(PoliticaProducto politicaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPoliticaProductos(List<PoliticaProducto> politicaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PoliticaProducto politicaproducto: politicaproductos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaProducto(PoliticaProducto politicaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && politicaproducto.getConCambioAuxiliar()) {
			politicaproducto.setIsDeleted(politicaproducto.getIsDeletedAuxiliar());	
			politicaproducto.setIsNew(politicaproducto.getIsNewAuxiliar());	
			politicaproducto.setIsChanged(politicaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			politicaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			politicaproducto.setIsDeletedAuxiliar(false);	
			politicaproducto.setIsNewAuxiliar(false);	
			politicaproducto.setIsChangedAuxiliar(false);
			
			politicaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaProductos(List<PoliticaProducto> politicaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PoliticaProducto politicaproducto : politicaproductos) {
			if(conAsignarBase && politicaproducto.getConCambioAuxiliar()) {
				politicaproducto.setIsDeleted(politicaproducto.getIsDeletedAuxiliar());	
				politicaproducto.setIsNew(politicaproducto.getIsNewAuxiliar());	
				politicaproducto.setIsChanged(politicaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				politicaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				politicaproducto.setIsDeletedAuxiliar(false);	
				politicaproducto.setIsNewAuxiliar(false);	
				politicaproducto.setIsChangedAuxiliar(false);
				
				politicaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPoliticaProducto(PoliticaProducto politicaproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPoliticaProductos(List<PoliticaProducto> politicaproductos,Boolean conEnteros) throws Exception  {
		
		for(PoliticaProducto politicaproducto: politicaproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPoliticaProducto(List<PoliticaProducto> politicaproductos,PoliticaProducto politicaproductoAux) throws Exception  {
		PoliticaProductoConstantesFunciones.InicializarValoresPoliticaProducto(politicaproductoAux,true);
		
		for(PoliticaProducto politicaproducto: politicaproductos) {
			if(politicaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PoliticaProductoConstantesFunciones.getArrayColumnasGlobalesPoliticaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPoliticaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PoliticaProducto> politicaproductos,PoliticaProducto politicaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PoliticaProducto politicaproductoAux: politicaproductos) {
			if(politicaproductoAux!=null && politicaproducto!=null) {
				if((politicaproductoAux.getId()==null && politicaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(politicaproductoAux.getId()!=null && politicaproducto.getId()!=null){
					if(politicaproductoAux.getId().equals(politicaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPoliticaProducto(List<PoliticaProducto> politicaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PoliticaProducto politicaproducto: politicaproductos) {			
			if(politicaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPoliticaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_ID, PoliticaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_VERSIONROW, PoliticaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_IDEMPRESA, PoliticaProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_IDSUCURSAL, PoliticaProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_IDBODEGA, PoliticaProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaProductoConstantesFunciones.LABEL_IDPRODUCTO, PoliticaProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPoliticaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaProducto() throws Exception  {
		return PoliticaProductoConstantesFunciones.getTiposSeleccionarPoliticaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaProducto(Boolean conFk) throws Exception  {
		return PoliticaProductoConstantesFunciones.getTiposSeleccionarPoliticaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PoliticaProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PoliticaProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(PoliticaProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PoliticaProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPoliticaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaProducto(PoliticaProducto politicaproductoAux) throws Exception {
		
			politicaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicaproductoAux.getEmpresa()));
			politicaproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicaproductoAux.getSucursal()));
			politicaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(politicaproductoAux.getBodega()));
			politicaproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(politicaproductoAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaProducto(List<PoliticaProducto> politicaproductosTemp) throws Exception {
		for(PoliticaProducto politicaproductoAux:politicaproductosTemp) {
			
			politicaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicaproductoAux.getEmpresa()));
			politicaproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicaproductoAux.getSucursal()));
			politicaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(politicaproductoAux.getBodega()));
			politicaproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(politicaproductoAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPoliticaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaProductoConstantesFunciones.getClassesRelationshipsOfPoliticaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfPoliticaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PoliticaProducto politicaproducto,List<PoliticaProducto> politicaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PoliticaProducto politicaproductoEncontrado=null;
			
			for(PoliticaProducto politicaproductoLocal:politicaproductos) {
				if(politicaproductoLocal.getId().equals(politicaproducto.getId())) {
					politicaproductoEncontrado=politicaproductoLocal;
					
					politicaproductoLocal.setIsChanged(politicaproducto.getIsChanged());
					politicaproductoLocal.setIsNew(politicaproducto.getIsNew());
					politicaproductoLocal.setIsDeleted(politicaproducto.getIsDeleted());
					
					politicaproductoLocal.setGeneralEntityOriginal(politicaproducto.getGeneralEntityOriginal());
					
					politicaproductoLocal.setId(politicaproducto.getId());	
					politicaproductoLocal.setVersionRow(politicaproducto.getVersionRow());	
					politicaproductoLocal.setid_empresa(politicaproducto.getid_empresa());	
					politicaproductoLocal.setid_sucursal(politicaproducto.getid_sucursal());	
					politicaproductoLocal.setid_bodega(politicaproducto.getid_bodega());	
					politicaproductoLocal.setid_producto(politicaproducto.getid_producto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!politicaproducto.getIsDeleted()) {
				if(!existe) {
					politicaproductos.add(politicaproducto);
				}
			} else {
				if(politicaproductoEncontrado!=null && permiteQuitar)  {
					politicaproductos.remove(politicaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PoliticaProducto politicaproducto,List<PoliticaProducto> politicaproductos) throws Exception {
		try	{			
			for(PoliticaProducto politicaproductoLocal:politicaproductos) {
				if(politicaproductoLocal.getId().equals(politicaproducto.getId())) {
					politicaproductoLocal.setIsSelected(politicaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPoliticaProducto(List<PoliticaProducto> politicaproductosAux) throws Exception {
		//this.politicaproductosAux=politicaproductosAux;
		
		for(PoliticaProducto politicaproductoAux:politicaproductosAux) {
			if(politicaproductoAux.getIsChanged()) {
				politicaproductoAux.setIsChanged(false);
			}		
			
			if(politicaproductoAux.getIsNew()) {
				politicaproductoAux.setIsNew(false);
			}	
			
			if(politicaproductoAux.getIsDeleted()) {
				politicaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPoliticaProducto(PoliticaProducto politicaproductoAux) throws Exception {
		//this.politicaproductoAux=politicaproductoAux;
		
			if(politicaproductoAux.getIsChanged()) {
				politicaproductoAux.setIsChanged(false);
			}		
			
			if(politicaproductoAux.getIsNew()) {
				politicaproductoAux.setIsNew(false);
			}	
			
			if(politicaproductoAux.getIsDeleted()) {
				politicaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PoliticaProducto politicaproductoAsignar,PoliticaProducto politicaproducto) throws Exception {
		politicaproductoAsignar.setId(politicaproducto.getId());	
		politicaproductoAsignar.setVersionRow(politicaproducto.getVersionRow());	
		politicaproductoAsignar.setid_empresa(politicaproducto.getid_empresa());
		politicaproductoAsignar.setempresa_descripcion(politicaproducto.getempresa_descripcion());	
		politicaproductoAsignar.setid_sucursal(politicaproducto.getid_sucursal());
		politicaproductoAsignar.setsucursal_descripcion(politicaproducto.getsucursal_descripcion());	
		politicaproductoAsignar.setid_bodega(politicaproducto.getid_bodega());
		politicaproductoAsignar.setbodega_descripcion(politicaproducto.getbodega_descripcion());	
		politicaproductoAsignar.setid_producto(politicaproducto.getid_producto());
		politicaproductoAsignar.setproducto_descripcion(politicaproducto.getproducto_descripcion());	
	}
	
	public static void inicializarPoliticaProducto(PoliticaProducto politicaproducto) throws Exception {
		try {
				politicaproducto.setId(0L);	
					
				politicaproducto.setid_empresa(-1L);	
				politicaproducto.setid_sucursal(-1L);	
				politicaproducto.setid_bodega(-1L);	
				politicaproducto.setid_producto(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPoliticaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPoliticaProducto(String sTipo,Row row,Workbook workbook,PoliticaProducto politicaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(politicaproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicaproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicaproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicaproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPoliticaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPoliticaProducto() {
		return this.sFinalQueryPoliticaProducto;
	}
	
	public void setsFinalQueryPoliticaProducto(String sFinalQueryPoliticaProducto) {
		this.sFinalQueryPoliticaProducto= sFinalQueryPoliticaProducto;
	}
	
	public Border resaltarSeleccionarPoliticaProducto=null;
	
	public Border setResaltarSeleccionarPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPoliticaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPoliticaProducto() {
		return this.resaltarSeleccionarPoliticaProducto;
	}
	
	public void setResaltarSeleccionarPoliticaProducto(Border borderResaltarSeleccionarPoliticaProducto) {
		this.resaltarSeleccionarPoliticaProducto= borderResaltarSeleccionarPoliticaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPoliticaProducto=null;
	public Boolean mostraridPoliticaProducto=true;
	public Boolean activaridPoliticaProducto=true;

	public Border resaltarid_empresaPoliticaProducto=null;
	public Boolean mostrarid_empresaPoliticaProducto=true;
	public Boolean activarid_empresaPoliticaProducto=true;
	public Boolean cargarid_empresaPoliticaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPoliticaProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalPoliticaProducto=null;
	public Boolean mostrarid_sucursalPoliticaProducto=true;
	public Boolean activarid_sucursalPoliticaProducto=true;
	public Boolean cargarid_sucursalPoliticaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPoliticaProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaPoliticaProducto=null;
	public Boolean mostrarid_bodegaPoliticaProducto=true;
	public Boolean activarid_bodegaPoliticaProducto=true;
	public Boolean cargarid_bodegaPoliticaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaPoliticaProducto=false;//ConEventDepend=true

	public Border resaltarid_productoPoliticaProducto=null;
	public Boolean mostrarid_productoPoliticaProducto=true;
	public Boolean activarid_productoPoliticaProducto=true;
	public Boolean cargarid_productoPoliticaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPoliticaProducto=false;//ConEventDepend=true

	
	

	public Border setResaltaridPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltaridPoliticaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPoliticaProducto() {
		return this.resaltaridPoliticaProducto;
	}

	public void setResaltaridPoliticaProducto(Border borderResaltar) {
		this.resaltaridPoliticaProducto= borderResaltar;
	}

	public Boolean getMostraridPoliticaProducto() {
		return this.mostraridPoliticaProducto;
	}

	public void setMostraridPoliticaProducto(Boolean mostraridPoliticaProducto) {
		this.mostraridPoliticaProducto= mostraridPoliticaProducto;
	}

	public Boolean getActivaridPoliticaProducto() {
		return this.activaridPoliticaProducto;
	}

	public void setActivaridPoliticaProducto(Boolean activaridPoliticaProducto) {
		this.activaridPoliticaProducto= activaridPoliticaProducto;
	}

	public Border setResaltarid_empresaPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPoliticaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPoliticaProducto() {
		return this.resaltarid_empresaPoliticaProducto;
	}

	public void setResaltarid_empresaPoliticaProducto(Border borderResaltar) {
		this.resaltarid_empresaPoliticaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPoliticaProducto() {
		return this.mostrarid_empresaPoliticaProducto;
	}

	public void setMostrarid_empresaPoliticaProducto(Boolean mostrarid_empresaPoliticaProducto) {
		this.mostrarid_empresaPoliticaProducto= mostrarid_empresaPoliticaProducto;
	}

	public Boolean getActivarid_empresaPoliticaProducto() {
		return this.activarid_empresaPoliticaProducto;
	}

	public void setActivarid_empresaPoliticaProducto(Boolean activarid_empresaPoliticaProducto) {
		this.activarid_empresaPoliticaProducto= activarid_empresaPoliticaProducto;
	}

	public Boolean getCargarid_empresaPoliticaProducto() {
		return this.cargarid_empresaPoliticaProducto;
	}

	public void setCargarid_empresaPoliticaProducto(Boolean cargarid_empresaPoliticaProducto) {
		this.cargarid_empresaPoliticaProducto= cargarid_empresaPoliticaProducto;
	}

	public Border setResaltarid_sucursalPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPoliticaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPoliticaProducto() {
		return this.resaltarid_sucursalPoliticaProducto;
	}

	public void setResaltarid_sucursalPoliticaProducto(Border borderResaltar) {
		this.resaltarid_sucursalPoliticaProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPoliticaProducto() {
		return this.mostrarid_sucursalPoliticaProducto;
	}

	public void setMostrarid_sucursalPoliticaProducto(Boolean mostrarid_sucursalPoliticaProducto) {
		this.mostrarid_sucursalPoliticaProducto= mostrarid_sucursalPoliticaProducto;
	}

	public Boolean getActivarid_sucursalPoliticaProducto() {
		return this.activarid_sucursalPoliticaProducto;
	}

	public void setActivarid_sucursalPoliticaProducto(Boolean activarid_sucursalPoliticaProducto) {
		this.activarid_sucursalPoliticaProducto= activarid_sucursalPoliticaProducto;
	}

	public Boolean getCargarid_sucursalPoliticaProducto() {
		return this.cargarid_sucursalPoliticaProducto;
	}

	public void setCargarid_sucursalPoliticaProducto(Boolean cargarid_sucursalPoliticaProducto) {
		this.cargarid_sucursalPoliticaProducto= cargarid_sucursalPoliticaProducto;
	}

	public Border setResaltarid_bodegaPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaPoliticaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaPoliticaProducto() {
		return this.resaltarid_bodegaPoliticaProducto;
	}

	public void setResaltarid_bodegaPoliticaProducto(Border borderResaltar) {
		this.resaltarid_bodegaPoliticaProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaPoliticaProducto() {
		return this.mostrarid_bodegaPoliticaProducto;
	}

	public void setMostrarid_bodegaPoliticaProducto(Boolean mostrarid_bodegaPoliticaProducto) {
		this.mostrarid_bodegaPoliticaProducto= mostrarid_bodegaPoliticaProducto;
	}

	public Boolean getActivarid_bodegaPoliticaProducto() {
		return this.activarid_bodegaPoliticaProducto;
	}

	public void setActivarid_bodegaPoliticaProducto(Boolean activarid_bodegaPoliticaProducto) {
		this.activarid_bodegaPoliticaProducto= activarid_bodegaPoliticaProducto;
	}

	public Boolean getCargarid_bodegaPoliticaProducto() {
		return this.cargarid_bodegaPoliticaProducto;
	}

	public void setCargarid_bodegaPoliticaProducto(Boolean cargarid_bodegaPoliticaProducto) {
		this.cargarid_bodegaPoliticaProducto= cargarid_bodegaPoliticaProducto;
	}

	public Border setResaltarid_productoPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaproductoBeanSwingJInternalFrame.jTtoolBarPoliticaProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoPoliticaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPoliticaProducto() {
		return this.resaltarid_productoPoliticaProducto;
	}

	public void setResaltarid_productoPoliticaProducto(Border borderResaltar) {
		this.resaltarid_productoPoliticaProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoPoliticaProducto() {
		return this.mostrarid_productoPoliticaProducto;
	}

	public void setMostrarid_productoPoliticaProducto(Boolean mostrarid_productoPoliticaProducto) {
		this.mostrarid_productoPoliticaProducto= mostrarid_productoPoliticaProducto;
	}

	public Boolean getActivarid_productoPoliticaProducto() {
		return this.activarid_productoPoliticaProducto;
	}

	public void setActivarid_productoPoliticaProducto(Boolean activarid_productoPoliticaProducto) {
		this.activarid_productoPoliticaProducto= activarid_productoPoliticaProducto;
	}

	public Boolean getCargarid_productoPoliticaProducto() {
		return this.cargarid_productoPoliticaProducto;
	}

	public void setCargarid_productoPoliticaProducto(Boolean cargarid_productoPoliticaProducto) {
		this.cargarid_productoPoliticaProducto= cargarid_productoPoliticaProducto;
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
		
		
		this.setMostraridPoliticaProducto(esInicial);
		this.setMostrarid_empresaPoliticaProducto(esInicial);
		this.setMostrarid_sucursalPoliticaProducto(esInicial);
		this.setMostrarid_bodegaPoliticaProducto(esInicial);
		this.setMostrarid_productoPoliticaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.ID)) {
				this.setMostraridPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPoliticaProducto(esAsigna);
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
		
		
		this.setActivaridPoliticaProducto(esInicial);
		this.setActivarid_empresaPoliticaProducto(esInicial);
		this.setActivarid_sucursalPoliticaProducto(esInicial);
		this.setActivarid_bodegaPoliticaProducto(esInicial);
		this.setActivarid_productoPoliticaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.ID)) {
				this.setActivaridPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPoliticaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPoliticaProducto(esInicial);
		this.setResaltarid_empresaPoliticaProducto(esInicial);
		this.setResaltarid_sucursalPoliticaProducto(esInicial);
		this.setResaltarid_bodegaPoliticaProducto(esInicial);
		this.setResaltarid_productoPoliticaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.ID)) {
				this.setResaltaridPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaPoliticaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPoliticaProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaPoliticaProducto=true;

	public Boolean getMostrarFK_IdBodegaPoliticaProducto() {
		return this.mostrarFK_IdBodegaPoliticaProducto;
	}

	public void setMostrarFK_IdBodegaPoliticaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaPoliticaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPoliticaProducto=true;

	public Boolean getMostrarFK_IdEmpresaPoliticaProducto() {
		return this.mostrarFK_IdEmpresaPoliticaProducto;
	}

	public void setMostrarFK_IdEmpresaPoliticaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPoliticaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPoliticaProducto=true;

	public Boolean getMostrarFK_IdProductoPoliticaProducto() {
		return this.mostrarFK_IdProductoPoliticaProducto;
	}

	public void setMostrarFK_IdProductoPoliticaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPoliticaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPoliticaProducto=true;

	public Boolean getMostrarFK_IdSucursalPoliticaProducto() {
		return this.mostrarFK_IdSucursalPoliticaProducto;
	}

	public void setMostrarFK_IdSucursalPoliticaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPoliticaProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaPoliticaProducto=true;

	public Boolean getActivarFK_IdBodegaPoliticaProducto() {
		return this.activarFK_IdBodegaPoliticaProducto;
	}

	public void setActivarFK_IdBodegaPoliticaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaPoliticaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPoliticaProducto=true;

	public Boolean getActivarFK_IdEmpresaPoliticaProducto() {
		return this.activarFK_IdEmpresaPoliticaProducto;
	}

	public void setActivarFK_IdEmpresaPoliticaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPoliticaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPoliticaProducto=true;

	public Boolean getActivarFK_IdProductoPoliticaProducto() {
		return this.activarFK_IdProductoPoliticaProducto;
	}

	public void setActivarFK_IdProductoPoliticaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPoliticaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPoliticaProducto=true;

	public Boolean getActivarFK_IdSucursalPoliticaProducto() {
		return this.activarFK_IdSucursalPoliticaProducto;
	}

	public void setActivarFK_IdSucursalPoliticaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPoliticaProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaPoliticaProducto=null;

	public Border getResaltarFK_IdBodegaPoliticaProducto() {
		return this.resaltarFK_IdBodegaPoliticaProducto;
	}

	public void setResaltarFK_IdBodegaPoliticaProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaPoliticaProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaPoliticaProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPoliticaProducto=null;

	public Border getResaltarFK_IdEmpresaPoliticaProducto() {
		return this.resaltarFK_IdEmpresaPoliticaProducto;
	}

	public void setResaltarFK_IdEmpresaPoliticaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPoliticaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPoliticaProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoPoliticaProducto=null;

	public Border getResaltarFK_IdProductoPoliticaProducto() {
		return this.resaltarFK_IdProductoPoliticaProducto;
	}

	public void setResaltarFK_IdProductoPoliticaProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoPoliticaProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPoliticaProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPoliticaProducto=null;

	public Border getResaltarFK_IdSucursalPoliticaProducto() {
		return this.resaltarFK_IdSucursalPoliticaProducto;
	}

	public void setResaltarFK_IdSucursalPoliticaProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalPoliticaProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPoliticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaProductoBeanSwingJInternalFrame politicaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPoliticaProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}