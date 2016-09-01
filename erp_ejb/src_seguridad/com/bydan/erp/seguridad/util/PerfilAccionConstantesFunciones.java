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


import com.bydan.erp.seguridad.util.PerfilAccionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilAccionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilAccionParameterGeneral;

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
final public class PerfilAccionConstantesFunciones extends PerfilAccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PerfilAccion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PerfilAccion"+PerfilAccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PerfilAccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PerfilAccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PerfilAccionConstantesFunciones.SCHEMA+"_"+PerfilAccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PerfilAccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PerfilAccionConstantesFunciones.SCHEMA+"_"+PerfilAccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PerfilAccionConstantesFunciones.SCHEMA+"_"+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PerfilAccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PerfilAccionConstantesFunciones.SCHEMA+"_"+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilAccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilAccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilAccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PerfilAccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PerfilAccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PerfilAccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PerfilAccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Perfil Acciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Perfil Accion";
	public static final String SCLASSWEBTITULO_LOWER="Perfil Accion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PerfilAccion";
	public static final String OBJECTNAME="perfilaccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="perfil_accion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select perfilaccion from "+PerfilAccionConstantesFunciones.SPERSISTENCENAME+" perfilaccion";
	public static String QUERYSELECTNATIVE="select "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".version_row,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id_perfil,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id_accion,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".ejecusion,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".estado from "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME;//+" as "+PerfilAccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PerfilAccionConstantesFuncionesAdditional perfilaccionConstantesFuncionesAdditional=null;
	
	public PerfilAccionConstantesFuncionesAdditional getPerfilAccionConstantesFuncionesAdditional() {
		return this.perfilaccionConstantesFuncionesAdditional;
	}
	
	public void setPerfilAccionConstantesFuncionesAdditional(PerfilAccionConstantesFuncionesAdditional perfilaccionConstantesFuncionesAdditional) {
		try {
			this.perfilaccionConstantesFuncionesAdditional=perfilaccionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPERFIL= "id_perfil";
    public static final String IDACCION= "id_accion";
    public static final String EJECUSION= "ejecusion";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPERFIL= "Perfil";
		public static final String LABEL_IDPERFIL_LOWER= "Perfil";
    	public static final String LABEL_IDACCION= "Accion";
		public static final String LABEL_IDACCION_LOWER= "Accion";
    	public static final String LABEL_EJECUSION= "Ejecusion";
		public static final String LABEL_EJECUSION_LOWER= "Ejecusion";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
		
	
	public static String getPerfilAccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PerfilAccionConstantesFunciones.IDPERFIL)) {sLabelColumna=PerfilAccionConstantesFunciones.LABEL_IDPERFIL;}
		if(sNombreColumna.equals(PerfilAccionConstantesFunciones.IDACCION)) {sLabelColumna=PerfilAccionConstantesFunciones.LABEL_IDACCION;}
		if(sNombreColumna.equals(PerfilAccionConstantesFunciones.EJECUSION)) {sLabelColumna=PerfilAccionConstantesFunciones.LABEL_EJECUSION;}
		if(sNombreColumna.equals(PerfilAccionConstantesFunciones.ESTADO)) {sLabelColumna=PerfilAccionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
		
	public static String getejecusionDescripcion(PerfilAccion perfilaccion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilaccion.getejecusion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getejecusionHtmlDescripcion(PerfilAccion perfilaccion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilaccion.getId(),perfilaccion.getejecusion());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(PerfilAccion perfilaccion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilaccion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(PerfilAccion perfilaccion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilaccion.getId(),perfilaccion.getestado());

		return sDescripcion;
	}	
	
	public static String getPerfilAccionDescripcion(PerfilAccion perfilaccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(perfilaccion !=null/* && perfilaccion.getId()!=0*/) {
			if(perfilaccion.getId()!=null) {
				sDescripcion=perfilaccion.getId().toString();
			}//perfilaccionperfilaccion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPerfilAccionDescripcionDetallado(PerfilAccion perfilaccion) {
		String sDescripcion="";
			
		sDescripcion+=PerfilAccionConstantesFunciones.ID+"=";
		sDescripcion+=perfilaccion.getId().toString()+",";
		sDescripcion+=PerfilAccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=perfilaccion.getVersionRow().toString()+",";
		sDescripcion+=PerfilAccionConstantesFunciones.IDPERFIL+"=";
		sDescripcion+=perfilaccion.getid_perfil().toString()+",";
		sDescripcion+=PerfilAccionConstantesFunciones.IDACCION+"=";
		sDescripcion+=perfilaccion.getid_accion().toString()+",";
		sDescripcion+=PerfilAccionConstantesFunciones.EJECUSION+"=";
		sDescripcion+=perfilaccion.getejecusion().toString()+",";
		sDescripcion+=PerfilAccionConstantesFunciones.ESTADO+"=";
		sDescripcion+=perfilaccion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPerfilAccionDescripcion(PerfilAccion perfilaccion,String sValor) throws Exception {			
		if(perfilaccion !=null) {
			//perfilaccionperfilaccion.getId().toString();
		}		
	}
	
		

	public static String getPerfilDescripcion(Perfil perfil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(perfil!=null/*&&perfil.getId()>0*/) {
			sDescripcion=PerfilConstantesFunciones.getPerfilDescripcion(perfil);
		}

		return sDescripcion;
	}

	public static String getAccionDescripcion(Accion accion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(accion!=null/*&&accion.getId()>0*/) {
			sDescripcion=AccionConstantesFunciones.getAccionDescripcion(accion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAccion")) {
			sNombreIndice="Tipo=  Por Accion";
		} else if(sNombreIndice.equals("FK_IdPerfil")) {
			sNombreIndice="Tipo=  Por Perfil";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAccion(Long id_accion) {
		String sDetalleIndice=" Parametros->";
		if(id_accion!=null) {sDetalleIndice+=" Codigo Unico De Accion="+id_accion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPerfil(Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPerfilAccion(PerfilAccion perfilaccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPerfilAccions(List<PerfilAccion> perfilaccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PerfilAccion perfilaccion: perfilaccions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilAccion(PerfilAccion perfilaccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && perfilaccion.getConCambioAuxiliar()) {
			perfilaccion.setIsDeleted(perfilaccion.getIsDeletedAuxiliar());	
			perfilaccion.setIsNew(perfilaccion.getIsNewAuxiliar());	
			perfilaccion.setIsChanged(perfilaccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			perfilaccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			perfilaccion.setIsDeletedAuxiliar(false);	
			perfilaccion.setIsNewAuxiliar(false);	
			perfilaccion.setIsChangedAuxiliar(false);
			
			perfilaccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilAccions(List<PerfilAccion> perfilaccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PerfilAccion perfilaccion : perfilaccions) {
			if(conAsignarBase && perfilaccion.getConCambioAuxiliar()) {
				perfilaccion.setIsDeleted(perfilaccion.getIsDeletedAuxiliar());	
				perfilaccion.setIsNew(perfilaccion.getIsNewAuxiliar());	
				perfilaccion.setIsChanged(perfilaccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				perfilaccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				perfilaccion.setIsDeletedAuxiliar(false);	
				perfilaccion.setIsNewAuxiliar(false);	
				perfilaccion.setIsChangedAuxiliar(false);
				
				perfilaccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPerfilAccion(PerfilAccion perfilaccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPerfilAccions(List<PerfilAccion> perfilaccions,Boolean conEnteros) throws Exception  {
		
		for(PerfilAccion perfilaccion: perfilaccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPerfilAccion(List<PerfilAccion> perfilaccions,PerfilAccion perfilaccionAux) throws Exception  {
		PerfilAccionConstantesFunciones.InicializarValoresPerfilAccion(perfilaccionAux,true);
		
		for(PerfilAccion perfilaccion: perfilaccions) {
			if(perfilaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilAccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PerfilAccionConstantesFunciones.getArrayColumnasGlobalesPerfilAccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilAccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPerfilAccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PerfilAccion> perfilaccions,PerfilAccion perfilaccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PerfilAccion perfilaccionAux: perfilaccions) {
			if(perfilaccionAux!=null && perfilaccion!=null) {
				if((perfilaccionAux.getId()==null && perfilaccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(perfilaccionAux.getId()!=null && perfilaccion.getId()!=null){
					if(perfilaccionAux.getId().equals(perfilaccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPerfilAccion(List<PerfilAccion> perfilaccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PerfilAccion perfilaccion: perfilaccions) {			
			if(perfilaccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPerfilAccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_ID, PerfilAccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_VERSIONROW, PerfilAccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_IDPERFIL, PerfilAccionConstantesFunciones.IDPERFIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_IDACCION, PerfilAccionConstantesFunciones.IDACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_EJECUSION, PerfilAccionConstantesFunciones.EJECUSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilAccionConstantesFunciones.LABEL_ESTADO, PerfilAccionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPerfilAccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.IDPERFIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.IDACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.EJECUSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilAccionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilAccion() throws Exception  {
		return PerfilAccionConstantesFunciones.getTiposSeleccionarPerfilAccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilAccion(Boolean conFk) throws Exception  {
		return PerfilAccionConstantesFunciones.getTiposSeleccionarPerfilAccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilAccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilAccionConstantesFunciones.LABEL_IDPERFIL);
			reporte.setsDescripcion(PerfilAccionConstantesFunciones.LABEL_IDPERFIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilAccionConstantesFunciones.LABEL_IDACCION);
			reporte.setsDescripcion(PerfilAccionConstantesFunciones.LABEL_IDACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilAccionConstantesFunciones.LABEL_EJECUSION);
			reporte.setsDescripcion(PerfilAccionConstantesFunciones.LABEL_EJECUSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilAccionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PerfilAccionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPerfilAccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilAccion(PerfilAccion perfilaccionAux) throws Exception {
		
			perfilaccionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilaccionAux.getPerfil()));
			perfilaccionAux.setaccion_descripcion(AccionConstantesFunciones.getAccionDescripcion(perfilaccionAux.getAccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilAccion(List<PerfilAccion> perfilaccionsTemp) throws Exception {
		for(PerfilAccion perfilaccionAux:perfilaccionsTemp) {
			
			perfilaccionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilaccionAux.getPerfil()));
			perfilaccionAux.setaccion_descripcion(AccionConstantesFunciones.getAccionDescripcion(perfilaccionAux.getAccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(Accion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Accion.class)) {
						classes.add(new Classe(Accion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPerfilAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilAccionConstantesFunciones.getClassesRelationshipsOfPerfilAccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilAccionConstantesFunciones.getClassesRelationshipsFromStringsOfPerfilAccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PerfilAccion perfilaccion,List<PerfilAccion> perfilaccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PerfilAccion perfilaccionEncontrado=null;
			
			for(PerfilAccion perfilaccionLocal:perfilaccions) {
				if(perfilaccionLocal.getId().equals(perfilaccion.getId())) {
					perfilaccionEncontrado=perfilaccionLocal;
					
					perfilaccionLocal.setIsChanged(perfilaccion.getIsChanged());
					perfilaccionLocal.setIsNew(perfilaccion.getIsNew());
					perfilaccionLocal.setIsDeleted(perfilaccion.getIsDeleted());
					
					perfilaccionLocal.setGeneralEntityOriginal(perfilaccion.getGeneralEntityOriginal());
					
					perfilaccionLocal.setId(perfilaccion.getId());	
					perfilaccionLocal.setVersionRow(perfilaccion.getVersionRow());	
					perfilaccionLocal.setid_perfil(perfilaccion.getid_perfil());	
					perfilaccionLocal.setid_accion(perfilaccion.getid_accion());	
					perfilaccionLocal.setejecusion(perfilaccion.getejecusion());	
					perfilaccionLocal.setestado(perfilaccion.getestado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!perfilaccion.getIsDeleted()) {
				if(!existe) {
					perfilaccions.add(perfilaccion);
				}
			} else {
				if(perfilaccionEncontrado!=null && permiteQuitar)  {
					perfilaccions.remove(perfilaccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PerfilAccion perfilaccion,List<PerfilAccion> perfilaccions) throws Exception {
		try	{			
			for(PerfilAccion perfilaccionLocal:perfilaccions) {
				if(perfilaccionLocal.getId().equals(perfilaccion.getId())) {
					perfilaccionLocal.setIsSelected(perfilaccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPerfilAccion(List<PerfilAccion> perfilaccionsAux) throws Exception {
		//this.perfilaccionsAux=perfilaccionsAux;
		
		for(PerfilAccion perfilaccionAux:perfilaccionsAux) {
			if(perfilaccionAux.getIsChanged()) {
				perfilaccionAux.setIsChanged(false);
			}		
			
			if(perfilaccionAux.getIsNew()) {
				perfilaccionAux.setIsNew(false);
			}	
			
			if(perfilaccionAux.getIsDeleted()) {
				perfilaccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPerfilAccion(PerfilAccion perfilaccionAux) throws Exception {
		//this.perfilaccionAux=perfilaccionAux;
		
			if(perfilaccionAux.getIsChanged()) {
				perfilaccionAux.setIsChanged(false);
			}		
			
			if(perfilaccionAux.getIsNew()) {
				perfilaccionAux.setIsNew(false);
			}	
			
			if(perfilaccionAux.getIsDeleted()) {
				perfilaccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PerfilAccion perfilaccionAsignar,PerfilAccion perfilaccion) throws Exception {
		perfilaccionAsignar.setId(perfilaccion.getId());	
		perfilaccionAsignar.setVersionRow(perfilaccion.getVersionRow());	
		perfilaccionAsignar.setid_perfil(perfilaccion.getid_perfil());
		perfilaccionAsignar.setperfil_descripcion(perfilaccion.getperfil_descripcion());	
		perfilaccionAsignar.setid_accion(perfilaccion.getid_accion());
		perfilaccionAsignar.setaccion_descripcion(perfilaccion.getaccion_descripcion());	
		perfilaccionAsignar.setejecusion(perfilaccion.getejecusion());	
		perfilaccionAsignar.setestado(perfilaccion.getestado());	
	}
	
	public static void inicializarPerfilAccion(PerfilAccion perfilaccion) throws Exception {
		try {
				perfilaccion.setId(0L);	
					
				perfilaccion.setid_perfil(-1L);	
				perfilaccion.setid_accion(-1L);	
				perfilaccion.setejecusion(false);	
				perfilaccion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPerfilAccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilAccionConstantesFunciones.LABEL_IDPERFIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilAccionConstantesFunciones.LABEL_IDACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilAccionConstantesFunciones.LABEL_EJECUSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilAccionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPerfilAccion(String sTipo,Row row,Workbook workbook,PerfilAccion perfilaccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilaccion.getperfil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilaccion.getaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilaccion.getejecusion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilaccion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPerfilAccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPerfilAccion() {
		return this.sFinalQueryPerfilAccion;
	}
	
	public void setsFinalQueryPerfilAccion(String sFinalQueryPerfilAccion) {
		this.sFinalQueryPerfilAccion= sFinalQueryPerfilAccion;
	}
	
	public Border resaltarSeleccionarPerfilAccion=null;
	
	public Border setResaltarSeleccionarPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPerfilAccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPerfilAccion() {
		return this.resaltarSeleccionarPerfilAccion;
	}
	
	public void setResaltarSeleccionarPerfilAccion(Border borderResaltarSeleccionarPerfilAccion) {
		this.resaltarSeleccionarPerfilAccion= borderResaltarSeleccionarPerfilAccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPerfilAccion=null;
	public Boolean mostraridPerfilAccion=true;
	public Boolean activaridPerfilAccion=true;

	public Border resaltarid_perfilPerfilAccion=null;
	public Boolean mostrarid_perfilPerfilAccion=true;
	public Boolean activarid_perfilPerfilAccion=true;
	public Boolean cargarid_perfilPerfilAccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_perfilPerfilAccion=false;//ConEventDepend=true

	public Border resaltarid_accionPerfilAccion=null;
	public Boolean mostrarid_accionPerfilAccion=true;
	public Boolean activarid_accionPerfilAccion=true;
	public Boolean cargarid_accionPerfilAccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_accionPerfilAccion=false;//ConEventDepend=true

	public Border resaltarejecusionPerfilAccion=null;
	public Boolean mostrarejecusionPerfilAccion=true;
	public Boolean activarejecusionPerfilAccion=true;

	public Border resaltarestadoPerfilAccion=null;
	public Boolean mostrarestadoPerfilAccion=true;
	public Boolean activarestadoPerfilAccion=true;

	
	

	public Border setResaltaridPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltaridPerfilAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPerfilAccion() {
		return this.resaltaridPerfilAccion;
	}

	public void setResaltaridPerfilAccion(Border borderResaltar) {
		this.resaltaridPerfilAccion= borderResaltar;
	}

	public Boolean getMostraridPerfilAccion() {
		return this.mostraridPerfilAccion;
	}

	public void setMostraridPerfilAccion(Boolean mostraridPerfilAccion) {
		this.mostraridPerfilAccion= mostraridPerfilAccion;
	}

	public Boolean getActivaridPerfilAccion() {
		return this.activaridPerfilAccion;
	}

	public void setActivaridPerfilAccion(Boolean activaridPerfilAccion) {
		this.activaridPerfilAccion= activaridPerfilAccion;
	}

	public Border setResaltarid_perfilPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltarid_perfilPerfilAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_perfilPerfilAccion() {
		return this.resaltarid_perfilPerfilAccion;
	}

	public void setResaltarid_perfilPerfilAccion(Border borderResaltar) {
		this.resaltarid_perfilPerfilAccion= borderResaltar;
	}

	public Boolean getMostrarid_perfilPerfilAccion() {
		return this.mostrarid_perfilPerfilAccion;
	}

	public void setMostrarid_perfilPerfilAccion(Boolean mostrarid_perfilPerfilAccion) {
		this.mostrarid_perfilPerfilAccion= mostrarid_perfilPerfilAccion;
	}

	public Boolean getActivarid_perfilPerfilAccion() {
		return this.activarid_perfilPerfilAccion;
	}

	public void setActivarid_perfilPerfilAccion(Boolean activarid_perfilPerfilAccion) {
		this.activarid_perfilPerfilAccion= activarid_perfilPerfilAccion;
	}

	public Boolean getCargarid_perfilPerfilAccion() {
		return this.cargarid_perfilPerfilAccion;
	}

	public void setCargarid_perfilPerfilAccion(Boolean cargarid_perfilPerfilAccion) {
		this.cargarid_perfilPerfilAccion= cargarid_perfilPerfilAccion;
	}

	public Border setResaltarid_accionPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltarid_accionPerfilAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_accionPerfilAccion() {
		return this.resaltarid_accionPerfilAccion;
	}

	public void setResaltarid_accionPerfilAccion(Border borderResaltar) {
		this.resaltarid_accionPerfilAccion= borderResaltar;
	}

	public Boolean getMostrarid_accionPerfilAccion() {
		return this.mostrarid_accionPerfilAccion;
	}

	public void setMostrarid_accionPerfilAccion(Boolean mostrarid_accionPerfilAccion) {
		this.mostrarid_accionPerfilAccion= mostrarid_accionPerfilAccion;
	}

	public Boolean getActivarid_accionPerfilAccion() {
		return this.activarid_accionPerfilAccion;
	}

	public void setActivarid_accionPerfilAccion(Boolean activarid_accionPerfilAccion) {
		this.activarid_accionPerfilAccion= activarid_accionPerfilAccion;
	}

	public Boolean getCargarid_accionPerfilAccion() {
		return this.cargarid_accionPerfilAccion;
	}

	public void setCargarid_accionPerfilAccion(Boolean cargarid_accionPerfilAccion) {
		this.cargarid_accionPerfilAccion= cargarid_accionPerfilAccion;
	}

	public Border setResaltarejecusionPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltarejecusionPerfilAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarejecusionPerfilAccion() {
		return this.resaltarejecusionPerfilAccion;
	}

	public void setResaltarejecusionPerfilAccion(Border borderResaltar) {
		this.resaltarejecusionPerfilAccion= borderResaltar;
	}

	public Boolean getMostrarejecusionPerfilAccion() {
		return this.mostrarejecusionPerfilAccion;
	}

	public void setMostrarejecusionPerfilAccion(Boolean mostrarejecusionPerfilAccion) {
		this.mostrarejecusionPerfilAccion= mostrarejecusionPerfilAccion;
	}

	public Boolean getActivarejecusionPerfilAccion() {
		return this.activarejecusionPerfilAccion;
	}

	public void setActivarejecusionPerfilAccion(Boolean activarejecusionPerfilAccion) {
		this.activarejecusionPerfilAccion= activarejecusionPerfilAccion;
	}

	public Border setResaltarestadoPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilaccionBeanSwingJInternalFrame.jTtoolBarPerfilAccion.setBorder(borderResaltar);
		
		this.resaltarestadoPerfilAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPerfilAccion() {
		return this.resaltarestadoPerfilAccion;
	}

	public void setResaltarestadoPerfilAccion(Border borderResaltar) {
		this.resaltarestadoPerfilAccion= borderResaltar;
	}

	public Boolean getMostrarestadoPerfilAccion() {
		return this.mostrarestadoPerfilAccion;
	}

	public void setMostrarestadoPerfilAccion(Boolean mostrarestadoPerfilAccion) {
		this.mostrarestadoPerfilAccion= mostrarestadoPerfilAccion;
	}

	public Boolean getActivarestadoPerfilAccion() {
		return this.activarestadoPerfilAccion;
	}

	public void setActivarestadoPerfilAccion(Boolean activarestadoPerfilAccion) {
		this.activarestadoPerfilAccion= activarestadoPerfilAccion;
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
		
		
		this.setMostraridPerfilAccion(esInicial);
		this.setMostrarid_perfilPerfilAccion(esInicial);
		this.setMostrarid_accionPerfilAccion(esInicial);
		this.setMostrarejecusionPerfilAccion(esInicial);
		this.setMostrarestadoPerfilAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ID)) {
				this.setMostraridPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDPERFIL)) {
				this.setMostrarid_perfilPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDACCION)) {
				this.setMostrarid_accionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.EJECUSION)) {
				this.setMostrarejecusionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPerfilAccion(esAsigna);
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
		
		
		this.setActivaridPerfilAccion(esInicial);
		this.setActivarid_perfilPerfilAccion(esInicial);
		this.setActivarid_accionPerfilAccion(esInicial);
		this.setActivarejecusionPerfilAccion(esInicial);
		this.setActivarestadoPerfilAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ID)) {
				this.setActivaridPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDPERFIL)) {
				this.setActivarid_perfilPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDACCION)) {
				this.setActivarid_accionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.EJECUSION)) {
				this.setActivarejecusionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ESTADO)) {
				this.setActivarestadoPerfilAccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPerfilAccion(esInicial);
		this.setResaltarid_perfilPerfilAccion(esInicial);
		this.setResaltarid_accionPerfilAccion(esInicial);
		this.setResaltarejecusionPerfilAccion(esInicial);
		this.setResaltarestadoPerfilAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ID)) {
				this.setResaltaridPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDPERFIL)) {
				this.setResaltarid_perfilPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.IDACCION)) {
				this.setResaltarid_accionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.EJECUSION)) {
				this.setResaltarejecusionPerfilAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilAccionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPerfilAccion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAccionPerfilAccion=true;

	public Boolean getMostrarFK_IdAccionPerfilAccion() {
		return this.mostrarFK_IdAccionPerfilAccion;
	}

	public void setMostrarFK_IdAccionPerfilAccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAccionPerfilAccion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPerfilPerfilAccion=true;

	public Boolean getMostrarFK_IdPerfilPerfilAccion() {
		return this.mostrarFK_IdPerfilPerfilAccion;
	}

	public void setMostrarFK_IdPerfilPerfilAccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPerfilPerfilAccion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAccionPerfilAccion=true;

	public Boolean getActivarFK_IdAccionPerfilAccion() {
		return this.activarFK_IdAccionPerfilAccion;
	}

	public void setActivarFK_IdAccionPerfilAccion(Boolean habilitarResaltar) {
		this.activarFK_IdAccionPerfilAccion= habilitarResaltar;
	}

	public Boolean activarFK_IdPerfilPerfilAccion=true;

	public Boolean getActivarFK_IdPerfilPerfilAccion() {
		return this.activarFK_IdPerfilPerfilAccion;
	}

	public void setActivarFK_IdPerfilPerfilAccion(Boolean habilitarResaltar) {
		this.activarFK_IdPerfilPerfilAccion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAccionPerfilAccion=null;

	public Border getResaltarFK_IdAccionPerfilAccion() {
		return this.resaltarFK_IdAccionPerfilAccion;
	}

	public void setResaltarFK_IdAccionPerfilAccion(Border borderResaltar) {
		this.resaltarFK_IdAccionPerfilAccion= borderResaltar;
	}

	public void setResaltarFK_IdAccionPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAccionPerfilAccion= borderResaltar;
	}

	public Border resaltarFK_IdPerfilPerfilAccion=null;

	public Border getResaltarFK_IdPerfilPerfilAccion() {
		return this.resaltarFK_IdPerfilPerfilAccion;
	}

	public void setResaltarFK_IdPerfilPerfilAccion(Border borderResaltar) {
		this.resaltarFK_IdPerfilPerfilAccion= borderResaltar;
	}

	public void setResaltarFK_IdPerfilPerfilAccion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilAccionBeanSwingJInternalFrame perfilaccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPerfilPerfilAccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}