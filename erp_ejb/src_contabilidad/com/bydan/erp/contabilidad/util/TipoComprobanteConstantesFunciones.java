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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoComprobanteConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoComprobanteParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoComprobanteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoComprobanteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoComprobante";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoComprobante"+TipoComprobanteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoComprobanteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoComprobanteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoComprobanteConstantesFunciones.SCHEMA+"_"+TipoComprobanteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoComprobanteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoComprobanteConstantesFunciones.SCHEMA+"_"+TipoComprobanteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoComprobanteConstantesFunciones.SCHEMA+"_"+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoComprobanteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoComprobanteConstantesFunciones.SCHEMA+"_"+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComprobanteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComprobanteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComprobanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoComprobanteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoComprobanteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoComprobanteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoComprobanteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Comprobantes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Comprobante";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Comprobante";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoComprobante";
	public static final String OBJECTNAME="tipocomprobante";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_comprobante";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocomprobante from "+TipoComprobanteConstantesFunciones.SPERSISTENCENAME+" tipocomprobante";
	public static String QUERYSELECTNATIVE="select "+TipoComprobanteConstantesFunciones.SCHEMA+"."+TipoComprobanteConstantesFunciones.TABLENAME+".id,"+TipoComprobanteConstantesFunciones.SCHEMA+"."+TipoComprobanteConstantesFunciones.TABLENAME+".version_row,"+TipoComprobanteConstantesFunciones.SCHEMA+"."+TipoComprobanteConstantesFunciones.TABLENAME+".id_empresa,"+TipoComprobanteConstantesFunciones.SCHEMA+"."+TipoComprobanteConstantesFunciones.TABLENAME+".nombre from "+TipoComprobanteConstantesFunciones.SCHEMA+"."+TipoComprobanteConstantesFunciones.TABLENAME;//+" as "+TipoComprobanteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoComprobanteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoComprobanteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoComprobanteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoComprobanteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoComprobanteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoComprobanteDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocomprobante !=null/* && tipocomprobante.getId()!=0*/) {
			sDescripcion=tipocomprobante.getnombre();//tipocomprobantetipocomprobante.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoComprobanteDescripcionDetallado(TipoComprobante tipocomprobante) {
		String sDescripcion="";
			
		sDescripcion+=TipoComprobanteConstantesFunciones.ID+"=";
		sDescripcion+=tipocomprobante.getId().toString()+",";
		sDescripcion+=TipoComprobanteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocomprobante.getVersionRow().toString()+",";
		sDescripcion+=TipoComprobanteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocomprobante.getid_empresa().toString()+",";
		sDescripcion+=TipoComprobanteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocomprobante.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoComprobanteDescripcion(TipoComprobante tipocomprobante,String sValor) throws Exception {			
		if(tipocomprobante !=null) {
			tipocomprobante.setnombre(sValor);;//tipocomprobantetipocomprobante.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTipoComprobante(TipoComprobante tipocomprobante,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocomprobante.setnombre(tipocomprobante.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoComprobantes(List<TipoComprobante> tipocomprobantes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoComprobante tipocomprobante: tipocomprobantes) {
			tipocomprobante.setnombre(tipocomprobante.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoComprobante(TipoComprobante tipocomprobante,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocomprobante.getConCambioAuxiliar()) {
			tipocomprobante.setIsDeleted(tipocomprobante.getIsDeletedAuxiliar());	
			tipocomprobante.setIsNew(tipocomprobante.getIsNewAuxiliar());	
			tipocomprobante.setIsChanged(tipocomprobante.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocomprobante.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocomprobante.setIsDeletedAuxiliar(false);	
			tipocomprobante.setIsNewAuxiliar(false);	
			tipocomprobante.setIsChangedAuxiliar(false);
			
			tipocomprobante.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoComprobantes(List<TipoComprobante> tipocomprobantes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoComprobante tipocomprobante : tipocomprobantes) {
			if(conAsignarBase && tipocomprobante.getConCambioAuxiliar()) {
				tipocomprobante.setIsDeleted(tipocomprobante.getIsDeletedAuxiliar());	
				tipocomprobante.setIsNew(tipocomprobante.getIsNewAuxiliar());	
				tipocomprobante.setIsChanged(tipocomprobante.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocomprobante.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocomprobante.setIsDeletedAuxiliar(false);	
				tipocomprobante.setIsNewAuxiliar(false);	
				tipocomprobante.setIsChangedAuxiliar(false);
				
				tipocomprobante.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoComprobante(TipoComprobante tipocomprobante,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoComprobantes(List<TipoComprobante> tipocomprobantes,Boolean conEnteros) throws Exception  {
		
		for(TipoComprobante tipocomprobante: tipocomprobantes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoComprobante(List<TipoComprobante> tipocomprobantes,TipoComprobante tipocomprobanteAux) throws Exception  {
		TipoComprobanteConstantesFunciones.InicializarValoresTipoComprobante(tipocomprobanteAux,true);
		
		for(TipoComprobante tipocomprobante: tipocomprobantes) {
			if(tipocomprobante.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoComprobante(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoComprobanteConstantesFunciones.getArrayColumnasGlobalesTipoComprobante(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoComprobante(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoComprobanteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoComprobanteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoComprobante(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoComprobante> tipocomprobantes,TipoComprobante tipocomprobante,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoComprobante tipocomprobanteAux: tipocomprobantes) {
			if(tipocomprobanteAux!=null && tipocomprobante!=null) {
				if((tipocomprobanteAux.getId()==null && tipocomprobante.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocomprobanteAux.getId()!=null && tipocomprobante.getId()!=null){
					if(tipocomprobanteAux.getId().equals(tipocomprobante.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoComprobante(List<TipoComprobante> tipocomprobantes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoComprobante tipocomprobante: tipocomprobantes) {			
			if(tipocomprobante.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoComprobante() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoComprobanteConstantesFunciones.LABEL_ID, TipoComprobanteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComprobanteConstantesFunciones.LABEL_VERSIONROW, TipoComprobanteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComprobanteConstantesFunciones.LABEL_IDEMPRESA, TipoComprobanteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComprobanteConstantesFunciones.LABEL_NOMBRE, TipoComprobanteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoComprobante() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoComprobanteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComprobanteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComprobanteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComprobanteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComprobante() throws Exception  {
		return TipoComprobanteConstantesFunciones.getTiposSeleccionarTipoComprobante(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComprobante(Boolean conFk) throws Exception  {
		return TipoComprobanteConstantesFunciones.getTiposSeleccionarTipoComprobante(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComprobante(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComprobanteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoComprobanteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComprobanteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoComprobanteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoComprobante(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoComprobante(TipoComprobante tipocomprobanteAux) throws Exception {
		
			tipocomprobanteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomprobanteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoComprobante(List<TipoComprobante> tipocomprobantesTemp) throws Exception {
		for(TipoComprobante tipocomprobanteAux:tipocomprobantesTemp) {
			
			tipocomprobanteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomprobanteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoComprobante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoComprobante(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComprobante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComprobanteConstantesFunciones.getClassesRelationshipsOfTipoComprobante(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComprobante(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(DocumentoAnulado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DocumentoAnulado.class)) {
						classes.add(new Classe(DocumentoAnulado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoComprobante(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComprobanteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoComprobante(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoComprobante(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(DocumentoAnulado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DocumentoAnulado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(DocumentoAnulado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DocumentoAnulado.class)); continue;
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
	public static void actualizarLista(TipoComprobante tipocomprobante,List<TipoComprobante> tipocomprobantes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoComprobante tipocomprobanteEncontrado=null;
			
			for(TipoComprobante tipocomprobanteLocal:tipocomprobantes) {
				if(tipocomprobanteLocal.getId().equals(tipocomprobante.getId())) {
					tipocomprobanteEncontrado=tipocomprobanteLocal;
					
					tipocomprobanteLocal.setIsChanged(tipocomprobante.getIsChanged());
					tipocomprobanteLocal.setIsNew(tipocomprobante.getIsNew());
					tipocomprobanteLocal.setIsDeleted(tipocomprobante.getIsDeleted());
					
					tipocomprobanteLocal.setGeneralEntityOriginal(tipocomprobante.getGeneralEntityOriginal());
					
					tipocomprobanteLocal.setId(tipocomprobante.getId());	
					tipocomprobanteLocal.setVersionRow(tipocomprobante.getVersionRow());	
					tipocomprobanteLocal.setid_empresa(tipocomprobante.getid_empresa());	
					tipocomprobanteLocal.setnombre(tipocomprobante.getnombre());	
					
					
					tipocomprobanteLocal.setTransaccionLocals(tipocomprobante.getTransaccionLocals());
					tipocomprobanteLocal.setTransaccions(tipocomprobante.getTransaccions());
					tipocomprobanteLocal.setDocumentoAnulados(tipocomprobante.getDocumentoAnulados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocomprobante.getIsDeleted()) {
				if(!existe) {
					tipocomprobantes.add(tipocomprobante);
				}
			} else {
				if(tipocomprobanteEncontrado!=null && permiteQuitar)  {
					tipocomprobantes.remove(tipocomprobanteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoComprobante tipocomprobante,List<TipoComprobante> tipocomprobantes) throws Exception {
		try	{			
			for(TipoComprobante tipocomprobanteLocal:tipocomprobantes) {
				if(tipocomprobanteLocal.getId().equals(tipocomprobante.getId())) {
					tipocomprobanteLocal.setIsSelected(tipocomprobante.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoComprobante(List<TipoComprobante> tipocomprobantesAux) throws Exception {
		//this.tipocomprobantesAux=tipocomprobantesAux;
		
		for(TipoComprobante tipocomprobanteAux:tipocomprobantesAux) {
			if(tipocomprobanteAux.getIsChanged()) {
				tipocomprobanteAux.setIsChanged(false);
			}		
			
			if(tipocomprobanteAux.getIsNew()) {
				tipocomprobanteAux.setIsNew(false);
			}	
			
			if(tipocomprobanteAux.getIsDeleted()) {
				tipocomprobanteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoComprobante(TipoComprobante tipocomprobanteAux) throws Exception {
		//this.tipocomprobanteAux=tipocomprobanteAux;
		
			if(tipocomprobanteAux.getIsChanged()) {
				tipocomprobanteAux.setIsChanged(false);
			}		
			
			if(tipocomprobanteAux.getIsNew()) {
				tipocomprobanteAux.setIsNew(false);
			}	
			
			if(tipocomprobanteAux.getIsDeleted()) {
				tipocomprobanteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoComprobante tipocomprobanteAsignar,TipoComprobante tipocomprobante) throws Exception {
		tipocomprobanteAsignar.setId(tipocomprobante.getId());	
		tipocomprobanteAsignar.setVersionRow(tipocomprobante.getVersionRow());	
		tipocomprobanteAsignar.setid_empresa(tipocomprobante.getid_empresa());
		tipocomprobanteAsignar.setempresa_descripcion(tipocomprobante.getempresa_descripcion());	
		tipocomprobanteAsignar.setnombre(tipocomprobante.getnombre());	
	}
	
	public static void inicializarTipoComprobante(TipoComprobante tipocomprobante) throws Exception {
		try {
				tipocomprobante.setId(0L);	
					
				tipocomprobante.setid_empresa(-1L);	
				tipocomprobante.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoComprobante(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComprobanteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComprobanteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoComprobante(String sTipo,Row row,Workbook workbook,TipoComprobante tipocomprobante,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocomprobante.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocomprobante.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoComprobante=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoComprobante() {
		return this.sFinalQueryTipoComprobante;
	}
	
	public void setsFinalQueryTipoComprobante(String sFinalQueryTipoComprobante) {
		this.sFinalQueryTipoComprobante= sFinalQueryTipoComprobante;
	}
	
	public Border resaltarSeleccionarTipoComprobante=null;
	
	public Border setResaltarSeleccionarTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoComprobante= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoComprobante() {
		return this.resaltarSeleccionarTipoComprobante;
	}
	
	public void setResaltarSeleccionarTipoComprobante(Border borderResaltarSeleccionarTipoComprobante) {
		this.resaltarSeleccionarTipoComprobante= borderResaltarSeleccionarTipoComprobante;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoComprobante=null;
	public Boolean mostraridTipoComprobante=true;
	public Boolean activaridTipoComprobante=true;

	public Border resaltarid_empresaTipoComprobante=null;
	public Boolean mostrarid_empresaTipoComprobante=true;
	public Boolean activarid_empresaTipoComprobante=true;
	public Boolean cargarid_empresaTipoComprobante=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoComprobante=false;//ConEventDepend=true

	public Border resaltarnombreTipoComprobante=null;
	public Boolean mostrarnombreTipoComprobante=true;
	public Boolean activarnombreTipoComprobante=true;

	
	

	public Border setResaltaridTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltar);
		
		this.resaltaridTipoComprobante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoComprobante() {
		return this.resaltaridTipoComprobante;
	}

	public void setResaltaridTipoComprobante(Border borderResaltar) {
		this.resaltaridTipoComprobante= borderResaltar;
	}

	public Boolean getMostraridTipoComprobante() {
		return this.mostraridTipoComprobante;
	}

	public void setMostraridTipoComprobante(Boolean mostraridTipoComprobante) {
		this.mostraridTipoComprobante= mostraridTipoComprobante;
	}

	public Boolean getActivaridTipoComprobante() {
		return this.activaridTipoComprobante;
	}

	public void setActivaridTipoComprobante(Boolean activaridTipoComprobante) {
		this.activaridTipoComprobante= activaridTipoComprobante;
	}

	public Border setResaltarid_empresaTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoComprobante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoComprobante() {
		return this.resaltarid_empresaTipoComprobante;
	}

	public void setResaltarid_empresaTipoComprobante(Border borderResaltar) {
		this.resaltarid_empresaTipoComprobante= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoComprobante() {
		return this.mostrarid_empresaTipoComprobante;
	}

	public void setMostrarid_empresaTipoComprobante(Boolean mostrarid_empresaTipoComprobante) {
		this.mostrarid_empresaTipoComprobante= mostrarid_empresaTipoComprobante;
	}

	public Boolean getActivarid_empresaTipoComprobante() {
		return this.activarid_empresaTipoComprobante;
	}

	public void setActivarid_empresaTipoComprobante(Boolean activarid_empresaTipoComprobante) {
		this.activarid_empresaTipoComprobante= activarid_empresaTipoComprobante;
	}

	public Boolean getCargarid_empresaTipoComprobante() {
		return this.cargarid_empresaTipoComprobante;
	}

	public void setCargarid_empresaTipoComprobante(Boolean cargarid_empresaTipoComprobante) {
		this.cargarid_empresaTipoComprobante= cargarid_empresaTipoComprobante;
	}

	public Border setResaltarnombreTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltar);
		
		this.resaltarnombreTipoComprobante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoComprobante() {
		return this.resaltarnombreTipoComprobante;
	}

	public void setResaltarnombreTipoComprobante(Border borderResaltar) {
		this.resaltarnombreTipoComprobante= borderResaltar;
	}

	public Boolean getMostrarnombreTipoComprobante() {
		return this.mostrarnombreTipoComprobante;
	}

	public void setMostrarnombreTipoComprobante(Boolean mostrarnombreTipoComprobante) {
		this.mostrarnombreTipoComprobante= mostrarnombreTipoComprobante;
	}

	public Boolean getActivarnombreTipoComprobante() {
		return this.activarnombreTipoComprobante;
	}

	public void setActivarnombreTipoComprobante(Boolean activarnombreTipoComprobante) {
		this.activarnombreTipoComprobante= activarnombreTipoComprobante;
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
		
		
		this.setMostraridTipoComprobante(esInicial);
		this.setMostrarid_empresaTipoComprobante(esInicial);
		this.setMostrarnombreTipoComprobante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.ID)) {
				this.setMostraridTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoComprobante(esAsigna);
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
		
		
		this.setActivaridTipoComprobante(esInicial);
		this.setActivarid_empresaTipoComprobante(esInicial);
		this.setActivarnombreTipoComprobante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.ID)) {
				this.setActivaridTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoComprobante(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoComprobante(esInicial);
		this.setResaltarid_empresaTipoComprobante(esInicial);
		this.setResaltarnombreTipoComprobante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.ID)) {
				this.setResaltaridTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoComprobante(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComprobanteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoComprobante(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalTipoComprobante=null;

	public Border getResaltarTransaccionLocalTipoComprobante() {
		return this.resaltarTransaccionLocalTipoComprobante;
	}

	public void setResaltarTransaccionLocalTipoComprobante(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalTipoComprobante= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalTipoComprobante= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalTipoComprobante=true;

	public Boolean getMostrarTransaccionLocalTipoComprobante() {
		return this.mostrarTransaccionLocalTipoComprobante;
	}

	public void setMostrarTransaccionLocalTipoComprobante(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalTipoComprobante= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalTipoComprobante=true;

	public Boolean gethabilitarResaltarTransaccionLocalTipoComprobante() {
		return this.activarTransaccionLocalTipoComprobante;
	}

	public void setActivarTransaccionLocalTipoComprobante(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalTipoComprobante= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarTransaccionTipoComprobante=null;

	public Border getResaltarTransaccionTipoComprobante() {
		return this.resaltarTransaccionTipoComprobante;
	}

	public void setResaltarTransaccionTipoComprobante(Border borderResaltarTransaccion) {
		if(borderResaltarTransaccion!=null) {
			this.resaltarTransaccionTipoComprobante= borderResaltarTransaccion;
		}
	}

	public Border setResaltarTransaccionTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltarTransaccion);
			
		this.resaltarTransaccionTipoComprobante= borderResaltarTransaccion;

		 return borderResaltarTransaccion;
	}



	public Boolean mostrarTransaccionTipoComprobante=true;

	public Boolean getMostrarTransaccionTipoComprobante() {
		return this.mostrarTransaccionTipoComprobante;
	}

	public void setMostrarTransaccionTipoComprobante(Boolean visibilidadResaltarTransaccion) {
		this.mostrarTransaccionTipoComprobante= visibilidadResaltarTransaccion;
	}



	public Boolean activarTransaccionTipoComprobante=true;

	public Boolean gethabilitarResaltarTransaccionTipoComprobante() {
		return this.activarTransaccionTipoComprobante;
	}

	public void setActivarTransaccionTipoComprobante(Boolean habilitarResaltarTransaccion) {
		this.activarTransaccionTipoComprobante= habilitarResaltarTransaccion;
	}


	public Border resaltarDocumentoAnuladoTipoComprobante=null;

	public Border getResaltarDocumentoAnuladoTipoComprobante() {
		return this.resaltarDocumentoAnuladoTipoComprobante;
	}

	public void setResaltarDocumentoAnuladoTipoComprobante(Border borderResaltarDocumentoAnulado) {
		if(borderResaltarDocumentoAnulado!=null) {
			this.resaltarDocumentoAnuladoTipoComprobante= borderResaltarDocumentoAnulado;
		}
	}

	public Border setResaltarDocumentoAnuladoTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltarDocumentoAnulado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocomprobanteBeanSwingJInternalFrame.jTtoolBarTipoComprobante.setBorder(borderResaltarDocumentoAnulado);
			
		this.resaltarDocumentoAnuladoTipoComprobante= borderResaltarDocumentoAnulado;

		 return borderResaltarDocumentoAnulado;
	}



	public Boolean mostrarDocumentoAnuladoTipoComprobante=true;

	public Boolean getMostrarDocumentoAnuladoTipoComprobante() {
		return this.mostrarDocumentoAnuladoTipoComprobante;
	}

	public void setMostrarDocumentoAnuladoTipoComprobante(Boolean visibilidadResaltarDocumentoAnulado) {
		this.mostrarDocumentoAnuladoTipoComprobante= visibilidadResaltarDocumentoAnulado;
	}



	public Boolean activarDocumentoAnuladoTipoComprobante=true;

	public Boolean gethabilitarResaltarDocumentoAnuladoTipoComprobante() {
		return this.activarDocumentoAnuladoTipoComprobante;
	}

	public void setActivarDocumentoAnuladoTipoComprobante(Boolean habilitarResaltarDocumentoAnulado) {
		this.activarDocumentoAnuladoTipoComprobante= habilitarResaltarDocumentoAnulado;
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

		this.setMostrarTransaccionLocalTipoComprobante(esInicial);
		this.setMostrarTransaccionTipoComprobante(esInicial);
		this.setMostrarDocumentoAnuladoTipoComprobante(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transaccion.class)) {
				this.setMostrarTransaccionTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setMostrarDocumentoAnuladoTipoComprobante(esAsigna);
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

		this.setActivarTransaccionLocalTipoComprobante(esInicial);
		this.setActivarTransaccionTipoComprobante(esInicial);
		this.setActivarDocumentoAnuladoTipoComprobante(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transaccion.class)) {
				this.setActivarTransaccionTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setActivarDocumentoAnuladoTipoComprobante(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalTipoComprobante(esInicial);
		this.setResaltarTransaccionTipoComprobante(esInicial);
		this.setResaltarDocumentoAnuladoTipoComprobante(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transaccion.class)) {
				this.setResaltarTransaccionTipoComprobante(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setResaltarDocumentoAnuladoTipoComprobante(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdTipoComprobante=true;

	public Boolean getMostrarBusquedaPorIdTipoComprobante() {
		return this.mostrarBusquedaPorIdTipoComprobante;
	}

	public void setMostrarBusquedaPorIdTipoComprobante(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoComprobante= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoComprobante=true;

	public Boolean getMostrarBusquedaPorNombreTipoComprobante() {
		return this.mostrarBusquedaPorNombreTipoComprobante;
	}

	public void setMostrarBusquedaPorNombreTipoComprobante(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoComprobante= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoComprobante=true;

	public Boolean getMostrarFK_IdEmpresaTipoComprobante() {
		return this.mostrarFK_IdEmpresaTipoComprobante;
	}

	public void setMostrarFK_IdEmpresaTipoComprobante(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoComprobante= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoComprobante=true;

	public Boolean getActivarBusquedaPorIdTipoComprobante() {
		return this.activarBusquedaPorIdTipoComprobante;
	}

	public void setActivarBusquedaPorIdTipoComprobante(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoComprobante= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoComprobante=true;

	public Boolean getActivarBusquedaPorNombreTipoComprobante() {
		return this.activarBusquedaPorNombreTipoComprobante;
	}

	public void setActivarBusquedaPorNombreTipoComprobante(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoComprobante= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoComprobante=true;

	public Boolean getActivarFK_IdEmpresaTipoComprobante() {
		return this.activarFK_IdEmpresaTipoComprobante;
	}

	public void setActivarFK_IdEmpresaTipoComprobante(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoComprobante= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoComprobante=null;

	public Border getResaltarBusquedaPorIdTipoComprobante() {
		return this.resaltarBusquedaPorIdTipoComprobante;
	}

	public void setResaltarBusquedaPorIdTipoComprobante(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoComprobante= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoComprobante= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoComprobante=null;

	public Border getResaltarBusquedaPorNombreTipoComprobante() {
		return this.resaltarBusquedaPorNombreTipoComprobante;
	}

	public void setResaltarBusquedaPorNombreTipoComprobante(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoComprobante= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoComprobante= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoComprobante=null;

	public Border getResaltarFK_IdEmpresaTipoComprobante() {
		return this.resaltarFK_IdEmpresaTipoComprobante;
	}

	public void setResaltarFK_IdEmpresaTipoComprobante(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoComprobante= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoComprobante(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComprobanteBeanSwingJInternalFrame tipocomprobanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoComprobante= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}