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


import com.bydan.erp.inventario.util.TipoAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.TipoAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoAutoriConsepParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoAutoriConsepConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAutoriConsep";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAutoriConsep"+TipoAutoriConsepConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAutoriConsepHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAutoriConsepHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAutoriConsepConstantesFunciones.SCHEMA+"_"+TipoAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAutoriConsepConstantesFunciones.SCHEMA+"_"+TipoAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAutoriConsepConstantesFunciones.SCHEMA+"_"+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAutoriConsepConstantesFunciones.SCHEMA+"_"+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAutoriConsepConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAutoriConsepConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Autorizacion Consepes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Autorizacion Consep";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Autori Consep";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAutoriConsep";
	public static final String OBJECTNAME="tipoautoriconsep";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_autori_consep";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoautoriconsep from "+TipoAutoriConsepConstantesFunciones.SPERSISTENCENAME+" tipoautoriconsep";
	public static String QUERYSELECTNATIVE="select "+TipoAutoriConsepConstantesFunciones.SCHEMA+"."+TipoAutoriConsepConstantesFunciones.TABLENAME+".id,"+TipoAutoriConsepConstantesFunciones.SCHEMA+"."+TipoAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+TipoAutoriConsepConstantesFunciones.SCHEMA+"."+TipoAutoriConsepConstantesFunciones.TABLENAME+".codigo,"+TipoAutoriConsepConstantesFunciones.SCHEMA+"."+TipoAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+TipoAutoriConsepConstantesFunciones.SCHEMA+"."+TipoAutoriConsepConstantesFunciones.TABLENAME;//+" as "+TipoAutoriConsepConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
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
	
	public static String getTipoAutoriConsepLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAutoriConsepConstantesFunciones.CODIGO)) {sLabelColumna=TipoAutoriConsepConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoAutoriConsepConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAutoriConsepConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoAutoriConsepDescripcion(TipoAutoriConsep tipoautoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoautoriconsep !=null/* && tipoautoriconsep.getId()!=0*/) {
			sDescripcion=tipoautoriconsep.getcodigo();//tipoautoriconseptipoautoriconsep.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAutoriConsepDescripcionDetallado(TipoAutoriConsep tipoautoriconsep) {
		String sDescripcion="";
			
		sDescripcion+=TipoAutoriConsepConstantesFunciones.ID+"=";
		sDescripcion+=tipoautoriconsep.getId().toString()+",";
		sDescripcion+=TipoAutoriConsepConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoautoriconsep.getVersionRow().toString()+",";
		sDescripcion+=TipoAutoriConsepConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoautoriconsep.getcodigo()+",";
		sDescripcion+=TipoAutoriConsepConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoautoriconsep.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAutoriConsepDescripcion(TipoAutoriConsep tipoautoriconsep,String sValor) throws Exception {			
		if(tipoautoriconsep !=null) {
			tipoautoriconsep.setcodigo(sValor);;//tipoautoriconseptipoautoriconsep.getcodigo().trim();
		}		
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoautoriconsep.setcodigo(tipoautoriconsep.getcodigo().trim());
		tipoautoriconsep.setnombre(tipoautoriconsep.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoAutoriConseps(List<TipoAutoriConsep> tipoautoriconseps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAutoriConsep tipoautoriconsep: tipoautoriconseps) {
			tipoautoriconsep.setcodigo(tipoautoriconsep.getcodigo().trim());
			tipoautoriconsep.setnombre(tipoautoriconsep.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoautoriconsep.getConCambioAuxiliar()) {
			tipoautoriconsep.setIsDeleted(tipoautoriconsep.getIsDeletedAuxiliar());	
			tipoautoriconsep.setIsNew(tipoautoriconsep.getIsNewAuxiliar());	
			tipoautoriconsep.setIsChanged(tipoautoriconsep.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoautoriconsep.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoautoriconsep.setIsDeletedAuxiliar(false);	
			tipoautoriconsep.setIsNewAuxiliar(false);	
			tipoautoriconsep.setIsChangedAuxiliar(false);
			
			tipoautoriconsep.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAutoriConseps(List<TipoAutoriConsep> tipoautoriconseps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAutoriConsep tipoautoriconsep : tipoautoriconseps) {
			if(conAsignarBase && tipoautoriconsep.getConCambioAuxiliar()) {
				tipoautoriconsep.setIsDeleted(tipoautoriconsep.getIsDeletedAuxiliar());	
				tipoautoriconsep.setIsNew(tipoautoriconsep.getIsNewAuxiliar());	
				tipoautoriconsep.setIsChanged(tipoautoriconsep.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoautoriconsep.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoautoriconsep.setIsDeletedAuxiliar(false);	
				tipoautoriconsep.setIsNewAuxiliar(false);	
				tipoautoriconsep.setIsChangedAuxiliar(false);
				
				tipoautoriconsep.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAutoriConseps(List<TipoAutoriConsep> tipoautoriconseps,Boolean conEnteros) throws Exception  {
		
		for(TipoAutoriConsep tipoautoriconsep: tipoautoriconseps) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAutoriConsep(List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsep tipoautoriconsepAux) throws Exception  {
		TipoAutoriConsepConstantesFunciones.InicializarValoresTipoAutoriConsep(tipoautoriconsepAux,true);
		
		for(TipoAutoriConsep tipoautoriconsep: tipoautoriconseps) {
			if(tipoautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAutoriConsepConstantesFunciones.getArrayColumnasGlobalesTipoAutoriConsep(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsep tipoautoriconsep,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAutoriConsep tipoautoriconsepAux: tipoautoriconseps) {
			if(tipoautoriconsepAux!=null && tipoautoriconsep!=null) {
				if((tipoautoriconsepAux.getId()==null && tipoautoriconsep.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoautoriconsepAux.getId()!=null && tipoautoriconsep.getId()!=null){
					if(tipoautoriconsepAux.getId().equals(tipoautoriconsep.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAutoriConsep(List<TipoAutoriConsep> tipoautoriconseps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoAutoriConsep tipoautoriconsep: tipoautoriconseps) {			
			if(tipoautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAutoriConsep() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAutoriConsepConstantesFunciones.LABEL_ID, TipoAutoriConsepConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoriConsepConstantesFunciones.LABEL_VERSIONROW, TipoAutoriConsepConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoriConsepConstantesFunciones.LABEL_CODIGO, TipoAutoriConsepConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoriConsepConstantesFunciones.LABEL_NOMBRE, TipoAutoriConsepConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAutoriConsep() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAutoriConsepConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoriConsepConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoriConsepConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoriConsepConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoriConsep() throws Exception  {
		return TipoAutoriConsepConstantesFunciones.getTiposSeleccionarTipoAutoriConsep(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoriConsep(Boolean conFk) throws Exception  {
		return TipoAutoriConsepConstantesFunciones.getTiposSeleccionarTipoAutoriConsep(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoriConsep(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAutoriConsepConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoAutoriConsepConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAutoriConsepConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAutoriConsepConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAutoriConsep(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAutoriConsep(TipoAutoriConsep tipoautoriconsepAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAutoriConsep(List<TipoAutoriConsep> tipoautoriconsepsTemp) throws Exception {
		for(TipoAutoriConsep tipoautoriconsepAux:tipoautoriconsepsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAutoriConsepConstantesFunciones.getClassesRelationshipsOfTipoAutoriConsep(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AutoriConsep.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriConsep.class)) {
						classes.add(new Classe(AutoriConsep.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAutoriConsepConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAutoriConsep(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriConsep.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriConsep.class)); continue;
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
	public static void actualizarLista(TipoAutoriConsep tipoautoriconsep,List<TipoAutoriConsep> tipoautoriconseps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAutoriConsep tipoautoriconsepEncontrado=null;
			
			for(TipoAutoriConsep tipoautoriconsepLocal:tipoautoriconseps) {
				if(tipoautoriconsepLocal.getId().equals(tipoautoriconsep.getId())) {
					tipoautoriconsepEncontrado=tipoautoriconsepLocal;
					
					tipoautoriconsepLocal.setIsChanged(tipoautoriconsep.getIsChanged());
					tipoautoriconsepLocal.setIsNew(tipoautoriconsep.getIsNew());
					tipoautoriconsepLocal.setIsDeleted(tipoautoriconsep.getIsDeleted());
					
					tipoautoriconsepLocal.setGeneralEntityOriginal(tipoautoriconsep.getGeneralEntityOriginal());
					
					tipoautoriconsepLocal.setId(tipoautoriconsep.getId());	
					tipoautoriconsepLocal.setVersionRow(tipoautoriconsep.getVersionRow());	
					tipoautoriconsepLocal.setcodigo(tipoautoriconsep.getcodigo());	
					tipoautoriconsepLocal.setnombre(tipoautoriconsep.getnombre());	
					
					
					tipoautoriconsepLocal.setAutoriConseps(tipoautoriconsep.getAutoriConseps());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoautoriconsep.getIsDeleted()) {
				if(!existe) {
					tipoautoriconseps.add(tipoautoriconsep);
				}
			} else {
				if(tipoautoriconsepEncontrado!=null && permiteQuitar)  {
					tipoautoriconseps.remove(tipoautoriconsepEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAutoriConsep tipoautoriconsep,List<TipoAutoriConsep> tipoautoriconseps) throws Exception {
		try	{			
			for(TipoAutoriConsep tipoautoriconsepLocal:tipoautoriconseps) {
				if(tipoautoriconsepLocal.getId().equals(tipoautoriconsep.getId())) {
					tipoautoriconsepLocal.setIsSelected(tipoautoriconsep.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAutoriConsep(List<TipoAutoriConsep> tipoautoriconsepsAux) throws Exception {
		//this.tipoautoriconsepsAux=tipoautoriconsepsAux;
		
		for(TipoAutoriConsep tipoautoriconsepAux:tipoautoriconsepsAux) {
			if(tipoautoriconsepAux.getIsChanged()) {
				tipoautoriconsepAux.setIsChanged(false);
			}		
			
			if(tipoautoriconsepAux.getIsNew()) {
				tipoautoriconsepAux.setIsNew(false);
			}	
			
			if(tipoautoriconsepAux.getIsDeleted()) {
				tipoautoriconsepAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAutoriConsep(TipoAutoriConsep tipoautoriconsepAux) throws Exception {
		//this.tipoautoriconsepAux=tipoautoriconsepAux;
		
			if(tipoautoriconsepAux.getIsChanged()) {
				tipoautoriconsepAux.setIsChanged(false);
			}		
			
			if(tipoautoriconsepAux.getIsNew()) {
				tipoautoriconsepAux.setIsNew(false);
			}	
			
			if(tipoautoriconsepAux.getIsDeleted()) {
				tipoautoriconsepAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAutoriConsep tipoautoriconsepAsignar,TipoAutoriConsep tipoautoriconsep) throws Exception {
		tipoautoriconsepAsignar.setId(tipoautoriconsep.getId());	
		tipoautoriconsepAsignar.setVersionRow(tipoautoriconsep.getVersionRow());	
		tipoautoriconsepAsignar.setcodigo(tipoautoriconsep.getcodigo());	
		tipoautoriconsepAsignar.setnombre(tipoautoriconsep.getnombre());	
	}
	
	public static void inicializarTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep) throws Exception {
		try {
				tipoautoriconsep.setId(0L);	
					
				tipoautoriconsep.setcodigo("");	
				tipoautoriconsep.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAutoriConsep(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAutoriConsepConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAutoriConsepConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAutoriConsep(String sTipo,Row row,Workbook workbook,TipoAutoriConsep tipoautoriconsep,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoautoriconsep.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoautoriconsep.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAutoriConsep=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAutoriConsep() {
		return this.sFinalQueryTipoAutoriConsep;
	}
	
	public void setsFinalQueryTipoAutoriConsep(String sFinalQueryTipoAutoriConsep) {
		this.sFinalQueryTipoAutoriConsep= sFinalQueryTipoAutoriConsep;
	}
	
	public Border resaltarSeleccionarTipoAutoriConsep=null;
	
	public Border setResaltarSeleccionarTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoautoriconsepBeanSwingJInternalFrame.jTtoolBarTipoAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAutoriConsep= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAutoriConsep() {
		return this.resaltarSeleccionarTipoAutoriConsep;
	}
	
	public void setResaltarSeleccionarTipoAutoriConsep(Border borderResaltarSeleccionarTipoAutoriConsep) {
		this.resaltarSeleccionarTipoAutoriConsep= borderResaltarSeleccionarTipoAutoriConsep;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAutoriConsep=null;
	public Boolean mostraridTipoAutoriConsep=true;
	public Boolean activaridTipoAutoriConsep=true;

	public Border resaltarcodigoTipoAutoriConsep=null;
	public Boolean mostrarcodigoTipoAutoriConsep=true;
	public Boolean activarcodigoTipoAutoriConsep=true;

	public Border resaltarnombreTipoAutoriConsep=null;
	public Boolean mostrarnombreTipoAutoriConsep=true;
	public Boolean activarnombreTipoAutoriConsep=true;

	
	

	public Border setResaltaridTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautoriconsepBeanSwingJInternalFrame.jTtoolBarTipoAutoriConsep.setBorder(borderResaltar);
		
		this.resaltaridTipoAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAutoriConsep() {
		return this.resaltaridTipoAutoriConsep;
	}

	public void setResaltaridTipoAutoriConsep(Border borderResaltar) {
		this.resaltaridTipoAutoriConsep= borderResaltar;
	}

	public Boolean getMostraridTipoAutoriConsep() {
		return this.mostraridTipoAutoriConsep;
	}

	public void setMostraridTipoAutoriConsep(Boolean mostraridTipoAutoriConsep) {
		this.mostraridTipoAutoriConsep= mostraridTipoAutoriConsep;
	}

	public Boolean getActivaridTipoAutoriConsep() {
		return this.activaridTipoAutoriConsep;
	}

	public void setActivaridTipoAutoriConsep(Boolean activaridTipoAutoriConsep) {
		this.activaridTipoAutoriConsep= activaridTipoAutoriConsep;
	}

	public Border setResaltarcodigoTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautoriconsepBeanSwingJInternalFrame.jTtoolBarTipoAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoAutoriConsep() {
		return this.resaltarcodigoTipoAutoriConsep;
	}

	public void setResaltarcodigoTipoAutoriConsep(Border borderResaltar) {
		this.resaltarcodigoTipoAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoAutoriConsep() {
		return this.mostrarcodigoTipoAutoriConsep;
	}

	public void setMostrarcodigoTipoAutoriConsep(Boolean mostrarcodigoTipoAutoriConsep) {
		this.mostrarcodigoTipoAutoriConsep= mostrarcodigoTipoAutoriConsep;
	}

	public Boolean getActivarcodigoTipoAutoriConsep() {
		return this.activarcodigoTipoAutoriConsep;
	}

	public void setActivarcodigoTipoAutoriConsep(Boolean activarcodigoTipoAutoriConsep) {
		this.activarcodigoTipoAutoriConsep= activarcodigoTipoAutoriConsep;
	}

	public Border setResaltarnombreTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautoriconsepBeanSwingJInternalFrame.jTtoolBarTipoAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAutoriConsep() {
		return this.resaltarnombreTipoAutoriConsep;
	}

	public void setResaltarnombreTipoAutoriConsep(Border borderResaltar) {
		this.resaltarnombreTipoAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAutoriConsep() {
		return this.mostrarnombreTipoAutoriConsep;
	}

	public void setMostrarnombreTipoAutoriConsep(Boolean mostrarnombreTipoAutoriConsep) {
		this.mostrarnombreTipoAutoriConsep= mostrarnombreTipoAutoriConsep;
	}

	public Boolean getActivarnombreTipoAutoriConsep() {
		return this.activarnombreTipoAutoriConsep;
	}

	public void setActivarnombreTipoAutoriConsep(Boolean activarnombreTipoAutoriConsep) {
		this.activarnombreTipoAutoriConsep= activarnombreTipoAutoriConsep;
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
		
		
		this.setMostraridTipoAutoriConsep(esInicial);
		this.setMostrarcodigoTipoAutoriConsep(esInicial);
		this.setMostrarnombreTipoAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.ID)) {
				this.setMostraridTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAutoriConsep(esAsigna);
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
		
		
		this.setActivaridTipoAutoriConsep(esInicial);
		this.setActivarcodigoTipoAutoriConsep(esInicial);
		this.setActivarnombreTipoAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.ID)) {
				this.setActivaridTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAutoriConsep(esInicial);
		this.setResaltarcodigoTipoAutoriConsep(esInicial);
		this.setResaltarnombreTipoAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.ID)) {
				this.setResaltaridTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAutoriConsepTipoAutoriConsep=null;

	public Border getResaltarAutoriConsepTipoAutoriConsep() {
		return this.resaltarAutoriConsepTipoAutoriConsep;
	}

	public void setResaltarAutoriConsepTipoAutoriConsep(Border borderResaltarAutoriConsep) {
		if(borderResaltarAutoriConsep!=null) {
			this.resaltarAutoriConsepTipoAutoriConsep= borderResaltarAutoriConsep;
		}
	}

	public Border setResaltarAutoriConsepTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriConsep=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoautoriconsepBeanSwingJInternalFrame.jTtoolBarTipoAutoriConsep.setBorder(borderResaltarAutoriConsep);
			
		this.resaltarAutoriConsepTipoAutoriConsep= borderResaltarAutoriConsep;

		 return borderResaltarAutoriConsep;
	}



	public Boolean mostrarAutoriConsepTipoAutoriConsep=true;

	public Boolean getMostrarAutoriConsepTipoAutoriConsep() {
		return this.mostrarAutoriConsepTipoAutoriConsep;
	}

	public void setMostrarAutoriConsepTipoAutoriConsep(Boolean visibilidadResaltarAutoriConsep) {
		this.mostrarAutoriConsepTipoAutoriConsep= visibilidadResaltarAutoriConsep;
	}



	public Boolean activarAutoriConsepTipoAutoriConsep=true;

	public Boolean gethabilitarResaltarAutoriConsepTipoAutoriConsep() {
		return this.activarAutoriConsepTipoAutoriConsep;
	}

	public void setActivarAutoriConsepTipoAutoriConsep(Boolean habilitarResaltarAutoriConsep) {
		this.activarAutoriConsepTipoAutoriConsep= habilitarResaltarAutoriConsep;
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

		this.setMostrarAutoriConsepTipoAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AutoriConsep.class)) {
				this.setMostrarAutoriConsepTipoAutoriConsep(esAsigna);
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

		this.setActivarAutoriConsepTipoAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AutoriConsep.class)) {
				this.setActivarAutoriConsepTipoAutoriConsep(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAutoriConsepTipoAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AutoriConsep.class)) {
				this.setResaltarAutoriConsepTipoAutoriConsep(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoAutoriConsep=true;

	public Boolean getMostrarBusquedaPorCodigoTipoAutoriConsep() {
		return this.mostrarBusquedaPorCodigoTipoAutoriConsep;
	}

	public void setMostrarBusquedaPorCodigoTipoAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoAutoriConsep=true;

	public Boolean getMostrarBusquedaPorNombreTipoAutoriConsep() {
		return this.mostrarBusquedaPorNombreTipoAutoriConsep;
	}

	public void setMostrarBusquedaPorNombreTipoAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoAutoriConsep= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoAutoriConsep=true;

	public Boolean getActivarBusquedaPorCodigoTipoAutoriConsep() {
		return this.activarBusquedaPorCodigoTipoAutoriConsep;
	}

	public void setActivarBusquedaPorCodigoTipoAutoriConsep(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoAutoriConsep= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoAutoriConsep=true;

	public Boolean getActivarBusquedaPorNombreTipoAutoriConsep() {
		return this.activarBusquedaPorNombreTipoAutoriConsep;
	}

	public void setActivarBusquedaPorNombreTipoAutoriConsep(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoAutoriConsep= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoAutoriConsep=null;

	public Border getResaltarBusquedaPorCodigoTipoAutoriConsep() {
		return this.resaltarBusquedaPorCodigoTipoAutoriConsep;
	}

	public void setResaltarBusquedaPorCodigoTipoAutoriConsep(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoAutoriConsep= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoAutoriConsep= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoAutoriConsep=null;

	public Border getResaltarBusquedaPorNombreTipoAutoriConsep() {
		return this.resaltarBusquedaPorNombreTipoAutoriConsep;
	}

	public void setResaltarBusquedaPorNombreTipoAutoriConsep(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoAutoriConsep= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoriConsepBeanSwingJInternalFrame tipoautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoAutoriConsep= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}