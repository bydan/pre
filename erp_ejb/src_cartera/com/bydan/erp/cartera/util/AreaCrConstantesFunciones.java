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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.AreaCrConstantesFunciones;
import com.bydan.erp.cartera.util.AreaCrParameterReturnGeneral;
//import com.bydan.erp.cartera.util.AreaCrParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AreaCrConstantesFunciones extends AreaCrConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AreaCr";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AreaCr"+AreaCrConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AreaCrHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AreaCrHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AreaCrConstantesFunciones.SCHEMA+"_"+AreaCrConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AreaCrHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AreaCrConstantesFunciones.SCHEMA+"_"+AreaCrConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AreaCrConstantesFunciones.SCHEMA+"_"+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AreaCrHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AreaCrConstantesFunciones.SCHEMA+"_"+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AreaCrHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AreaCrHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaCrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AreaCrConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AreaCrConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AreaCrConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AreaCrConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Areas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Area";
	public static final String SCLASSWEBTITULO_LOWER="Area Cr";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AreaCr";
	public static final String OBJECTNAME="areacr";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="area_cr";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select areacr from "+AreaCrConstantesFunciones.SPERSISTENCENAME+" areacr";
	public static String QUERYSELECTNATIVE="select "+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".id,"+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".version_row,"+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".id_empresa,"+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".id_sucursal,"+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".codigo,"+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME+".nombre from "+AreaCrConstantesFunciones.SCHEMA+"."+AreaCrConstantesFunciones.TABLENAME;//+" as "+AreaCrConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AreaCrConstantesFuncionesAdditional areacrConstantesFuncionesAdditional=null;
	
	public AreaCrConstantesFuncionesAdditional getAreaCrConstantesFuncionesAdditional() {
		return this.areacrConstantesFuncionesAdditional;
	}
	
	public void setAreaCrConstantesFuncionesAdditional(AreaCrConstantesFuncionesAdditional areacrConstantesFuncionesAdditional) {
		try {
			this.areacrConstantesFuncionesAdditional=areacrConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAreaCrLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AreaCrConstantesFunciones.IDEMPRESA)) {sLabelColumna=AreaCrConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AreaCrConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AreaCrConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AreaCrConstantesFunciones.CODIGO)) {sLabelColumna=AreaCrConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AreaCrConstantesFunciones.NOMBRE)) {sLabelColumna=AreaCrConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getAreaCrDescripcion(AreaCr areacr) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(areacr !=null/* && areacr.getId()!=0*/) {
			sDescripcion=areacr.getcodigo();//areacrareacr.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAreaCrDescripcionDetallado(AreaCr areacr) {
		String sDescripcion="";
			
		sDescripcion+=AreaCrConstantesFunciones.ID+"=";
		sDescripcion+=areacr.getId().toString()+",";
		sDescripcion+=AreaCrConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=areacr.getVersionRow().toString()+",";
		sDescripcion+=AreaCrConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=areacr.getid_empresa().toString()+",";
		sDescripcion+=AreaCrConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=areacr.getid_sucursal().toString()+",";
		sDescripcion+=AreaCrConstantesFunciones.CODIGO+"=";
		sDescripcion+=areacr.getcodigo()+",";
		sDescripcion+=AreaCrConstantesFunciones.NOMBRE+"=";
		sDescripcion+=areacr.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setAreaCrDescripcion(AreaCr areacr,String sValor) throws Exception {			
		if(areacr !=null) {
			areacr.setcodigo(sValor);;//areacrareacr.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAreaCr(AreaCr areacr,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		areacr.setcodigo(areacr.getcodigo().trim());
		areacr.setnombre(areacr.getnombre().trim());
	}
	
	public static void quitarEspaciosAreaCrs(List<AreaCr> areacrs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AreaCr areacr: areacrs) {
			areacr.setcodigo(areacr.getcodigo().trim());
			areacr.setnombre(areacr.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAreaCr(AreaCr areacr,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && areacr.getConCambioAuxiliar()) {
			areacr.setIsDeleted(areacr.getIsDeletedAuxiliar());	
			areacr.setIsNew(areacr.getIsNewAuxiliar());	
			areacr.setIsChanged(areacr.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			areacr.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			areacr.setIsDeletedAuxiliar(false);	
			areacr.setIsNewAuxiliar(false);	
			areacr.setIsChangedAuxiliar(false);
			
			areacr.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAreaCrs(List<AreaCr> areacrs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AreaCr areacr : areacrs) {
			if(conAsignarBase && areacr.getConCambioAuxiliar()) {
				areacr.setIsDeleted(areacr.getIsDeletedAuxiliar());	
				areacr.setIsNew(areacr.getIsNewAuxiliar());	
				areacr.setIsChanged(areacr.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				areacr.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				areacr.setIsDeletedAuxiliar(false);	
				areacr.setIsNewAuxiliar(false);	
				areacr.setIsChangedAuxiliar(false);
				
				areacr.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAreaCr(AreaCr areacr,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAreaCrs(List<AreaCr> areacrs,Boolean conEnteros) throws Exception  {
		
		for(AreaCr areacr: areacrs) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAreaCr(List<AreaCr> areacrs,AreaCr areacrAux) throws Exception  {
		AreaCrConstantesFunciones.InicializarValoresAreaCr(areacrAux,true);
		
		for(AreaCr areacr: areacrs) {
			if(areacr.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAreaCr(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AreaCrConstantesFunciones.getArrayColumnasGlobalesAreaCr(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAreaCr(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AreaCrConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AreaCrConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AreaCrConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AreaCrConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAreaCr(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AreaCr> areacrs,AreaCr areacr,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AreaCr areacrAux: areacrs) {
			if(areacrAux!=null && areacr!=null) {
				if((areacrAux.getId()==null && areacr.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(areacrAux.getId()!=null && areacr.getId()!=null){
					if(areacrAux.getId().equals(areacr.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAreaCr(List<AreaCr> areacrs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AreaCr areacr: areacrs) {			
			if(areacr.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAreaCr() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_ID, AreaCrConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_VERSIONROW, AreaCrConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_IDEMPRESA, AreaCrConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_IDSUCURSAL, AreaCrConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_CODIGO, AreaCrConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaCrConstantesFunciones.LABEL_NOMBRE, AreaCrConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAreaCr() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaCrConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAreaCr() throws Exception  {
		return AreaCrConstantesFunciones.getTiposSeleccionarAreaCr(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAreaCr(Boolean conFk) throws Exception  {
		return AreaCrConstantesFunciones.getTiposSeleccionarAreaCr(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAreaCr(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaCrConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AreaCrConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaCrConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AreaCrConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaCrConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AreaCrConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaCrConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AreaCrConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAreaCr(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAreaCr(AreaCr areacrAux) throws Exception {
		
			areacrAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(areacrAux.getEmpresa()));
			areacrAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(areacrAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAreaCr(List<AreaCr> areacrsTemp) throws Exception {
		for(AreaCr areacrAux:areacrsTemp) {
			
			areacrAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(areacrAux.getEmpresa()));
			areacrAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(areacrAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAreaCr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAreaCr(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAreaCr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AreaCrConstantesFunciones.getClassesRelationshipsOfAreaCr(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAreaCr(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAreaCr(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AreaCrConstantesFunciones.getClassesRelationshipsFromStringsOfAreaCr(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAreaCr(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(AreaCr areacr,List<AreaCr> areacrs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AreaCr areacrEncontrado=null;
			
			for(AreaCr areacrLocal:areacrs) {
				if(areacrLocal.getId().equals(areacr.getId())) {
					areacrEncontrado=areacrLocal;
					
					areacrLocal.setIsChanged(areacr.getIsChanged());
					areacrLocal.setIsNew(areacr.getIsNew());
					areacrLocal.setIsDeleted(areacr.getIsDeleted());
					
					areacrLocal.setGeneralEntityOriginal(areacr.getGeneralEntityOriginal());
					
					areacrLocal.setId(areacr.getId());	
					areacrLocal.setVersionRow(areacr.getVersionRow());	
					areacrLocal.setid_empresa(areacr.getid_empresa());	
					areacrLocal.setid_sucursal(areacr.getid_sucursal());	
					areacrLocal.setcodigo(areacr.getcodigo());	
					areacrLocal.setnombre(areacr.getnombre());	
					
					
					areacrLocal.setClientes(areacr.getClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!areacr.getIsDeleted()) {
				if(!existe) {
					areacrs.add(areacr);
				}
			} else {
				if(areacrEncontrado!=null && permiteQuitar)  {
					areacrs.remove(areacrEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AreaCr areacr,List<AreaCr> areacrs) throws Exception {
		try	{			
			for(AreaCr areacrLocal:areacrs) {
				if(areacrLocal.getId().equals(areacr.getId())) {
					areacrLocal.setIsSelected(areacr.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAreaCr(List<AreaCr> areacrsAux) throws Exception {
		//this.areacrsAux=areacrsAux;
		
		for(AreaCr areacrAux:areacrsAux) {
			if(areacrAux.getIsChanged()) {
				areacrAux.setIsChanged(false);
			}		
			
			if(areacrAux.getIsNew()) {
				areacrAux.setIsNew(false);
			}	
			
			if(areacrAux.getIsDeleted()) {
				areacrAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAreaCr(AreaCr areacrAux) throws Exception {
		//this.areacrAux=areacrAux;
		
			if(areacrAux.getIsChanged()) {
				areacrAux.setIsChanged(false);
			}		
			
			if(areacrAux.getIsNew()) {
				areacrAux.setIsNew(false);
			}	
			
			if(areacrAux.getIsDeleted()) {
				areacrAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AreaCr areacrAsignar,AreaCr areacr) throws Exception {
		areacrAsignar.setId(areacr.getId());	
		areacrAsignar.setVersionRow(areacr.getVersionRow());	
		areacrAsignar.setid_empresa(areacr.getid_empresa());
		areacrAsignar.setempresa_descripcion(areacr.getempresa_descripcion());	
		areacrAsignar.setid_sucursal(areacr.getid_sucursal());
		areacrAsignar.setsucursal_descripcion(areacr.getsucursal_descripcion());	
		areacrAsignar.setcodigo(areacr.getcodigo());	
		areacrAsignar.setnombre(areacr.getnombre());	
	}
	
	public static void inicializarAreaCr(AreaCr areacr) throws Exception {
		try {
				areacr.setId(0L);	
					
				areacr.setid_empresa(-1L);	
				areacr.setid_sucursal(-1L);	
				areacr.setcodigo("");	
				areacr.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAreaCr(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaCrConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaCrConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaCrConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaCrConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAreaCr(String sTipo,Row row,Workbook workbook,AreaCr areacr,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(areacr.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(areacr.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(areacr.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(areacr.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAreaCr=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAreaCr() {
		return this.sFinalQueryAreaCr;
	}
	
	public void setsFinalQueryAreaCr(String sFinalQueryAreaCr) {
		this.sFinalQueryAreaCr= sFinalQueryAreaCr;
	}
	
	public Border resaltarSeleccionarAreaCr=null;
	
	public Border setResaltarSeleccionarAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAreaCr= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAreaCr() {
		return this.resaltarSeleccionarAreaCr;
	}
	
	public void setResaltarSeleccionarAreaCr(Border borderResaltarSeleccionarAreaCr) {
		this.resaltarSeleccionarAreaCr= borderResaltarSeleccionarAreaCr;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAreaCr=null;
	public Boolean mostraridAreaCr=true;
	public Boolean activaridAreaCr=true;

	public Border resaltarid_empresaAreaCr=null;
	public Boolean mostrarid_empresaAreaCr=true;
	public Boolean activarid_empresaAreaCr=true;
	public Boolean cargarid_empresaAreaCr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAreaCr=false;//ConEventDepend=true

	public Border resaltarid_sucursalAreaCr=null;
	public Boolean mostrarid_sucursalAreaCr=true;
	public Boolean activarid_sucursalAreaCr=true;
	public Boolean cargarid_sucursalAreaCr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAreaCr=false;//ConEventDepend=true

	public Border resaltarcodigoAreaCr=null;
	public Boolean mostrarcodigoAreaCr=true;
	public Boolean activarcodigoAreaCr=true;

	public Border resaltarnombreAreaCr=null;
	public Boolean mostrarnombreAreaCr=true;
	public Boolean activarnombreAreaCr=true;

	
	

	public Border setResaltaridAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltaridAreaCr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAreaCr() {
		return this.resaltaridAreaCr;
	}

	public void setResaltaridAreaCr(Border borderResaltar) {
		this.resaltaridAreaCr= borderResaltar;
	}

	public Boolean getMostraridAreaCr() {
		return this.mostraridAreaCr;
	}

	public void setMostraridAreaCr(Boolean mostraridAreaCr) {
		this.mostraridAreaCr= mostraridAreaCr;
	}

	public Boolean getActivaridAreaCr() {
		return this.activaridAreaCr;
	}

	public void setActivaridAreaCr(Boolean activaridAreaCr) {
		this.activaridAreaCr= activaridAreaCr;
	}

	public Border setResaltarid_empresaAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltarid_empresaAreaCr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAreaCr() {
		return this.resaltarid_empresaAreaCr;
	}

	public void setResaltarid_empresaAreaCr(Border borderResaltar) {
		this.resaltarid_empresaAreaCr= borderResaltar;
	}

	public Boolean getMostrarid_empresaAreaCr() {
		return this.mostrarid_empresaAreaCr;
	}

	public void setMostrarid_empresaAreaCr(Boolean mostrarid_empresaAreaCr) {
		this.mostrarid_empresaAreaCr= mostrarid_empresaAreaCr;
	}

	public Boolean getActivarid_empresaAreaCr() {
		return this.activarid_empresaAreaCr;
	}

	public void setActivarid_empresaAreaCr(Boolean activarid_empresaAreaCr) {
		this.activarid_empresaAreaCr= activarid_empresaAreaCr;
	}

	public Boolean getCargarid_empresaAreaCr() {
		return this.cargarid_empresaAreaCr;
	}

	public void setCargarid_empresaAreaCr(Boolean cargarid_empresaAreaCr) {
		this.cargarid_empresaAreaCr= cargarid_empresaAreaCr;
	}

	public Border setResaltarid_sucursalAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAreaCr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAreaCr() {
		return this.resaltarid_sucursalAreaCr;
	}

	public void setResaltarid_sucursalAreaCr(Border borderResaltar) {
		this.resaltarid_sucursalAreaCr= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAreaCr() {
		return this.mostrarid_sucursalAreaCr;
	}

	public void setMostrarid_sucursalAreaCr(Boolean mostrarid_sucursalAreaCr) {
		this.mostrarid_sucursalAreaCr= mostrarid_sucursalAreaCr;
	}

	public Boolean getActivarid_sucursalAreaCr() {
		return this.activarid_sucursalAreaCr;
	}

	public void setActivarid_sucursalAreaCr(Boolean activarid_sucursalAreaCr) {
		this.activarid_sucursalAreaCr= activarid_sucursalAreaCr;
	}

	public Boolean getCargarid_sucursalAreaCr() {
		return this.cargarid_sucursalAreaCr;
	}

	public void setCargarid_sucursalAreaCr(Boolean cargarid_sucursalAreaCr) {
		this.cargarid_sucursalAreaCr= cargarid_sucursalAreaCr;
	}

	public Border setResaltarcodigoAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltarcodigoAreaCr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAreaCr() {
		return this.resaltarcodigoAreaCr;
	}

	public void setResaltarcodigoAreaCr(Border borderResaltar) {
		this.resaltarcodigoAreaCr= borderResaltar;
	}

	public Boolean getMostrarcodigoAreaCr() {
		return this.mostrarcodigoAreaCr;
	}

	public void setMostrarcodigoAreaCr(Boolean mostrarcodigoAreaCr) {
		this.mostrarcodigoAreaCr= mostrarcodigoAreaCr;
	}

	public Boolean getActivarcodigoAreaCr() {
		return this.activarcodigoAreaCr;
	}

	public void setActivarcodigoAreaCr(Boolean activarcodigoAreaCr) {
		this.activarcodigoAreaCr= activarcodigoAreaCr;
	}

	public Border setResaltarnombreAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltar);
		
		this.resaltarnombreAreaCr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAreaCr() {
		return this.resaltarnombreAreaCr;
	}

	public void setResaltarnombreAreaCr(Border borderResaltar) {
		this.resaltarnombreAreaCr= borderResaltar;
	}

	public Boolean getMostrarnombreAreaCr() {
		return this.mostrarnombreAreaCr;
	}

	public void setMostrarnombreAreaCr(Boolean mostrarnombreAreaCr) {
		this.mostrarnombreAreaCr= mostrarnombreAreaCr;
	}

	public Boolean getActivarnombreAreaCr() {
		return this.activarnombreAreaCr;
	}

	public void setActivarnombreAreaCr(Boolean activarnombreAreaCr) {
		this.activarnombreAreaCr= activarnombreAreaCr;
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
		
		
		this.setMostraridAreaCr(esInicial);
		this.setMostrarid_empresaAreaCr(esInicial);
		this.setMostrarid_sucursalAreaCr(esInicial);
		this.setMostrarcodigoAreaCr(esInicial);
		this.setMostrarnombreAreaCr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaCrConstantesFunciones.ID)) {
				this.setMostraridAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAreaCr(esAsigna);
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
		
		
		this.setActivaridAreaCr(esInicial);
		this.setActivarid_empresaAreaCr(esInicial);
		this.setActivarid_sucursalAreaCr(esInicial);
		this.setActivarcodigoAreaCr(esInicial);
		this.setActivarnombreAreaCr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaCrConstantesFunciones.ID)) {
				this.setActivaridAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAreaCr(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAreaCr(esInicial);
		this.setResaltarid_empresaAreaCr(esInicial);
		this.setResaltarid_sucursalAreaCr(esInicial);
		this.setResaltarcodigoAreaCr(esInicial);
		this.setResaltarnombreAreaCr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaCrConstantesFunciones.ID)) {
				this.setResaltaridAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAreaCr(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaCrConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAreaCr(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteAreaCr=null;

	public Border getResaltarClienteAreaCr() {
		return this.resaltarClienteAreaCr;
	}

	public void setResaltarClienteAreaCr(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteAreaCr= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//areacrBeanSwingJInternalFrame.jTtoolBarAreaCr.setBorder(borderResaltarCliente);
			
		this.resaltarClienteAreaCr= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteAreaCr=true;

	public Boolean getMostrarClienteAreaCr() {
		return this.mostrarClienteAreaCr;
	}

	public void setMostrarClienteAreaCr(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteAreaCr= visibilidadResaltarCliente;
	}



	public Boolean activarClienteAreaCr=true;

	public Boolean gethabilitarResaltarClienteAreaCr() {
		return this.activarClienteAreaCr;
	}

	public void setActivarClienteAreaCr(Boolean habilitarResaltarCliente) {
		this.activarClienteAreaCr= habilitarResaltarCliente;
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

		this.setMostrarClienteAreaCr(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteAreaCr(esAsigna);
				continue;
			}
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

		this.setActivarClienteAreaCr(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteAreaCr(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteAreaCr(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteAreaCr(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoAreaCr=true;

	public Boolean getMostrarBusquedaPorCodigoAreaCr() {
		return this.mostrarBusquedaPorCodigoAreaCr;
	}

	public void setMostrarBusquedaPorCodigoAreaCr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoAreaCr= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreAreaCr=true;

	public Boolean getMostrarBusquedaPorNombreAreaCr() {
		return this.mostrarBusquedaPorNombreAreaCr;
	}

	public void setMostrarBusquedaPorNombreAreaCr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreAreaCr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAreaCr=true;

	public Boolean getMostrarFK_IdEmpresaAreaCr() {
		return this.mostrarFK_IdEmpresaAreaCr;
	}

	public void setMostrarFK_IdEmpresaAreaCr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAreaCr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAreaCr=true;

	public Boolean getMostrarFK_IdSucursalAreaCr() {
		return this.mostrarFK_IdSucursalAreaCr;
	}

	public void setMostrarFK_IdSucursalAreaCr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAreaCr= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoAreaCr=true;

	public Boolean getActivarBusquedaPorCodigoAreaCr() {
		return this.activarBusquedaPorCodigoAreaCr;
	}

	public void setActivarBusquedaPorCodigoAreaCr(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoAreaCr= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreAreaCr=true;

	public Boolean getActivarBusquedaPorNombreAreaCr() {
		return this.activarBusquedaPorNombreAreaCr;
	}

	public void setActivarBusquedaPorNombreAreaCr(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreAreaCr= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAreaCr=true;

	public Boolean getActivarFK_IdEmpresaAreaCr() {
		return this.activarFK_IdEmpresaAreaCr;
	}

	public void setActivarFK_IdEmpresaAreaCr(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAreaCr= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAreaCr=true;

	public Boolean getActivarFK_IdSucursalAreaCr() {
		return this.activarFK_IdSucursalAreaCr;
	}

	public void setActivarFK_IdSucursalAreaCr(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAreaCr= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoAreaCr=null;

	public Border getResaltarBusquedaPorCodigoAreaCr() {
		return this.resaltarBusquedaPorCodigoAreaCr;
	}

	public void setResaltarBusquedaPorCodigoAreaCr(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoAreaCr= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoAreaCr= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreAreaCr=null;

	public Border getResaltarBusquedaPorNombreAreaCr() {
		return this.resaltarBusquedaPorNombreAreaCr;
	}

	public void setResaltarBusquedaPorNombreAreaCr(Border borderResaltar) {
		this.resaltarBusquedaPorNombreAreaCr= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreAreaCr= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAreaCr=null;

	public Border getResaltarFK_IdEmpresaAreaCr() {
		return this.resaltarFK_IdEmpresaAreaCr;
	}

	public void setResaltarFK_IdEmpresaAreaCr(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAreaCr= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAreaCr= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAreaCr=null;

	public Border getResaltarFK_IdSucursalAreaCr() {
		return this.resaltarFK_IdSucursalAreaCr;
	}

	public void setResaltarFK_IdSucursalAreaCr(Border borderResaltar) {
		this.resaltarFK_IdSucursalAreaCr= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAreaCr(ParametroGeneralUsuario parametroGeneralUsuario/*AreaCrBeanSwingJInternalFrame areacrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAreaCr= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}