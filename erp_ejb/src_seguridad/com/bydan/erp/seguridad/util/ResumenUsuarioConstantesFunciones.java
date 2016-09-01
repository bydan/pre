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


import com.bydan.erp.seguridad.util.ResumenUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.ResumenUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ResumenUsuarioParameterGeneral;

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
final public class ResumenUsuarioConstantesFunciones extends ResumenUsuarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ResumenUsuario";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ResumenUsuario"+ResumenUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResumenUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResumenUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResumenUsuarioConstantesFunciones.SCHEMA+"_"+ResumenUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResumenUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResumenUsuarioConstantesFunciones.SCHEMA+"_"+ResumenUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResumenUsuarioConstantesFunciones.SCHEMA+"_"+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResumenUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResumenUsuarioConstantesFunciones.SCHEMA+"_"+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResumenUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResumenUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResumenUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResumenUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResumenUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResumenUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResumenUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Resumen Usuarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Resumen Usuario";
	public static final String SCLASSWEBTITULO_LOWER="Resumen Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ResumenUsuario";
	public static final String OBJECTNAME="resumenusuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="resumen_usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select resumenusuario from "+ResumenUsuarioConstantesFunciones.SPERSISTENCENAME+" resumenusuario";
	public static String QUERYSELECTNATIVE="select "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".id,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".version_row,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_ingresos,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_error_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_intentos,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_cierres,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_reinicios,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_ingreso_actual,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_error_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_intento,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_cierre from "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME;//+" as "+ResumenUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ResumenUsuarioConstantesFuncionesAdditional resumenusuarioConstantesFuncionesAdditional=null;
	
	public ResumenUsuarioConstantesFuncionesAdditional getResumenUsuarioConstantesFuncionesAdditional() {
		return this.resumenusuarioConstantesFuncionesAdditional;
	}
	
	public void setResumenUsuarioConstantesFuncionesAdditional(ResumenUsuarioConstantesFuncionesAdditional resumenusuarioConstantesFuncionesAdditional) {
		try {
			this.resumenusuarioConstantesFuncionesAdditional=resumenusuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDUSUARIO= "id_usuario";
    public static final String NUMEROINGRESOS= "numero_ingresos";
    public static final String NUMEROERRORINGRESO= "numero_error_ingreso";
    public static final String NUMEROINTENTOS= "numero_intentos";
    public static final String NUMEROCIERRES= "numero_cierres";
    public static final String NUMEROREINICIOS= "numero_reinicios";
    public static final String NUMEROINGRESOACTUAL= "numero_ingreso_actual";
    public static final String FECHAULTIMOINGRESO= "fecha_ultimo_ingreso";
    public static final String FECHAULTIMOERRORINGRESO= "fecha_ultimo_error_ingreso";
    public static final String FECHAULTIMOINTENTO= "fecha_ultimo_intento";
    public static final String FECHAULTIMOCIERRE= "fecha_ultimo_cierre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NUMEROINGRESOS= "Numero Ingresos";
		public static final String LABEL_NUMEROINGRESOS_LOWER= "Numero Ingresos";
    	public static final String LABEL_NUMEROERRORINGRESO= "Numero Error Ingreso";
		public static final String LABEL_NUMEROERRORINGRESO_LOWER= "Numero Error Ingreso";
    	public static final String LABEL_NUMEROINTENTOS= "Numero Intentos";
		public static final String LABEL_NUMEROINTENTOS_LOWER= "Numero Intentos";
    	public static final String LABEL_NUMEROCIERRES= "Numero Cierres";
		public static final String LABEL_NUMEROCIERRES_LOWER= "Numero Cierres";
    	public static final String LABEL_NUMEROREINICIOS= "Numero Reinicios";
		public static final String LABEL_NUMEROREINICIOS_LOWER= "Numero Reinicios";
    	public static final String LABEL_NUMEROINGRESOACTUAL= "Numero Ingreso Actual";
		public static final String LABEL_NUMEROINGRESOACTUAL_LOWER= "Numero Ingreso Actual";
    	public static final String LABEL_FECHAULTIMOINGRESO= "Fecha Ultimo Ingreso";
		public static final String LABEL_FECHAULTIMOINGRESO_LOWER= "Fecha Ultimo Ingreso";
    	public static final String LABEL_FECHAULTIMOERRORINGRESO= "Fecha Ultimo Error Ingreso";
		public static final String LABEL_FECHAULTIMOERRORINGRESO_LOWER= "Fecha Ultimo Error Ingreso";
    	public static final String LABEL_FECHAULTIMOINTENTO= "Fecha Ultimo Intento";
		public static final String LABEL_FECHAULTIMOINTENTO_LOWER= "Fecha Ultimo Intento";
    	public static final String LABEL_FECHAULTIMOCIERRE= "Fecha Ultimo Cierre";
		public static final String LABEL_FECHAULTIMOCIERRE_LOWER= "Fecha Ultimo Cierre";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getResumenUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOS)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOS;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROERRORINGRESO;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROINTENTOS)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROINTENTOS;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROCIERRES)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROCIERRES;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROREINICIOS)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROREINICIOS;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOACTUAL;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINGRESO;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOERRORINGRESO;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINTENTO;}
		if(sNombreColumna.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE)) {sLabelColumna=ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOCIERRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getResumenUsuarioDescripcion(ResumenUsuario resumenusuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(resumenusuario !=null/* && resumenusuario.getId()!=0*/) {
			if(resumenusuario.getId()!=null) {
				sDescripcion=resumenusuario.getId().toString();
			}//resumenusuarioresumenusuario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getResumenUsuarioDescripcionDetallado(ResumenUsuario resumenusuario) {
		String sDescripcion="";
			
		sDescripcion+=ResumenUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=resumenusuario.getId().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=resumenusuario.getVersionRow().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=resumenusuario.getid_usuario().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROINGRESOS+"=";
		sDescripcion+=resumenusuario.getnumero_ingresos().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO+"=";
		sDescripcion+=resumenusuario.getnumero_error_ingreso().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROINTENTOS+"=";
		sDescripcion+=resumenusuario.getnumero_intentos().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROCIERRES+"=";
		sDescripcion+=resumenusuario.getnumero_cierres().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROREINICIOS+"=";
		sDescripcion+=resumenusuario.getnumero_reinicios().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL+"=";
		sDescripcion+=resumenusuario.getnumero_ingreso_actual().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO+"=";
		sDescripcion+=resumenusuario.getfecha_ultimo_ingreso().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO+"=";
		sDescripcion+=resumenusuario.getfecha_ultimo_error_ingreso().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO+"=";
		sDescripcion+=resumenusuario.getfecha_ultimo_intento().toString()+",";
		sDescripcion+=ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE+"=";
		sDescripcion+=resumenusuario.getfecha_ultimo_cierre().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setResumenUsuarioDescripcion(ResumenUsuario resumenusuario,String sValor) throws Exception {			
		if(resumenusuario !=null) {
			//resumenusuarioresumenusuario.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosResumenUsuario(ResumenUsuario resumenusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosResumenUsuarios(List<ResumenUsuario> resumenusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResumenUsuario resumenusuario: resumenusuarios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResumenUsuario(ResumenUsuario resumenusuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && resumenusuario.getConCambioAuxiliar()) {
			resumenusuario.setIsDeleted(resumenusuario.getIsDeletedAuxiliar());	
			resumenusuario.setIsNew(resumenusuario.getIsNewAuxiliar());	
			resumenusuario.setIsChanged(resumenusuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			resumenusuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			resumenusuario.setIsDeletedAuxiliar(false);	
			resumenusuario.setIsNewAuxiliar(false);	
			resumenusuario.setIsChangedAuxiliar(false);
			
			resumenusuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResumenUsuarios(List<ResumenUsuario> resumenusuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ResumenUsuario resumenusuario : resumenusuarios) {
			if(conAsignarBase && resumenusuario.getConCambioAuxiliar()) {
				resumenusuario.setIsDeleted(resumenusuario.getIsDeletedAuxiliar());	
				resumenusuario.setIsNew(resumenusuario.getIsNewAuxiliar());	
				resumenusuario.setIsChanged(resumenusuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				resumenusuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				resumenusuario.setIsDeletedAuxiliar(false);	
				resumenusuario.setIsNewAuxiliar(false);	
				resumenusuario.setIsChangedAuxiliar(false);
				
				resumenusuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResumenUsuario(ResumenUsuario resumenusuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			resumenusuario.setnumero_ingresos(0L);
			resumenusuario.setnumero_error_ingreso(0L);
			resumenusuario.setnumero_intentos(0L);
			resumenusuario.setnumero_cierres(0L);
			resumenusuario.setnumero_reinicios(0L);
			resumenusuario.setnumero_ingreso_actual(0L);
		}
	}		
	
	public static void InicializarValoresResumenUsuarios(List<ResumenUsuario> resumenusuarios,Boolean conEnteros) throws Exception  {
		
		for(ResumenUsuario resumenusuario: resumenusuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				resumenusuario.setnumero_ingresos(0L);
				resumenusuario.setnumero_error_ingreso(0L);
				resumenusuario.setnumero_intentos(0L);
				resumenusuario.setnumero_cierres(0L);
				resumenusuario.setnumero_reinicios(0L);
				resumenusuario.setnumero_ingreso_actual(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaResumenUsuario(List<ResumenUsuario> resumenusuarios,ResumenUsuario resumenusuarioAux) throws Exception  {
		ResumenUsuarioConstantesFunciones.InicializarValoresResumenUsuario(resumenusuarioAux,true);
		
		for(ResumenUsuario resumenusuario: resumenusuarios) {
			if(resumenusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			resumenusuarioAux.setnumero_ingresos(resumenusuarioAux.getnumero_ingresos()+resumenusuario.getnumero_ingresos());			
			resumenusuarioAux.setnumero_error_ingreso(resumenusuarioAux.getnumero_error_ingreso()+resumenusuario.getnumero_error_ingreso());			
			resumenusuarioAux.setnumero_intentos(resumenusuarioAux.getnumero_intentos()+resumenusuario.getnumero_intentos());			
			resumenusuarioAux.setnumero_cierres(resumenusuarioAux.getnumero_cierres()+resumenusuario.getnumero_cierres());			
			resumenusuarioAux.setnumero_reinicios(resumenusuarioAux.getnumero_reinicios()+resumenusuario.getnumero_reinicios());			
			resumenusuarioAux.setnumero_ingreso_actual(resumenusuarioAux.getnumero_ingreso_actual()+resumenusuario.getnumero_ingreso_actual());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResumenUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResumenUsuarioConstantesFunciones.getArrayColumnasGlobalesResumenUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResumenUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResumenUsuarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResumenUsuarioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResumenUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResumenUsuario> resumenusuarios,ResumenUsuario resumenusuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResumenUsuario resumenusuarioAux: resumenusuarios) {
			if(resumenusuarioAux!=null && resumenusuario!=null) {
				if((resumenusuarioAux.getId()==null && resumenusuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(resumenusuarioAux.getId()!=null && resumenusuario.getId()!=null){
					if(resumenusuarioAux.getId().equals(resumenusuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResumenUsuario(List<ResumenUsuario> resumenusuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ResumenUsuario resumenusuario: resumenusuarios) {			
			if(resumenusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResumenUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_ID, ResumenUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_VERSIONROW, ResumenUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_IDUSUARIO, ResumenUsuarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOS, ResumenUsuarioConstantesFunciones.NUMEROINGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROERRORINGRESO, ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROINTENTOS, ResumenUsuarioConstantesFunciones.NUMEROINTENTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROCIERRES, ResumenUsuarioConstantesFunciones.NUMEROCIERRES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROREINICIOS, ResumenUsuarioConstantesFunciones.NUMEROREINICIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOACTUAL, ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINGRESO, ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOERRORINGRESO, ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINTENTO, ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOCIERRE, ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResumenUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROINGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROINTENTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROCIERRES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROREINICIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenUsuario() throws Exception  {
		return ResumenUsuarioConstantesFunciones.getTiposSeleccionarResumenUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenUsuario(Boolean conFk) throws Exception  {
		return ResumenUsuarioConstantesFunciones.getTiposSeleccionarResumenUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResumenUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOS);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROERRORINGRESO);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROERRORINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINTENTOS);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINTENTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROCIERRES);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROCIERRES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROREINICIOS);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROREINICIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOACTUAL);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINGRESO);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOERRORINGRESO);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOERRORINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINTENTO);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINTENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOCIERRE);
			reporte.setsDescripcion(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOCIERRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResumenUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResumenUsuario(ResumenUsuario resumenusuarioAux) throws Exception {
		
			resumenusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(resumenusuarioAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResumenUsuario(List<ResumenUsuario> resumenusuariosTemp) throws Exception {
		for(ResumenUsuario resumenusuarioAux:resumenusuariosTemp) {
			
			resumenusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(resumenusuarioAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResumenUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResumenUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResumenUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResumenUsuarioConstantesFunciones.getClassesRelationshipsOfResumenUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResumenUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResumenUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResumenUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfResumenUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResumenUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ResumenUsuario resumenusuario,List<ResumenUsuario> resumenusuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ResumenUsuario resumenusuarioEncontrado=null;
			
			for(ResumenUsuario resumenusuarioLocal:resumenusuarios) {
				if(resumenusuarioLocal.getId().equals(resumenusuario.getId())) {
					resumenusuarioEncontrado=resumenusuarioLocal;
					
					resumenusuarioLocal.setIsChanged(resumenusuario.getIsChanged());
					resumenusuarioLocal.setIsNew(resumenusuario.getIsNew());
					resumenusuarioLocal.setIsDeleted(resumenusuario.getIsDeleted());
					
					resumenusuarioLocal.setGeneralEntityOriginal(resumenusuario.getGeneralEntityOriginal());
					
					resumenusuarioLocal.setId(resumenusuario.getId());	
					resumenusuarioLocal.setVersionRow(resumenusuario.getVersionRow());	
					resumenusuarioLocal.setid_usuario(resumenusuario.getid_usuario());	
					resumenusuarioLocal.setnumero_ingresos(resumenusuario.getnumero_ingresos());	
					resumenusuarioLocal.setnumero_error_ingreso(resumenusuario.getnumero_error_ingreso());	
					resumenusuarioLocal.setnumero_intentos(resumenusuario.getnumero_intentos());	
					resumenusuarioLocal.setnumero_cierres(resumenusuario.getnumero_cierres());	
					resumenusuarioLocal.setnumero_reinicios(resumenusuario.getnumero_reinicios());	
					resumenusuarioLocal.setnumero_ingreso_actual(resumenusuario.getnumero_ingreso_actual());	
					resumenusuarioLocal.setfecha_ultimo_ingreso(resumenusuario.getfecha_ultimo_ingreso());	
					resumenusuarioLocal.setfecha_ultimo_error_ingreso(resumenusuario.getfecha_ultimo_error_ingreso());	
					resumenusuarioLocal.setfecha_ultimo_intento(resumenusuario.getfecha_ultimo_intento());	
					resumenusuarioLocal.setfecha_ultimo_cierre(resumenusuario.getfecha_ultimo_cierre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!resumenusuario.getIsDeleted()) {
				if(!existe) {
					resumenusuarios.add(resumenusuario);
				}
			} else {
				if(resumenusuarioEncontrado!=null && permiteQuitar)  {
					resumenusuarios.remove(resumenusuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ResumenUsuario resumenusuario,List<ResumenUsuario> resumenusuarios) throws Exception {
		try	{			
			for(ResumenUsuario resumenusuarioLocal:resumenusuarios) {
				if(resumenusuarioLocal.getId().equals(resumenusuario.getId())) {
					resumenusuarioLocal.setIsSelected(resumenusuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResumenUsuario(List<ResumenUsuario> resumenusuariosAux) throws Exception {
		//this.resumenusuariosAux=resumenusuariosAux;
		
		for(ResumenUsuario resumenusuarioAux:resumenusuariosAux) {
			if(resumenusuarioAux.getIsChanged()) {
				resumenusuarioAux.setIsChanged(false);
			}		
			
			if(resumenusuarioAux.getIsNew()) {
				resumenusuarioAux.setIsNew(false);
			}	
			
			if(resumenusuarioAux.getIsDeleted()) {
				resumenusuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResumenUsuario(ResumenUsuario resumenusuarioAux) throws Exception {
		//this.resumenusuarioAux=resumenusuarioAux;
		
			if(resumenusuarioAux.getIsChanged()) {
				resumenusuarioAux.setIsChanged(false);
			}		
			
			if(resumenusuarioAux.getIsNew()) {
				resumenusuarioAux.setIsNew(false);
			}	
			
			if(resumenusuarioAux.getIsDeleted()) {
				resumenusuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ResumenUsuario resumenusuarioAsignar,ResumenUsuario resumenusuario) throws Exception {
		resumenusuarioAsignar.setId(resumenusuario.getId());	
		resumenusuarioAsignar.setVersionRow(resumenusuario.getVersionRow());	
		resumenusuarioAsignar.setid_usuario(resumenusuario.getid_usuario());
		resumenusuarioAsignar.setusuario_descripcion(resumenusuario.getusuario_descripcion());	
		resumenusuarioAsignar.setnumero_ingresos(resumenusuario.getnumero_ingresos());	
		resumenusuarioAsignar.setnumero_error_ingreso(resumenusuario.getnumero_error_ingreso());	
		resumenusuarioAsignar.setnumero_intentos(resumenusuario.getnumero_intentos());	
		resumenusuarioAsignar.setnumero_cierres(resumenusuario.getnumero_cierres());	
		resumenusuarioAsignar.setnumero_reinicios(resumenusuario.getnumero_reinicios());	
		resumenusuarioAsignar.setnumero_ingreso_actual(resumenusuario.getnumero_ingreso_actual());	
		resumenusuarioAsignar.setfecha_ultimo_ingreso(resumenusuario.getfecha_ultimo_ingreso());	
		resumenusuarioAsignar.setfecha_ultimo_error_ingreso(resumenusuario.getfecha_ultimo_error_ingreso());	
		resumenusuarioAsignar.setfecha_ultimo_intento(resumenusuario.getfecha_ultimo_intento());	
		resumenusuarioAsignar.setfecha_ultimo_cierre(resumenusuario.getfecha_ultimo_cierre());	
	}
	
	public static void inicializarResumenUsuario(ResumenUsuario resumenusuario) throws Exception {
		try {
				resumenusuario.setId(0L);	
					
				resumenusuario.setid_usuario(-1L);	
				resumenusuario.setnumero_ingresos(0L);	
				resumenusuario.setnumero_error_ingreso(0L);	
				resumenusuario.setnumero_intentos(0L);	
				resumenusuario.setnumero_cierres(0L);	
				resumenusuario.setnumero_reinicios(0L);	
				resumenusuario.setnumero_ingreso_actual(0L);	
				resumenusuario.setfecha_ultimo_ingreso(new Date());	
				resumenusuario.setfecha_ultimo_error_ingreso(new Date());	
				resumenusuario.setfecha_ultimo_intento(new Date());	
				resumenusuario.setfecha_ultimo_cierre(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResumenUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROERRORINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINTENTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROCIERRES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROREINICIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_NUMEROINGRESOACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOERRORINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOINTENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResumenUsuarioConstantesFunciones.LABEL_FECHAULTIMOCIERRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResumenUsuario(String sTipo,Row row,Workbook workbook,ResumenUsuario resumenusuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_ingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_error_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_intentos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_cierres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_reinicios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getnumero_ingreso_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getfecha_ultimo_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getfecha_ultimo_error_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getfecha_ultimo_intento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(resumenusuario.getfecha_ultimo_cierre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResumenUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryResumenUsuario() {
		return this.sFinalQueryResumenUsuario;
	}
	
	public void setsFinalQueryResumenUsuario(String sFinalQueryResumenUsuario) {
		this.sFinalQueryResumenUsuario= sFinalQueryResumenUsuario;
	}
	
	public Border resaltarSeleccionarResumenUsuario=null;
	
	public Border setResaltarSeleccionarResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResumenUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResumenUsuario() {
		return this.resaltarSeleccionarResumenUsuario;
	}
	
	public void setResaltarSeleccionarResumenUsuario(Border borderResaltarSeleccionarResumenUsuario) {
		this.resaltarSeleccionarResumenUsuario= borderResaltarSeleccionarResumenUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResumenUsuario=null;
	public Boolean mostraridResumenUsuario=true;
	public Boolean activaridResumenUsuario=true;

	public Border resaltarid_usuarioResumenUsuario=null;
	public Boolean mostrarid_usuarioResumenUsuario=true;
	public Boolean activarid_usuarioResumenUsuario=true;
	public Boolean cargarid_usuarioResumenUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioResumenUsuario=false;//ConEventDepend=true

	public Border resaltarnumero_ingresosResumenUsuario=null;
	public Boolean mostrarnumero_ingresosResumenUsuario=true;
	public Boolean activarnumero_ingresosResumenUsuario=true;

	public Border resaltarnumero_error_ingresoResumenUsuario=null;
	public Boolean mostrarnumero_error_ingresoResumenUsuario=true;
	public Boolean activarnumero_error_ingresoResumenUsuario=true;

	public Border resaltarnumero_intentosResumenUsuario=null;
	public Boolean mostrarnumero_intentosResumenUsuario=true;
	public Boolean activarnumero_intentosResumenUsuario=true;

	public Border resaltarnumero_cierresResumenUsuario=null;
	public Boolean mostrarnumero_cierresResumenUsuario=true;
	public Boolean activarnumero_cierresResumenUsuario=true;

	public Border resaltarnumero_reiniciosResumenUsuario=null;
	public Boolean mostrarnumero_reiniciosResumenUsuario=true;
	public Boolean activarnumero_reiniciosResumenUsuario=true;

	public Border resaltarnumero_ingreso_actualResumenUsuario=null;
	public Boolean mostrarnumero_ingreso_actualResumenUsuario=true;
	public Boolean activarnumero_ingreso_actualResumenUsuario=true;

	public Border resaltarfecha_ultimo_ingresoResumenUsuario=null;
	public Boolean mostrarfecha_ultimo_ingresoResumenUsuario=true;
	public Boolean activarfecha_ultimo_ingresoResumenUsuario=false;

	public Border resaltarfecha_ultimo_error_ingresoResumenUsuario=null;
	public Boolean mostrarfecha_ultimo_error_ingresoResumenUsuario=true;
	public Boolean activarfecha_ultimo_error_ingresoResumenUsuario=false;

	public Border resaltarfecha_ultimo_intentoResumenUsuario=null;
	public Boolean mostrarfecha_ultimo_intentoResumenUsuario=true;
	public Boolean activarfecha_ultimo_intentoResumenUsuario=false;

	public Border resaltarfecha_ultimo_cierreResumenUsuario=null;
	public Boolean mostrarfecha_ultimo_cierreResumenUsuario=true;
	public Boolean activarfecha_ultimo_cierreResumenUsuario=false;

	
	

	public Border setResaltaridResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltaridResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResumenUsuario() {
		return this.resaltaridResumenUsuario;
	}

	public void setResaltaridResumenUsuario(Border borderResaltar) {
		this.resaltaridResumenUsuario= borderResaltar;
	}

	public Boolean getMostraridResumenUsuario() {
		return this.mostraridResumenUsuario;
	}

	public void setMostraridResumenUsuario(Boolean mostraridResumenUsuario) {
		this.mostraridResumenUsuario= mostraridResumenUsuario;
	}

	public Boolean getActivaridResumenUsuario() {
		return this.activaridResumenUsuario;
	}

	public void setActivaridResumenUsuario(Boolean activaridResumenUsuario) {
		this.activaridResumenUsuario= activaridResumenUsuario;
	}

	public Border setResaltarid_usuarioResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioResumenUsuario() {
		return this.resaltarid_usuarioResumenUsuario;
	}

	public void setResaltarid_usuarioResumenUsuario(Border borderResaltar) {
		this.resaltarid_usuarioResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioResumenUsuario() {
		return this.mostrarid_usuarioResumenUsuario;
	}

	public void setMostrarid_usuarioResumenUsuario(Boolean mostrarid_usuarioResumenUsuario) {
		this.mostrarid_usuarioResumenUsuario= mostrarid_usuarioResumenUsuario;
	}

	public Boolean getActivarid_usuarioResumenUsuario() {
		return this.activarid_usuarioResumenUsuario;
	}

	public void setActivarid_usuarioResumenUsuario(Boolean activarid_usuarioResumenUsuario) {
		this.activarid_usuarioResumenUsuario= activarid_usuarioResumenUsuario;
	}

	public Boolean getCargarid_usuarioResumenUsuario() {
		return this.cargarid_usuarioResumenUsuario;
	}

	public void setCargarid_usuarioResumenUsuario(Boolean cargarid_usuarioResumenUsuario) {
		this.cargarid_usuarioResumenUsuario= cargarid_usuarioResumenUsuario;
	}

	public Border setResaltarnumero_ingresosResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_ingresosResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_ingresosResumenUsuario() {
		return this.resaltarnumero_ingresosResumenUsuario;
	}

	public void setResaltarnumero_ingresosResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_ingresosResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_ingresosResumenUsuario() {
		return this.mostrarnumero_ingresosResumenUsuario;
	}

	public void setMostrarnumero_ingresosResumenUsuario(Boolean mostrarnumero_ingresosResumenUsuario) {
		this.mostrarnumero_ingresosResumenUsuario= mostrarnumero_ingresosResumenUsuario;
	}

	public Boolean getActivarnumero_ingresosResumenUsuario() {
		return this.activarnumero_ingresosResumenUsuario;
	}

	public void setActivarnumero_ingresosResumenUsuario(Boolean activarnumero_ingresosResumenUsuario) {
		this.activarnumero_ingresosResumenUsuario= activarnumero_ingresosResumenUsuario;
	}

	public Border setResaltarnumero_error_ingresoResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_error_ingresoResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_error_ingresoResumenUsuario() {
		return this.resaltarnumero_error_ingresoResumenUsuario;
	}

	public void setResaltarnumero_error_ingresoResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_error_ingresoResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_error_ingresoResumenUsuario() {
		return this.mostrarnumero_error_ingresoResumenUsuario;
	}

	public void setMostrarnumero_error_ingresoResumenUsuario(Boolean mostrarnumero_error_ingresoResumenUsuario) {
		this.mostrarnumero_error_ingresoResumenUsuario= mostrarnumero_error_ingresoResumenUsuario;
	}

	public Boolean getActivarnumero_error_ingresoResumenUsuario() {
		return this.activarnumero_error_ingresoResumenUsuario;
	}

	public void setActivarnumero_error_ingresoResumenUsuario(Boolean activarnumero_error_ingresoResumenUsuario) {
		this.activarnumero_error_ingresoResumenUsuario= activarnumero_error_ingresoResumenUsuario;
	}

	public Border setResaltarnumero_intentosResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_intentosResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_intentosResumenUsuario() {
		return this.resaltarnumero_intentosResumenUsuario;
	}

	public void setResaltarnumero_intentosResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_intentosResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_intentosResumenUsuario() {
		return this.mostrarnumero_intentosResumenUsuario;
	}

	public void setMostrarnumero_intentosResumenUsuario(Boolean mostrarnumero_intentosResumenUsuario) {
		this.mostrarnumero_intentosResumenUsuario= mostrarnumero_intentosResumenUsuario;
	}

	public Boolean getActivarnumero_intentosResumenUsuario() {
		return this.activarnumero_intentosResumenUsuario;
	}

	public void setActivarnumero_intentosResumenUsuario(Boolean activarnumero_intentosResumenUsuario) {
		this.activarnumero_intentosResumenUsuario= activarnumero_intentosResumenUsuario;
	}

	public Border setResaltarnumero_cierresResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_cierresResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cierresResumenUsuario() {
		return this.resaltarnumero_cierresResumenUsuario;
	}

	public void setResaltarnumero_cierresResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_cierresResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_cierresResumenUsuario() {
		return this.mostrarnumero_cierresResumenUsuario;
	}

	public void setMostrarnumero_cierresResumenUsuario(Boolean mostrarnumero_cierresResumenUsuario) {
		this.mostrarnumero_cierresResumenUsuario= mostrarnumero_cierresResumenUsuario;
	}

	public Boolean getActivarnumero_cierresResumenUsuario() {
		return this.activarnumero_cierresResumenUsuario;
	}

	public void setActivarnumero_cierresResumenUsuario(Boolean activarnumero_cierresResumenUsuario) {
		this.activarnumero_cierresResumenUsuario= activarnumero_cierresResumenUsuario;
	}

	public Border setResaltarnumero_reiniciosResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_reiniciosResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_reiniciosResumenUsuario() {
		return this.resaltarnumero_reiniciosResumenUsuario;
	}

	public void setResaltarnumero_reiniciosResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_reiniciosResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_reiniciosResumenUsuario() {
		return this.mostrarnumero_reiniciosResumenUsuario;
	}

	public void setMostrarnumero_reiniciosResumenUsuario(Boolean mostrarnumero_reiniciosResumenUsuario) {
		this.mostrarnumero_reiniciosResumenUsuario= mostrarnumero_reiniciosResumenUsuario;
	}

	public Boolean getActivarnumero_reiniciosResumenUsuario() {
		return this.activarnumero_reiniciosResumenUsuario;
	}

	public void setActivarnumero_reiniciosResumenUsuario(Boolean activarnumero_reiniciosResumenUsuario) {
		this.activarnumero_reiniciosResumenUsuario= activarnumero_reiniciosResumenUsuario;
	}

	public Border setResaltarnumero_ingreso_actualResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarnumero_ingreso_actualResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_ingreso_actualResumenUsuario() {
		return this.resaltarnumero_ingreso_actualResumenUsuario;
	}

	public void setResaltarnumero_ingreso_actualResumenUsuario(Border borderResaltar) {
		this.resaltarnumero_ingreso_actualResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarnumero_ingreso_actualResumenUsuario() {
		return this.mostrarnumero_ingreso_actualResumenUsuario;
	}

	public void setMostrarnumero_ingreso_actualResumenUsuario(Boolean mostrarnumero_ingreso_actualResumenUsuario) {
		this.mostrarnumero_ingreso_actualResumenUsuario= mostrarnumero_ingreso_actualResumenUsuario;
	}

	public Boolean getActivarnumero_ingreso_actualResumenUsuario() {
		return this.activarnumero_ingreso_actualResumenUsuario;
	}

	public void setActivarnumero_ingreso_actualResumenUsuario(Boolean activarnumero_ingreso_actualResumenUsuario) {
		this.activarnumero_ingreso_actualResumenUsuario= activarnumero_ingreso_actualResumenUsuario;
	}

	public Border setResaltarfecha_ultimo_ingresoResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_ingresoResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_ingresoResumenUsuario() {
		return this.resaltarfecha_ultimo_ingresoResumenUsuario;
	}

	public void setResaltarfecha_ultimo_ingresoResumenUsuario(Border borderResaltar) {
		this.resaltarfecha_ultimo_ingresoResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_ingresoResumenUsuario() {
		return this.mostrarfecha_ultimo_ingresoResumenUsuario;
	}

	public void setMostrarfecha_ultimo_ingresoResumenUsuario(Boolean mostrarfecha_ultimo_ingresoResumenUsuario) {
		this.mostrarfecha_ultimo_ingresoResumenUsuario= mostrarfecha_ultimo_ingresoResumenUsuario;
	}

	public Boolean getActivarfecha_ultimo_ingresoResumenUsuario() {
		return this.activarfecha_ultimo_ingresoResumenUsuario;
	}

	public void setActivarfecha_ultimo_ingresoResumenUsuario(Boolean activarfecha_ultimo_ingresoResumenUsuario) {
		this.activarfecha_ultimo_ingresoResumenUsuario= activarfecha_ultimo_ingresoResumenUsuario;
	}

	public Border setResaltarfecha_ultimo_error_ingresoResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_error_ingresoResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_error_ingresoResumenUsuario() {
		return this.resaltarfecha_ultimo_error_ingresoResumenUsuario;
	}

	public void setResaltarfecha_ultimo_error_ingresoResumenUsuario(Border borderResaltar) {
		this.resaltarfecha_ultimo_error_ingresoResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_error_ingresoResumenUsuario() {
		return this.mostrarfecha_ultimo_error_ingresoResumenUsuario;
	}

	public void setMostrarfecha_ultimo_error_ingresoResumenUsuario(Boolean mostrarfecha_ultimo_error_ingresoResumenUsuario) {
		this.mostrarfecha_ultimo_error_ingresoResumenUsuario= mostrarfecha_ultimo_error_ingresoResumenUsuario;
	}

	public Boolean getActivarfecha_ultimo_error_ingresoResumenUsuario() {
		return this.activarfecha_ultimo_error_ingresoResumenUsuario;
	}

	public void setActivarfecha_ultimo_error_ingresoResumenUsuario(Boolean activarfecha_ultimo_error_ingresoResumenUsuario) {
		this.activarfecha_ultimo_error_ingresoResumenUsuario= activarfecha_ultimo_error_ingresoResumenUsuario;
	}

	public Border setResaltarfecha_ultimo_intentoResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_intentoResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_intentoResumenUsuario() {
		return this.resaltarfecha_ultimo_intentoResumenUsuario;
	}

	public void setResaltarfecha_ultimo_intentoResumenUsuario(Border borderResaltar) {
		this.resaltarfecha_ultimo_intentoResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_intentoResumenUsuario() {
		return this.mostrarfecha_ultimo_intentoResumenUsuario;
	}

	public void setMostrarfecha_ultimo_intentoResumenUsuario(Boolean mostrarfecha_ultimo_intentoResumenUsuario) {
		this.mostrarfecha_ultimo_intentoResumenUsuario= mostrarfecha_ultimo_intentoResumenUsuario;
	}

	public Boolean getActivarfecha_ultimo_intentoResumenUsuario() {
		return this.activarfecha_ultimo_intentoResumenUsuario;
	}

	public void setActivarfecha_ultimo_intentoResumenUsuario(Boolean activarfecha_ultimo_intentoResumenUsuario) {
		this.activarfecha_ultimo_intentoResumenUsuario= activarfecha_ultimo_intentoResumenUsuario;
	}

	public Border setResaltarfecha_ultimo_cierreResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//resumenusuarioBeanSwingJInternalFrame.jTtoolBarResumenUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_cierreResumenUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_cierreResumenUsuario() {
		return this.resaltarfecha_ultimo_cierreResumenUsuario;
	}

	public void setResaltarfecha_ultimo_cierreResumenUsuario(Border borderResaltar) {
		this.resaltarfecha_ultimo_cierreResumenUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_cierreResumenUsuario() {
		return this.mostrarfecha_ultimo_cierreResumenUsuario;
	}

	public void setMostrarfecha_ultimo_cierreResumenUsuario(Boolean mostrarfecha_ultimo_cierreResumenUsuario) {
		this.mostrarfecha_ultimo_cierreResumenUsuario= mostrarfecha_ultimo_cierreResumenUsuario;
	}

	public Boolean getActivarfecha_ultimo_cierreResumenUsuario() {
		return this.activarfecha_ultimo_cierreResumenUsuario;
	}

	public void setActivarfecha_ultimo_cierreResumenUsuario(Boolean activarfecha_ultimo_cierreResumenUsuario) {
		this.activarfecha_ultimo_cierreResumenUsuario= activarfecha_ultimo_cierreResumenUsuario;
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
		
		
		this.setMostraridResumenUsuario(esInicial);
		this.setMostrarid_usuarioResumenUsuario(esInicial);
		this.setMostrarnumero_ingresosResumenUsuario(esInicial);
		this.setMostrarnumero_error_ingresoResumenUsuario(esInicial);
		this.setMostrarnumero_intentosResumenUsuario(esInicial);
		this.setMostrarnumero_cierresResumenUsuario(esInicial);
		this.setMostrarnumero_reiniciosResumenUsuario(esInicial);
		this.setMostrarnumero_ingreso_actualResumenUsuario(esInicial);
		this.setMostrarfecha_ultimo_ingresoResumenUsuario(esInicial);
		this.setMostrarfecha_ultimo_error_ingresoResumenUsuario(esInicial);
		this.setMostrarfecha_ultimo_intentoResumenUsuario(esInicial);
		this.setMostrarfecha_ultimo_cierreResumenUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.ID)) {
				this.setMostraridResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOS)) {
				this.setMostrarnumero_ingresosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO)) {
				this.setMostrarnumero_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINTENTOS)) {
				this.setMostrarnumero_intentosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROCIERRES)) {
				this.setMostrarnumero_cierresResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROREINICIOS)) {
				this.setMostrarnumero_reiniciosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL)) {
				this.setMostrarnumero_ingreso_actualResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO)) {
				this.setMostrarfecha_ultimo_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO)) {
				this.setMostrarfecha_ultimo_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO)) {
				this.setMostrarfecha_ultimo_intentoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE)) {
				this.setMostrarfecha_ultimo_cierreResumenUsuario(esAsigna);
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
		
		
		this.setActivaridResumenUsuario(esInicial);
		this.setActivarid_usuarioResumenUsuario(esInicial);
		this.setActivarnumero_ingresosResumenUsuario(esInicial);
		this.setActivarnumero_error_ingresoResumenUsuario(esInicial);
		this.setActivarnumero_intentosResumenUsuario(esInicial);
		this.setActivarnumero_cierresResumenUsuario(esInicial);
		this.setActivarnumero_reiniciosResumenUsuario(esInicial);
		this.setActivarnumero_ingreso_actualResumenUsuario(esInicial);
		this.setActivarfecha_ultimo_ingresoResumenUsuario(esInicial);
		this.setActivarfecha_ultimo_error_ingresoResumenUsuario(esInicial);
		this.setActivarfecha_ultimo_intentoResumenUsuario(esInicial);
		this.setActivarfecha_ultimo_cierreResumenUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.ID)) {
				this.setActivaridResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOS)) {
				this.setActivarnumero_ingresosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO)) {
				this.setActivarnumero_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINTENTOS)) {
				this.setActivarnumero_intentosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROCIERRES)) {
				this.setActivarnumero_cierresResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROREINICIOS)) {
				this.setActivarnumero_reiniciosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL)) {
				this.setActivarnumero_ingreso_actualResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO)) {
				this.setActivarfecha_ultimo_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO)) {
				this.setActivarfecha_ultimo_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO)) {
				this.setActivarfecha_ultimo_intentoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE)) {
				this.setActivarfecha_ultimo_cierreResumenUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResumenUsuario(esInicial);
		this.setResaltarid_usuarioResumenUsuario(esInicial);
		this.setResaltarnumero_ingresosResumenUsuario(esInicial);
		this.setResaltarnumero_error_ingresoResumenUsuario(esInicial);
		this.setResaltarnumero_intentosResumenUsuario(esInicial);
		this.setResaltarnumero_cierresResumenUsuario(esInicial);
		this.setResaltarnumero_reiniciosResumenUsuario(esInicial);
		this.setResaltarnumero_ingreso_actualResumenUsuario(esInicial);
		this.setResaltarfecha_ultimo_ingresoResumenUsuario(esInicial);
		this.setResaltarfecha_ultimo_error_ingresoResumenUsuario(esInicial);
		this.setResaltarfecha_ultimo_intentoResumenUsuario(esInicial);
		this.setResaltarfecha_ultimo_cierreResumenUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.ID)) {
				this.setResaltaridResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOS)) {
				this.setResaltarnumero_ingresosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO)) {
				this.setResaltarnumero_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINTENTOS)) {
				this.setResaltarnumero_intentosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROCIERRES)) {
				this.setResaltarnumero_cierresResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROREINICIOS)) {
				this.setResaltarnumero_reiniciosResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL)) {
				this.setResaltarnumero_ingreso_actualResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO)) {
				this.setResaltarfecha_ultimo_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO)) {
				this.setResaltarfecha_ultimo_error_ingresoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO)) {
				this.setResaltarfecha_ultimo_intentoResumenUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE)) {
				this.setResaltarfecha_ultimo_cierreResumenUsuario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdUsuarioResumenUsuario=true;

	public Boolean getMostrarFK_IdUsuarioResumenUsuario() {
		return this.mostrarFK_IdUsuarioResumenUsuario;
	}

	public void setMostrarFK_IdUsuarioResumenUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioResumenUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdUsuarioResumenUsuario=true;

	public Boolean getActivarFK_IdUsuarioResumenUsuario() {
		return this.activarFK_IdUsuarioResumenUsuario;
	}

	public void setActivarFK_IdUsuarioResumenUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioResumenUsuario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdUsuarioResumenUsuario=null;

	public Border getResaltarFK_IdUsuarioResumenUsuario() {
		return this.resaltarFK_IdUsuarioResumenUsuario;
	}

	public void setResaltarFK_IdUsuarioResumenUsuario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioResumenUsuario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioResumenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ResumenUsuarioBeanSwingJInternalFrame resumenusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioResumenUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}