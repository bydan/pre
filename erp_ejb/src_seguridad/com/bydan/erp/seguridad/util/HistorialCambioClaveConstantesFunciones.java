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


import com.bydan.erp.seguridad.util.HistorialCambioClaveConstantesFunciones;
import com.bydan.erp.seguridad.util.HistorialCambioClaveParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.HistorialCambioClaveParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class HistorialCambioClaveConstantesFunciones extends HistorialCambioClaveConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialCambioClave";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialCambioClave"+HistorialCambioClaveConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialCambioClaveHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialCambioClaveHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialCambioClaveConstantesFunciones.SCHEMA+"_"+HistorialCambioClaveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialCambioClaveHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialCambioClaveConstantesFunciones.SCHEMA+"_"+HistorialCambioClaveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialCambioClaveConstantesFunciones.SCHEMA+"_"+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialCambioClaveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialCambioClaveConstantesFunciones.SCHEMA+"_"+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialCambioClaveHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialCambioClaveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialCambioClaveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialCambioClaveConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialCambioClaveConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialCambioClaveConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialCambioClaveConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Cambio Claves";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Historial Cambio Clave";
	public static final String SCLASSWEBTITULO_LOWER="Historial Cambio Clave";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialCambioClave";
	public static final String OBJECTNAME="historialcambioclave";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="historial_cambio_clave";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialcambioclave from "+HistorialCambioClaveConstantesFunciones.SPERSISTENCENAME+" historialcambioclave";
	public static String QUERYSELECTNATIVE="select "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".id,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".version_row,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".id_usuario,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".nombre,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".fecha_hora,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".observacion from "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME;//+" as "+HistorialCambioClaveConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HistorialCambioClaveConstantesFuncionesAdditional historialcambioclaveConstantesFuncionesAdditional=null;
	
	public HistorialCambioClaveConstantesFuncionesAdditional getHistorialCambioClaveConstantesFuncionesAdditional() {
		return this.historialcambioclaveConstantesFuncionesAdditional;
	}
	
	public void setHistorialCambioClaveConstantesFuncionesAdditional(HistorialCambioClaveConstantesFuncionesAdditional historialcambioclaveConstantesFuncionesAdditional) {
		try {
			this.historialcambioclaveConstantesFuncionesAdditional=historialcambioclaveConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDUSUARIO= "id_usuario";
    public static final String NOMBRE= "nombre";
    public static final String FECHAHORA= "fecha_hora";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHAHORA= "Fecha Hora";
		public static final String LABEL_FECHAHORA_LOWER= "Fecha Hora";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getHistorialCambioClaveLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialCambioClaveConstantesFunciones.IDUSUARIO)) {sLabelColumna=HistorialCambioClaveConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(HistorialCambioClaveConstantesFunciones.NOMBRE)) {sLabelColumna=HistorialCambioClaveConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(HistorialCambioClaveConstantesFunciones.FECHAHORA)) {sLabelColumna=HistorialCambioClaveConstantesFunciones.LABEL_FECHAHORA;}
		if(sNombreColumna.equals(HistorialCambioClaveConstantesFunciones.OBSERVACION)) {sLabelColumna=HistorialCambioClaveConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getHistorialCambioClaveDescripcion(HistorialCambioClave historialcambioclave) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialcambioclave !=null/* && historialcambioclave.getId()!=0*/) {
			sDescripcion=historialcambioclave.getnombre();//historialcambioclavehistorialcambioclave.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialCambioClaveDescripcionDetallado(HistorialCambioClave historialcambioclave) {
		String sDescripcion="";
			
		sDescripcion+=HistorialCambioClaveConstantesFunciones.ID+"=";
		sDescripcion+=historialcambioclave.getId().toString()+",";
		sDescripcion+=HistorialCambioClaveConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialcambioclave.getVersionRow().toString()+",";
		sDescripcion+=HistorialCambioClaveConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=historialcambioclave.getid_usuario().toString()+",";
		sDescripcion+=HistorialCambioClaveConstantesFunciones.NOMBRE+"=";
		sDescripcion+=historialcambioclave.getnombre()+",";
		sDescripcion+=HistorialCambioClaveConstantesFunciones.FECHAHORA+"=";
		sDescripcion+=historialcambioclave.getfecha_hora().toString()+",";
		sDescripcion+=HistorialCambioClaveConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=historialcambioclave.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialCambioClaveDescripcion(HistorialCambioClave historialcambioclave,String sValor) throws Exception {			
		if(historialcambioclave !=null) {
			historialcambioclave.setnombre(sValor);;//historialcambioclavehistorialcambioclave.getnombre().trim();
		}		
	}
	
		

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdUsuarioPorFechaHora")) {
			sNombreIndice="Tipo=  Por Usuario Por Fecha Hora";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdUsuarioPorFechaHora(Long id_usuario,Timestamp fecha_hora) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Hora="+fecha_hora.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosHistorialCambioClave(HistorialCambioClave historialcambioclave,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		historialcambioclave.setnombre(historialcambioclave.getnombre().trim());
		historialcambioclave.setobservacion(historialcambioclave.getobservacion().trim());
	}
	
	public static void quitarEspaciosHistorialCambioClaves(List<HistorialCambioClave> historialcambioclaves,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialCambioClave historialcambioclave: historialcambioclaves) {
			historialcambioclave.setnombre(historialcambioclave.getnombre().trim());
			historialcambioclave.setobservacion(historialcambioclave.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialCambioClave(HistorialCambioClave historialcambioclave,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialcambioclave.getConCambioAuxiliar()) {
			historialcambioclave.setIsDeleted(historialcambioclave.getIsDeletedAuxiliar());	
			historialcambioclave.setIsNew(historialcambioclave.getIsNewAuxiliar());	
			historialcambioclave.setIsChanged(historialcambioclave.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialcambioclave.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialcambioclave.setIsDeletedAuxiliar(false);	
			historialcambioclave.setIsNewAuxiliar(false);	
			historialcambioclave.setIsChangedAuxiliar(false);
			
			historialcambioclave.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialCambioClaves(List<HistorialCambioClave> historialcambioclaves,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialCambioClave historialcambioclave : historialcambioclaves) {
			if(conAsignarBase && historialcambioclave.getConCambioAuxiliar()) {
				historialcambioclave.setIsDeleted(historialcambioclave.getIsDeletedAuxiliar());	
				historialcambioclave.setIsNew(historialcambioclave.getIsNewAuxiliar());	
				historialcambioclave.setIsChanged(historialcambioclave.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialcambioclave.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialcambioclave.setIsDeletedAuxiliar(false);	
				historialcambioclave.setIsNewAuxiliar(false);	
				historialcambioclave.setIsChangedAuxiliar(false);
				
				historialcambioclave.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialCambioClave(HistorialCambioClave historialcambioclave,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHistorialCambioClaves(List<HistorialCambioClave> historialcambioclaves,Boolean conEnteros) throws Exception  {
		
		for(HistorialCambioClave historialcambioclave: historialcambioclaves) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialCambioClave(List<HistorialCambioClave> historialcambioclaves,HistorialCambioClave historialcambioclaveAux) throws Exception  {
		HistorialCambioClaveConstantesFunciones.InicializarValoresHistorialCambioClave(historialcambioclaveAux,true);
		
		for(HistorialCambioClave historialcambioclave: historialcambioclaves) {
			if(historialcambioclave.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialCambioClave(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialCambioClaveConstantesFunciones.getArrayColumnasGlobalesHistorialCambioClave(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialCambioClave(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialCambioClaveConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialCambioClaveConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialCambioClave(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialCambioClave> historialcambioclaves,HistorialCambioClave historialcambioclave,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialCambioClave historialcambioclaveAux: historialcambioclaves) {
			if(historialcambioclaveAux!=null && historialcambioclave!=null) {
				if((historialcambioclaveAux.getId()==null && historialcambioclave.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialcambioclaveAux.getId()!=null && historialcambioclave.getId()!=null){
					if(historialcambioclaveAux.getId().equals(historialcambioclave.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialCambioClave(List<HistorialCambioClave> historialcambioclaves) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(HistorialCambioClave historialcambioclave: historialcambioclaves) {			
			if(historialcambioclave.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialCambioClave() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_ID, HistorialCambioClaveConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_VERSIONROW, HistorialCambioClaveConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_IDUSUARIO, HistorialCambioClaveConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_NOMBRE, HistorialCambioClaveConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_FECHAHORA, HistorialCambioClaveConstantesFunciones.FECHAHORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialCambioClaveConstantesFunciones.LABEL_OBSERVACION, HistorialCambioClaveConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialCambioClave() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.FECHAHORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialCambioClaveConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialCambioClave() throws Exception  {
		return HistorialCambioClaveConstantesFunciones.getTiposSeleccionarHistorialCambioClave(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialCambioClave(Boolean conFk) throws Exception  {
		return HistorialCambioClaveConstantesFunciones.getTiposSeleccionarHistorialCambioClave(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialCambioClave(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialCambioClaveConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(HistorialCambioClaveConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialCambioClaveConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(HistorialCambioClaveConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(HistorialCambioClaveConstantesFunciones.LABEL_FECHAHORA);
		reporte.setsDescripcion(HistorialCambioClaveConstantesFunciones.LABEL_FECHAHORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialCambioClaveConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(HistorialCambioClaveConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialCambioClave(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialCambioClave(HistorialCambioClave historialcambioclaveAux) throws Exception {
		
			historialcambioclaveAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(historialcambioclaveAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialCambioClave(List<HistorialCambioClave> historialcambioclavesTemp) throws Exception {
		for(HistorialCambioClave historialcambioclaveAux:historialcambioclavesTemp) {
			
			historialcambioclaveAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(historialcambioclaveAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialCambioClave(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialCambioClave(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialCambioClave(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialCambioClaveConstantesFunciones.getClassesRelationshipsOfHistorialCambioClave(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialCambioClave(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialCambioClave(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialCambioClaveConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialCambioClave(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialCambioClave(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HistorialCambioClave historialcambioclave,List<HistorialCambioClave> historialcambioclaves,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HistorialCambioClave historialcambioclaveEncontrado=null;
			
			for(HistorialCambioClave historialcambioclaveLocal:historialcambioclaves) {
				if(historialcambioclaveLocal.getId().equals(historialcambioclave.getId())) {
					historialcambioclaveEncontrado=historialcambioclaveLocal;
					
					historialcambioclaveLocal.setIsChanged(historialcambioclave.getIsChanged());
					historialcambioclaveLocal.setIsNew(historialcambioclave.getIsNew());
					historialcambioclaveLocal.setIsDeleted(historialcambioclave.getIsDeleted());
					
					historialcambioclaveLocal.setGeneralEntityOriginal(historialcambioclave.getGeneralEntityOriginal());
					
					historialcambioclaveLocal.setId(historialcambioclave.getId());	
					historialcambioclaveLocal.setVersionRow(historialcambioclave.getVersionRow());	
					historialcambioclaveLocal.setid_usuario(historialcambioclave.getid_usuario());	
					historialcambioclaveLocal.setnombre(historialcambioclave.getnombre());	
					historialcambioclaveLocal.setfecha_hora(historialcambioclave.getfecha_hora());	
					historialcambioclaveLocal.setobservacion(historialcambioclave.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!historialcambioclave.getIsDeleted()) {
				if(!existe) {
					historialcambioclaves.add(historialcambioclave);
				}
			} else {
				if(historialcambioclaveEncontrado!=null && permiteQuitar)  {
					historialcambioclaves.remove(historialcambioclaveEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HistorialCambioClave historialcambioclave,List<HistorialCambioClave> historialcambioclaves) throws Exception {
		try	{			
			for(HistorialCambioClave historialcambioclaveLocal:historialcambioclaves) {
				if(historialcambioclaveLocal.getId().equals(historialcambioclave.getId())) {
					historialcambioclaveLocal.setIsSelected(historialcambioclave.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialCambioClave(List<HistorialCambioClave> historialcambioclavesAux) throws Exception {
		//this.historialcambioclavesAux=historialcambioclavesAux;
		
		for(HistorialCambioClave historialcambioclaveAux:historialcambioclavesAux) {
			if(historialcambioclaveAux.getIsChanged()) {
				historialcambioclaveAux.setIsChanged(false);
			}		
			
			if(historialcambioclaveAux.getIsNew()) {
				historialcambioclaveAux.setIsNew(false);
			}	
			
			if(historialcambioclaveAux.getIsDeleted()) {
				historialcambioclaveAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialCambioClave(HistorialCambioClave historialcambioclaveAux) throws Exception {
		//this.historialcambioclaveAux=historialcambioclaveAux;
		
			if(historialcambioclaveAux.getIsChanged()) {
				historialcambioclaveAux.setIsChanged(false);
			}		
			
			if(historialcambioclaveAux.getIsNew()) {
				historialcambioclaveAux.setIsNew(false);
			}	
			
			if(historialcambioclaveAux.getIsDeleted()) {
				historialcambioclaveAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialCambioClave historialcambioclaveAsignar,HistorialCambioClave historialcambioclave) throws Exception {
		historialcambioclaveAsignar.setId(historialcambioclave.getId());	
		historialcambioclaveAsignar.setVersionRow(historialcambioclave.getVersionRow());	
		historialcambioclaveAsignar.setid_usuario(historialcambioclave.getid_usuario());
		historialcambioclaveAsignar.setusuario_descripcion(historialcambioclave.getusuario_descripcion());	
		historialcambioclaveAsignar.setnombre(historialcambioclave.getnombre());	
		historialcambioclaveAsignar.setfecha_hora(historialcambioclave.getfecha_hora());	
		historialcambioclaveAsignar.setobservacion(historialcambioclave.getobservacion());	
	}
	
	public static void inicializarHistorialCambioClave(HistorialCambioClave historialcambioclave) throws Exception {
		try {
				historialcambioclave.setId(0L);	
					
				historialcambioclave.setid_usuario(-1L);	
				historialcambioclave.setnombre("");	
				historialcambioclave.setfecha_hora(new Timestamp((new Date()).getTime()));	
				historialcambioclave.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialCambioClave(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialCambioClaveConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialCambioClaveConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialCambioClaveConstantesFunciones.LABEL_FECHAHORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialCambioClaveConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialCambioClave(String sTipo,Row row,Workbook workbook,HistorialCambioClave historialcambioclave,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialcambioclave.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialcambioclave.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialcambioclave.getfecha_hora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialcambioclave.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialCambioClave=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHistorialCambioClave() {
		return this.sFinalQueryHistorialCambioClave;
	}
	
	public void setsFinalQueryHistorialCambioClave(String sFinalQueryHistorialCambioClave) {
		this.sFinalQueryHistorialCambioClave= sFinalQueryHistorialCambioClave;
	}
	
	public Border resaltarSeleccionarHistorialCambioClave=null;
	
	public Border setResaltarSeleccionarHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialCambioClave= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialCambioClave() {
		return this.resaltarSeleccionarHistorialCambioClave;
	}
	
	public void setResaltarSeleccionarHistorialCambioClave(Border borderResaltarSeleccionarHistorialCambioClave) {
		this.resaltarSeleccionarHistorialCambioClave= borderResaltarSeleccionarHistorialCambioClave;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialCambioClave=null;
	public Boolean mostraridHistorialCambioClave=true;
	public Boolean activaridHistorialCambioClave=true;

	public Border resaltarid_usuarioHistorialCambioClave=null;
	public Boolean mostrarid_usuarioHistorialCambioClave=true;
	public Boolean activarid_usuarioHistorialCambioClave=true;
	public Boolean cargarid_usuarioHistorialCambioClave=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioHistorialCambioClave=false;//ConEventDepend=true

	public Border resaltarnombreHistorialCambioClave=null;
	public Boolean mostrarnombreHistorialCambioClave=true;
	public Boolean activarnombreHistorialCambioClave=true;

	public Border resaltarfecha_horaHistorialCambioClave=null;
	public Boolean mostrarfecha_horaHistorialCambioClave=true;
	public Boolean activarfecha_horaHistorialCambioClave=true;

	public Border resaltarobservacionHistorialCambioClave=null;
	public Boolean mostrarobservacionHistorialCambioClave=true;
	public Boolean activarobservacionHistorialCambioClave=true;

	
	

	public Border setResaltaridHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltaridHistorialCambioClave= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialCambioClave() {
		return this.resaltaridHistorialCambioClave;
	}

	public void setResaltaridHistorialCambioClave(Border borderResaltar) {
		this.resaltaridHistorialCambioClave= borderResaltar;
	}

	public Boolean getMostraridHistorialCambioClave() {
		return this.mostraridHistorialCambioClave;
	}

	public void setMostraridHistorialCambioClave(Boolean mostraridHistorialCambioClave) {
		this.mostraridHistorialCambioClave= mostraridHistorialCambioClave;
	}

	public Boolean getActivaridHistorialCambioClave() {
		return this.activaridHistorialCambioClave;
	}

	public void setActivaridHistorialCambioClave(Boolean activaridHistorialCambioClave) {
		this.activaridHistorialCambioClave= activaridHistorialCambioClave;
	}

	public Border setResaltarid_usuarioHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltarid_usuarioHistorialCambioClave= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioHistorialCambioClave() {
		return this.resaltarid_usuarioHistorialCambioClave;
	}

	public void setResaltarid_usuarioHistorialCambioClave(Border borderResaltar) {
		this.resaltarid_usuarioHistorialCambioClave= borderResaltar;
	}

	public Boolean getMostrarid_usuarioHistorialCambioClave() {
		return this.mostrarid_usuarioHistorialCambioClave;
	}

	public void setMostrarid_usuarioHistorialCambioClave(Boolean mostrarid_usuarioHistorialCambioClave) {
		this.mostrarid_usuarioHistorialCambioClave= mostrarid_usuarioHistorialCambioClave;
	}

	public Boolean getActivarid_usuarioHistorialCambioClave() {
		return this.activarid_usuarioHistorialCambioClave;
	}

	public void setActivarid_usuarioHistorialCambioClave(Boolean activarid_usuarioHistorialCambioClave) {
		this.activarid_usuarioHistorialCambioClave= activarid_usuarioHistorialCambioClave;
	}

	public Boolean getCargarid_usuarioHistorialCambioClave() {
		return this.cargarid_usuarioHistorialCambioClave;
	}

	public void setCargarid_usuarioHistorialCambioClave(Boolean cargarid_usuarioHistorialCambioClave) {
		this.cargarid_usuarioHistorialCambioClave= cargarid_usuarioHistorialCambioClave;
	}

	public Border setResaltarnombreHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltarnombreHistorialCambioClave= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreHistorialCambioClave() {
		return this.resaltarnombreHistorialCambioClave;
	}

	public void setResaltarnombreHistorialCambioClave(Border borderResaltar) {
		this.resaltarnombreHistorialCambioClave= borderResaltar;
	}

	public Boolean getMostrarnombreHistorialCambioClave() {
		return this.mostrarnombreHistorialCambioClave;
	}

	public void setMostrarnombreHistorialCambioClave(Boolean mostrarnombreHistorialCambioClave) {
		this.mostrarnombreHistorialCambioClave= mostrarnombreHistorialCambioClave;
	}

	public Boolean getActivarnombreHistorialCambioClave() {
		return this.activarnombreHistorialCambioClave;
	}

	public void setActivarnombreHistorialCambioClave(Boolean activarnombreHistorialCambioClave) {
		this.activarnombreHistorialCambioClave= activarnombreHistorialCambioClave;
	}

	public Border setResaltarfecha_horaHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltarfecha_horaHistorialCambioClave= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_horaHistorialCambioClave() {
		return this.resaltarfecha_horaHistorialCambioClave;
	}

	public void setResaltarfecha_horaHistorialCambioClave(Border borderResaltar) {
		this.resaltarfecha_horaHistorialCambioClave= borderResaltar;
	}

	public Boolean getMostrarfecha_horaHistorialCambioClave() {
		return this.mostrarfecha_horaHistorialCambioClave;
	}

	public void setMostrarfecha_horaHistorialCambioClave(Boolean mostrarfecha_horaHistorialCambioClave) {
		this.mostrarfecha_horaHistorialCambioClave= mostrarfecha_horaHistorialCambioClave;
	}

	public Boolean getActivarfecha_horaHistorialCambioClave() {
		return this.activarfecha_horaHistorialCambioClave;
	}

	public void setActivarfecha_horaHistorialCambioClave(Boolean activarfecha_horaHistorialCambioClave) {
		this.activarfecha_horaHistorialCambioClave= activarfecha_horaHistorialCambioClave;
	}

	public Border setResaltarobservacionHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialcambioclaveBeanSwingJInternalFrame.jTtoolBarHistorialCambioClave.setBorder(borderResaltar);
		
		this.resaltarobservacionHistorialCambioClave= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionHistorialCambioClave() {
		return this.resaltarobservacionHistorialCambioClave;
	}

	public void setResaltarobservacionHistorialCambioClave(Border borderResaltar) {
		this.resaltarobservacionHistorialCambioClave= borderResaltar;
	}

	public Boolean getMostrarobservacionHistorialCambioClave() {
		return this.mostrarobservacionHistorialCambioClave;
	}

	public void setMostrarobservacionHistorialCambioClave(Boolean mostrarobservacionHistorialCambioClave) {
		this.mostrarobservacionHistorialCambioClave= mostrarobservacionHistorialCambioClave;
	}

	public Boolean getActivarobservacionHistorialCambioClave() {
		return this.activarobservacionHistorialCambioClave;
	}

	public void setActivarobservacionHistorialCambioClave(Boolean activarobservacionHistorialCambioClave) {
		this.activarobservacionHistorialCambioClave= activarobservacionHistorialCambioClave;
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
		
		
		this.setMostraridHistorialCambioClave(esInicial);
		this.setMostrarid_usuarioHistorialCambioClave(esInicial);
		this.setMostrarnombreHistorialCambioClave(esInicial);
		this.setMostrarfecha_horaHistorialCambioClave(esInicial);
		this.setMostrarobservacionHistorialCambioClave(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.ID)) {
				this.setMostraridHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.FECHAHORA)) {
				this.setMostrarfecha_horaHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionHistorialCambioClave(esAsigna);
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
		
		
		this.setActivaridHistorialCambioClave(esInicial);
		this.setActivarid_usuarioHistorialCambioClave(esInicial);
		this.setActivarnombreHistorialCambioClave(esInicial);
		this.setActivarfecha_horaHistorialCambioClave(esInicial);
		this.setActivarobservacionHistorialCambioClave(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.ID)) {
				this.setActivaridHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.NOMBRE)) {
				this.setActivarnombreHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.FECHAHORA)) {
				this.setActivarfecha_horaHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionHistorialCambioClave(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialCambioClave(esInicial);
		this.setResaltarid_usuarioHistorialCambioClave(esInicial);
		this.setResaltarnombreHistorialCambioClave(esInicial);
		this.setResaltarfecha_horaHistorialCambioClave(esInicial);
		this.setResaltarobservacionHistorialCambioClave(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.ID)) {
				this.setResaltaridHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.FECHAHORA)) {
				this.setResaltarfecha_horaHistorialCambioClave(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialCambioClaveConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionHistorialCambioClave(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave=true;

	public Boolean getMostrarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave() {
		return this.mostrarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave;
	}

	public void setMostrarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioHistorialCambioClave=true;

	public Boolean getMostrarFK_IdUsuarioHistorialCambioClave() {
		return this.mostrarFK_IdUsuarioHistorialCambioClave;
	}

	public void setMostrarFK_IdUsuarioHistorialCambioClave(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioHistorialCambioClave= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave=true;

	public Boolean getActivarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave() {
		return this.activarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave;
	}

	public void setActivarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioHistorialCambioClave=true;

	public Boolean getActivarFK_IdUsuarioHistorialCambioClave() {
		return this.activarFK_IdUsuarioHistorialCambioClave;
	}

	public void setActivarFK_IdUsuarioHistorialCambioClave(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioHistorialCambioClave= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave=null;

	public Border getResaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave() {
		return this.resaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave;
	}

	public void setResaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave(Border borderResaltar) {
		this.resaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave= borderResaltar;
	}

	public void setResaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdUsuarioPorFechaHoraHistorialCambioClave= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioHistorialCambioClave=null;

	public Border getResaltarFK_IdUsuarioHistorialCambioClave() {
		return this.resaltarFK_IdUsuarioHistorialCambioClave;
	}

	public void setResaltarFK_IdUsuarioHistorialCambioClave(Border borderResaltar) {
		this.resaltarFK_IdUsuarioHistorialCambioClave= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioHistorialCambioClave(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialCambioClaveBeanSwingJInternalFrame historialcambioclaveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioHistorialCambioClave= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}