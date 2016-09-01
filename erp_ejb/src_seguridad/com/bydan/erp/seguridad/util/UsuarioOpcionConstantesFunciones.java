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


import com.bydan.erp.seguridad.util.UsuarioOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.UsuarioOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UsuarioOpcionParameterGeneral;

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
final public class UsuarioOpcionConstantesFunciones extends UsuarioOpcionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UsuarioOpcion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UsuarioOpcion"+UsuarioOpcionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UsuarioOpcionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UsuarioOpcionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UsuarioOpcionConstantesFunciones.SCHEMA+"_"+UsuarioOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UsuarioOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UsuarioOpcionConstantesFunciones.SCHEMA+"_"+UsuarioOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UsuarioOpcionConstantesFunciones.SCHEMA+"_"+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UsuarioOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UsuarioOpcionConstantesFunciones.SCHEMA+"_"+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UsuarioOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UsuarioOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UsuarioOpcionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UsuarioOpcionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UsuarioOpcionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UsuarioOpcionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Usuario Opciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Usuario Opcion";
	public static final String SCLASSWEBTITULO_LOWER="Usuario Opcion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UsuarioOpcion";
	public static final String OBJECTNAME="usuarioopcion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="usuario_opcion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select usuarioopcion from "+UsuarioOpcionConstantesFunciones.SPERSISTENCENAME+" usuarioopcion";
	public static String QUERYSELECTNATIVE="select "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".version_row,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_sistema,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_modulo,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_opcion,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_perfil,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_usuario,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".con_precargar,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".estado from "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME;//+" as "+UsuarioOpcionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UsuarioOpcionConstantesFuncionesAdditional usuarioopcionConstantesFuncionesAdditional=null;
	
	public UsuarioOpcionConstantesFuncionesAdditional getUsuarioOpcionConstantesFuncionesAdditional() {
		return this.usuarioopcionConstantesFuncionesAdditional;
	}
	
	public void setUsuarioOpcionConstantesFuncionesAdditional(UsuarioOpcionConstantesFuncionesAdditional usuarioopcionConstantesFuncionesAdditional) {
		try {
			this.usuarioopcionConstantesFuncionesAdditional=usuarioopcionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String IDMODULO= "id_modulo";
    public static final String IDGRUPOOPCION= "id_grupo_opcion";
    public static final String IDOPCION= "id_opcion";
    public static final String IDPERFIL= "id_perfil";
    public static final String IDUSUARIO= "id_usuario";
    public static final String CONPRECARGAR= "con_precargar";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDGRUPOOPCION= "Grupo Opcion";
		public static final String LABEL_IDGRUPOOPCION_LOWER= "Grupo Opcion";
    	public static final String LABEL_IDOPCION= "Opcion";
		public static final String LABEL_IDOPCION_LOWER= "Opcion";
    	public static final String LABEL_IDPERFIL= "Perfil";
		public static final String LABEL_IDPERFIL_LOWER= "Perfil";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_CONPRECARGAR= "Con Precargar";
		public static final String LABEL_CONPRECARGAR_LOWER= "Con Precargar";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getUsuarioOpcionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDSISTEMA)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDMODULO)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDGRUPOOPCION)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDGRUPOOPCION;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDOPCION)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDOPCION;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDPERFIL)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDPERFIL;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.IDUSUARIO)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.CONPRECARGAR)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_CONPRECARGAR;}
		if(sNombreColumna.equals(UsuarioOpcionConstantesFunciones.ESTADO)) {sLabelColumna=UsuarioOpcionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getcon_precargarDescripcion(UsuarioOpcion usuarioopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!usuarioopcion.getcon_precargar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precargarHtmlDescripcion(UsuarioOpcion usuarioopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(usuarioopcion.getId(),usuarioopcion.getcon_precargar());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(UsuarioOpcion usuarioopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!usuarioopcion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(UsuarioOpcion usuarioopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(usuarioopcion.getId(),usuarioopcion.getestado());

		return sDescripcion;
	}	
	
	public static String getUsuarioOpcionDescripcion(UsuarioOpcion usuarioopcion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(usuarioopcion !=null/* && usuarioopcion.getId()!=0*/) {
			if(usuarioopcion.getId()!=null) {
				sDescripcion=usuarioopcion.getId().toString();
			}//usuarioopcionusuarioopcion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUsuarioOpcionDescripcionDetallado(UsuarioOpcion usuarioopcion) {
		String sDescripcion="";
			
		sDescripcion+=UsuarioOpcionConstantesFunciones.ID+"=";
		sDescripcion+=usuarioopcion.getId().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=usuarioopcion.getVersionRow().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=usuarioopcion.getid_sistema().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=usuarioopcion.getid_modulo().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDGRUPOOPCION+"=";
		sDescripcion+=usuarioopcion.getid_grupo_opcion().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDOPCION+"=";
		sDescripcion+=usuarioopcion.getid_opcion().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDPERFIL+"=";
		sDescripcion+=usuarioopcion.getid_perfil().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=usuarioopcion.getid_usuario().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.CONPRECARGAR+"=";
		sDescripcion+=usuarioopcion.getcon_precargar().toString()+",";
		sDescripcion+=UsuarioOpcionConstantesFunciones.ESTADO+"=";
		sDescripcion+=usuarioopcion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUsuarioOpcionDescripcion(UsuarioOpcion usuarioopcion,String sValor) throws Exception {			
		if(usuarioopcion !=null) {
			//usuarioopcionusuarioopcion.getId().toString();
		}		
	}
	
		

	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sistema!=null/*&&sistema.getId()>0*/) {
			sDescripcion=SistemaConstantesFunciones.getSistemaDescripcion(sistema);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getGrupoOpcionDescripcion(GrupoOpcion grupoopcion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupoopcion!=null/*&&grupoopcion.getId()>0*/) {
			sDescripcion=GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(grupoopcion);
		}

		return sDescripcion;
	}

	public static String getOpcionDescripcion(Opcion opcion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(opcion!=null/*&&opcion.getId()>0*/) {
			sDescripcion=OpcionConstantesFunciones.getOpcionDescripcion(opcion);
		}

		return sDescripcion;
	}

	public static String getPerfilDescripcion(Perfil perfil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(perfil!=null/*&&perfil.getId()>0*/) {
			sDescripcion=PerfilConstantesFunciones.getPerfilDescripcion(perfil);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("FK_IdGrupoOpcion")) {
			sNombreIndice="Tipo=  Por Grupo Opcion";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdOpcion")) {
			sNombreIndice="Tipo=  Por Opcion";
		} else if(sNombreIndice.equals("FK_IdPerfil")) {
			sNombreIndice="Tipo=  Por Perfil";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdGrupoOpcion(Long id_grupo_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_opcion!=null) {sDetalleIndice+=" Codigo Unico De Grupo Opcion="+id_grupo_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdOpcion(Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPerfil(Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUsuarioOpcion(UsuarioOpcion usuarioopcion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosUsuarioOpcions(List<UsuarioOpcion> usuarioopcions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UsuarioOpcion usuarioopcion: usuarioopcions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUsuarioOpcion(UsuarioOpcion usuarioopcion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && usuarioopcion.getConCambioAuxiliar()) {
			usuarioopcion.setIsDeleted(usuarioopcion.getIsDeletedAuxiliar());	
			usuarioopcion.setIsNew(usuarioopcion.getIsNewAuxiliar());	
			usuarioopcion.setIsChanged(usuarioopcion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			usuarioopcion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			usuarioopcion.setIsDeletedAuxiliar(false);	
			usuarioopcion.setIsNewAuxiliar(false);	
			usuarioopcion.setIsChangedAuxiliar(false);
			
			usuarioopcion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUsuarioOpcions(List<UsuarioOpcion> usuarioopcions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UsuarioOpcion usuarioopcion : usuarioopcions) {
			if(conAsignarBase && usuarioopcion.getConCambioAuxiliar()) {
				usuarioopcion.setIsDeleted(usuarioopcion.getIsDeletedAuxiliar());	
				usuarioopcion.setIsNew(usuarioopcion.getIsNewAuxiliar());	
				usuarioopcion.setIsChanged(usuarioopcion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				usuarioopcion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				usuarioopcion.setIsDeletedAuxiliar(false);	
				usuarioopcion.setIsNewAuxiliar(false);	
				usuarioopcion.setIsChangedAuxiliar(false);
				
				usuarioopcion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUsuarioOpcion(UsuarioOpcion usuarioopcion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUsuarioOpcions(List<UsuarioOpcion> usuarioopcions,Boolean conEnteros) throws Exception  {
		
		for(UsuarioOpcion usuarioopcion: usuarioopcions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUsuarioOpcion(List<UsuarioOpcion> usuarioopcions,UsuarioOpcion usuarioopcionAux) throws Exception  {
		UsuarioOpcionConstantesFunciones.InicializarValoresUsuarioOpcion(usuarioopcionAux,true);
		
		for(UsuarioOpcion usuarioopcion: usuarioopcions) {
			if(usuarioopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUsuarioOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UsuarioOpcionConstantesFunciones.getArrayColumnasGlobalesUsuarioOpcion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUsuarioOpcion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUsuarioOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UsuarioOpcion> usuarioopcions,UsuarioOpcion usuarioopcion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UsuarioOpcion usuarioopcionAux: usuarioopcions) {
			if(usuarioopcionAux!=null && usuarioopcion!=null) {
				if((usuarioopcionAux.getId()==null && usuarioopcion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(usuarioopcionAux.getId()!=null && usuarioopcion.getId()!=null){
					if(usuarioopcionAux.getId().equals(usuarioopcion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUsuarioOpcion(List<UsuarioOpcion> usuarioopcions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(UsuarioOpcion usuarioopcion: usuarioopcions) {			
			if(usuarioopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUsuarioOpcion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_ID, UsuarioOpcionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_VERSIONROW, UsuarioOpcionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDSISTEMA, UsuarioOpcionConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDMODULO, UsuarioOpcionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDGRUPOOPCION, UsuarioOpcionConstantesFunciones.IDGRUPOOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDOPCION, UsuarioOpcionConstantesFunciones.IDOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDPERFIL, UsuarioOpcionConstantesFunciones.IDPERFIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_IDUSUARIO, UsuarioOpcionConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_CONPRECARGAR, UsuarioOpcionConstantesFunciones.CONPRECARGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioOpcionConstantesFunciones.LABEL_ESTADO, UsuarioOpcionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUsuarioOpcion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDGRUPOOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDPERFIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.CONPRECARGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioOpcionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuarioOpcion() throws Exception  {
		return UsuarioOpcionConstantesFunciones.getTiposSeleccionarUsuarioOpcion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuarioOpcion(Boolean conFk) throws Exception  {
		return UsuarioOpcionConstantesFunciones.getTiposSeleccionarUsuarioOpcion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuarioOpcion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDOPCION);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDPERFIL);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDPERFIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_CONPRECARGAR);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_CONPRECARGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioOpcionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(UsuarioOpcionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUsuarioOpcion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUsuarioOpcion(UsuarioOpcion usuarioopcionAux) throws Exception {
		
			usuarioopcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(usuarioopcionAux.getSistema()));
			usuarioopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(usuarioopcionAux.getModulo()));
			usuarioopcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(usuarioopcionAux.getGrupoOpcion()));
			usuarioopcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(usuarioopcionAux.getOpcion()));
			usuarioopcionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(usuarioopcionAux.getPerfil()));
			usuarioopcionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(usuarioopcionAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUsuarioOpcion(List<UsuarioOpcion> usuarioopcionsTemp) throws Exception {
		for(UsuarioOpcion usuarioopcionAux:usuarioopcionsTemp) {
			
			usuarioopcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(usuarioopcionAux.getSistema()));
			usuarioopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(usuarioopcionAux.getModulo()));
			usuarioopcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(usuarioopcionAux.getGrupoOpcion()));
			usuarioopcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(usuarioopcionAux.getOpcion()));
			usuarioopcionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(usuarioopcionAux.getPerfil()));
			usuarioopcionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(usuarioopcionAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUsuarioOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(GrupoOpcion.class));
				classes.add(new Classe(Opcion.class));
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sistema.class)) {
						classes.add(new Classe(Sistema.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoOpcion.class)) {
						classes.add(new Classe(GrupoOpcion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUsuarioOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(GrupoOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(GrupoOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuarioOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UsuarioOpcionConstantesFunciones.getClassesRelationshipsOfUsuarioOpcion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuarioOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUsuarioOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UsuarioOpcionConstantesFunciones.getClassesRelationshipsFromStringsOfUsuarioOpcion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUsuarioOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UsuarioOpcion usuarioopcion,List<UsuarioOpcion> usuarioopcions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UsuarioOpcion usuarioopcionEncontrado=null;
			
			for(UsuarioOpcion usuarioopcionLocal:usuarioopcions) {
				if(usuarioopcionLocal.getId().equals(usuarioopcion.getId())) {
					usuarioopcionEncontrado=usuarioopcionLocal;
					
					usuarioopcionLocal.setIsChanged(usuarioopcion.getIsChanged());
					usuarioopcionLocal.setIsNew(usuarioopcion.getIsNew());
					usuarioopcionLocal.setIsDeleted(usuarioopcion.getIsDeleted());
					
					usuarioopcionLocal.setGeneralEntityOriginal(usuarioopcion.getGeneralEntityOriginal());
					
					usuarioopcionLocal.setId(usuarioopcion.getId());	
					usuarioopcionLocal.setVersionRow(usuarioopcion.getVersionRow());	
					usuarioopcionLocal.setid_sistema(usuarioopcion.getid_sistema());	
					usuarioopcionLocal.setid_modulo(usuarioopcion.getid_modulo());	
					usuarioopcionLocal.setid_grupo_opcion(usuarioopcion.getid_grupo_opcion());	
					usuarioopcionLocal.setid_opcion(usuarioopcion.getid_opcion());	
					usuarioopcionLocal.setid_perfil(usuarioopcion.getid_perfil());	
					usuarioopcionLocal.setid_usuario(usuarioopcion.getid_usuario());	
					usuarioopcionLocal.setcon_precargar(usuarioopcion.getcon_precargar());	
					usuarioopcionLocal.setestado(usuarioopcion.getestado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!usuarioopcion.getIsDeleted()) {
				if(!existe) {
					usuarioopcions.add(usuarioopcion);
				}
			} else {
				if(usuarioopcionEncontrado!=null && permiteQuitar)  {
					usuarioopcions.remove(usuarioopcionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UsuarioOpcion usuarioopcion,List<UsuarioOpcion> usuarioopcions) throws Exception {
		try	{			
			for(UsuarioOpcion usuarioopcionLocal:usuarioopcions) {
				if(usuarioopcionLocal.getId().equals(usuarioopcion.getId())) {
					usuarioopcionLocal.setIsSelected(usuarioopcion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUsuarioOpcion(List<UsuarioOpcion> usuarioopcionsAux) throws Exception {
		//this.usuarioopcionsAux=usuarioopcionsAux;
		
		for(UsuarioOpcion usuarioopcionAux:usuarioopcionsAux) {
			if(usuarioopcionAux.getIsChanged()) {
				usuarioopcionAux.setIsChanged(false);
			}		
			
			if(usuarioopcionAux.getIsNew()) {
				usuarioopcionAux.setIsNew(false);
			}	
			
			if(usuarioopcionAux.getIsDeleted()) {
				usuarioopcionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUsuarioOpcion(UsuarioOpcion usuarioopcionAux) throws Exception {
		//this.usuarioopcionAux=usuarioopcionAux;
		
			if(usuarioopcionAux.getIsChanged()) {
				usuarioopcionAux.setIsChanged(false);
			}		
			
			if(usuarioopcionAux.getIsNew()) {
				usuarioopcionAux.setIsNew(false);
			}	
			
			if(usuarioopcionAux.getIsDeleted()) {
				usuarioopcionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UsuarioOpcion usuarioopcionAsignar,UsuarioOpcion usuarioopcion) throws Exception {
		usuarioopcionAsignar.setId(usuarioopcion.getId());	
		usuarioopcionAsignar.setVersionRow(usuarioopcion.getVersionRow());	
		usuarioopcionAsignar.setid_sistema(usuarioopcion.getid_sistema());
		usuarioopcionAsignar.setsistema_descripcion(usuarioopcion.getsistema_descripcion());	
		usuarioopcionAsignar.setid_modulo(usuarioopcion.getid_modulo());
		usuarioopcionAsignar.setmodulo_descripcion(usuarioopcion.getmodulo_descripcion());	
		usuarioopcionAsignar.setid_grupo_opcion(usuarioopcion.getid_grupo_opcion());
		usuarioopcionAsignar.setgrupoopcion_descripcion(usuarioopcion.getgrupoopcion_descripcion());	
		usuarioopcionAsignar.setid_opcion(usuarioopcion.getid_opcion());
		usuarioopcionAsignar.setopcion_descripcion(usuarioopcion.getopcion_descripcion());	
		usuarioopcionAsignar.setid_perfil(usuarioopcion.getid_perfil());
		usuarioopcionAsignar.setperfil_descripcion(usuarioopcion.getperfil_descripcion());	
		usuarioopcionAsignar.setid_usuario(usuarioopcion.getid_usuario());
		usuarioopcionAsignar.setusuario_descripcion(usuarioopcion.getusuario_descripcion());	
		usuarioopcionAsignar.setcon_precargar(usuarioopcion.getcon_precargar());	
		usuarioopcionAsignar.setestado(usuarioopcion.getestado());	
	}
	
	public static void inicializarUsuarioOpcion(UsuarioOpcion usuarioopcion) throws Exception {
		try {
				usuarioopcion.setId(0L);	
					
				usuarioopcion.setid_sistema(-1L);	
				usuarioopcion.setid_modulo(-1L);	
				usuarioopcion.setid_grupo_opcion(null);	
				usuarioopcion.setid_opcion(-1L);	
				usuarioopcion.setid_perfil(-1L);	
				usuarioopcion.setid_usuario(-1L);	
				usuarioopcion.setcon_precargar(false);	
				usuarioopcion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUsuarioOpcion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDPERFIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_CONPRECARGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioOpcionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUsuarioOpcion(String sTipo,Row row,Workbook workbook,UsuarioOpcion usuarioopcion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getgrupoopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getperfil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuarioopcion.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(usuarioopcion.getcon_precargar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(usuarioopcion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUsuarioOpcion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUsuarioOpcion() {
		return this.sFinalQueryUsuarioOpcion;
	}
	
	public void setsFinalQueryUsuarioOpcion(String sFinalQueryUsuarioOpcion) {
		this.sFinalQueryUsuarioOpcion= sFinalQueryUsuarioOpcion;
	}
	
	public Border resaltarSeleccionarUsuarioOpcion=null;
	
	public Border setResaltarSeleccionarUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUsuarioOpcion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUsuarioOpcion() {
		return this.resaltarSeleccionarUsuarioOpcion;
	}
	
	public void setResaltarSeleccionarUsuarioOpcion(Border borderResaltarSeleccionarUsuarioOpcion) {
		this.resaltarSeleccionarUsuarioOpcion= borderResaltarSeleccionarUsuarioOpcion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUsuarioOpcion=null;
	public Boolean mostraridUsuarioOpcion=true;
	public Boolean activaridUsuarioOpcion=true;

	public Border resaltarid_sistemaUsuarioOpcion=null;
	public Boolean mostrarid_sistemaUsuarioOpcion=true;
	public Boolean activarid_sistemaUsuarioOpcion=true;
	public Boolean cargarid_sistemaUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaUsuarioOpcion=false;//ConEventDepend=true

	public Border resaltarid_moduloUsuarioOpcion=null;
	public Boolean mostrarid_moduloUsuarioOpcion=true;
	public Boolean activarid_moduloUsuarioOpcion=true;
	public Boolean cargarid_moduloUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloUsuarioOpcion=true;//ConEventDepend=true

	public Border resaltarid_grupo_opcionUsuarioOpcion=null;
	public Boolean mostrarid_grupo_opcionUsuarioOpcion=true;
	public Boolean activarid_grupo_opcionUsuarioOpcion=true;
	public Boolean cargarid_grupo_opcionUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_opcionUsuarioOpcion=true;//ConEventDepend=true

	public Border resaltarid_opcionUsuarioOpcion=null;
	public Boolean mostrarid_opcionUsuarioOpcion=true;
	public Boolean activarid_opcionUsuarioOpcion=true;
	public Boolean cargarid_opcionUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_opcionUsuarioOpcion=true;//ConEventDepend=true

	public Border resaltarid_perfilUsuarioOpcion=null;
	public Boolean mostrarid_perfilUsuarioOpcion=true;
	public Boolean activarid_perfilUsuarioOpcion=true;
	public Boolean cargarid_perfilUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_perfilUsuarioOpcion=false;//ConEventDepend=true

	public Border resaltarid_usuarioUsuarioOpcion=null;
	public Boolean mostrarid_usuarioUsuarioOpcion=true;
	public Boolean activarid_usuarioUsuarioOpcion=true;
	public Boolean cargarid_usuarioUsuarioOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioUsuarioOpcion=true;//ConEventDepend=true

	public Border resaltarcon_precargarUsuarioOpcion=null;
	public Boolean mostrarcon_precargarUsuarioOpcion=true;
	public Boolean activarcon_precargarUsuarioOpcion=true;

	public Border resaltarestadoUsuarioOpcion=null;
	public Boolean mostrarestadoUsuarioOpcion=true;
	public Boolean activarestadoUsuarioOpcion=true;

	
	

	public Border setResaltaridUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltaridUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUsuarioOpcion() {
		return this.resaltaridUsuarioOpcion;
	}

	public void setResaltaridUsuarioOpcion(Border borderResaltar) {
		this.resaltaridUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostraridUsuarioOpcion() {
		return this.mostraridUsuarioOpcion;
	}

	public void setMostraridUsuarioOpcion(Boolean mostraridUsuarioOpcion) {
		this.mostraridUsuarioOpcion= mostraridUsuarioOpcion;
	}

	public Boolean getActivaridUsuarioOpcion() {
		return this.activaridUsuarioOpcion;
	}

	public void setActivaridUsuarioOpcion(Boolean activaridUsuarioOpcion) {
		this.activaridUsuarioOpcion= activaridUsuarioOpcion;
	}

	public Border setResaltarid_sistemaUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_sistemaUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaUsuarioOpcion() {
		return this.resaltarid_sistemaUsuarioOpcion;
	}

	public void setResaltarid_sistemaUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_sistemaUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_sistemaUsuarioOpcion() {
		return this.mostrarid_sistemaUsuarioOpcion;
	}

	public void setMostrarid_sistemaUsuarioOpcion(Boolean mostrarid_sistemaUsuarioOpcion) {
		this.mostrarid_sistemaUsuarioOpcion= mostrarid_sistemaUsuarioOpcion;
	}

	public Boolean getActivarid_sistemaUsuarioOpcion() {
		return this.activarid_sistemaUsuarioOpcion;
	}

	public void setActivarid_sistemaUsuarioOpcion(Boolean activarid_sistemaUsuarioOpcion) {
		this.activarid_sistemaUsuarioOpcion= activarid_sistemaUsuarioOpcion;
	}

	public Boolean getCargarid_sistemaUsuarioOpcion() {
		return this.cargarid_sistemaUsuarioOpcion;
	}

	public void setCargarid_sistemaUsuarioOpcion(Boolean cargarid_sistemaUsuarioOpcion) {
		this.cargarid_sistemaUsuarioOpcion= cargarid_sistemaUsuarioOpcion;
	}

	public Border setResaltarid_moduloUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_moduloUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloUsuarioOpcion() {
		return this.resaltarid_moduloUsuarioOpcion;
	}

	public void setResaltarid_moduloUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_moduloUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_moduloUsuarioOpcion() {
		return this.mostrarid_moduloUsuarioOpcion;
	}

	public void setMostrarid_moduloUsuarioOpcion(Boolean mostrarid_moduloUsuarioOpcion) {
		this.mostrarid_moduloUsuarioOpcion= mostrarid_moduloUsuarioOpcion;
	}

	public Boolean getActivarid_moduloUsuarioOpcion() {
		return this.activarid_moduloUsuarioOpcion;
	}

	public void setActivarid_moduloUsuarioOpcion(Boolean activarid_moduloUsuarioOpcion) {
		this.activarid_moduloUsuarioOpcion= activarid_moduloUsuarioOpcion;
	}

	public Boolean getCargarid_moduloUsuarioOpcion() {
		return this.cargarid_moduloUsuarioOpcion;
	}

	public void setCargarid_moduloUsuarioOpcion(Boolean cargarid_moduloUsuarioOpcion) {
		this.cargarid_moduloUsuarioOpcion= cargarid_moduloUsuarioOpcion;
	}

	public Border setResaltarid_grupo_opcionUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_grupo_opcionUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_opcionUsuarioOpcion() {
		return this.resaltarid_grupo_opcionUsuarioOpcion;
	}

	public void setResaltarid_grupo_opcionUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_grupo_opcionUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_grupo_opcionUsuarioOpcion() {
		return this.mostrarid_grupo_opcionUsuarioOpcion;
	}

	public void setMostrarid_grupo_opcionUsuarioOpcion(Boolean mostrarid_grupo_opcionUsuarioOpcion) {
		this.mostrarid_grupo_opcionUsuarioOpcion= mostrarid_grupo_opcionUsuarioOpcion;
	}

	public Boolean getActivarid_grupo_opcionUsuarioOpcion() {
		return this.activarid_grupo_opcionUsuarioOpcion;
	}

	public void setActivarid_grupo_opcionUsuarioOpcion(Boolean activarid_grupo_opcionUsuarioOpcion) {
		this.activarid_grupo_opcionUsuarioOpcion= activarid_grupo_opcionUsuarioOpcion;
	}

	public Boolean getCargarid_grupo_opcionUsuarioOpcion() {
		return this.cargarid_grupo_opcionUsuarioOpcion;
	}

	public void setCargarid_grupo_opcionUsuarioOpcion(Boolean cargarid_grupo_opcionUsuarioOpcion) {
		this.cargarid_grupo_opcionUsuarioOpcion= cargarid_grupo_opcionUsuarioOpcion;
	}

	public Border setResaltarid_opcionUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_opcionUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_opcionUsuarioOpcion() {
		return this.resaltarid_opcionUsuarioOpcion;
	}

	public void setResaltarid_opcionUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_opcionUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_opcionUsuarioOpcion() {
		return this.mostrarid_opcionUsuarioOpcion;
	}

	public void setMostrarid_opcionUsuarioOpcion(Boolean mostrarid_opcionUsuarioOpcion) {
		this.mostrarid_opcionUsuarioOpcion= mostrarid_opcionUsuarioOpcion;
	}

	public Boolean getActivarid_opcionUsuarioOpcion() {
		return this.activarid_opcionUsuarioOpcion;
	}

	public void setActivarid_opcionUsuarioOpcion(Boolean activarid_opcionUsuarioOpcion) {
		this.activarid_opcionUsuarioOpcion= activarid_opcionUsuarioOpcion;
	}

	public Boolean getCargarid_opcionUsuarioOpcion() {
		return this.cargarid_opcionUsuarioOpcion;
	}

	public void setCargarid_opcionUsuarioOpcion(Boolean cargarid_opcionUsuarioOpcion) {
		this.cargarid_opcionUsuarioOpcion= cargarid_opcionUsuarioOpcion;
	}

	public Border setResaltarid_perfilUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_perfilUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_perfilUsuarioOpcion() {
		return this.resaltarid_perfilUsuarioOpcion;
	}

	public void setResaltarid_perfilUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_perfilUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_perfilUsuarioOpcion() {
		return this.mostrarid_perfilUsuarioOpcion;
	}

	public void setMostrarid_perfilUsuarioOpcion(Boolean mostrarid_perfilUsuarioOpcion) {
		this.mostrarid_perfilUsuarioOpcion= mostrarid_perfilUsuarioOpcion;
	}

	public Boolean getActivarid_perfilUsuarioOpcion() {
		return this.activarid_perfilUsuarioOpcion;
	}

	public void setActivarid_perfilUsuarioOpcion(Boolean activarid_perfilUsuarioOpcion) {
		this.activarid_perfilUsuarioOpcion= activarid_perfilUsuarioOpcion;
	}

	public Boolean getCargarid_perfilUsuarioOpcion() {
		return this.cargarid_perfilUsuarioOpcion;
	}

	public void setCargarid_perfilUsuarioOpcion(Boolean cargarid_perfilUsuarioOpcion) {
		this.cargarid_perfilUsuarioOpcion= cargarid_perfilUsuarioOpcion;
	}

	public Border setResaltarid_usuarioUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarid_usuarioUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioUsuarioOpcion() {
		return this.resaltarid_usuarioUsuarioOpcion;
	}

	public void setResaltarid_usuarioUsuarioOpcion(Border borderResaltar) {
		this.resaltarid_usuarioUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarid_usuarioUsuarioOpcion() {
		return this.mostrarid_usuarioUsuarioOpcion;
	}

	public void setMostrarid_usuarioUsuarioOpcion(Boolean mostrarid_usuarioUsuarioOpcion) {
		this.mostrarid_usuarioUsuarioOpcion= mostrarid_usuarioUsuarioOpcion;
	}

	public Boolean getActivarid_usuarioUsuarioOpcion() {
		return this.activarid_usuarioUsuarioOpcion;
	}

	public void setActivarid_usuarioUsuarioOpcion(Boolean activarid_usuarioUsuarioOpcion) {
		this.activarid_usuarioUsuarioOpcion= activarid_usuarioUsuarioOpcion;
	}

	public Boolean getCargarid_usuarioUsuarioOpcion() {
		return this.cargarid_usuarioUsuarioOpcion;
	}

	public void setCargarid_usuarioUsuarioOpcion(Boolean cargarid_usuarioUsuarioOpcion) {
		this.cargarid_usuarioUsuarioOpcion= cargarid_usuarioUsuarioOpcion;
	}

	public Border setResaltarcon_precargarUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarcon_precargarUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precargarUsuarioOpcion() {
		return this.resaltarcon_precargarUsuarioOpcion;
	}

	public void setResaltarcon_precargarUsuarioOpcion(Border borderResaltar) {
		this.resaltarcon_precargarUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarcon_precargarUsuarioOpcion() {
		return this.mostrarcon_precargarUsuarioOpcion;
	}

	public void setMostrarcon_precargarUsuarioOpcion(Boolean mostrarcon_precargarUsuarioOpcion) {
		this.mostrarcon_precargarUsuarioOpcion= mostrarcon_precargarUsuarioOpcion;
	}

	public Boolean getActivarcon_precargarUsuarioOpcion() {
		return this.activarcon_precargarUsuarioOpcion;
	}

	public void setActivarcon_precargarUsuarioOpcion(Boolean activarcon_precargarUsuarioOpcion) {
		this.activarcon_precargarUsuarioOpcion= activarcon_precargarUsuarioOpcion;
	}

	public Border setResaltarestadoUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioopcionBeanSwingJInternalFrame.jTtoolBarUsuarioOpcion.setBorder(borderResaltar);
		
		this.resaltarestadoUsuarioOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoUsuarioOpcion() {
		return this.resaltarestadoUsuarioOpcion;
	}

	public void setResaltarestadoUsuarioOpcion(Border borderResaltar) {
		this.resaltarestadoUsuarioOpcion= borderResaltar;
	}

	public Boolean getMostrarestadoUsuarioOpcion() {
		return this.mostrarestadoUsuarioOpcion;
	}

	public void setMostrarestadoUsuarioOpcion(Boolean mostrarestadoUsuarioOpcion) {
		this.mostrarestadoUsuarioOpcion= mostrarestadoUsuarioOpcion;
	}

	public Boolean getActivarestadoUsuarioOpcion() {
		return this.activarestadoUsuarioOpcion;
	}

	public void setActivarestadoUsuarioOpcion(Boolean activarestadoUsuarioOpcion) {
		this.activarestadoUsuarioOpcion= activarestadoUsuarioOpcion;
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
		
		
		this.setMostraridUsuarioOpcion(esInicial);
		this.setMostrarid_sistemaUsuarioOpcion(esInicial);
		this.setMostrarid_moduloUsuarioOpcion(esInicial);
		this.setMostrarid_grupo_opcionUsuarioOpcion(esInicial);
		this.setMostrarid_opcionUsuarioOpcion(esInicial);
		this.setMostrarid_perfilUsuarioOpcion(esInicial);
		this.setMostrarid_usuarioUsuarioOpcion(esInicial);
		this.setMostrarcon_precargarUsuarioOpcion(esInicial);
		this.setMostrarestadoUsuarioOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ID)) {
				this.setMostraridUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setMostrarid_grupo_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDOPCION)) {
				this.setMostrarid_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDPERFIL)) {
				this.setMostrarid_perfilUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setMostrarcon_precargarUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoUsuarioOpcion(esAsigna);
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
		
		
		this.setActivaridUsuarioOpcion(esInicial);
		this.setActivarid_sistemaUsuarioOpcion(esInicial);
		this.setActivarid_moduloUsuarioOpcion(esInicial);
		this.setActivarid_grupo_opcionUsuarioOpcion(esInicial);
		this.setActivarid_opcionUsuarioOpcion(esInicial);
		this.setActivarid_perfilUsuarioOpcion(esInicial);
		this.setActivarid_usuarioUsuarioOpcion(esInicial);
		this.setActivarcon_precargarUsuarioOpcion(esInicial);
		this.setActivarestadoUsuarioOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ID)) {
				this.setActivaridUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setActivarid_grupo_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDOPCION)) {
				this.setActivarid_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDPERFIL)) {
				this.setActivarid_perfilUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setActivarcon_precargarUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ESTADO)) {
				this.setActivarestadoUsuarioOpcion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUsuarioOpcion(esInicial);
		this.setResaltarid_sistemaUsuarioOpcion(esInicial);
		this.setResaltarid_moduloUsuarioOpcion(esInicial);
		this.setResaltarid_grupo_opcionUsuarioOpcion(esInicial);
		this.setResaltarid_opcionUsuarioOpcion(esInicial);
		this.setResaltarid_perfilUsuarioOpcion(esInicial);
		this.setResaltarid_usuarioUsuarioOpcion(esInicial);
		this.setResaltarcon_precargarUsuarioOpcion(esInicial);
		this.setResaltarestadoUsuarioOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ID)) {
				this.setResaltaridUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setResaltarid_grupo_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDOPCION)) {
				this.setResaltarid_opcionUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDPERFIL)) {
				this.setResaltarid_perfilUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setResaltarcon_precargarUsuarioOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioOpcionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoUsuarioOpcion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdGrupoOpcionUsuarioOpcion=true;

	public Boolean getMostrarFK_IdGrupoOpcionUsuarioOpcion() {
		return this.mostrarFK_IdGrupoOpcionUsuarioOpcion;
	}

	public void setMostrarFK_IdGrupoOpcionUsuarioOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoOpcionUsuarioOpcion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPerfilUsuarioOpcion=true;

	public Boolean getMostrarFK_IdPerfilUsuarioOpcion() {
		return this.mostrarFK_IdPerfilUsuarioOpcion;
	}

	public void setMostrarFK_IdPerfilUsuarioOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPerfilUsuarioOpcion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdGrupoOpcionUsuarioOpcion=true;

	public Boolean getActivarFK_IdGrupoOpcionUsuarioOpcion() {
		return this.activarFK_IdGrupoOpcionUsuarioOpcion;
	}

	public void setActivarFK_IdGrupoOpcionUsuarioOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoOpcionUsuarioOpcion= habilitarResaltar;
	}

	public Boolean activarFK_IdPerfilUsuarioOpcion=true;

	public Boolean getActivarFK_IdPerfilUsuarioOpcion() {
		return this.activarFK_IdPerfilUsuarioOpcion;
	}

	public void setActivarFK_IdPerfilUsuarioOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdPerfilUsuarioOpcion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdGrupoOpcionUsuarioOpcion=null;

	public Border getResaltarFK_IdGrupoOpcionUsuarioOpcion() {
		return this.resaltarFK_IdGrupoOpcionUsuarioOpcion;
	}

	public void setResaltarFK_IdGrupoOpcionUsuarioOpcion(Border borderResaltar) {
		this.resaltarFK_IdGrupoOpcionUsuarioOpcion= borderResaltar;
	}

	public void setResaltarFK_IdGrupoOpcionUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoOpcionUsuarioOpcion= borderResaltar;
	}

	public Border resaltarFK_IdPerfilUsuarioOpcion=null;

	public Border getResaltarFK_IdPerfilUsuarioOpcion() {
		return this.resaltarFK_IdPerfilUsuarioOpcion;
	}

	public void setResaltarFK_IdPerfilUsuarioOpcion(Border borderResaltar) {
		this.resaltarFK_IdPerfilUsuarioOpcion= borderResaltar;
	}

	public void setResaltarFK_IdPerfilUsuarioOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioOpcionBeanSwingJInternalFrame usuarioopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPerfilUsuarioOpcion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}