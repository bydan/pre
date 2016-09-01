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


import com.bydan.erp.seguridad.util.PerfilCampoConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilCampoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilCampoParameterGeneral;

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
final public class PerfilCampoConstantesFunciones extends PerfilCampoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PerfilCampo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PerfilCampo"+PerfilCampoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PerfilCampoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PerfilCampoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PerfilCampoConstantesFunciones.SCHEMA+"_"+PerfilCampoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PerfilCampoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PerfilCampoConstantesFunciones.SCHEMA+"_"+PerfilCampoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PerfilCampoConstantesFunciones.SCHEMA+"_"+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PerfilCampoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PerfilCampoConstantesFunciones.SCHEMA+"_"+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilCampoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilCampoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilCampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PerfilCampoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PerfilCampoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PerfilCampoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PerfilCampoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Perfil Campos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Perfil Campo";
	public static final String SCLASSWEBTITULO_LOWER="Perfil Campo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PerfilCampo";
	public static final String OBJECTNAME="perfilcampo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="perfil_campo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select perfilcampo from "+PerfilCampoConstantesFunciones.SPERSISTENCENAME+" perfilcampo";
	public static String QUERYSELECTNATIVE="select "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".version_row,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id_perfil,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id_campo,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".todo,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".ingreso,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".modificacion,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".eliminacion,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".consulta,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".estado from "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME;//+" as "+PerfilCampoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PerfilCampoConstantesFuncionesAdditional perfilcampoConstantesFuncionesAdditional=null;
	
	public PerfilCampoConstantesFuncionesAdditional getPerfilCampoConstantesFuncionesAdditional() {
		return this.perfilcampoConstantesFuncionesAdditional;
	}
	
	public void setPerfilCampoConstantesFuncionesAdditional(PerfilCampoConstantesFuncionesAdditional perfilcampoConstantesFuncionesAdditional) {
		try {
			this.perfilcampoConstantesFuncionesAdditional=perfilcampoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPERFIL= "id_perfil";
    public static final String IDCAMPO= "id_campo";
    public static final String TODO= "todo";
    public static final String INGRESO= "ingreso";
    public static final String MODIFICACION= "modificacion";
    public static final String ELIMINACION= "eliminacion";
    public static final String CONSULTA= "consulta";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPERFIL= "Perfil";
		public static final String LABEL_IDPERFIL_LOWER= "Perfil";
    	public static final String LABEL_IDCAMPO= "Campo";
		public static final String LABEL_IDCAMPO_LOWER= "Campo";
    	public static final String LABEL_TODO= "Todo";
		public static final String LABEL_TODO_LOWER= "Todo";
    	public static final String LABEL_INGRESO= "Ingreso";
		public static final String LABEL_INGRESO_LOWER= "Ingreso";
    	public static final String LABEL_MODIFICACION= "Modificacion";
		public static final String LABEL_MODIFICACION_LOWER= "Modificacion";
    	public static final String LABEL_ELIMINACION= "Eliminacion";
		public static final String LABEL_ELIMINACION_LOWER= "Eliminacion";
    	public static final String LABEL_CONSULTA= "Consulta";
		public static final String LABEL_CONSULTA_LOWER= "Consulta";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getPerfilCampoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.IDPERFIL)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_IDPERFIL;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.IDCAMPO)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_IDCAMPO;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.TODO)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_TODO;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.INGRESO)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_INGRESO;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.MODIFICACION)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_MODIFICACION;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.ELIMINACION)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_ELIMINACION;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.CONSULTA)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_CONSULTA;}
		if(sNombreColumna.equals(PerfilCampoConstantesFunciones.ESTADO)) {sLabelColumna=PerfilCampoConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
		
	public static String gettodoDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.gettodo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettodoHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.gettodo());

		return sDescripcion;
	}	
		
	public static String getingresoDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.getingreso()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getingresoHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.getingreso());

		return sDescripcion;
	}	
		
	public static String getmodificacionDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.getmodificacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getmodificacionHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.getmodificacion());

		return sDescripcion;
	}	
		
	public static String geteliminacionDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.geteliminacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String geteliminacionHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.geteliminacion());

		return sDescripcion;
	}	
		
	public static String getconsultaDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.getconsulta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getconsultaHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.getconsulta());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilcampo.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(PerfilCampo perfilcampo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilcampo.getId(),perfilcampo.getestado());

		return sDescripcion;
	}	
	
	public static String getPerfilCampoDescripcion(PerfilCampo perfilcampo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(perfilcampo !=null/* && perfilcampo.getId()!=0*/) {
			if(perfilcampo.getId()!=null) {
				sDescripcion=perfilcampo.getId().toString();
			}//perfilcampoperfilcampo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPerfilCampoDescripcionDetallado(PerfilCampo perfilcampo) {
		String sDescripcion="";
			
		sDescripcion+=PerfilCampoConstantesFunciones.ID+"=";
		sDescripcion+=perfilcampo.getId().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=perfilcampo.getVersionRow().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.IDPERFIL+"=";
		sDescripcion+=perfilcampo.getid_perfil().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.IDCAMPO+"=";
		sDescripcion+=perfilcampo.getid_campo().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.TODO+"=";
		sDescripcion+=perfilcampo.gettodo().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.INGRESO+"=";
		sDescripcion+=perfilcampo.getingreso().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.MODIFICACION+"=";
		sDescripcion+=perfilcampo.getmodificacion().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.ELIMINACION+"=";
		sDescripcion+=perfilcampo.geteliminacion().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.CONSULTA+"=";
		sDescripcion+=perfilcampo.getconsulta().toString()+",";
		sDescripcion+=PerfilCampoConstantesFunciones.ESTADO+"=";
		sDescripcion+=perfilcampo.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPerfilCampoDescripcion(PerfilCampo perfilcampo,String sValor) throws Exception {			
		if(perfilcampo !=null) {
			//perfilcampoperfilcampo.getId().toString();
		}		
	}
	
		

	public static String getPerfilDescripcion(Perfil perfil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(perfil!=null/*&&perfil.getId()>0*/) {
			sDescripcion=PerfilConstantesFunciones.getPerfilDescripcion(perfil);
		}

		return sDescripcion;
	}

	public static String getCampoDescripcion(Campo campo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(campo!=null/*&&campo.getId()>0*/) {
			sDescripcion=CampoConstantesFunciones.getCampoDescripcion(campo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCampo")) {
			sNombreIndice="Tipo=  Por Campo";
		} else if(sNombreIndice.equals("FK_IdPerfil")) {
			sNombreIndice="Tipo=  Por Perfil";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCampo(Long id_campo) {
		String sDetalleIndice=" Parametros->";
		if(id_campo!=null) {sDetalleIndice+=" Codigo Unico De Campo="+id_campo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPerfil(Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPerfilCampo(PerfilCampo perfilcampo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPerfilCampos(List<PerfilCampo> perfilcampos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PerfilCampo perfilcampo: perfilcampos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilCampo(PerfilCampo perfilcampo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && perfilcampo.getConCambioAuxiliar()) {
			perfilcampo.setIsDeleted(perfilcampo.getIsDeletedAuxiliar());	
			perfilcampo.setIsNew(perfilcampo.getIsNewAuxiliar());	
			perfilcampo.setIsChanged(perfilcampo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			perfilcampo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			perfilcampo.setIsDeletedAuxiliar(false);	
			perfilcampo.setIsNewAuxiliar(false);	
			perfilcampo.setIsChangedAuxiliar(false);
			
			perfilcampo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilCampos(List<PerfilCampo> perfilcampos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PerfilCampo perfilcampo : perfilcampos) {
			if(conAsignarBase && perfilcampo.getConCambioAuxiliar()) {
				perfilcampo.setIsDeleted(perfilcampo.getIsDeletedAuxiliar());	
				perfilcampo.setIsNew(perfilcampo.getIsNewAuxiliar());	
				perfilcampo.setIsChanged(perfilcampo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				perfilcampo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				perfilcampo.setIsDeletedAuxiliar(false);	
				perfilcampo.setIsNewAuxiliar(false);	
				perfilcampo.setIsChangedAuxiliar(false);
				
				perfilcampo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPerfilCampo(PerfilCampo perfilcampo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPerfilCampos(List<PerfilCampo> perfilcampos,Boolean conEnteros) throws Exception  {
		
		for(PerfilCampo perfilcampo: perfilcampos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPerfilCampo(List<PerfilCampo> perfilcampos,PerfilCampo perfilcampoAux) throws Exception  {
		PerfilCampoConstantesFunciones.InicializarValoresPerfilCampo(perfilcampoAux,true);
		
		for(PerfilCampo perfilcampo: perfilcampos) {
			if(perfilcampo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilCampo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PerfilCampoConstantesFunciones.getArrayColumnasGlobalesPerfilCampo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilCampo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPerfilCampo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PerfilCampo> perfilcampos,PerfilCampo perfilcampo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PerfilCampo perfilcampoAux: perfilcampos) {
			if(perfilcampoAux!=null && perfilcampo!=null) {
				if((perfilcampoAux.getId()==null && perfilcampo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(perfilcampoAux.getId()!=null && perfilcampo.getId()!=null){
					if(perfilcampoAux.getId().equals(perfilcampo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPerfilCampo(List<PerfilCampo> perfilcampos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PerfilCampo perfilcampo: perfilcampos) {			
			if(perfilcampo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPerfilCampo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_ID, PerfilCampoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_VERSIONROW, PerfilCampoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_IDPERFIL, PerfilCampoConstantesFunciones.IDPERFIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_IDCAMPO, PerfilCampoConstantesFunciones.IDCAMPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_TODO, PerfilCampoConstantesFunciones.TODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_INGRESO, PerfilCampoConstantesFunciones.INGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_MODIFICACION, PerfilCampoConstantesFunciones.MODIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_ELIMINACION, PerfilCampoConstantesFunciones.ELIMINACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_CONSULTA, PerfilCampoConstantesFunciones.CONSULTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilCampoConstantesFunciones.LABEL_ESTADO, PerfilCampoConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPerfilCampo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.IDPERFIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.IDCAMPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.TODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.INGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.MODIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.ELIMINACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.CONSULTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilCampoConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilCampo() throws Exception  {
		return PerfilCampoConstantesFunciones.getTiposSeleccionarPerfilCampo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilCampo(Boolean conFk) throws Exception  {
		return PerfilCampoConstantesFunciones.getTiposSeleccionarPerfilCampo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilCampo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_IDPERFIL);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_IDPERFIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_IDCAMPO);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_IDCAMPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_TODO);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_TODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_INGRESO);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_INGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_MODIFICACION);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_MODIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_ELIMINACION);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_ELIMINACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_CONSULTA);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_CONSULTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilCampoConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PerfilCampoConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPerfilCampo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilCampo(PerfilCampo perfilcampoAux) throws Exception {
		
			perfilcampoAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilcampoAux.getPerfil()));
			perfilcampoAux.setcampo_descripcion(CampoConstantesFunciones.getCampoDescripcion(perfilcampoAux.getCampo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilCampo(List<PerfilCampo> perfilcamposTemp) throws Exception {
		for(PerfilCampo perfilcampoAux:perfilcamposTemp) {
			
			perfilcampoAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilcampoAux.getPerfil()));
			perfilcampoAux.setcampo_descripcion(CampoConstantesFunciones.getCampoDescripcion(perfilcampoAux.getCampo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(Campo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Campo.class)) {
						classes.add(new Classe(Campo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPerfilCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilCampoConstantesFunciones.getClassesRelationshipsOfPerfilCampo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilCampoConstantesFunciones.getClassesRelationshipsFromStringsOfPerfilCampo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PerfilCampo perfilcampo,List<PerfilCampo> perfilcampos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PerfilCampo perfilcampoEncontrado=null;
			
			for(PerfilCampo perfilcampoLocal:perfilcampos) {
				if(perfilcampoLocal.getId().equals(perfilcampo.getId())) {
					perfilcampoEncontrado=perfilcampoLocal;
					
					perfilcampoLocal.setIsChanged(perfilcampo.getIsChanged());
					perfilcampoLocal.setIsNew(perfilcampo.getIsNew());
					perfilcampoLocal.setIsDeleted(perfilcampo.getIsDeleted());
					
					perfilcampoLocal.setGeneralEntityOriginal(perfilcampo.getGeneralEntityOriginal());
					
					perfilcampoLocal.setId(perfilcampo.getId());	
					perfilcampoLocal.setVersionRow(perfilcampo.getVersionRow());	
					perfilcampoLocal.setid_perfil(perfilcampo.getid_perfil());	
					perfilcampoLocal.setid_campo(perfilcampo.getid_campo());	
					perfilcampoLocal.settodo(perfilcampo.gettodo());	
					perfilcampoLocal.setingreso(perfilcampo.getingreso());	
					perfilcampoLocal.setmodificacion(perfilcampo.getmodificacion());	
					perfilcampoLocal.seteliminacion(perfilcampo.geteliminacion());	
					perfilcampoLocal.setconsulta(perfilcampo.getconsulta());	
					perfilcampoLocal.setestado(perfilcampo.getestado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!perfilcampo.getIsDeleted()) {
				if(!existe) {
					perfilcampos.add(perfilcampo);
				}
			} else {
				if(perfilcampoEncontrado!=null && permiteQuitar)  {
					perfilcampos.remove(perfilcampoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PerfilCampo perfilcampo,List<PerfilCampo> perfilcampos) throws Exception {
		try	{			
			for(PerfilCampo perfilcampoLocal:perfilcampos) {
				if(perfilcampoLocal.getId().equals(perfilcampo.getId())) {
					perfilcampoLocal.setIsSelected(perfilcampo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPerfilCampo(List<PerfilCampo> perfilcamposAux) throws Exception {
		//this.perfilcamposAux=perfilcamposAux;
		
		for(PerfilCampo perfilcampoAux:perfilcamposAux) {
			if(perfilcampoAux.getIsChanged()) {
				perfilcampoAux.setIsChanged(false);
			}		
			
			if(perfilcampoAux.getIsNew()) {
				perfilcampoAux.setIsNew(false);
			}	
			
			if(perfilcampoAux.getIsDeleted()) {
				perfilcampoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPerfilCampo(PerfilCampo perfilcampoAux) throws Exception {
		//this.perfilcampoAux=perfilcampoAux;
		
			if(perfilcampoAux.getIsChanged()) {
				perfilcampoAux.setIsChanged(false);
			}		
			
			if(perfilcampoAux.getIsNew()) {
				perfilcampoAux.setIsNew(false);
			}	
			
			if(perfilcampoAux.getIsDeleted()) {
				perfilcampoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PerfilCampo perfilcampoAsignar,PerfilCampo perfilcampo) throws Exception {
		perfilcampoAsignar.setId(perfilcampo.getId());	
		perfilcampoAsignar.setVersionRow(perfilcampo.getVersionRow());	
		perfilcampoAsignar.setid_perfil(perfilcampo.getid_perfil());
		perfilcampoAsignar.setperfil_descripcion(perfilcampo.getperfil_descripcion());	
		perfilcampoAsignar.setid_campo(perfilcampo.getid_campo());
		perfilcampoAsignar.setcampo_descripcion(perfilcampo.getcampo_descripcion());	
		perfilcampoAsignar.settodo(perfilcampo.gettodo());	
		perfilcampoAsignar.setingreso(perfilcampo.getingreso());	
		perfilcampoAsignar.setmodificacion(perfilcampo.getmodificacion());	
		perfilcampoAsignar.seteliminacion(perfilcampo.geteliminacion());	
		perfilcampoAsignar.setconsulta(perfilcampo.getconsulta());	
		perfilcampoAsignar.setestado(perfilcampo.getestado());	
	}
	
	public static void inicializarPerfilCampo(PerfilCampo perfilcampo) throws Exception {
		try {
				perfilcampo.setId(0L);	
					
				perfilcampo.setid_perfil(-1L);	
				perfilcampo.setid_campo(-1L);	
				perfilcampo.settodo(false);	
				perfilcampo.setingreso(false);	
				perfilcampo.setmodificacion(false);	
				perfilcampo.seteliminacion(false);	
				perfilcampo.setconsulta(false);	
				perfilcampo.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPerfilCampo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_IDPERFIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_IDCAMPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_TODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_INGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_MODIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_ELIMINACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_CONSULTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilCampoConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPerfilCampo(String sTipo,Row row,Workbook workbook,PerfilCampo perfilcampo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilcampo.getperfil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilcampo.getcampo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.gettodo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.getingreso()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.getmodificacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.geteliminacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.getconsulta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilcampo.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPerfilCampo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPerfilCampo() {
		return this.sFinalQueryPerfilCampo;
	}
	
	public void setsFinalQueryPerfilCampo(String sFinalQueryPerfilCampo) {
		this.sFinalQueryPerfilCampo= sFinalQueryPerfilCampo;
	}
	
	public Border resaltarSeleccionarPerfilCampo=null;
	
	public Border setResaltarSeleccionarPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPerfilCampo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPerfilCampo() {
		return this.resaltarSeleccionarPerfilCampo;
	}
	
	public void setResaltarSeleccionarPerfilCampo(Border borderResaltarSeleccionarPerfilCampo) {
		this.resaltarSeleccionarPerfilCampo= borderResaltarSeleccionarPerfilCampo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPerfilCampo=null;
	public Boolean mostraridPerfilCampo=true;
	public Boolean activaridPerfilCampo=true;

	public Border resaltarid_perfilPerfilCampo=null;
	public Boolean mostrarid_perfilPerfilCampo=true;
	public Boolean activarid_perfilPerfilCampo=true;
	public Boolean cargarid_perfilPerfilCampo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_perfilPerfilCampo=false;//ConEventDepend=true

	public Border resaltarid_campoPerfilCampo=null;
	public Boolean mostrarid_campoPerfilCampo=true;
	public Boolean activarid_campoPerfilCampo=true;
	public Boolean cargarid_campoPerfilCampo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_campoPerfilCampo=false;//ConEventDepend=true

	public Border resaltartodoPerfilCampo=null;
	public Boolean mostrartodoPerfilCampo=true;
	public Boolean activartodoPerfilCampo=true;

	public Border resaltaringresoPerfilCampo=null;
	public Boolean mostraringresoPerfilCampo=true;
	public Boolean activaringresoPerfilCampo=true;

	public Border resaltarmodificacionPerfilCampo=null;
	public Boolean mostrarmodificacionPerfilCampo=true;
	public Boolean activarmodificacionPerfilCampo=true;

	public Border resaltareliminacionPerfilCampo=null;
	public Boolean mostrareliminacionPerfilCampo=true;
	public Boolean activareliminacionPerfilCampo=true;

	public Border resaltarconsultaPerfilCampo=null;
	public Boolean mostrarconsultaPerfilCampo=true;
	public Boolean activarconsultaPerfilCampo=true;

	public Border resaltarestadoPerfilCampo=null;
	public Boolean mostrarestadoPerfilCampo=true;
	public Boolean activarestadoPerfilCampo=true;

	
	

	public Border setResaltaridPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltaridPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPerfilCampo() {
		return this.resaltaridPerfilCampo;
	}

	public void setResaltaridPerfilCampo(Border borderResaltar) {
		this.resaltaridPerfilCampo= borderResaltar;
	}

	public Boolean getMostraridPerfilCampo() {
		return this.mostraridPerfilCampo;
	}

	public void setMostraridPerfilCampo(Boolean mostraridPerfilCampo) {
		this.mostraridPerfilCampo= mostraridPerfilCampo;
	}

	public Boolean getActivaridPerfilCampo() {
		return this.activaridPerfilCampo;
	}

	public void setActivaridPerfilCampo(Boolean activaridPerfilCampo) {
		this.activaridPerfilCampo= activaridPerfilCampo;
	}

	public Border setResaltarid_perfilPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarid_perfilPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_perfilPerfilCampo() {
		return this.resaltarid_perfilPerfilCampo;
	}

	public void setResaltarid_perfilPerfilCampo(Border borderResaltar) {
		this.resaltarid_perfilPerfilCampo= borderResaltar;
	}

	public Boolean getMostrarid_perfilPerfilCampo() {
		return this.mostrarid_perfilPerfilCampo;
	}

	public void setMostrarid_perfilPerfilCampo(Boolean mostrarid_perfilPerfilCampo) {
		this.mostrarid_perfilPerfilCampo= mostrarid_perfilPerfilCampo;
	}

	public Boolean getActivarid_perfilPerfilCampo() {
		return this.activarid_perfilPerfilCampo;
	}

	public void setActivarid_perfilPerfilCampo(Boolean activarid_perfilPerfilCampo) {
		this.activarid_perfilPerfilCampo= activarid_perfilPerfilCampo;
	}

	public Boolean getCargarid_perfilPerfilCampo() {
		return this.cargarid_perfilPerfilCampo;
	}

	public void setCargarid_perfilPerfilCampo(Boolean cargarid_perfilPerfilCampo) {
		this.cargarid_perfilPerfilCampo= cargarid_perfilPerfilCampo;
	}

	public Border setResaltarid_campoPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarid_campoPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_campoPerfilCampo() {
		return this.resaltarid_campoPerfilCampo;
	}

	public void setResaltarid_campoPerfilCampo(Border borderResaltar) {
		this.resaltarid_campoPerfilCampo= borderResaltar;
	}

	public Boolean getMostrarid_campoPerfilCampo() {
		return this.mostrarid_campoPerfilCampo;
	}

	public void setMostrarid_campoPerfilCampo(Boolean mostrarid_campoPerfilCampo) {
		this.mostrarid_campoPerfilCampo= mostrarid_campoPerfilCampo;
	}

	public Boolean getActivarid_campoPerfilCampo() {
		return this.activarid_campoPerfilCampo;
	}

	public void setActivarid_campoPerfilCampo(Boolean activarid_campoPerfilCampo) {
		this.activarid_campoPerfilCampo= activarid_campoPerfilCampo;
	}

	public Boolean getCargarid_campoPerfilCampo() {
		return this.cargarid_campoPerfilCampo;
	}

	public void setCargarid_campoPerfilCampo(Boolean cargarid_campoPerfilCampo) {
		this.cargarid_campoPerfilCampo= cargarid_campoPerfilCampo;
	}

	public Border setResaltartodoPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltartodoPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartodoPerfilCampo() {
		return this.resaltartodoPerfilCampo;
	}

	public void setResaltartodoPerfilCampo(Border borderResaltar) {
		this.resaltartodoPerfilCampo= borderResaltar;
	}

	public Boolean getMostrartodoPerfilCampo() {
		return this.mostrartodoPerfilCampo;
	}

	public void setMostrartodoPerfilCampo(Boolean mostrartodoPerfilCampo) {
		this.mostrartodoPerfilCampo= mostrartodoPerfilCampo;
	}

	public Boolean getActivartodoPerfilCampo() {
		return this.activartodoPerfilCampo;
	}

	public void setActivartodoPerfilCampo(Boolean activartodoPerfilCampo) {
		this.activartodoPerfilCampo= activartodoPerfilCampo;
	}

	public Border setResaltaringresoPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltaringresoPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresoPerfilCampo() {
		return this.resaltaringresoPerfilCampo;
	}

	public void setResaltaringresoPerfilCampo(Border borderResaltar) {
		this.resaltaringresoPerfilCampo= borderResaltar;
	}

	public Boolean getMostraringresoPerfilCampo() {
		return this.mostraringresoPerfilCampo;
	}

	public void setMostraringresoPerfilCampo(Boolean mostraringresoPerfilCampo) {
		this.mostraringresoPerfilCampo= mostraringresoPerfilCampo;
	}

	public Boolean getActivaringresoPerfilCampo() {
		return this.activaringresoPerfilCampo;
	}

	public void setActivaringresoPerfilCampo(Boolean activaringresoPerfilCampo) {
		this.activaringresoPerfilCampo= activaringresoPerfilCampo;
	}

	public Border setResaltarmodificacionPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarmodificacionPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodificacionPerfilCampo() {
		return this.resaltarmodificacionPerfilCampo;
	}

	public void setResaltarmodificacionPerfilCampo(Border borderResaltar) {
		this.resaltarmodificacionPerfilCampo= borderResaltar;
	}

	public Boolean getMostrarmodificacionPerfilCampo() {
		return this.mostrarmodificacionPerfilCampo;
	}

	public void setMostrarmodificacionPerfilCampo(Boolean mostrarmodificacionPerfilCampo) {
		this.mostrarmodificacionPerfilCampo= mostrarmodificacionPerfilCampo;
	}

	public Boolean getActivarmodificacionPerfilCampo() {
		return this.activarmodificacionPerfilCampo;
	}

	public void setActivarmodificacionPerfilCampo(Boolean activarmodificacionPerfilCampo) {
		this.activarmodificacionPerfilCampo= activarmodificacionPerfilCampo;
	}

	public Border setResaltareliminacionPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltareliminacionPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltareliminacionPerfilCampo() {
		return this.resaltareliminacionPerfilCampo;
	}

	public void setResaltareliminacionPerfilCampo(Border borderResaltar) {
		this.resaltareliminacionPerfilCampo= borderResaltar;
	}

	public Boolean getMostrareliminacionPerfilCampo() {
		return this.mostrareliminacionPerfilCampo;
	}

	public void setMostrareliminacionPerfilCampo(Boolean mostrareliminacionPerfilCampo) {
		this.mostrareliminacionPerfilCampo= mostrareliminacionPerfilCampo;
	}

	public Boolean getActivareliminacionPerfilCampo() {
		return this.activareliminacionPerfilCampo;
	}

	public void setActivareliminacionPerfilCampo(Boolean activareliminacionPerfilCampo) {
		this.activareliminacionPerfilCampo= activareliminacionPerfilCampo;
	}

	public Border setResaltarconsultaPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarconsultaPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconsultaPerfilCampo() {
		return this.resaltarconsultaPerfilCampo;
	}

	public void setResaltarconsultaPerfilCampo(Border borderResaltar) {
		this.resaltarconsultaPerfilCampo= borderResaltar;
	}

	public Boolean getMostrarconsultaPerfilCampo() {
		return this.mostrarconsultaPerfilCampo;
	}

	public void setMostrarconsultaPerfilCampo(Boolean mostrarconsultaPerfilCampo) {
		this.mostrarconsultaPerfilCampo= mostrarconsultaPerfilCampo;
	}

	public Boolean getActivarconsultaPerfilCampo() {
		return this.activarconsultaPerfilCampo;
	}

	public void setActivarconsultaPerfilCampo(Boolean activarconsultaPerfilCampo) {
		this.activarconsultaPerfilCampo= activarconsultaPerfilCampo;
	}

	public Border setResaltarestadoPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilcampoBeanSwingJInternalFrame.jTtoolBarPerfilCampo.setBorder(borderResaltar);
		
		this.resaltarestadoPerfilCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPerfilCampo() {
		return this.resaltarestadoPerfilCampo;
	}

	public void setResaltarestadoPerfilCampo(Border borderResaltar) {
		this.resaltarestadoPerfilCampo= borderResaltar;
	}

	public Boolean getMostrarestadoPerfilCampo() {
		return this.mostrarestadoPerfilCampo;
	}

	public void setMostrarestadoPerfilCampo(Boolean mostrarestadoPerfilCampo) {
		this.mostrarestadoPerfilCampo= mostrarestadoPerfilCampo;
	}

	public Boolean getActivarestadoPerfilCampo() {
		return this.activarestadoPerfilCampo;
	}

	public void setActivarestadoPerfilCampo(Boolean activarestadoPerfilCampo) {
		this.activarestadoPerfilCampo= activarestadoPerfilCampo;
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
		
		
		this.setMostraridPerfilCampo(esInicial);
		this.setMostrarid_perfilPerfilCampo(esInicial);
		this.setMostrarid_campoPerfilCampo(esInicial);
		this.setMostrartodoPerfilCampo(esInicial);
		this.setMostraringresoPerfilCampo(esInicial);
		this.setMostrarmodificacionPerfilCampo(esInicial);
		this.setMostrareliminacionPerfilCampo(esInicial);
		this.setMostrarconsultaPerfilCampo(esInicial);
		this.setMostrarestadoPerfilCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ID)) {
				this.setMostraridPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDPERFIL)) {
				this.setMostrarid_perfilPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDCAMPO)) {
				this.setMostrarid_campoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.TODO)) {
				this.setMostrartodoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.INGRESO)) {
				this.setMostraringresoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.MODIFICACION)) {
				this.setMostrarmodificacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ELIMINACION)) {
				this.setMostrareliminacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.CONSULTA)) {
				this.setMostrarconsultaPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPerfilCampo(esAsigna);
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
		
		
		this.setActivaridPerfilCampo(esInicial);
		this.setActivarid_perfilPerfilCampo(esInicial);
		this.setActivarid_campoPerfilCampo(esInicial);
		this.setActivartodoPerfilCampo(esInicial);
		this.setActivaringresoPerfilCampo(esInicial);
		this.setActivarmodificacionPerfilCampo(esInicial);
		this.setActivareliminacionPerfilCampo(esInicial);
		this.setActivarconsultaPerfilCampo(esInicial);
		this.setActivarestadoPerfilCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ID)) {
				this.setActivaridPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDPERFIL)) {
				this.setActivarid_perfilPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDCAMPO)) {
				this.setActivarid_campoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.TODO)) {
				this.setActivartodoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.INGRESO)) {
				this.setActivaringresoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.MODIFICACION)) {
				this.setActivarmodificacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ELIMINACION)) {
				this.setActivareliminacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.CONSULTA)) {
				this.setActivarconsultaPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ESTADO)) {
				this.setActivarestadoPerfilCampo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPerfilCampo(esInicial);
		this.setResaltarid_perfilPerfilCampo(esInicial);
		this.setResaltarid_campoPerfilCampo(esInicial);
		this.setResaltartodoPerfilCampo(esInicial);
		this.setResaltaringresoPerfilCampo(esInicial);
		this.setResaltarmodificacionPerfilCampo(esInicial);
		this.setResaltareliminacionPerfilCampo(esInicial);
		this.setResaltarconsultaPerfilCampo(esInicial);
		this.setResaltarestadoPerfilCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ID)) {
				this.setResaltaridPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDPERFIL)) {
				this.setResaltarid_perfilPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.IDCAMPO)) {
				this.setResaltarid_campoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.TODO)) {
				this.setResaltartodoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.INGRESO)) {
				this.setResaltaringresoPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.MODIFICACION)) {
				this.setResaltarmodificacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ELIMINACION)) {
				this.setResaltareliminacionPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.CONSULTA)) {
				this.setResaltarconsultaPerfilCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilCampoConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPerfilCampo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCampoPerfilCampo=true;

	public Boolean getMostrarFK_IdCampoPerfilCampo() {
		return this.mostrarFK_IdCampoPerfilCampo;
	}

	public void setMostrarFK_IdCampoPerfilCampo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCampoPerfilCampo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPerfilPerfilCampo=true;

	public Boolean getMostrarFK_IdPerfilPerfilCampo() {
		return this.mostrarFK_IdPerfilPerfilCampo;
	}

	public void setMostrarFK_IdPerfilPerfilCampo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPerfilPerfilCampo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCampoPerfilCampo=true;

	public Boolean getActivarFK_IdCampoPerfilCampo() {
		return this.activarFK_IdCampoPerfilCampo;
	}

	public void setActivarFK_IdCampoPerfilCampo(Boolean habilitarResaltar) {
		this.activarFK_IdCampoPerfilCampo= habilitarResaltar;
	}

	public Boolean activarFK_IdPerfilPerfilCampo=true;

	public Boolean getActivarFK_IdPerfilPerfilCampo() {
		return this.activarFK_IdPerfilPerfilCampo;
	}

	public void setActivarFK_IdPerfilPerfilCampo(Boolean habilitarResaltar) {
		this.activarFK_IdPerfilPerfilCampo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCampoPerfilCampo=null;

	public Border getResaltarFK_IdCampoPerfilCampo() {
		return this.resaltarFK_IdCampoPerfilCampo;
	}

	public void setResaltarFK_IdCampoPerfilCampo(Border borderResaltar) {
		this.resaltarFK_IdCampoPerfilCampo= borderResaltar;
	}

	public void setResaltarFK_IdCampoPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCampoPerfilCampo= borderResaltar;
	}

	public Border resaltarFK_IdPerfilPerfilCampo=null;

	public Border getResaltarFK_IdPerfilPerfilCampo() {
		return this.resaltarFK_IdPerfilPerfilCampo;
	}

	public void setResaltarFK_IdPerfilPerfilCampo(Border borderResaltar) {
		this.resaltarFK_IdPerfilPerfilCampo= borderResaltar;
	}

	public void setResaltarFK_IdPerfilPerfilCampo(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilCampoBeanSwingJInternalFrame perfilcampoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPerfilPerfilCampo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}