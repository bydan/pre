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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.ZonaConstantesFunciones;
import com.bydan.erp.seguridad.util.ZonaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ZonaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ZonaConstantesFunciones extends ZonaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Zona";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Zona"+ZonaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ZonaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ZonaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ZonaConstantesFunciones.SCHEMA+"_"+ZonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ZonaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ZonaConstantesFunciones.SCHEMA+"_"+ZonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ZonaConstantesFunciones.SCHEMA+"_"+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ZonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ZonaConstantesFunciones.SCHEMA+"_"+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ZonaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ZonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ZonaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ZonaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ZonaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ZonaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Zonas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Zona";
	public static final String SCLASSWEBTITULO_LOWER="Zona";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Zona";
	public static final String OBJECTNAME="zona";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="zona";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select zona from "+ZonaConstantesFunciones.SPERSISTENCENAME+" zona";
	public static String QUERYSELECTNATIVE="select "+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME+".id,"+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME+".version_row,"+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME+".id_empresa,"+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME+".id_sucursal,"+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME+".nombre from "+ZonaConstantesFunciones.SCHEMA+"."+ZonaConstantesFunciones.TABLENAME;//+" as "+ZonaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ZonaConstantesFuncionesAdditional zonaConstantesFuncionesAdditional=null;
	
	public ZonaConstantesFuncionesAdditional getZonaConstantesFuncionesAdditional() {
		return this.zonaConstantesFuncionesAdditional;
	}
	
	public void setZonaConstantesFuncionesAdditional(ZonaConstantesFuncionesAdditional zonaConstantesFuncionesAdditional) {
		try {
			this.zonaConstantesFuncionesAdditional=zonaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
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
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getZonaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ZonaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ZonaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ZonaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ZonaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ZonaConstantesFunciones.NOMBRE)) {sLabelColumna=ZonaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(zona !=null/* && zona.getId()!=0*/) {
			sDescripcion=zona.getnombre();//zonazona.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getZonaDescripcionDetallado(Zona zona) {
		String sDescripcion="";
			
		sDescripcion+=ZonaConstantesFunciones.ID+"=";
		sDescripcion+=zona.getId().toString()+",";
		sDescripcion+=ZonaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=zona.getVersionRow().toString()+",";
		sDescripcion+=ZonaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=zona.getid_empresa().toString()+",";
		sDescripcion+=ZonaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=zona.getid_sucursal().toString()+",";
		sDescripcion+=ZonaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=zona.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setZonaDescripcion(Zona zona,String sValor) throws Exception {			
		if(zona !=null) {
			zona.setnombre(sValor);;//zonazona.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("PorIdEmpresaPorIdSucursalPorNombre")) {
			sNombreIndice="Tipo=  Por Empresa Por Sucursal Por Nombre";
		} else if(sNombreIndice.equals("PorIdPorIdEmpresaPorIdSucursal")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndicePorIdEmpresaPorIdSucursalPorNombre(Long id_empresa,Long id_sucursal,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorIdEmpresaPorIdSucursal(Long id,Long id_empresa,Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosZona(Zona zona,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		zona.setnombre(zona.getnombre().trim());
	}
	
	public static void quitarEspaciosZonas(List<Zona> zonas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Zona zona: zonas) {
			zona.setnombre(zona.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresZona(Zona zona,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && zona.getConCambioAuxiliar()) {
			zona.setIsDeleted(zona.getIsDeletedAuxiliar());	
			zona.setIsNew(zona.getIsNewAuxiliar());	
			zona.setIsChanged(zona.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			zona.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			zona.setIsDeletedAuxiliar(false);	
			zona.setIsNewAuxiliar(false);	
			zona.setIsChangedAuxiliar(false);
			
			zona.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresZonas(List<Zona> zonas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Zona zona : zonas) {
			if(conAsignarBase && zona.getConCambioAuxiliar()) {
				zona.setIsDeleted(zona.getIsDeletedAuxiliar());	
				zona.setIsNew(zona.getIsNewAuxiliar());	
				zona.setIsChanged(zona.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				zona.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				zona.setIsDeletedAuxiliar(false);	
				zona.setIsNewAuxiliar(false);	
				zona.setIsChangedAuxiliar(false);
				
				zona.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresZona(Zona zona,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresZonas(List<Zona> zonas,Boolean conEnteros) throws Exception  {
		
		for(Zona zona: zonas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaZona(List<Zona> zonas,Zona zonaAux) throws Exception  {
		ZonaConstantesFunciones.InicializarValoresZona(zonaAux,true);
		
		for(Zona zona: zonas) {
			if(zona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesZona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ZonaConstantesFunciones.getArrayColumnasGlobalesZona(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesZona(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ZonaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ZonaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ZonaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ZonaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoZona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Zona> zonas,Zona zona,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Zona zonaAux: zonas) {
			if(zonaAux!=null && zona!=null) {
				if((zonaAux.getId()==null && zona.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(zonaAux.getId()!=null && zona.getId()!=null){
					if(zonaAux.getId().equals(zona.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaZona(List<Zona> zonas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Zona zona: zonas) {			
			if(zona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaZona() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ZonaConstantesFunciones.LABEL_ID, ZonaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ZonaConstantesFunciones.LABEL_VERSIONROW, ZonaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ZonaConstantesFunciones.LABEL_IDEMPRESA, ZonaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ZonaConstantesFunciones.LABEL_IDSUCURSAL, ZonaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ZonaConstantesFunciones.LABEL_NOMBRE, ZonaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasZona() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ZonaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ZonaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ZonaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ZonaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ZonaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarZona() throws Exception  {
		return ZonaConstantesFunciones.getTiposSeleccionarZona(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarZona(Boolean conFk) throws Exception  {
		return ZonaConstantesFunciones.getTiposSeleccionarZona(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarZona(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ZonaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ZonaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ZonaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ZonaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ZonaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ZonaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesZona(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesZona(Zona zonaAux) throws Exception {
		
			zonaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(zonaAux.getEmpresa()));
			zonaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(zonaAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesZona(List<Zona> zonasTemp) throws Exception {
		for(Zona zonaAux:zonasTemp) {
			
			zonaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(zonaAux.getEmpresa()));
			zonaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(zonaAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ZonaConstantesFunciones.getClassesRelationshipsOfZona(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				classes.add(new Classe(VendedorZona.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(PresupuestoVentas.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(PresupuestoVentasLineas.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(VendedorZona.class)) {
						classes.add(new Classe(VendedorZona.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentas.class)) {
						classes.add(new Classe(PresupuestoVentas.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentasLineas.class)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ZonaConstantesFunciones.getClassesRelationshipsFromStringsOfZona(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(VendedorZona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VendedorZona.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(VendedorZona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VendedorZona.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
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
	public static void actualizarLista(Zona zona,List<Zona> zonas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Zona zonaEncontrado=null;
			
			for(Zona zonaLocal:zonas) {
				if(zonaLocal.getId().equals(zona.getId())) {
					zonaEncontrado=zonaLocal;
					
					zonaLocal.setIsChanged(zona.getIsChanged());
					zonaLocal.setIsNew(zona.getIsNew());
					zonaLocal.setIsDeleted(zona.getIsDeleted());
					
					zonaLocal.setGeneralEntityOriginal(zona.getGeneralEntityOriginal());
					
					zonaLocal.setId(zona.getId());	
					zonaLocal.setVersionRow(zona.getVersionRow());	
					zonaLocal.setid_empresa(zona.getid_empresa());	
					zonaLocal.setid_sucursal(zona.getid_sucursal());	
					zonaLocal.setnombre(zona.getnombre());	
					
					
					zonaLocal.setPresupuestoVentasLineass(zona.getPresupuestoVentasLineass());
					zonaLocal.setVendedors(zona.getVendedors());
					zonaLocal.setClientes(zona.getClientes());
					zonaLocal.setSubClientes(zona.getSubClientes());
					zonaLocal.setPresupuestoVentass(zona.getPresupuestoVentass());
					zonaLocal.setVendedorZonas(zona.getVendedorZonas());
					
					existe=true;
					break;
				}
			}
			
			if(!zona.getIsDeleted()) {
				if(!existe) {
					zonas.add(zona);
				}
			} else {
				if(zonaEncontrado!=null && permiteQuitar)  {
					zonas.remove(zonaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Zona zona,List<Zona> zonas) throws Exception {
		try	{			
			for(Zona zonaLocal:zonas) {
				if(zonaLocal.getId().equals(zona.getId())) {
					zonaLocal.setIsSelected(zona.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesZona(List<Zona> zonasAux) throws Exception {
		//this.zonasAux=zonasAux;
		
		for(Zona zonaAux:zonasAux) {
			if(zonaAux.getIsChanged()) {
				zonaAux.setIsChanged(false);
			}		
			
			if(zonaAux.getIsNew()) {
				zonaAux.setIsNew(false);
			}	
			
			if(zonaAux.getIsDeleted()) {
				zonaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesZona(Zona zonaAux) throws Exception {
		//this.zonaAux=zonaAux;
		
			if(zonaAux.getIsChanged()) {
				zonaAux.setIsChanged(false);
			}		
			
			if(zonaAux.getIsNew()) {
				zonaAux.setIsNew(false);
			}	
			
			if(zonaAux.getIsDeleted()) {
				zonaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Zona zonaAsignar,Zona zona) throws Exception {
		zonaAsignar.setId(zona.getId());	
		zonaAsignar.setVersionRow(zona.getVersionRow());	
		zonaAsignar.setid_empresa(zona.getid_empresa());
		zonaAsignar.setempresa_descripcion(zona.getempresa_descripcion());	
		zonaAsignar.setid_sucursal(zona.getid_sucursal());
		zonaAsignar.setsucursal_descripcion(zona.getsucursal_descripcion());	
		zonaAsignar.setnombre(zona.getnombre());	
	}
	
	public static void inicializarZona(Zona zona) throws Exception {
		try {
				zona.setId(0L);	
					
				zona.setid_empresa(-1L);	
				zona.setid_sucursal(-1L);	
				zona.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderZona(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ZonaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ZonaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ZonaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataZona(String sTipo,Row row,Workbook workbook,Zona zona,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(zona.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(zona.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(zona.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryZona=Constantes.SFINALQUERY;
	
	public String getsFinalQueryZona() {
		return this.sFinalQueryZona;
	}
	
	public void setsFinalQueryZona(String sFinalQueryZona) {
		this.sFinalQueryZona= sFinalQueryZona;
	}
	
	public Border resaltarSeleccionarZona=null;
	
	public Border setResaltarSeleccionarZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltar);
		
		this.resaltarSeleccionarZona= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarZona() {
		return this.resaltarSeleccionarZona;
	}
	
	public void setResaltarSeleccionarZona(Border borderResaltarSeleccionarZona) {
		this.resaltarSeleccionarZona= borderResaltarSeleccionarZona;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridZona=null;
	public Boolean mostraridZona=true;
	public Boolean activaridZona=true;

	public Border resaltarid_empresaZona=null;
	public Boolean mostrarid_empresaZona=true;
	public Boolean activarid_empresaZona=true;
	public Boolean cargarid_empresaZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaZona=false;//ConEventDepend=true

	public Border resaltarid_sucursalZona=null;
	public Boolean mostrarid_sucursalZona=true;
	public Boolean activarid_sucursalZona=true;
	public Boolean cargarid_sucursalZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalZona=false;//ConEventDepend=true

	public Border resaltarnombreZona=null;
	public Boolean mostrarnombreZona=true;
	public Boolean activarnombreZona=true;

	
	

	public Border setResaltaridZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltar);
		
		this.resaltaridZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridZona() {
		return this.resaltaridZona;
	}

	public void setResaltaridZona(Border borderResaltar) {
		this.resaltaridZona= borderResaltar;
	}

	public Boolean getMostraridZona() {
		return this.mostraridZona;
	}

	public void setMostraridZona(Boolean mostraridZona) {
		this.mostraridZona= mostraridZona;
	}

	public Boolean getActivaridZona() {
		return this.activaridZona;
	}

	public void setActivaridZona(Boolean activaridZona) {
		this.activaridZona= activaridZona;
	}

	public Border setResaltarid_empresaZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltar);
		
		this.resaltarid_empresaZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaZona() {
		return this.resaltarid_empresaZona;
	}

	public void setResaltarid_empresaZona(Border borderResaltar) {
		this.resaltarid_empresaZona= borderResaltar;
	}

	public Boolean getMostrarid_empresaZona() {
		return this.mostrarid_empresaZona;
	}

	public void setMostrarid_empresaZona(Boolean mostrarid_empresaZona) {
		this.mostrarid_empresaZona= mostrarid_empresaZona;
	}

	public Boolean getActivarid_empresaZona() {
		return this.activarid_empresaZona;
	}

	public void setActivarid_empresaZona(Boolean activarid_empresaZona) {
		this.activarid_empresaZona= activarid_empresaZona;
	}

	public Boolean getCargarid_empresaZona() {
		return this.cargarid_empresaZona;
	}

	public void setCargarid_empresaZona(Boolean cargarid_empresaZona) {
		this.cargarid_empresaZona= cargarid_empresaZona;
	}

	public Border setResaltarid_sucursalZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltar);
		
		this.resaltarid_sucursalZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalZona() {
		return this.resaltarid_sucursalZona;
	}

	public void setResaltarid_sucursalZona(Border borderResaltar) {
		this.resaltarid_sucursalZona= borderResaltar;
	}

	public Boolean getMostrarid_sucursalZona() {
		return this.mostrarid_sucursalZona;
	}

	public void setMostrarid_sucursalZona(Boolean mostrarid_sucursalZona) {
		this.mostrarid_sucursalZona= mostrarid_sucursalZona;
	}

	public Boolean getActivarid_sucursalZona() {
		return this.activarid_sucursalZona;
	}

	public void setActivarid_sucursalZona(Boolean activarid_sucursalZona) {
		this.activarid_sucursalZona= activarid_sucursalZona;
	}

	public Boolean getCargarid_sucursalZona() {
		return this.cargarid_sucursalZona;
	}

	public void setCargarid_sucursalZona(Boolean cargarid_sucursalZona) {
		this.cargarid_sucursalZona= cargarid_sucursalZona;
	}

	public Border setResaltarnombreZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltar);
		
		this.resaltarnombreZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreZona() {
		return this.resaltarnombreZona;
	}

	public void setResaltarnombreZona(Border borderResaltar) {
		this.resaltarnombreZona= borderResaltar;
	}

	public Boolean getMostrarnombreZona() {
		return this.mostrarnombreZona;
	}

	public void setMostrarnombreZona(Boolean mostrarnombreZona) {
		this.mostrarnombreZona= mostrarnombreZona;
	}

	public Boolean getActivarnombreZona() {
		return this.activarnombreZona;
	}

	public void setActivarnombreZona(Boolean activarnombreZona) {
		this.activarnombreZona= activarnombreZona;
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
		
		
		this.setMostraridZona(esInicial);
		this.setMostrarid_empresaZona(esInicial);
		this.setMostrarid_sucursalZona(esInicial);
		this.setMostrarnombreZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ZonaConstantesFunciones.ID)) {
				this.setMostraridZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreZona(esAsigna);
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
		
		
		this.setActivaridZona(esInicial);
		this.setActivarid_empresaZona(esInicial);
		this.setActivarid_sucursalZona(esInicial);
		this.setActivarnombreZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ZonaConstantesFunciones.ID)) {
				this.setActivaridZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreZona(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridZona(esInicial);
		this.setResaltarid_empresaZona(esInicial);
		this.setResaltarid_sucursalZona(esInicial);
		this.setResaltarnombreZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ZonaConstantesFunciones.ID)) {
				this.setResaltaridZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(ZonaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreZona(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarSubClienteZona=null;

	public Border getResaltarSubClienteZona() {
		return this.resaltarSubClienteZona;
	}

	public void setResaltarSubClienteZona(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteZona= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteZona= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteZona=true;

	public Boolean getMostrarSubClienteZona() {
		return this.mostrarSubClienteZona;
	}

	public void setMostrarSubClienteZona(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteZona= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteZona=true;

	public Boolean gethabilitarResaltarSubClienteZona() {
		return this.activarSubClienteZona;
	}

	public void setActivarSubClienteZona(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteZona= habilitarResaltarSubCliente;
	}


	public Border resaltarVendedorZona=null;

	public Border getResaltarVendedorZona() {
		return this.resaltarVendedorZona;
	}

	public void setResaltarVendedorZona(Border borderResaltarVendedor) {
		if(borderResaltarVendedor!=null) {
			this.resaltarVendedorZona= borderResaltarVendedor;
		}
	}

	public Border setResaltarVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarVendedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarVendedor);
			
		this.resaltarVendedorZona= borderResaltarVendedor;

		 return borderResaltarVendedor;
	}



	public Boolean mostrarVendedorZona=true;

	public Boolean getMostrarVendedorZona() {
		return this.mostrarVendedorZona;
	}

	public void setMostrarVendedorZona(Boolean visibilidadResaltarVendedor) {
		this.mostrarVendedorZona= visibilidadResaltarVendedor;
	}



	public Boolean activarVendedorZona=true;

	public Boolean gethabilitarResaltarVendedorZona() {
		return this.activarVendedorZona;
	}

	public void setActivarVendedorZona(Boolean habilitarResaltarVendedor) {
		this.activarVendedorZona= habilitarResaltarVendedor;
	}


	public Border resaltarClienteZona=null;

	public Border getResaltarClienteZona() {
		return this.resaltarClienteZona;
	}

	public void setResaltarClienteZona(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteZona= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarCliente);
			
		this.resaltarClienteZona= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteZona=true;

	public Boolean getMostrarClienteZona() {
		return this.mostrarClienteZona;
	}

	public void setMostrarClienteZona(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteZona= visibilidadResaltarCliente;
	}



	public Boolean activarClienteZona=true;

	public Boolean gethabilitarResaltarClienteZona() {
		return this.activarClienteZona;
	}

	public void setActivarClienteZona(Boolean habilitarResaltarCliente) {
		this.activarClienteZona= habilitarResaltarCliente;
	}


	public Border resaltarVendedorZonaZona=null;

	public Border getResaltarVendedorZonaZona() {
		return this.resaltarVendedorZonaZona;
	}

	public void setResaltarVendedorZonaZona(Border borderResaltarVendedorZona) {
		if(borderResaltarVendedorZona!=null) {
			this.resaltarVendedorZonaZona= borderResaltarVendedorZona;
		}
	}

	public Border setResaltarVendedorZonaZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarVendedorZona=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarVendedorZona);
			
		this.resaltarVendedorZonaZona= borderResaltarVendedorZona;

		 return borderResaltarVendedorZona;
	}



	public Boolean mostrarVendedorZonaZona=true;

	public Boolean getMostrarVendedorZonaZona() {
		return this.mostrarVendedorZonaZona;
	}

	public void setMostrarVendedorZonaZona(Boolean visibilidadResaltarVendedorZona) {
		this.mostrarVendedorZonaZona= visibilidadResaltarVendedorZona;
	}



	public Boolean activarVendedorZonaZona=true;

	public Boolean gethabilitarResaltarVendedorZonaZona() {
		return this.activarVendedorZonaZona;
	}

	public void setActivarVendedorZonaZona(Boolean habilitarResaltarVendedorZona) {
		this.activarVendedorZonaZona= habilitarResaltarVendedorZona;
	}


	public Border resaltarPresupuestoVentasZona=null;

	public Border getResaltarPresupuestoVentasZona() {
		return this.resaltarPresupuestoVentasZona;
	}

	public void setResaltarPresupuestoVentasZona(Border borderResaltarPresupuestoVentas) {
		if(borderResaltarPresupuestoVentas!=null) {
			this.resaltarPresupuestoVentasZona= borderResaltarPresupuestoVentas;
		}
	}

	public Border setResaltarPresupuestoVentasZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarPresupuestoVentas);
			
		this.resaltarPresupuestoVentasZona= borderResaltarPresupuestoVentas;

		 return borderResaltarPresupuestoVentas;
	}



	public Boolean mostrarPresupuestoVentasZona=true;

	public Boolean getMostrarPresupuestoVentasZona() {
		return this.mostrarPresupuestoVentasZona;
	}

	public void setMostrarPresupuestoVentasZona(Boolean visibilidadResaltarPresupuestoVentas) {
		this.mostrarPresupuestoVentasZona= visibilidadResaltarPresupuestoVentas;
	}



	public Boolean activarPresupuestoVentasZona=true;

	public Boolean gethabilitarResaltarPresupuestoVentasZona() {
		return this.activarPresupuestoVentasZona;
	}

	public void setActivarPresupuestoVentasZona(Boolean habilitarResaltarPresupuestoVentas) {
		this.activarPresupuestoVentasZona= habilitarResaltarPresupuestoVentas;
	}


	public Border resaltarPresupuestoVentasLineasZona=null;

	public Border getResaltarPresupuestoVentasLineasZona() {
		return this.resaltarPresupuestoVentasLineasZona;
	}

	public void setResaltarPresupuestoVentasLineasZona(Border borderResaltarPresupuestoVentasLineas) {
		if(borderResaltarPresupuestoVentasLineas!=null) {
			this.resaltarPresupuestoVentasLineasZona= borderResaltarPresupuestoVentasLineas;
		}
	}

	public Border setResaltarPresupuestoVentasLineasZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentasLineas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//zonaBeanSwingJInternalFrame.jTtoolBarZona.setBorder(borderResaltarPresupuestoVentasLineas);
			
		this.resaltarPresupuestoVentasLineasZona= borderResaltarPresupuestoVentasLineas;

		 return borderResaltarPresupuestoVentasLineas;
	}



	public Boolean mostrarPresupuestoVentasLineasZona=true;

	public Boolean getMostrarPresupuestoVentasLineasZona() {
		return this.mostrarPresupuestoVentasLineasZona;
	}

	public void setMostrarPresupuestoVentasLineasZona(Boolean visibilidadResaltarPresupuestoVentasLineas) {
		this.mostrarPresupuestoVentasLineasZona= visibilidadResaltarPresupuestoVentasLineas;
	}



	public Boolean activarPresupuestoVentasLineasZona=true;

	public Boolean gethabilitarResaltarPresupuestoVentasLineasZona() {
		return this.activarPresupuestoVentasLineasZona;
	}

	public void setActivarPresupuestoVentasLineasZona(Boolean habilitarResaltarPresupuestoVentasLineas) {
		this.activarPresupuestoVentasLineasZona= habilitarResaltarPresupuestoVentasLineas;
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

		this.setMostrarSubClienteZona(esInicial);
		this.setMostrarVendedorZona(esInicial);
		this.setMostrarClienteZona(esInicial);
		this.setMostrarVendedorZonaZona(esInicial);
		this.setMostrarPresupuestoVentasZona(esInicial);
		this.setMostrarPresupuestoVentasLineasZona(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setMostrarVendedorZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setMostrarVendedorZonaZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setMostrarPresupuestoVentasZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setMostrarPresupuestoVentasLineasZona(esAsigna);
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

		this.setActivarSubClienteZona(esInicial);
		this.setActivarVendedorZona(esInicial);
		this.setActivarClienteZona(esInicial);
		this.setActivarVendedorZonaZona(esInicial);
		this.setActivarPresupuestoVentasZona(esInicial);
		this.setActivarPresupuestoVentasLineasZona(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setActivarVendedorZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setActivarVendedorZonaZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setActivarPresupuestoVentasZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setActivarPresupuestoVentasLineasZona(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarSubClienteZona(esInicial);
		this.setResaltarVendedorZona(esInicial);
		this.setResaltarClienteZona(esInicial);
		this.setResaltarVendedorZonaZona(esInicial);
		this.setResaltarPresupuestoVentasZona(esInicial);
		this.setResaltarPresupuestoVentasLineasZona(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vendedor.class)) {
				this.setResaltarVendedorZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(VendedorZona.class)) {
				this.setResaltarVendedorZonaZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setResaltarPresupuestoVentasZona(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setResaltarPresupuestoVentasLineasZona(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreZona=true;

	public Boolean getMostrarBusquedaPorNombreZona() {
		return this.mostrarBusquedaPorNombreZona;
	}

	public void setMostrarBusquedaPorNombreZona(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreZona= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaZona=true;

	public Boolean getMostrarFK_IdEmpresaZona() {
		return this.mostrarFK_IdEmpresaZona;
	}

	public void setMostrarFK_IdEmpresaZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaZona= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalZona=true;

	public Boolean getMostrarFK_IdSucursalZona() {
		return this.mostrarFK_IdSucursalZona;
	}

	public void setMostrarFK_IdSucursalZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalZona= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreZona=true;

	public Boolean getActivarBusquedaPorNombreZona() {
		return this.activarBusquedaPorNombreZona;
	}

	public void setActivarBusquedaPorNombreZona(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreZona= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaZona=true;

	public Boolean getActivarFK_IdEmpresaZona() {
		return this.activarFK_IdEmpresaZona;
	}

	public void setActivarFK_IdEmpresaZona(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaZona= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalZona=true;

	public Boolean getActivarFK_IdSucursalZona() {
		return this.activarFK_IdSucursalZona;
	}

	public void setActivarFK_IdSucursalZona(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalZona= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreZona=null;

	public Border getResaltarBusquedaPorNombreZona() {
		return this.resaltarBusquedaPorNombreZona;
	}

	public void setResaltarBusquedaPorNombreZona(Border borderResaltar) {
		this.resaltarBusquedaPorNombreZona= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreZona= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaZona=null;

	public Border getResaltarFK_IdEmpresaZona() {
		return this.resaltarFK_IdEmpresaZona;
	}

	public void setResaltarFK_IdEmpresaZona(Border borderResaltar) {
		this.resaltarFK_IdEmpresaZona= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaZona= borderResaltar;
	}

	public Border resaltarFK_IdSucursalZona=null;

	public Border getResaltarFK_IdSucursalZona() {
		return this.resaltarFK_IdSucursalZona;
	}

	public void setResaltarFK_IdSucursalZona(Border borderResaltar) {
		this.resaltarFK_IdSucursalZona= borderResaltar;
	}

	public void setResaltarFK_IdSucursalZona(ParametroGeneralUsuario parametroGeneralUsuario/*ZonaBeanSwingJInternalFrame zonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalZona= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}