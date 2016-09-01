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


import com.bydan.erp.cartera.util.TipoIdentificacionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoIdentificacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoIdentificacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoIdentificacionConstantesFunciones extends TipoIdentificacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoIdentificacion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoIdentificacion"+TipoIdentificacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoIdentificacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoIdentificacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoIdentificacionConstantesFunciones.SCHEMA+"_"+TipoIdentificacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoIdentificacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoIdentificacionConstantesFunciones.SCHEMA+"_"+TipoIdentificacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoIdentificacionConstantesFunciones.SCHEMA+"_"+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoIdentificacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoIdentificacionConstantesFunciones.SCHEMA+"_"+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIdentificacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIdentificacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIdentificacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoIdentificacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoIdentificacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoIdentificacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoIdentificacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Identificaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Identificacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Identificacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoIdentificacion";
	public static final String OBJECTNAME="tipoidentificacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_identificacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoidentificacion from "+TipoIdentificacionConstantesFunciones.SPERSISTENCENAME+" tipoidentificacion";
	public static String QUERYSELECTNATIVE="select "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".id,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".version_row,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".codigo,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".nombre from "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME;//+" as "+TipoIdentificacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoIdentificacionConstantesFuncionesAdditional tipoidentificacionConstantesFuncionesAdditional=null;
	
	public TipoIdentificacionConstantesFuncionesAdditional getTipoIdentificacionConstantesFuncionesAdditional() {
		return this.tipoidentificacionConstantesFuncionesAdditional;
	}
	
	public void setTipoIdentificacionConstantesFuncionesAdditional(TipoIdentificacionConstantesFuncionesAdditional tipoidentificacionConstantesFuncionesAdditional) {
		try {
			this.tipoidentificacionConstantesFuncionesAdditional=tipoidentificacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoIdentificacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoIdentificacionConstantesFunciones.CODIGO)) {sLabelColumna=TipoIdentificacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoIdentificacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoIdentificacionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoidentificacion !=null/* && tipoidentificacion.getId()!=0*/) {
			sDescripcion=tipoidentificacion.getcodigo();//tipoidentificaciontipoidentificacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoIdentificacionDescripcionDetallado(TipoIdentificacion tipoidentificacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoIdentificacionConstantesFunciones.ID+"=";
		sDescripcion+=tipoidentificacion.getId().toString()+",";
		sDescripcion+=TipoIdentificacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoidentificacion.getVersionRow().toString()+",";
		sDescripcion+=TipoIdentificacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoidentificacion.getcodigo()+",";
		sDescripcion+=TipoIdentificacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoidentificacion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion,String sValor) throws Exception {			
		if(tipoidentificacion !=null) {
			tipoidentificacion.setcodigo(sValor);;//tipoidentificaciontipoidentificacion.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoIdentificacion(TipoIdentificacion tipoidentificacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoidentificacion.setcodigo(tipoidentificacion.getcodigo().trim());
		tipoidentificacion.setnombre(tipoidentificacion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoIdentificacions(List<TipoIdentificacion> tipoidentificacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoIdentificacion tipoidentificacion: tipoidentificacions) {
			tipoidentificacion.setcodigo(tipoidentificacion.getcodigo().trim());
			tipoidentificacion.setnombre(tipoidentificacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIdentificacion(TipoIdentificacion tipoidentificacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoidentificacion.getConCambioAuxiliar()) {
			tipoidentificacion.setIsDeleted(tipoidentificacion.getIsDeletedAuxiliar());	
			tipoidentificacion.setIsNew(tipoidentificacion.getIsNewAuxiliar());	
			tipoidentificacion.setIsChanged(tipoidentificacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoidentificacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoidentificacion.setIsDeletedAuxiliar(false);	
			tipoidentificacion.setIsNewAuxiliar(false);	
			tipoidentificacion.setIsChangedAuxiliar(false);
			
			tipoidentificacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIdentificacions(List<TipoIdentificacion> tipoidentificacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoIdentificacion tipoidentificacion : tipoidentificacions) {
			if(conAsignarBase && tipoidentificacion.getConCambioAuxiliar()) {
				tipoidentificacion.setIsDeleted(tipoidentificacion.getIsDeletedAuxiliar());	
				tipoidentificacion.setIsNew(tipoidentificacion.getIsNewAuxiliar());	
				tipoidentificacion.setIsChanged(tipoidentificacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoidentificacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoidentificacion.setIsDeletedAuxiliar(false);	
				tipoidentificacion.setIsNewAuxiliar(false);	
				tipoidentificacion.setIsChangedAuxiliar(false);
				
				tipoidentificacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoIdentificacion(TipoIdentificacion tipoidentificacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoIdentificacions(List<TipoIdentificacion> tipoidentificacions,Boolean conEnteros) throws Exception  {
		
		for(TipoIdentificacion tipoidentificacion: tipoidentificacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoIdentificacion(List<TipoIdentificacion> tipoidentificacions,TipoIdentificacion tipoidentificacionAux) throws Exception  {
		TipoIdentificacionConstantesFunciones.InicializarValoresTipoIdentificacion(tipoidentificacionAux,true);
		
		for(TipoIdentificacion tipoidentificacion: tipoidentificacions) {
			if(tipoidentificacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIdentificacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoIdentificacionConstantesFunciones.getArrayColumnasGlobalesTipoIdentificacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIdentificacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoIdentificacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoIdentificacion> tipoidentificacions,TipoIdentificacion tipoidentificacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoIdentificacion tipoidentificacionAux: tipoidentificacions) {
			if(tipoidentificacionAux!=null && tipoidentificacion!=null) {
				if((tipoidentificacionAux.getId()==null && tipoidentificacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoidentificacionAux.getId()!=null && tipoidentificacion.getId()!=null){
					if(tipoidentificacionAux.getId().equals(tipoidentificacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoIdentificacion(List<TipoIdentificacion> tipoidentificacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoIdentificacion tipoidentificacion: tipoidentificacions) {			
			if(tipoidentificacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoIdentificacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoIdentificacionConstantesFunciones.LABEL_ID, TipoIdentificacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIdentificacionConstantesFunciones.LABEL_VERSIONROW, TipoIdentificacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIdentificacionConstantesFunciones.LABEL_CODIGO, TipoIdentificacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIdentificacionConstantesFunciones.LABEL_NOMBRE, TipoIdentificacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoIdentificacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoIdentificacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIdentificacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIdentificacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIdentificacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIdentificacion() throws Exception  {
		return TipoIdentificacionConstantesFunciones.getTiposSeleccionarTipoIdentificacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIdentificacion(Boolean conFk) throws Exception  {
		return TipoIdentificacionConstantesFunciones.getTiposSeleccionarTipoIdentificacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIdentificacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIdentificacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoIdentificacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIdentificacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoIdentificacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoIdentificacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIdentificacion(TipoIdentificacion tipoidentificacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIdentificacion(List<TipoIdentificacion> tipoidentificacionsTemp) throws Exception {
		for(TipoIdentificacion tipoidentificacionAux:tipoidentificacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIdentificacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoIdentificacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIdentificacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIdentificacionConstantesFunciones.getClassesRelationshipsOfTipoIdentificacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIdentificacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Conyuge.class));
				classes.add(new Classe(Cobrador.class));
				classes.add(new Classe(RepresentanteLegal.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Accionista.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Conyuge.class)) {
						classes.add(new Classe(Conyuge.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cobrador.class)) {
						classes.add(new Classe(Cobrador.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RepresentanteLegal.class)) {
						classes.add(new Classe(RepresentanteLegal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Accionista.class)) {
						classes.add(new Classe(Accionista.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIdentificacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIdentificacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoIdentificacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIdentificacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Conyuge.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conyuge.class)); continue;
					}

					if(Cobrador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cobrador.class)); continue;
					}

					if(RepresentanteLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RepresentanteLegal.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Accionista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accionista.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Conyuge.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conyuge.class)); continue;
					}

					if(Cobrador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cobrador.class)); continue;
					}

					if(RepresentanteLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RepresentanteLegal.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Accionista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accionista.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
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
	public static void actualizarLista(TipoIdentificacion tipoidentificacion,List<TipoIdentificacion> tipoidentificacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoIdentificacion tipoidentificacionEncontrado=null;
			
			for(TipoIdentificacion tipoidentificacionLocal:tipoidentificacions) {
				if(tipoidentificacionLocal.getId().equals(tipoidentificacion.getId())) {
					tipoidentificacionEncontrado=tipoidentificacionLocal;
					
					tipoidentificacionLocal.setIsChanged(tipoidentificacion.getIsChanged());
					tipoidentificacionLocal.setIsNew(tipoidentificacion.getIsNew());
					tipoidentificacionLocal.setIsDeleted(tipoidentificacion.getIsDeleted());
					
					tipoidentificacionLocal.setGeneralEntityOriginal(tipoidentificacion.getGeneralEntityOriginal());
					
					tipoidentificacionLocal.setId(tipoidentificacion.getId());	
					tipoidentificacionLocal.setVersionRow(tipoidentificacion.getVersionRow());	
					tipoidentificacionLocal.setcodigo(tipoidentificacion.getcodigo());	
					tipoidentificacionLocal.setnombre(tipoidentificacion.getnombre());	
					
					
					tipoidentificacionLocal.setConyuges(tipoidentificacion.getConyuges());
					tipoidentificacionLocal.setCobradors(tipoidentificacion.getCobradors());
					tipoidentificacionLocal.setRepresentanteLegals(tipoidentificacion.getRepresentanteLegals());
					tipoidentificacionLocal.setSubClientes(tipoidentificacion.getSubClientes());
					tipoidentificacionLocal.setAccionistas(tipoidentificacion.getAccionistas());
					tipoidentificacionLocal.setClientes(tipoidentificacion.getClientes());
					tipoidentificacionLocal.setParametroCarteraDefectos(tipoidentificacion.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoidentificacion.getIsDeleted()) {
				if(!existe) {
					tipoidentificacions.add(tipoidentificacion);
				}
			} else {
				if(tipoidentificacionEncontrado!=null && permiteQuitar)  {
					tipoidentificacions.remove(tipoidentificacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoIdentificacion tipoidentificacion,List<TipoIdentificacion> tipoidentificacions) throws Exception {
		try	{			
			for(TipoIdentificacion tipoidentificacionLocal:tipoidentificacions) {
				if(tipoidentificacionLocal.getId().equals(tipoidentificacion.getId())) {
					tipoidentificacionLocal.setIsSelected(tipoidentificacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoIdentificacion(List<TipoIdentificacion> tipoidentificacionsAux) throws Exception {
		//this.tipoidentificacionsAux=tipoidentificacionsAux;
		
		for(TipoIdentificacion tipoidentificacionAux:tipoidentificacionsAux) {
			if(tipoidentificacionAux.getIsChanged()) {
				tipoidentificacionAux.setIsChanged(false);
			}		
			
			if(tipoidentificacionAux.getIsNew()) {
				tipoidentificacionAux.setIsNew(false);
			}	
			
			if(tipoidentificacionAux.getIsDeleted()) {
				tipoidentificacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoIdentificacion(TipoIdentificacion tipoidentificacionAux) throws Exception {
		//this.tipoidentificacionAux=tipoidentificacionAux;
		
			if(tipoidentificacionAux.getIsChanged()) {
				tipoidentificacionAux.setIsChanged(false);
			}		
			
			if(tipoidentificacionAux.getIsNew()) {
				tipoidentificacionAux.setIsNew(false);
			}	
			
			if(tipoidentificacionAux.getIsDeleted()) {
				tipoidentificacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoIdentificacion tipoidentificacionAsignar,TipoIdentificacion tipoidentificacion) throws Exception {
		tipoidentificacionAsignar.setId(tipoidentificacion.getId());	
		tipoidentificacionAsignar.setVersionRow(tipoidentificacion.getVersionRow());	
		tipoidentificacionAsignar.setcodigo(tipoidentificacion.getcodigo());	
		tipoidentificacionAsignar.setnombre(tipoidentificacion.getnombre());	
	}
	
	public static void inicializarTipoIdentificacion(TipoIdentificacion tipoidentificacion) throws Exception {
		try {
				tipoidentificacion.setId(0L);	
					
				tipoidentificacion.setcodigo("");	
				tipoidentificacion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoIdentificacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIdentificacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIdentificacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoIdentificacion(String sTipo,Row row,Workbook workbook,TipoIdentificacion tipoidentificacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoidentificacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoidentificacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoIdentificacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoIdentificacion() {
		return this.sFinalQueryTipoIdentificacion;
	}
	
	public void setsFinalQueryTipoIdentificacion(String sFinalQueryTipoIdentificacion) {
		this.sFinalQueryTipoIdentificacion= sFinalQueryTipoIdentificacion;
	}
	
	public Border resaltarSeleccionarTipoIdentificacion=null;
	
	public Border setResaltarSeleccionarTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoIdentificacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoIdentificacion() {
		return this.resaltarSeleccionarTipoIdentificacion;
	}
	
	public void setResaltarSeleccionarTipoIdentificacion(Border borderResaltarSeleccionarTipoIdentificacion) {
		this.resaltarSeleccionarTipoIdentificacion= borderResaltarSeleccionarTipoIdentificacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoIdentificacion=null;
	public Boolean mostraridTipoIdentificacion=true;
	public Boolean activaridTipoIdentificacion=true;

	public Border resaltarcodigoTipoIdentificacion=null;
	public Boolean mostrarcodigoTipoIdentificacion=true;
	public Boolean activarcodigoTipoIdentificacion=true;

	public Border resaltarnombreTipoIdentificacion=null;
	public Boolean mostrarnombreTipoIdentificacion=true;
	public Boolean activarnombreTipoIdentificacion=true;

	
	

	public Border setResaltaridTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltar);
		
		this.resaltaridTipoIdentificacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoIdentificacion() {
		return this.resaltaridTipoIdentificacion;
	}

	public void setResaltaridTipoIdentificacion(Border borderResaltar) {
		this.resaltaridTipoIdentificacion= borderResaltar;
	}

	public Boolean getMostraridTipoIdentificacion() {
		return this.mostraridTipoIdentificacion;
	}

	public void setMostraridTipoIdentificacion(Boolean mostraridTipoIdentificacion) {
		this.mostraridTipoIdentificacion= mostraridTipoIdentificacion;
	}

	public Boolean getActivaridTipoIdentificacion() {
		return this.activaridTipoIdentificacion;
	}

	public void setActivaridTipoIdentificacion(Boolean activaridTipoIdentificacion) {
		this.activaridTipoIdentificacion= activaridTipoIdentificacion;
	}

	public Border setResaltarcodigoTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoIdentificacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoIdentificacion() {
		return this.resaltarcodigoTipoIdentificacion;
	}

	public void setResaltarcodigoTipoIdentificacion(Border borderResaltar) {
		this.resaltarcodigoTipoIdentificacion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoIdentificacion() {
		return this.mostrarcodigoTipoIdentificacion;
	}

	public void setMostrarcodigoTipoIdentificacion(Boolean mostrarcodigoTipoIdentificacion) {
		this.mostrarcodigoTipoIdentificacion= mostrarcodigoTipoIdentificacion;
	}

	public Boolean getActivarcodigoTipoIdentificacion() {
		return this.activarcodigoTipoIdentificacion;
	}

	public void setActivarcodigoTipoIdentificacion(Boolean activarcodigoTipoIdentificacion) {
		this.activarcodigoTipoIdentificacion= activarcodigoTipoIdentificacion;
	}

	public Border setResaltarnombreTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoIdentificacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoIdentificacion() {
		return this.resaltarnombreTipoIdentificacion;
	}

	public void setResaltarnombreTipoIdentificacion(Border borderResaltar) {
		this.resaltarnombreTipoIdentificacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoIdentificacion() {
		return this.mostrarnombreTipoIdentificacion;
	}

	public void setMostrarnombreTipoIdentificacion(Boolean mostrarnombreTipoIdentificacion) {
		this.mostrarnombreTipoIdentificacion= mostrarnombreTipoIdentificacion;
	}

	public Boolean getActivarnombreTipoIdentificacion() {
		return this.activarnombreTipoIdentificacion;
	}

	public void setActivarnombreTipoIdentificacion(Boolean activarnombreTipoIdentificacion) {
		this.activarnombreTipoIdentificacion= activarnombreTipoIdentificacion;
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
		
		
		this.setMostraridTipoIdentificacion(esInicial);
		this.setMostrarcodigoTipoIdentificacion(esInicial);
		this.setMostrarnombreTipoIdentificacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.ID)) {
				this.setMostraridTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoIdentificacion(esAsigna);
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
		
		
		this.setActivaridTipoIdentificacion(esInicial);
		this.setActivarcodigoTipoIdentificacion(esInicial);
		this.setActivarnombreTipoIdentificacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.ID)) {
				this.setActivaridTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoIdentificacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoIdentificacion(esInicial);
		this.setResaltarcodigoTipoIdentificacion(esInicial);
		this.setResaltarnombreTipoIdentificacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.ID)) {
				this.setResaltaridTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoIdentificacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIdentificacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoIdentificacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarConyugeTipoIdentificacion=null;

	public Border getResaltarConyugeTipoIdentificacion() {
		return this.resaltarConyugeTipoIdentificacion;
	}

	public void setResaltarConyugeTipoIdentificacion(Border borderResaltarConyuge) {
		if(borderResaltarConyuge!=null) {
			this.resaltarConyugeTipoIdentificacion= borderResaltarConyuge;
		}
	}

	public Border setResaltarConyugeTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarConyuge=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarConyuge);
			
		this.resaltarConyugeTipoIdentificacion= borderResaltarConyuge;

		 return borderResaltarConyuge;
	}



	public Boolean mostrarConyugeTipoIdentificacion=true;

	public Boolean getMostrarConyugeTipoIdentificacion() {
		return this.mostrarConyugeTipoIdentificacion;
	}

	public void setMostrarConyugeTipoIdentificacion(Boolean visibilidadResaltarConyuge) {
		this.mostrarConyugeTipoIdentificacion= visibilidadResaltarConyuge;
	}



	public Boolean activarConyugeTipoIdentificacion=true;

	public Boolean gethabilitarResaltarConyugeTipoIdentificacion() {
		return this.activarConyugeTipoIdentificacion;
	}

	public void setActivarConyugeTipoIdentificacion(Boolean habilitarResaltarConyuge) {
		this.activarConyugeTipoIdentificacion= habilitarResaltarConyuge;
	}


	public Border resaltarCobradorTipoIdentificacion=null;

	public Border getResaltarCobradorTipoIdentificacion() {
		return this.resaltarCobradorTipoIdentificacion;
	}

	public void setResaltarCobradorTipoIdentificacion(Border borderResaltarCobrador) {
		if(borderResaltarCobrador!=null) {
			this.resaltarCobradorTipoIdentificacion= borderResaltarCobrador;
		}
	}

	public Border setResaltarCobradorTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarCobrador=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarCobrador);
			
		this.resaltarCobradorTipoIdentificacion= borderResaltarCobrador;

		 return borderResaltarCobrador;
	}



	public Boolean mostrarCobradorTipoIdentificacion=true;

	public Boolean getMostrarCobradorTipoIdentificacion() {
		return this.mostrarCobradorTipoIdentificacion;
	}

	public void setMostrarCobradorTipoIdentificacion(Boolean visibilidadResaltarCobrador) {
		this.mostrarCobradorTipoIdentificacion= visibilidadResaltarCobrador;
	}



	public Boolean activarCobradorTipoIdentificacion=true;

	public Boolean gethabilitarResaltarCobradorTipoIdentificacion() {
		return this.activarCobradorTipoIdentificacion;
	}

	public void setActivarCobradorTipoIdentificacion(Boolean habilitarResaltarCobrador) {
		this.activarCobradorTipoIdentificacion= habilitarResaltarCobrador;
	}


	public Border resaltarRepresentanteLegalTipoIdentificacion=null;

	public Border getResaltarRepresentanteLegalTipoIdentificacion() {
		return this.resaltarRepresentanteLegalTipoIdentificacion;
	}

	public void setResaltarRepresentanteLegalTipoIdentificacion(Border borderResaltarRepresentanteLegal) {
		if(borderResaltarRepresentanteLegal!=null) {
			this.resaltarRepresentanteLegalTipoIdentificacion= borderResaltarRepresentanteLegal;
		}
	}

	public Border setResaltarRepresentanteLegalTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarRepresentanteLegal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarRepresentanteLegal);
			
		this.resaltarRepresentanteLegalTipoIdentificacion= borderResaltarRepresentanteLegal;

		 return borderResaltarRepresentanteLegal;
	}



	public Boolean mostrarRepresentanteLegalTipoIdentificacion=true;

	public Boolean getMostrarRepresentanteLegalTipoIdentificacion() {
		return this.mostrarRepresentanteLegalTipoIdentificacion;
	}

	public void setMostrarRepresentanteLegalTipoIdentificacion(Boolean visibilidadResaltarRepresentanteLegal) {
		this.mostrarRepresentanteLegalTipoIdentificacion= visibilidadResaltarRepresentanteLegal;
	}



	public Boolean activarRepresentanteLegalTipoIdentificacion=true;

	public Boolean gethabilitarResaltarRepresentanteLegalTipoIdentificacion() {
		return this.activarRepresentanteLegalTipoIdentificacion;
	}

	public void setActivarRepresentanteLegalTipoIdentificacion(Boolean habilitarResaltarRepresentanteLegal) {
		this.activarRepresentanteLegalTipoIdentificacion= habilitarResaltarRepresentanteLegal;
	}


	public Border resaltarSubClienteTipoIdentificacion=null;

	public Border getResaltarSubClienteTipoIdentificacion() {
		return this.resaltarSubClienteTipoIdentificacion;
	}

	public void setResaltarSubClienteTipoIdentificacion(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteTipoIdentificacion= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteTipoIdentificacion= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteTipoIdentificacion=true;

	public Boolean getMostrarSubClienteTipoIdentificacion() {
		return this.mostrarSubClienteTipoIdentificacion;
	}

	public void setMostrarSubClienteTipoIdentificacion(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteTipoIdentificacion= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteTipoIdentificacion=true;

	public Boolean gethabilitarResaltarSubClienteTipoIdentificacion() {
		return this.activarSubClienteTipoIdentificacion;
	}

	public void setActivarSubClienteTipoIdentificacion(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteTipoIdentificacion= habilitarResaltarSubCliente;
	}


	public Border resaltarAccionistaTipoIdentificacion=null;

	public Border getResaltarAccionistaTipoIdentificacion() {
		return this.resaltarAccionistaTipoIdentificacion;
	}

	public void setResaltarAccionistaTipoIdentificacion(Border borderResaltarAccionista) {
		if(borderResaltarAccionista!=null) {
			this.resaltarAccionistaTipoIdentificacion= borderResaltarAccionista;
		}
	}

	public Border setResaltarAccionistaTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarAccionista=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarAccionista);
			
		this.resaltarAccionistaTipoIdentificacion= borderResaltarAccionista;

		 return borderResaltarAccionista;
	}



	public Boolean mostrarAccionistaTipoIdentificacion=true;

	public Boolean getMostrarAccionistaTipoIdentificacion() {
		return this.mostrarAccionistaTipoIdentificacion;
	}

	public void setMostrarAccionistaTipoIdentificacion(Boolean visibilidadResaltarAccionista) {
		this.mostrarAccionistaTipoIdentificacion= visibilidadResaltarAccionista;
	}



	public Boolean activarAccionistaTipoIdentificacion=true;

	public Boolean gethabilitarResaltarAccionistaTipoIdentificacion() {
		return this.activarAccionistaTipoIdentificacion;
	}

	public void setActivarAccionistaTipoIdentificacion(Boolean habilitarResaltarAccionista) {
		this.activarAccionistaTipoIdentificacion= habilitarResaltarAccionista;
	}


	public Border resaltarClienteTipoIdentificacion=null;

	public Border getResaltarClienteTipoIdentificacion() {
		return this.resaltarClienteTipoIdentificacion;
	}

	public void setResaltarClienteTipoIdentificacion(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoIdentificacion= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoIdentificacion= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoIdentificacion=true;

	public Boolean getMostrarClienteTipoIdentificacion() {
		return this.mostrarClienteTipoIdentificacion;
	}

	public void setMostrarClienteTipoIdentificacion(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoIdentificacion= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoIdentificacion=true;

	public Boolean gethabilitarResaltarClienteTipoIdentificacion() {
		return this.activarClienteTipoIdentificacion;
	}

	public void setActivarClienteTipoIdentificacion(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoIdentificacion= habilitarResaltarCliente;
	}


	public Border resaltarParametroCarteraDefectoTipoIdentificacion=null;

	public Border getResaltarParametroCarteraDefectoTipoIdentificacion() {
		return this.resaltarParametroCarteraDefectoTipoIdentificacion;
	}

	public void setResaltarParametroCarteraDefectoTipoIdentificacion(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoTipoIdentificacion= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoTipoIdentificacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoidentificacionBeanSwingJInternalFrame.jTtoolBarTipoIdentificacion.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoTipoIdentificacion= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoTipoIdentificacion=true;

	public Boolean getMostrarParametroCarteraDefectoTipoIdentificacion() {
		return this.mostrarParametroCarteraDefectoTipoIdentificacion;
	}

	public void setMostrarParametroCarteraDefectoTipoIdentificacion(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoTipoIdentificacion= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoTipoIdentificacion=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoTipoIdentificacion() {
		return this.activarParametroCarteraDefectoTipoIdentificacion;
	}

	public void setActivarParametroCarteraDefectoTipoIdentificacion(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoTipoIdentificacion= habilitarResaltarParametroCarteraDefecto;
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

		this.setMostrarConyugeTipoIdentificacion(esInicial);
		this.setMostrarCobradorTipoIdentificacion(esInicial);
		this.setMostrarRepresentanteLegalTipoIdentificacion(esInicial);
		this.setMostrarSubClienteTipoIdentificacion(esInicial);
		this.setMostrarAccionistaTipoIdentificacion(esInicial);
		this.setMostrarClienteTipoIdentificacion(esInicial);
		this.setMostrarParametroCarteraDefectoTipoIdentificacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conyuge.class)) {
				this.setMostrarConyugeTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cobrador.class)) {
				this.setMostrarCobradorTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setMostrarRepresentanteLegalTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accionista.class)) {
				this.setMostrarAccionistaTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoTipoIdentificacion(esAsigna);
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

		this.setActivarConyugeTipoIdentificacion(esInicial);
		this.setActivarCobradorTipoIdentificacion(esInicial);
		this.setActivarRepresentanteLegalTipoIdentificacion(esInicial);
		this.setActivarSubClienteTipoIdentificacion(esInicial);
		this.setActivarAccionistaTipoIdentificacion(esInicial);
		this.setActivarClienteTipoIdentificacion(esInicial);
		this.setActivarParametroCarteraDefectoTipoIdentificacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conyuge.class)) {
				this.setActivarConyugeTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cobrador.class)) {
				this.setActivarCobradorTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setActivarRepresentanteLegalTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accionista.class)) {
				this.setActivarAccionistaTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoTipoIdentificacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIdentificacionBeanSwingJInternalFrame tipoidentificacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarConyugeTipoIdentificacion(esInicial);
		this.setResaltarCobradorTipoIdentificacion(esInicial);
		this.setResaltarRepresentanteLegalTipoIdentificacion(esInicial);
		this.setResaltarSubClienteTipoIdentificacion(esInicial);
		this.setResaltarAccionistaTipoIdentificacion(esInicial);
		this.setResaltarClienteTipoIdentificacion(esInicial);
		this.setResaltarParametroCarteraDefectoTipoIdentificacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conyuge.class)) {
				this.setResaltarConyugeTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cobrador.class)) {
				this.setResaltarCobradorTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setResaltarRepresentanteLegalTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accionista.class)) {
				this.setResaltarAccionistaTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoIdentificacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoTipoIdentificacion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}