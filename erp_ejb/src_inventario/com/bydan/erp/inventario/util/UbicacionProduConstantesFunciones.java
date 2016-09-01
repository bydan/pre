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


import com.bydan.erp.inventario.util.UbicacionProduConstantesFunciones;
import com.bydan.erp.inventario.util.UbicacionProduParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UbicacionProduParameterGeneral;

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
final public class UbicacionProduConstantesFunciones extends UbicacionProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UbicacionProdu";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UbicacionProdu"+UbicacionProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UbicacionProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UbicacionProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UbicacionProduConstantesFunciones.SCHEMA+"_"+UbicacionProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UbicacionProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UbicacionProduConstantesFunciones.SCHEMA+"_"+UbicacionProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UbicacionProduConstantesFunciones.SCHEMA+"_"+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UbicacionProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UbicacionProduConstantesFunciones.SCHEMA+"_"+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UbicacionProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UbicacionProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UbicacionProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UbicacionProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UbicacionProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UbicacionProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ubicacion Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ubicacion Producto";
	public static final String SCLASSWEBTITULO_LOWER="Ubicacion Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UbicacionProdu";
	public static final String OBJECTNAME="ubicacionprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="ubicacion_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ubicacionprodu from "+UbicacionProduConstantesFunciones.SPERSISTENCENAME+" ubicacionprodu";
	public static String QUERYSELECTNATIVE="select "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".version_row,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_empresa,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_sucursal,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_bodega,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_producto,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_ubicacion_bode from "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME;//+" as "+UbicacionProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UbicacionProduConstantesFuncionesAdditional ubicacionproduConstantesFuncionesAdditional=null;
	
	public UbicacionProduConstantesFuncionesAdditional getUbicacionProduConstantesFuncionesAdditional() {
		return this.ubicacionproduConstantesFuncionesAdditional;
	}
	
	public void setUbicacionProduConstantesFuncionesAdditional(UbicacionProduConstantesFuncionesAdditional ubicacionproduConstantesFuncionesAdditional) {
		try {
			this.ubicacionproduConstantesFuncionesAdditional=ubicacionproduConstantesFuncionesAdditional;
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
    public static final String IDUBICACIONBODE= "id_ubicacion_bode";
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
    	public static final String LABEL_IDUBICACIONBODE= "Ubicacion Bodega";
		public static final String LABEL_IDUBICACIONBODE_LOWER= "Ubicacion Bode";
	
		
		
		
		
		
		
		
	
	public static String getUbicacionProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UbicacionProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=UbicacionProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UbicacionProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=UbicacionProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(UbicacionProduConstantesFunciones.IDBODEGA)) {sLabelColumna=UbicacionProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(UbicacionProduConstantesFunciones.IDPRODUCTO)) {sLabelColumna=UbicacionProduConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(UbicacionProduConstantesFunciones.IDUBICACIONBODE)) {sLabelColumna=UbicacionProduConstantesFunciones.LABEL_IDUBICACIONBODE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getUbicacionProduDescripcion(UbicacionProdu ubicacionprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ubicacionprodu !=null/* && ubicacionprodu.getId()!=0*/) {
			if(ubicacionprodu.getId()!=null) {
				sDescripcion=ubicacionprodu.getId().toString();
			}//ubicacionproduubicacionprodu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUbicacionProduDescripcionDetallado(UbicacionProdu ubicacionprodu) {
		String sDescripcion="";
			
		sDescripcion+=UbicacionProduConstantesFunciones.ID+"=";
		sDescripcion+=ubicacionprodu.getId().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ubicacionprodu.getVersionRow().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ubicacionprodu.getid_empresa().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ubicacionprodu.getid_sucursal().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=ubicacionprodu.getid_bodega().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=ubicacionprodu.getid_producto().toString()+",";
		sDescripcion+=UbicacionProduConstantesFunciones.IDUBICACIONBODE+"=";
		sDescripcion+=ubicacionprodu.getid_ubicacion_bode().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUbicacionProduDescripcion(UbicacionProdu ubicacionprodu,String sValor) throws Exception {			
		if(ubicacionprodu !=null) {
			//ubicacionproduubicacionprodu.getId().toString();
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

	public static String getUbicacionBodeDescripcion(UbicacionBode ubicacionbode) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ubicacionbode!=null/*&&ubicacionbode.getId()>0*/) {
			sDescripcion=UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(ubicacionbode);
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
		} else if(sNombreIndice.equals("FK_IdUbicacionBode")) {
			sNombreIndice="Tipo=  Por Ubicacion Bodega";
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

	public static String getDetalleIndiceFK_IdUbicacionBode(Long id_ubicacion_bode) {
		String sDetalleIndice=" Parametros->";
		if(id_ubicacion_bode!=null) {sDetalleIndice+=" Codigo Unico De Ubicacion Bodega="+id_ubicacion_bode.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUbicacionProdu(UbicacionProdu ubicacionprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosUbicacionProdus(List<UbicacionProdu> ubicacionprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UbicacionProdu ubicacionprodu: ubicacionprodus) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUbicacionProdu(UbicacionProdu ubicacionprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ubicacionprodu.getConCambioAuxiliar()) {
			ubicacionprodu.setIsDeleted(ubicacionprodu.getIsDeletedAuxiliar());	
			ubicacionprodu.setIsNew(ubicacionprodu.getIsNewAuxiliar());	
			ubicacionprodu.setIsChanged(ubicacionprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ubicacionprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ubicacionprodu.setIsDeletedAuxiliar(false);	
			ubicacionprodu.setIsNewAuxiliar(false);	
			ubicacionprodu.setIsChangedAuxiliar(false);
			
			ubicacionprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUbicacionProdus(List<UbicacionProdu> ubicacionprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UbicacionProdu ubicacionprodu : ubicacionprodus) {
			if(conAsignarBase && ubicacionprodu.getConCambioAuxiliar()) {
				ubicacionprodu.setIsDeleted(ubicacionprodu.getIsDeletedAuxiliar());	
				ubicacionprodu.setIsNew(ubicacionprodu.getIsNewAuxiliar());	
				ubicacionprodu.setIsChanged(ubicacionprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ubicacionprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ubicacionprodu.setIsDeletedAuxiliar(false);	
				ubicacionprodu.setIsNewAuxiliar(false);	
				ubicacionprodu.setIsChangedAuxiliar(false);
				
				ubicacionprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUbicacionProdu(UbicacionProdu ubicacionprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUbicacionProdus(List<UbicacionProdu> ubicacionprodus,Boolean conEnteros) throws Exception  {
		
		for(UbicacionProdu ubicacionprodu: ubicacionprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUbicacionProdu(List<UbicacionProdu> ubicacionprodus,UbicacionProdu ubicacionproduAux) throws Exception  {
		UbicacionProduConstantesFunciones.InicializarValoresUbicacionProdu(ubicacionproduAux,true);
		
		for(UbicacionProdu ubicacionprodu: ubicacionprodus) {
			if(ubicacionprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUbicacionProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UbicacionProduConstantesFunciones.getArrayColumnasGlobalesUbicacionProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUbicacionProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UbicacionProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UbicacionProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UbicacionProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UbicacionProduConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUbicacionProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UbicacionProdu> ubicacionprodus,UbicacionProdu ubicacionprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UbicacionProdu ubicacionproduAux: ubicacionprodus) {
			if(ubicacionproduAux!=null && ubicacionprodu!=null) {
				if((ubicacionproduAux.getId()==null && ubicacionprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ubicacionproduAux.getId()!=null && ubicacionprodu.getId()!=null){
					if(ubicacionproduAux.getId().equals(ubicacionprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUbicacionProdu(List<UbicacionProdu> ubicacionprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(UbicacionProdu ubicacionprodu: ubicacionprodus) {			
			if(ubicacionprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUbicacionProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_ID, UbicacionProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_VERSIONROW, UbicacionProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_IDEMPRESA, UbicacionProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_IDSUCURSAL, UbicacionProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_IDBODEGA, UbicacionProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_IDPRODUCTO, UbicacionProduConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionProduConstantesFunciones.LABEL_IDUBICACIONBODE, UbicacionProduConstantesFunciones.IDUBICACIONBODE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUbicacionProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionProduConstantesFunciones.IDUBICACIONBODE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionProdu() throws Exception  {
		return UbicacionProduConstantesFunciones.getTiposSeleccionarUbicacionProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionProdu(Boolean conFk) throws Exception  {
		return UbicacionProduConstantesFunciones.getTiposSeleccionarUbicacionProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UbicacionProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(UbicacionProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(UbicacionProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionProduConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(UbicacionProduConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionProduConstantesFunciones.LABEL_IDUBICACIONBODE);
			reporte.setsDescripcion(UbicacionProduConstantesFunciones.LABEL_IDUBICACIONBODE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUbicacionProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUbicacionProdu(UbicacionProdu ubicacionproduAux) throws Exception {
		
			ubicacionproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ubicacionproduAux.getEmpresa()));
			ubicacionproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ubicacionproduAux.getSucursal()));
			ubicacionproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ubicacionproduAux.getBodega()));
			ubicacionproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ubicacionproduAux.getProducto()));
			ubicacionproduAux.setubicacionbode_descripcion(UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(ubicacionproduAux.getUbicacionBode()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUbicacionProdu(List<UbicacionProdu> ubicacionprodusTemp) throws Exception {
		for(UbicacionProdu ubicacionproduAux:ubicacionprodusTemp) {
			
			ubicacionproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ubicacionproduAux.getEmpresa()));
			ubicacionproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ubicacionproduAux.getSucursal()));
			ubicacionproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ubicacionproduAux.getBodega()));
			ubicacionproduAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ubicacionproduAux.getProducto()));
			ubicacionproduAux.setubicacionbode_descripcion(UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(ubicacionproduAux.getUbicacionBode()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUbicacionProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(UbicacionBode.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(UbicacionBode.class)) {
						classes.add(new Classe(UbicacionBode.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUbicacionProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
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

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UbicacionProduConstantesFunciones.getClassesRelationshipsOfUbicacionProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUbicacionProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UbicacionProduConstantesFunciones.getClassesRelationshipsFromStringsOfUbicacionProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUbicacionProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UbicacionProdu ubicacionprodu,List<UbicacionProdu> ubicacionprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UbicacionProdu ubicacionproduEncontrado=null;
			
			for(UbicacionProdu ubicacionproduLocal:ubicacionprodus) {
				if(ubicacionproduLocal.getId().equals(ubicacionprodu.getId())) {
					ubicacionproduEncontrado=ubicacionproduLocal;
					
					ubicacionproduLocal.setIsChanged(ubicacionprodu.getIsChanged());
					ubicacionproduLocal.setIsNew(ubicacionprodu.getIsNew());
					ubicacionproduLocal.setIsDeleted(ubicacionprodu.getIsDeleted());
					
					ubicacionproduLocal.setGeneralEntityOriginal(ubicacionprodu.getGeneralEntityOriginal());
					
					ubicacionproduLocal.setId(ubicacionprodu.getId());	
					ubicacionproduLocal.setVersionRow(ubicacionprodu.getVersionRow());	
					ubicacionproduLocal.setid_empresa(ubicacionprodu.getid_empresa());	
					ubicacionproduLocal.setid_sucursal(ubicacionprodu.getid_sucursal());	
					ubicacionproduLocal.setid_bodega(ubicacionprodu.getid_bodega());	
					ubicacionproduLocal.setid_producto(ubicacionprodu.getid_producto());	
					ubicacionproduLocal.setid_ubicacion_bode(ubicacionprodu.getid_ubicacion_bode());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!ubicacionprodu.getIsDeleted()) {
				if(!existe) {
					ubicacionprodus.add(ubicacionprodu);
				}
			} else {
				if(ubicacionproduEncontrado!=null && permiteQuitar)  {
					ubicacionprodus.remove(ubicacionproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UbicacionProdu ubicacionprodu,List<UbicacionProdu> ubicacionprodus) throws Exception {
		try	{			
			for(UbicacionProdu ubicacionproduLocal:ubicacionprodus) {
				if(ubicacionproduLocal.getId().equals(ubicacionprodu.getId())) {
					ubicacionproduLocal.setIsSelected(ubicacionprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUbicacionProdu(List<UbicacionProdu> ubicacionprodusAux) throws Exception {
		//this.ubicacionprodusAux=ubicacionprodusAux;
		
		for(UbicacionProdu ubicacionproduAux:ubicacionprodusAux) {
			if(ubicacionproduAux.getIsChanged()) {
				ubicacionproduAux.setIsChanged(false);
			}		
			
			if(ubicacionproduAux.getIsNew()) {
				ubicacionproduAux.setIsNew(false);
			}	
			
			if(ubicacionproduAux.getIsDeleted()) {
				ubicacionproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUbicacionProdu(UbicacionProdu ubicacionproduAux) throws Exception {
		//this.ubicacionproduAux=ubicacionproduAux;
		
			if(ubicacionproduAux.getIsChanged()) {
				ubicacionproduAux.setIsChanged(false);
			}		
			
			if(ubicacionproduAux.getIsNew()) {
				ubicacionproduAux.setIsNew(false);
			}	
			
			if(ubicacionproduAux.getIsDeleted()) {
				ubicacionproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UbicacionProdu ubicacionproduAsignar,UbicacionProdu ubicacionprodu) throws Exception {
		ubicacionproduAsignar.setId(ubicacionprodu.getId());	
		ubicacionproduAsignar.setVersionRow(ubicacionprodu.getVersionRow());	
		ubicacionproduAsignar.setid_empresa(ubicacionprodu.getid_empresa());
		ubicacionproduAsignar.setempresa_descripcion(ubicacionprodu.getempresa_descripcion());	
		ubicacionproduAsignar.setid_sucursal(ubicacionprodu.getid_sucursal());
		ubicacionproduAsignar.setsucursal_descripcion(ubicacionprodu.getsucursal_descripcion());	
		ubicacionproduAsignar.setid_bodega(ubicacionprodu.getid_bodega());
		ubicacionproduAsignar.setbodega_descripcion(ubicacionprodu.getbodega_descripcion());	
		ubicacionproduAsignar.setid_producto(ubicacionprodu.getid_producto());
		ubicacionproduAsignar.setproducto_descripcion(ubicacionprodu.getproducto_descripcion());	
		ubicacionproduAsignar.setid_ubicacion_bode(ubicacionprodu.getid_ubicacion_bode());
		ubicacionproduAsignar.setubicacionbode_descripcion(ubicacionprodu.getubicacionbode_descripcion());	
	}
	
	public static void inicializarUbicacionProdu(UbicacionProdu ubicacionprodu) throws Exception {
		try {
				ubicacionprodu.setId(0L);	
					
				ubicacionprodu.setid_empresa(-1L);	
				ubicacionprodu.setid_sucursal(-1L);	
				ubicacionprodu.setid_bodega(-1L);	
				ubicacionprodu.setid_producto(-1L);	
				ubicacionprodu.setid_ubicacion_bode(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUbicacionProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionProduConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionProduConstantesFunciones.LABEL_IDUBICACIONBODE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUbicacionProdu(String sTipo,Row row,Workbook workbook,UbicacionProdu ubicacionprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionprodu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionprodu.getubicacionbode_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUbicacionProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUbicacionProdu() {
		return this.sFinalQueryUbicacionProdu;
	}
	
	public void setsFinalQueryUbicacionProdu(String sFinalQueryUbicacionProdu) {
		this.sFinalQueryUbicacionProdu= sFinalQueryUbicacionProdu;
	}
	
	public Border resaltarSeleccionarUbicacionProdu=null;
	
	public Border setResaltarSeleccionarUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUbicacionProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUbicacionProdu() {
		return this.resaltarSeleccionarUbicacionProdu;
	}
	
	public void setResaltarSeleccionarUbicacionProdu(Border borderResaltarSeleccionarUbicacionProdu) {
		this.resaltarSeleccionarUbicacionProdu= borderResaltarSeleccionarUbicacionProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUbicacionProdu=null;
	public Boolean mostraridUbicacionProdu=true;
	public Boolean activaridUbicacionProdu=true;

	public Border resaltarid_empresaUbicacionProdu=null;
	public Boolean mostrarid_empresaUbicacionProdu=true;
	public Boolean activarid_empresaUbicacionProdu=true;
	public Boolean cargarid_empresaUbicacionProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUbicacionProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalUbicacionProdu=null;
	public Boolean mostrarid_sucursalUbicacionProdu=true;
	public Boolean activarid_sucursalUbicacionProdu=true;
	public Boolean cargarid_sucursalUbicacionProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalUbicacionProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaUbicacionProdu=null;
	public Boolean mostrarid_bodegaUbicacionProdu=true;
	public Boolean activarid_bodegaUbicacionProdu=true;
	public Boolean cargarid_bodegaUbicacionProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaUbicacionProdu=false;//ConEventDepend=true

	public Border resaltarid_productoUbicacionProdu=null;
	public Boolean mostrarid_productoUbicacionProdu=true;
	public Boolean activarid_productoUbicacionProdu=true;
	public Boolean cargarid_productoUbicacionProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoUbicacionProdu=false;//ConEventDepend=true

	public Border resaltarid_ubicacion_bodeUbicacionProdu=null;
	public Boolean mostrarid_ubicacion_bodeUbicacionProdu=true;
	public Boolean activarid_ubicacion_bodeUbicacionProdu=true;
	public Boolean cargarid_ubicacion_bodeUbicacionProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ubicacion_bodeUbicacionProdu=false;//ConEventDepend=true

	
	

	public Border setResaltaridUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltaridUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUbicacionProdu() {
		return this.resaltaridUbicacionProdu;
	}

	public void setResaltaridUbicacionProdu(Border borderResaltar) {
		this.resaltaridUbicacionProdu= borderResaltar;
	}

	public Boolean getMostraridUbicacionProdu() {
		return this.mostraridUbicacionProdu;
	}

	public void setMostraridUbicacionProdu(Boolean mostraridUbicacionProdu) {
		this.mostraridUbicacionProdu= mostraridUbicacionProdu;
	}

	public Boolean getActivaridUbicacionProdu() {
		return this.activaridUbicacionProdu;
	}

	public void setActivaridUbicacionProdu(Boolean activaridUbicacionProdu) {
		this.activaridUbicacionProdu= activaridUbicacionProdu;
	}

	public Border setResaltarid_empresaUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUbicacionProdu() {
		return this.resaltarid_empresaUbicacionProdu;
	}

	public void setResaltarid_empresaUbicacionProdu(Border borderResaltar) {
		this.resaltarid_empresaUbicacionProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaUbicacionProdu() {
		return this.mostrarid_empresaUbicacionProdu;
	}

	public void setMostrarid_empresaUbicacionProdu(Boolean mostrarid_empresaUbicacionProdu) {
		this.mostrarid_empresaUbicacionProdu= mostrarid_empresaUbicacionProdu;
	}

	public Boolean getActivarid_empresaUbicacionProdu() {
		return this.activarid_empresaUbicacionProdu;
	}

	public void setActivarid_empresaUbicacionProdu(Boolean activarid_empresaUbicacionProdu) {
		this.activarid_empresaUbicacionProdu= activarid_empresaUbicacionProdu;
	}

	public Boolean getCargarid_empresaUbicacionProdu() {
		return this.cargarid_empresaUbicacionProdu;
	}

	public void setCargarid_empresaUbicacionProdu(Boolean cargarid_empresaUbicacionProdu) {
		this.cargarid_empresaUbicacionProdu= cargarid_empresaUbicacionProdu;
	}

	public Border setResaltarid_sucursalUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalUbicacionProdu() {
		return this.resaltarid_sucursalUbicacionProdu;
	}

	public void setResaltarid_sucursalUbicacionProdu(Border borderResaltar) {
		this.resaltarid_sucursalUbicacionProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalUbicacionProdu() {
		return this.mostrarid_sucursalUbicacionProdu;
	}

	public void setMostrarid_sucursalUbicacionProdu(Boolean mostrarid_sucursalUbicacionProdu) {
		this.mostrarid_sucursalUbicacionProdu= mostrarid_sucursalUbicacionProdu;
	}

	public Boolean getActivarid_sucursalUbicacionProdu() {
		return this.activarid_sucursalUbicacionProdu;
	}

	public void setActivarid_sucursalUbicacionProdu(Boolean activarid_sucursalUbicacionProdu) {
		this.activarid_sucursalUbicacionProdu= activarid_sucursalUbicacionProdu;
	}

	public Boolean getCargarid_sucursalUbicacionProdu() {
		return this.cargarid_sucursalUbicacionProdu;
	}

	public void setCargarid_sucursalUbicacionProdu(Boolean cargarid_sucursalUbicacionProdu) {
		this.cargarid_sucursalUbicacionProdu= cargarid_sucursalUbicacionProdu;
	}

	public Border setResaltarid_bodegaUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaUbicacionProdu() {
		return this.resaltarid_bodegaUbicacionProdu;
	}

	public void setResaltarid_bodegaUbicacionProdu(Border borderResaltar) {
		this.resaltarid_bodegaUbicacionProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaUbicacionProdu() {
		return this.mostrarid_bodegaUbicacionProdu;
	}

	public void setMostrarid_bodegaUbicacionProdu(Boolean mostrarid_bodegaUbicacionProdu) {
		this.mostrarid_bodegaUbicacionProdu= mostrarid_bodegaUbicacionProdu;
	}

	public Boolean getActivarid_bodegaUbicacionProdu() {
		return this.activarid_bodegaUbicacionProdu;
	}

	public void setActivarid_bodegaUbicacionProdu(Boolean activarid_bodegaUbicacionProdu) {
		this.activarid_bodegaUbicacionProdu= activarid_bodegaUbicacionProdu;
	}

	public Boolean getCargarid_bodegaUbicacionProdu() {
		return this.cargarid_bodegaUbicacionProdu;
	}

	public void setCargarid_bodegaUbicacionProdu(Boolean cargarid_bodegaUbicacionProdu) {
		this.cargarid_bodegaUbicacionProdu= cargarid_bodegaUbicacionProdu;
	}

	public Border setResaltarid_productoUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarid_productoUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoUbicacionProdu() {
		return this.resaltarid_productoUbicacionProdu;
	}

	public void setResaltarid_productoUbicacionProdu(Border borderResaltar) {
		this.resaltarid_productoUbicacionProdu= borderResaltar;
	}

	public Boolean getMostrarid_productoUbicacionProdu() {
		return this.mostrarid_productoUbicacionProdu;
	}

	public void setMostrarid_productoUbicacionProdu(Boolean mostrarid_productoUbicacionProdu) {
		this.mostrarid_productoUbicacionProdu= mostrarid_productoUbicacionProdu;
	}

	public Boolean getActivarid_productoUbicacionProdu() {
		return this.activarid_productoUbicacionProdu;
	}

	public void setActivarid_productoUbicacionProdu(Boolean activarid_productoUbicacionProdu) {
		this.activarid_productoUbicacionProdu= activarid_productoUbicacionProdu;
	}

	public Boolean getCargarid_productoUbicacionProdu() {
		return this.cargarid_productoUbicacionProdu;
	}

	public void setCargarid_productoUbicacionProdu(Boolean cargarid_productoUbicacionProdu) {
		this.cargarid_productoUbicacionProdu= cargarid_productoUbicacionProdu;
	}

	public Border setResaltarid_ubicacion_bodeUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionproduBeanSwingJInternalFrame.jTtoolBarUbicacionProdu.setBorder(borderResaltar);
		
		this.resaltarid_ubicacion_bodeUbicacionProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ubicacion_bodeUbicacionProdu() {
		return this.resaltarid_ubicacion_bodeUbicacionProdu;
	}

	public void setResaltarid_ubicacion_bodeUbicacionProdu(Border borderResaltar) {
		this.resaltarid_ubicacion_bodeUbicacionProdu= borderResaltar;
	}

	public Boolean getMostrarid_ubicacion_bodeUbicacionProdu() {
		return this.mostrarid_ubicacion_bodeUbicacionProdu;
	}

	public void setMostrarid_ubicacion_bodeUbicacionProdu(Boolean mostrarid_ubicacion_bodeUbicacionProdu) {
		this.mostrarid_ubicacion_bodeUbicacionProdu= mostrarid_ubicacion_bodeUbicacionProdu;
	}

	public Boolean getActivarid_ubicacion_bodeUbicacionProdu() {
		return this.activarid_ubicacion_bodeUbicacionProdu;
	}

	public void setActivarid_ubicacion_bodeUbicacionProdu(Boolean activarid_ubicacion_bodeUbicacionProdu) {
		this.activarid_ubicacion_bodeUbicacionProdu= activarid_ubicacion_bodeUbicacionProdu;
	}

	public Boolean getCargarid_ubicacion_bodeUbicacionProdu() {
		return this.cargarid_ubicacion_bodeUbicacionProdu;
	}

	public void setCargarid_ubicacion_bodeUbicacionProdu(Boolean cargarid_ubicacion_bodeUbicacionProdu) {
		this.cargarid_ubicacion_bodeUbicacionProdu= cargarid_ubicacion_bodeUbicacionProdu;
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
		
		
		this.setMostraridUbicacionProdu(esInicial);
		this.setMostrarid_empresaUbicacionProdu(esInicial);
		this.setMostrarid_sucursalUbicacionProdu(esInicial);
		this.setMostrarid_bodegaUbicacionProdu(esInicial);
		this.setMostrarid_productoUbicacionProdu(esInicial);
		this.setMostrarid_ubicacion_bodeUbicacionProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionProduConstantesFunciones.ID)) {
				this.setMostraridUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDUBICACIONBODE)) {
				this.setMostrarid_ubicacion_bodeUbicacionProdu(esAsigna);
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
		
		
		this.setActivaridUbicacionProdu(esInicial);
		this.setActivarid_empresaUbicacionProdu(esInicial);
		this.setActivarid_sucursalUbicacionProdu(esInicial);
		this.setActivarid_bodegaUbicacionProdu(esInicial);
		this.setActivarid_productoUbicacionProdu(esInicial);
		this.setActivarid_ubicacion_bodeUbicacionProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionProduConstantesFunciones.ID)) {
				this.setActivaridUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDUBICACIONBODE)) {
				this.setActivarid_ubicacion_bodeUbicacionProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUbicacionProdu(esInicial);
		this.setResaltarid_empresaUbicacionProdu(esInicial);
		this.setResaltarid_sucursalUbicacionProdu(esInicial);
		this.setResaltarid_bodegaUbicacionProdu(esInicial);
		this.setResaltarid_productoUbicacionProdu(esInicial);
		this.setResaltarid_ubicacion_bodeUbicacionProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionProduConstantesFunciones.ID)) {
				this.setResaltaridUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoUbicacionProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionProduConstantesFunciones.IDUBICACIONBODE)) {
				this.setResaltarid_ubicacion_bodeUbicacionProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaUbicacionProdu=true;

	public Boolean getMostrarFK_IdBodegaUbicacionProdu() {
		return this.mostrarFK_IdBodegaUbicacionProdu;
	}

	public void setMostrarFK_IdBodegaUbicacionProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaUbicacionProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUbicacionProdu=true;

	public Boolean getMostrarFK_IdEmpresaUbicacionProdu() {
		return this.mostrarFK_IdEmpresaUbicacionProdu;
	}

	public void setMostrarFK_IdEmpresaUbicacionProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUbicacionProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalUbicacionProdu=true;

	public Boolean getMostrarFK_IdSucursalUbicacionProdu() {
		return this.mostrarFK_IdSucursalUbicacionProdu;
	}

	public void setMostrarFK_IdSucursalUbicacionProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalUbicacionProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUbicacionBodeUbicacionProdu=true;

	public Boolean getMostrarFK_IdUbicacionBodeUbicacionProdu() {
		return this.mostrarFK_IdUbicacionBodeUbicacionProdu;
	}

	public void setMostrarFK_IdUbicacionBodeUbicacionProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUbicacionBodeUbicacionProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaUbicacionProdu=true;

	public Boolean getActivarFK_IdBodegaUbicacionProdu() {
		return this.activarFK_IdBodegaUbicacionProdu;
	}

	public void setActivarFK_IdBodegaUbicacionProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaUbicacionProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUbicacionProdu=true;

	public Boolean getActivarFK_IdEmpresaUbicacionProdu() {
		return this.activarFK_IdEmpresaUbicacionProdu;
	}

	public void setActivarFK_IdEmpresaUbicacionProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUbicacionProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalUbicacionProdu=true;

	public Boolean getActivarFK_IdSucursalUbicacionProdu() {
		return this.activarFK_IdSucursalUbicacionProdu;
	}

	public void setActivarFK_IdSucursalUbicacionProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalUbicacionProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdUbicacionBodeUbicacionProdu=true;

	public Boolean getActivarFK_IdUbicacionBodeUbicacionProdu() {
		return this.activarFK_IdUbicacionBodeUbicacionProdu;
	}

	public void setActivarFK_IdUbicacionBodeUbicacionProdu(Boolean habilitarResaltar) {
		this.activarFK_IdUbicacionBodeUbicacionProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaUbicacionProdu=null;

	public Border getResaltarFK_IdBodegaUbicacionProdu() {
		return this.resaltarFK_IdBodegaUbicacionProdu;
	}

	public void setResaltarFK_IdBodegaUbicacionProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaUbicacionProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaUbicacionProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUbicacionProdu=null;

	public Border getResaltarFK_IdEmpresaUbicacionProdu() {
		return this.resaltarFK_IdEmpresaUbicacionProdu;
	}

	public void setResaltarFK_IdEmpresaUbicacionProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUbicacionProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUbicacionProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalUbicacionProdu=null;

	public Border getResaltarFK_IdSucursalUbicacionProdu() {
		return this.resaltarFK_IdSucursalUbicacionProdu;
	}

	public void setResaltarFK_IdSucursalUbicacionProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalUbicacionProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalUbicacionProdu= borderResaltar;
	}

	public Border resaltarFK_IdUbicacionBodeUbicacionProdu=null;

	public Border getResaltarFK_IdUbicacionBodeUbicacionProdu() {
		return this.resaltarFK_IdUbicacionBodeUbicacionProdu;
	}

	public void setResaltarFK_IdUbicacionBodeUbicacionProdu(Border borderResaltar) {
		this.resaltarFK_IdUbicacionBodeUbicacionProdu= borderResaltar;
	}

	public void setResaltarFK_IdUbicacionBodeUbicacionProdu(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionProduBeanSwingJInternalFrame ubicacionproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUbicacionBodeUbicacionProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}