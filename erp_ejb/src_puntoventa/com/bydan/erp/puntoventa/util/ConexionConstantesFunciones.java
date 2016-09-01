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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.ConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.ConexionParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ConexionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConexionConstantesFunciones extends ConexionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Conexion";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Conexion"+ConexionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConexionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConexionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConexionConstantesFunciones.SCHEMA+"_"+ConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConexionConstantesFunciones.SCHEMA+"_"+ConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConexionConstantesFunciones.SCHEMA+"_"+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConexionConstantesFunciones.SCHEMA+"_"+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConexionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConexionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConexionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConexionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conexiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Conexion";
	public static final String SCLASSWEBTITULO_LOWER="Conexion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Conexion";
	public static final String OBJECTNAME="conexion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="conexion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conexion from "+ConexionConstantesFunciones.SPERSISTENCENAME+" conexion";
	public static String QUERYSELECTNATIVE="select "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".id,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".version_row,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".id_tipo_conexion,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".nombre,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".nombre_maquina from "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME;//+" as "+ConexionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConexionConstantesFuncionesAdditional conexionConstantesFuncionesAdditional=null;
	
	public ConexionConstantesFuncionesAdditional getConexionConstantesFuncionesAdditional() {
		return this.conexionConstantesFuncionesAdditional;
	}
	
	public void setConexionConstantesFuncionesAdditional(ConexionConstantesFuncionesAdditional conexionConstantesFuncionesAdditional) {
		try {
			this.conexionConstantesFuncionesAdditional=conexionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOCONEXION= "id_tipo_conexion";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREMAQUINA= "nombre_maquina";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOCONEXION= "Tipo Conexion";
		public static final String LABEL_IDTIPOCONEXION_LOWER= "Tipo Conexion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREMAQUINA= "Nombre Maquina";
		public static final String LABEL_NOMBREMAQUINA_LOWER= "Nombre Maquina";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MAQUINA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MAQUINA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getConexionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConexionConstantesFunciones.IDTIPOCONEXION)) {sLabelColumna=ConexionConstantesFunciones.LABEL_IDTIPOCONEXION;}
		if(sNombreColumna.equals(ConexionConstantesFunciones.NOMBRE)) {sLabelColumna=ConexionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConexionConstantesFunciones.NOMBREMAQUINA)) {sLabelColumna=ConexionConstantesFunciones.LABEL_NOMBREMAQUINA;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getConexionDescripcion(Conexion conexion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conexion !=null/* && conexion.getId()!=0*/) {
			sDescripcion=conexion.getnombre();//conexionconexion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConexionDescripcionDetallado(Conexion conexion) {
		String sDescripcion="";
			
		sDescripcion+=ConexionConstantesFunciones.ID+"=";
		sDescripcion+=conexion.getId().toString()+",";
		sDescripcion+=ConexionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conexion.getVersionRow().toString()+",";
		sDescripcion+=ConexionConstantesFunciones.IDTIPOCONEXION+"=";
		sDescripcion+=conexion.getid_tipo_conexion().toString()+",";
		sDescripcion+=ConexionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=conexion.getnombre()+",";
		sDescripcion+=ConexionConstantesFunciones.NOMBREMAQUINA+"=";
		sDescripcion+=conexion.getnombre_maquina()+",";
			
		return sDescripcion;
	}
	
	public static void setConexionDescripcion(Conexion conexion,String sValor) throws Exception {			
		if(conexion !=null) {
			conexion.setnombre(sValor);;//conexionconexion.getnombre().trim();
		}		
	}
	
		

	public static String getTipoConexionDescripcion(TipoConexion tipoconexion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoconexion!=null/*&&tipoconexion.getId()>0*/) {
			sDescripcion=TipoConexionConstantesFunciones.getTipoConexionDescripcion(tipoconexion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdTipoConexion")) {
			sNombreIndice="Tipo=  Por Tipo Conexion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdTipoConexion(Long id_tipo_conexion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_conexion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Conexion="+id_tipo_conexion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConexion(Conexion conexion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conexion.setnombre(conexion.getnombre().trim());
		conexion.setnombre_maquina(conexion.getnombre_maquina().trim());
	}
	
	public static void quitarEspaciosConexions(List<Conexion> conexions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Conexion conexion: conexions) {
			conexion.setnombre(conexion.getnombre().trim());
			conexion.setnombre_maquina(conexion.getnombre_maquina().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConexion(Conexion conexion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conexion.getConCambioAuxiliar()) {
			conexion.setIsDeleted(conexion.getIsDeletedAuxiliar());	
			conexion.setIsNew(conexion.getIsNewAuxiliar());	
			conexion.setIsChanged(conexion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conexion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conexion.setIsDeletedAuxiliar(false);	
			conexion.setIsNewAuxiliar(false);	
			conexion.setIsChangedAuxiliar(false);
			
			conexion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConexions(List<Conexion> conexions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Conexion conexion : conexions) {
			if(conAsignarBase && conexion.getConCambioAuxiliar()) {
				conexion.setIsDeleted(conexion.getIsDeletedAuxiliar());	
				conexion.setIsNew(conexion.getIsNewAuxiliar());	
				conexion.setIsChanged(conexion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conexion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conexion.setIsDeletedAuxiliar(false);	
				conexion.setIsNewAuxiliar(false);	
				conexion.setIsChangedAuxiliar(false);
				
				conexion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConexion(Conexion conexion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConexions(List<Conexion> conexions,Boolean conEnteros) throws Exception  {
		
		for(Conexion conexion: conexions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConexion(List<Conexion> conexions,Conexion conexionAux) throws Exception  {
		ConexionConstantesFunciones.InicializarValoresConexion(conexionAux,true);
		
		for(Conexion conexion: conexions) {
			if(conexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConexionConstantesFunciones.getArrayColumnasGlobalesConexion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConexion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Conexion> conexions,Conexion conexion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Conexion conexionAux: conexions) {
			if(conexionAux!=null && conexion!=null) {
				if((conexionAux.getId()==null && conexion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conexionAux.getId()!=null && conexion.getId()!=null){
					if(conexionAux.getId().equals(conexion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConexion(List<Conexion> conexions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Conexion conexion: conexions) {			
			if(conexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConexion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConexionConstantesFunciones.LABEL_ID, ConexionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConexionConstantesFunciones.LABEL_VERSIONROW, ConexionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConexionConstantesFunciones.LABEL_IDTIPOCONEXION, ConexionConstantesFunciones.IDTIPOCONEXION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConexionConstantesFunciones.LABEL_NOMBRE, ConexionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConexionConstantesFunciones.LABEL_NOMBREMAQUINA, ConexionConstantesFunciones.NOMBREMAQUINA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConexion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConexionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConexionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConexionConstantesFunciones.IDTIPOCONEXION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConexionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConexionConstantesFunciones.NOMBREMAQUINA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConexion() throws Exception  {
		return ConexionConstantesFunciones.getTiposSeleccionarConexion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConexion(Boolean conFk) throws Exception  {
		return ConexionConstantesFunciones.getTiposSeleccionarConexion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConexion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConexionConstantesFunciones.LABEL_IDTIPOCONEXION);
			reporte.setsDescripcion(ConexionConstantesFunciones.LABEL_IDTIPOCONEXION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConexionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConexionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConexionConstantesFunciones.LABEL_NOMBREMAQUINA);
			reporte.setsDescripcion(ConexionConstantesFunciones.LABEL_NOMBREMAQUINA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConexion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConexion(Conexion conexionAux) throws Exception {
		
			conexionAux.settipoconexion_descripcion(TipoConexionConstantesFunciones.getTipoConexionDescripcion(conexionAux.getTipoConexion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConexion(List<Conexion> conexionsTemp) throws Exception {
		for(Conexion conexionAux:conexionsTemp) {
			
			conexionAux.settipoconexion_descripcion(TipoConexionConstantesFunciones.getTipoConexionDescripcion(conexionAux.getTipoConexion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoConexion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoConexion.class)) {
						classes.add(new Classe(TipoConexion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConexion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoConexion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConexionConstantesFunciones.getClassesRelationshipsOfConexion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TarjetaCreditoConexion.class));
				classes.add(new Classe(NumeroRecap.class));
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCreditoConexion.class)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroRecap.class)) {
						classes.add(new Classe(NumeroRecap.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConexionConstantesFunciones.getClassesRelationshipsFromStringsOfConexion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCreditoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); continue;
					}

					if(NumeroRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroRecap.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCreditoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); continue;
					}

					if(NumeroRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroRecap.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
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
	public static void actualizarLista(Conexion conexion,List<Conexion> conexions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Conexion conexionEncontrado=null;
			
			for(Conexion conexionLocal:conexions) {
				if(conexionLocal.getId().equals(conexion.getId())) {
					conexionEncontrado=conexionLocal;
					
					conexionLocal.setIsChanged(conexion.getIsChanged());
					conexionLocal.setIsNew(conexion.getIsNew());
					conexionLocal.setIsDeleted(conexion.getIsDeleted());
					
					conexionLocal.setGeneralEntityOriginal(conexion.getGeneralEntityOriginal());
					
					conexionLocal.setId(conexion.getId());	
					conexionLocal.setVersionRow(conexion.getVersionRow());	
					conexionLocal.setid_tipo_conexion(conexion.getid_tipo_conexion());	
					conexionLocal.setnombre(conexion.getnombre());	
					conexionLocal.setnombre_maquina(conexion.getnombre_maquina());	
					
					
					conexionLocal.setTarjetaCreditoConexions(conexion.getTarjetaCreditoConexions());
					conexionLocal.setNumeroRecaps(conexion.getNumeroRecaps());
					conexionLocal.setFormaPagoPuntoVentas(conexion.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!conexion.getIsDeleted()) {
				if(!existe) {
					conexions.add(conexion);
				}
			} else {
				if(conexionEncontrado!=null && permiteQuitar)  {
					conexions.remove(conexionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Conexion conexion,List<Conexion> conexions) throws Exception {
		try	{			
			for(Conexion conexionLocal:conexions) {
				if(conexionLocal.getId().equals(conexion.getId())) {
					conexionLocal.setIsSelected(conexion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConexion(List<Conexion> conexionsAux) throws Exception {
		//this.conexionsAux=conexionsAux;
		
		for(Conexion conexionAux:conexionsAux) {
			if(conexionAux.getIsChanged()) {
				conexionAux.setIsChanged(false);
			}		
			
			if(conexionAux.getIsNew()) {
				conexionAux.setIsNew(false);
			}	
			
			if(conexionAux.getIsDeleted()) {
				conexionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConexion(Conexion conexionAux) throws Exception {
		//this.conexionAux=conexionAux;
		
			if(conexionAux.getIsChanged()) {
				conexionAux.setIsChanged(false);
			}		
			
			if(conexionAux.getIsNew()) {
				conexionAux.setIsNew(false);
			}	
			
			if(conexionAux.getIsDeleted()) {
				conexionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Conexion conexionAsignar,Conexion conexion) throws Exception {
		conexionAsignar.setId(conexion.getId());	
		conexionAsignar.setVersionRow(conexion.getVersionRow());	
		conexionAsignar.setid_tipo_conexion(conexion.getid_tipo_conexion());
		conexionAsignar.settipoconexion_descripcion(conexion.gettipoconexion_descripcion());	
		conexionAsignar.setnombre(conexion.getnombre());	
		conexionAsignar.setnombre_maquina(conexion.getnombre_maquina());	
	}
	
	public static void inicializarConexion(Conexion conexion) throws Exception {
		try {
				conexion.setId(0L);	
					
				conexion.setid_tipo_conexion(-1L);	
				conexion.setnombre("");	
				conexion.setnombre_maquina("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConexion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConexionConstantesFunciones.LABEL_IDTIPOCONEXION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConexionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConexionConstantesFunciones.LABEL_NOMBREMAQUINA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConexion(String sTipo,Row row,Workbook workbook,Conexion conexion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conexion.gettipoconexion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conexion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conexion.getnombre_maquina());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConexion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConexion() {
		return this.sFinalQueryConexion;
	}
	
	public void setsFinalQueryConexion(String sFinalQueryConexion) {
		this.sFinalQueryConexion= sFinalQueryConexion;
	}
	
	public Border resaltarSeleccionarConexion=null;
	
	public Border setResaltarSeleccionarConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConexion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConexion() {
		return this.resaltarSeleccionarConexion;
	}
	
	public void setResaltarSeleccionarConexion(Border borderResaltarSeleccionarConexion) {
		this.resaltarSeleccionarConexion= borderResaltarSeleccionarConexion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConexion=null;
	public Boolean mostraridConexion=true;
	public Boolean activaridConexion=true;

	public Border resaltarid_tipo_conexionConexion=null;
	public Boolean mostrarid_tipo_conexionConexion=true;
	public Boolean activarid_tipo_conexionConexion=true;
	public Boolean cargarid_tipo_conexionConexion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_conexionConexion=false;//ConEventDepend=true

	public Border resaltarnombreConexion=null;
	public Boolean mostrarnombreConexion=true;
	public Boolean activarnombreConexion=true;

	public Border resaltarnombre_maquinaConexion=null;
	public Boolean mostrarnombre_maquinaConexion=true;
	public Boolean activarnombre_maquinaConexion=true;

	
	

	public Border setResaltaridConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltar);
		
		this.resaltaridConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConexion() {
		return this.resaltaridConexion;
	}

	public void setResaltaridConexion(Border borderResaltar) {
		this.resaltaridConexion= borderResaltar;
	}

	public Boolean getMostraridConexion() {
		return this.mostraridConexion;
	}

	public void setMostraridConexion(Boolean mostraridConexion) {
		this.mostraridConexion= mostraridConexion;
	}

	public Boolean getActivaridConexion() {
		return this.activaridConexion;
	}

	public void setActivaridConexion(Boolean activaridConexion) {
		this.activaridConexion= activaridConexion;
	}

	public Border setResaltarid_tipo_conexionConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_conexionConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_conexionConexion() {
		return this.resaltarid_tipo_conexionConexion;
	}

	public void setResaltarid_tipo_conexionConexion(Border borderResaltar) {
		this.resaltarid_tipo_conexionConexion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_conexionConexion() {
		return this.mostrarid_tipo_conexionConexion;
	}

	public void setMostrarid_tipo_conexionConexion(Boolean mostrarid_tipo_conexionConexion) {
		this.mostrarid_tipo_conexionConexion= mostrarid_tipo_conexionConexion;
	}

	public Boolean getActivarid_tipo_conexionConexion() {
		return this.activarid_tipo_conexionConexion;
	}

	public void setActivarid_tipo_conexionConexion(Boolean activarid_tipo_conexionConexion) {
		this.activarid_tipo_conexionConexion= activarid_tipo_conexionConexion;
	}

	public Boolean getCargarid_tipo_conexionConexion() {
		return this.cargarid_tipo_conexionConexion;
	}

	public void setCargarid_tipo_conexionConexion(Boolean cargarid_tipo_conexionConexion) {
		this.cargarid_tipo_conexionConexion= cargarid_tipo_conexionConexion;
	}

	public Border setResaltarnombreConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltar);
		
		this.resaltarnombreConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConexion() {
		return this.resaltarnombreConexion;
	}

	public void setResaltarnombreConexion(Border borderResaltar) {
		this.resaltarnombreConexion= borderResaltar;
	}

	public Boolean getMostrarnombreConexion() {
		return this.mostrarnombreConexion;
	}

	public void setMostrarnombreConexion(Boolean mostrarnombreConexion) {
		this.mostrarnombreConexion= mostrarnombreConexion;
	}

	public Boolean getActivarnombreConexion() {
		return this.activarnombreConexion;
	}

	public void setActivarnombreConexion(Boolean activarnombreConexion) {
		this.activarnombreConexion= activarnombreConexion;
	}

	public Border setResaltarnombre_maquinaConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltar);
		
		this.resaltarnombre_maquinaConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_maquinaConexion() {
		return this.resaltarnombre_maquinaConexion;
	}

	public void setResaltarnombre_maquinaConexion(Border borderResaltar) {
		this.resaltarnombre_maquinaConexion= borderResaltar;
	}

	public Boolean getMostrarnombre_maquinaConexion() {
		return this.mostrarnombre_maquinaConexion;
	}

	public void setMostrarnombre_maquinaConexion(Boolean mostrarnombre_maquinaConexion) {
		this.mostrarnombre_maquinaConexion= mostrarnombre_maquinaConexion;
	}

	public Boolean getActivarnombre_maquinaConexion() {
		return this.activarnombre_maquinaConexion;
	}

	public void setActivarnombre_maquinaConexion(Boolean activarnombre_maquinaConexion) {
		this.activarnombre_maquinaConexion= activarnombre_maquinaConexion;
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
		
		
		this.setMostraridConexion(esInicial);
		this.setMostrarid_tipo_conexionConexion(esInicial);
		this.setMostrarnombreConexion(esInicial);
		this.setMostrarnombre_maquinaConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConexionConstantesFunciones.ID)) {
				this.setMostraridConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.IDTIPOCONEXION)) {
				this.setMostrarid_tipo_conexionConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBREMAQUINA)) {
				this.setMostrarnombre_maquinaConexion(esAsigna);
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
		
		
		this.setActivaridConexion(esInicial);
		this.setActivarid_tipo_conexionConexion(esInicial);
		this.setActivarnombreConexion(esInicial);
		this.setActivarnombre_maquinaConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConexionConstantesFunciones.ID)) {
				this.setActivaridConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.IDTIPOCONEXION)) {
				this.setActivarid_tipo_conexionConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBREMAQUINA)) {
				this.setActivarnombre_maquinaConexion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConexion(esInicial);
		this.setResaltarid_tipo_conexionConexion(esInicial);
		this.setResaltarnombreConexion(esInicial);
		this.setResaltarnombre_maquinaConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConexionConstantesFunciones.ID)) {
				this.setResaltaridConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.IDTIPOCONEXION)) {
				this.setResaltarid_tipo_conexionConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConexionConstantesFunciones.NOMBREMAQUINA)) {
				this.setResaltarnombre_maquinaConexion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTarjetaCreditoConexionConexion=null;

	public Border getResaltarTarjetaCreditoConexionConexion() {
		return this.resaltarTarjetaCreditoConexionConexion;
	}

	public void setResaltarTarjetaCreditoConexionConexion(Border borderResaltarTarjetaCreditoConexion) {
		if(borderResaltarTarjetaCreditoConexion!=null) {
			this.resaltarTarjetaCreditoConexionConexion= borderResaltarTarjetaCreditoConexion;
		}
	}

	public Border setResaltarTarjetaCreditoConexionConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCreditoConexion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltarTarjetaCreditoConexion);
			
		this.resaltarTarjetaCreditoConexionConexion= borderResaltarTarjetaCreditoConexion;

		 return borderResaltarTarjetaCreditoConexion;
	}



	public Boolean mostrarTarjetaCreditoConexionConexion=true;

	public Boolean getMostrarTarjetaCreditoConexionConexion() {
		return this.mostrarTarjetaCreditoConexionConexion;
	}

	public void setMostrarTarjetaCreditoConexionConexion(Boolean visibilidadResaltarTarjetaCreditoConexion) {
		this.mostrarTarjetaCreditoConexionConexion= visibilidadResaltarTarjetaCreditoConexion;
	}



	public Boolean activarTarjetaCreditoConexionConexion=true;

	public Boolean gethabilitarResaltarTarjetaCreditoConexionConexion() {
		return this.activarTarjetaCreditoConexionConexion;
	}

	public void setActivarTarjetaCreditoConexionConexion(Boolean habilitarResaltarTarjetaCreditoConexion) {
		this.activarTarjetaCreditoConexionConexion= habilitarResaltarTarjetaCreditoConexion;
	}


	public Border resaltarNumeroRecapConexion=null;

	public Border getResaltarNumeroRecapConexion() {
		return this.resaltarNumeroRecapConexion;
	}

	public void setResaltarNumeroRecapConexion(Border borderResaltarNumeroRecap) {
		if(borderResaltarNumeroRecap!=null) {
			this.resaltarNumeroRecapConexion= borderResaltarNumeroRecap;
		}
	}

	public Border setResaltarNumeroRecapConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltarNumeroRecap=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltarNumeroRecap);
			
		this.resaltarNumeroRecapConexion= borderResaltarNumeroRecap;

		 return borderResaltarNumeroRecap;
	}



	public Boolean mostrarNumeroRecapConexion=true;

	public Boolean getMostrarNumeroRecapConexion() {
		return this.mostrarNumeroRecapConexion;
	}

	public void setMostrarNumeroRecapConexion(Boolean visibilidadResaltarNumeroRecap) {
		this.mostrarNumeroRecapConexion= visibilidadResaltarNumeroRecap;
	}



	public Boolean activarNumeroRecapConexion=true;

	public Boolean gethabilitarResaltarNumeroRecapConexion() {
		return this.activarNumeroRecapConexion;
	}

	public void setActivarNumeroRecapConexion(Boolean habilitarResaltarNumeroRecap) {
		this.activarNumeroRecapConexion= habilitarResaltarNumeroRecap;
	}


	public Border resaltarFormaPagoPuntoVentaConexion=null;

	public Border getResaltarFormaPagoPuntoVentaConexion() {
		return this.resaltarFormaPagoPuntoVentaConexion;
	}

	public void setResaltarFormaPagoPuntoVentaConexion(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaConexion= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//conexionBeanSwingJInternalFrame.jTtoolBarConexion.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaConexion= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaConexion=true;

	public Boolean getMostrarFormaPagoPuntoVentaConexion() {
		return this.mostrarFormaPagoPuntoVentaConexion;
	}

	public void setMostrarFormaPagoPuntoVentaConexion(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaConexion= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaConexion=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaConexion() {
		return this.activarFormaPagoPuntoVentaConexion;
	}

	public void setActivarFormaPagoPuntoVentaConexion(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaConexion= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarTarjetaCreditoConexionConexion(esInicial);
		this.setMostrarNumeroRecapConexion(esInicial);
		this.setMostrarFormaPagoPuntoVentaConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setMostrarTarjetaCreditoConexionConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(NumeroRecap.class)) {
				this.setMostrarNumeroRecapConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaConexion(esAsigna);
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

		this.setActivarTarjetaCreditoConexionConexion(esInicial);
		this.setActivarNumeroRecapConexion(esInicial);
		this.setActivarFormaPagoPuntoVentaConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setActivarTarjetaCreditoConexionConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(NumeroRecap.class)) {
				this.setActivarNumeroRecapConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaConexion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTarjetaCreditoConexionConexion(esInicial);
		this.setResaltarNumeroRecapConexion(esInicial);
		this.setResaltarFormaPagoPuntoVentaConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setResaltarTarjetaCreditoConexionConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(NumeroRecap.class)) {
				this.setResaltarNumeroRecapConexion(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaConexion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdTipoConexionConexion=true;

	public Boolean getMostrarFK_IdTipoConexionConexion() {
		return this.mostrarFK_IdTipoConexionConexion;
	}

	public void setMostrarFK_IdTipoConexionConexion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoConexionConexion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdTipoConexionConexion=true;

	public Boolean getActivarFK_IdTipoConexionConexion() {
		return this.activarFK_IdTipoConexionConexion;
	}

	public void setActivarFK_IdTipoConexionConexion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoConexionConexion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdTipoConexionConexion=null;

	public Border getResaltarFK_IdTipoConexionConexion() {
		return this.resaltarFK_IdTipoConexionConexion;
	}

	public void setResaltarFK_IdTipoConexionConexion(Border borderResaltar) {
		this.resaltarFK_IdTipoConexionConexion= borderResaltar;
	}

	public void setResaltarFK_IdTipoConexionConexion(ParametroGeneralUsuario parametroGeneralUsuario/*ConexionBeanSwingJInternalFrame conexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoConexionConexion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}