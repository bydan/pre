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


import com.bydan.erp.seguridad.util.PerfilUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilUsuarioParameterGeneral;

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
final public class PerfilUsuarioConstantesFunciones extends PerfilUsuarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PerfilUsuario";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PerfilUsuario"+PerfilUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PerfilUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PerfilUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PerfilUsuarioConstantesFunciones.SCHEMA+"_"+PerfilUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PerfilUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PerfilUsuarioConstantesFunciones.SCHEMA+"_"+PerfilUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PerfilUsuarioConstantesFunciones.SCHEMA+"_"+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PerfilUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PerfilUsuarioConstantesFunciones.SCHEMA+"_"+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PerfilUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PerfilUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PerfilUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PerfilUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Usuarios Perfiles s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Usuarios Perfiles ";
	public static final String SCLASSWEBTITULO_LOWER="Perfil Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PerfilUsuario";
	public static final String OBJECTNAME="perfilusuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="perfil_usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select perfilusuario from "+PerfilUsuarioConstantesFunciones.SPERSISTENCENAME+" perfilusuario";
	public static String QUERYSELECTNATIVE="select "+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME+".id,"+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME+".version_row,"+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME+".id_perfil,"+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME+".estado from "+PerfilUsuarioConstantesFunciones.SCHEMA+"."+PerfilUsuarioConstantesFunciones.TABLENAME;//+" as "+PerfilUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PerfilUsuarioConstantesFuncionesAdditional perfilusuarioConstantesFuncionesAdditional=null;
	
	public PerfilUsuarioConstantesFuncionesAdditional getPerfilUsuarioConstantesFuncionesAdditional() {
		return this.perfilusuarioConstantesFuncionesAdditional;
	}
	
	public void setPerfilUsuarioConstantesFuncionesAdditional(PerfilUsuarioConstantesFuncionesAdditional perfilusuarioConstantesFuncionesAdditional) {
		try {
			this.perfilusuarioConstantesFuncionesAdditional=perfilusuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPERFIL= "id_perfil";
    public static final String IDUSUARIO= "id_usuario";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPERFIL= "Perfil";
		public static final String LABEL_IDPERFIL_LOWER= "Perfil";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
	
	public static String getPerfilUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PerfilUsuarioConstantesFunciones.IDPERFIL)) {sLabelColumna=PerfilUsuarioConstantesFunciones.LABEL_IDPERFIL;}
		if(sNombreColumna.equals(PerfilUsuarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=PerfilUsuarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PerfilUsuarioConstantesFunciones.ESTADO)) {sLabelColumna=PerfilUsuarioConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
		
	public static String getestadoDescripcion(PerfilUsuario perfilusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilusuario.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(PerfilUsuario perfilusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilusuario.getId(),perfilusuario.getestado());

		return sDescripcion;
	}	
	
	public static String getPerfilUsuarioDescripcion(PerfilUsuario perfilusuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(perfilusuario !=null/* && perfilusuario.getId()!=0*/) {
			if(perfilusuario.getId()!=null) {
				sDescripcion=perfilusuario.getId().toString();
			}//perfilusuarioperfilusuario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPerfilUsuarioDescripcionDetallado(PerfilUsuario perfilusuario) {
		String sDescripcion="";
			
		sDescripcion+=PerfilUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=perfilusuario.getId().toString()+",";
		sDescripcion+=PerfilUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=perfilusuario.getVersionRow().toString()+",";
		sDescripcion+=PerfilUsuarioConstantesFunciones.IDPERFIL+"=";
		sDescripcion+=perfilusuario.getid_perfil().toString()+",";
		sDescripcion+=PerfilUsuarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=perfilusuario.getid_usuario().toString()+",";
		sDescripcion+=PerfilUsuarioConstantesFunciones.ESTADO+"=";
		sDescripcion+=perfilusuario.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPerfilUsuarioDescripcion(PerfilUsuario perfilusuario,String sValor) throws Exception {			
		if(perfilusuario !=null) {
			//perfilusuarioperfilusuario.getId().toString();
		}		
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
		} else if(sNombreIndice.equals("FK_IdPerfil")) {
			sNombreIndice="Tipo=  Por Perfil";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPerfil(Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPerfilUsuario(PerfilUsuario perfilusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPerfilUsuarios(List<PerfilUsuario> perfilusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PerfilUsuario perfilusuario: perfilusuarios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilUsuario(PerfilUsuario perfilusuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && perfilusuario.getConCambioAuxiliar()) {
			perfilusuario.setIsDeleted(perfilusuario.getIsDeletedAuxiliar());	
			perfilusuario.setIsNew(perfilusuario.getIsNewAuxiliar());	
			perfilusuario.setIsChanged(perfilusuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			perfilusuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			perfilusuario.setIsDeletedAuxiliar(false);	
			perfilusuario.setIsNewAuxiliar(false);	
			perfilusuario.setIsChangedAuxiliar(false);
			
			perfilusuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilUsuarios(List<PerfilUsuario> perfilusuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PerfilUsuario perfilusuario : perfilusuarios) {
			if(conAsignarBase && perfilusuario.getConCambioAuxiliar()) {
				perfilusuario.setIsDeleted(perfilusuario.getIsDeletedAuxiliar());	
				perfilusuario.setIsNew(perfilusuario.getIsNewAuxiliar());	
				perfilusuario.setIsChanged(perfilusuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				perfilusuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				perfilusuario.setIsDeletedAuxiliar(false);	
				perfilusuario.setIsNewAuxiliar(false);	
				perfilusuario.setIsChangedAuxiliar(false);
				
				perfilusuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPerfilUsuario(PerfilUsuario perfilusuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPerfilUsuarios(List<PerfilUsuario> perfilusuarios,Boolean conEnteros) throws Exception  {
		
		for(PerfilUsuario perfilusuario: perfilusuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPerfilUsuario(List<PerfilUsuario> perfilusuarios,PerfilUsuario perfilusuarioAux) throws Exception  {
		PerfilUsuarioConstantesFunciones.InicializarValoresPerfilUsuario(perfilusuarioAux,true);
		
		for(PerfilUsuario perfilusuario: perfilusuarios) {
			if(perfilusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PerfilUsuarioConstantesFunciones.getArrayColumnasGlobalesPerfilUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PerfilUsuarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PerfilUsuarioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPerfilUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PerfilUsuario> perfilusuarios,PerfilUsuario perfilusuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PerfilUsuario perfilusuarioAux: perfilusuarios) {
			if(perfilusuarioAux!=null && perfilusuario!=null) {
				if((perfilusuarioAux.getId()==null && perfilusuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(perfilusuarioAux.getId()!=null && perfilusuario.getId()!=null){
					if(perfilusuarioAux.getId().equals(perfilusuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPerfilUsuario(List<PerfilUsuario> perfilusuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PerfilUsuario perfilusuario: perfilusuarios) {			
			if(perfilusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPerfilUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PerfilUsuarioConstantesFunciones.LABEL_ID, PerfilUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilUsuarioConstantesFunciones.LABEL_VERSIONROW, PerfilUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilUsuarioConstantesFunciones.LABEL_IDPERFIL, PerfilUsuarioConstantesFunciones.IDPERFIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilUsuarioConstantesFunciones.LABEL_IDUSUARIO, PerfilUsuarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilUsuarioConstantesFunciones.LABEL_ESTADO, PerfilUsuarioConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPerfilUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PerfilUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilUsuarioConstantesFunciones.IDPERFIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilUsuarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilUsuarioConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilUsuario() throws Exception  {
		return PerfilUsuarioConstantesFunciones.getTiposSeleccionarPerfilUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilUsuario(Boolean conFk) throws Exception  {
		return PerfilUsuarioConstantesFunciones.getTiposSeleccionarPerfilUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilUsuarioConstantesFunciones.LABEL_IDPERFIL);
			reporte.setsDescripcion(PerfilUsuarioConstantesFunciones.LABEL_IDPERFIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilUsuarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PerfilUsuarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilUsuarioConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PerfilUsuarioConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPerfilUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilUsuario(PerfilUsuario perfilusuarioAux) throws Exception {
		
			perfilusuarioAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilusuarioAux.getPerfil()));
			perfilusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(perfilusuarioAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilUsuario(List<PerfilUsuario> perfilusuariosTemp) throws Exception {
		for(PerfilUsuario perfilusuarioAux:perfilusuariosTemp) {
			
			perfilusuarioAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilusuarioAux.getPerfil()));
			perfilusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(perfilusuarioAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPerfilUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilUsuarioConstantesFunciones.getClassesRelationshipsOfPerfilUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfPerfilUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PerfilUsuario perfilusuario,List<PerfilUsuario> perfilusuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PerfilUsuario perfilusuarioEncontrado=null;
			
			for(PerfilUsuario perfilusuarioLocal:perfilusuarios) {
				if(perfilusuarioLocal.getId().equals(perfilusuario.getId())) {
					perfilusuarioEncontrado=perfilusuarioLocal;
					
					perfilusuarioLocal.setIsChanged(perfilusuario.getIsChanged());
					perfilusuarioLocal.setIsNew(perfilusuario.getIsNew());
					perfilusuarioLocal.setIsDeleted(perfilusuario.getIsDeleted());
					
					perfilusuarioLocal.setGeneralEntityOriginal(perfilusuario.getGeneralEntityOriginal());
					
					perfilusuarioLocal.setId(perfilusuario.getId());	
					perfilusuarioLocal.setVersionRow(perfilusuario.getVersionRow());	
					perfilusuarioLocal.setid_perfil(perfilusuario.getid_perfil());	
					perfilusuarioLocal.setid_usuario(perfilusuario.getid_usuario());	
					perfilusuarioLocal.setestado(perfilusuario.getestado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!perfilusuario.getIsDeleted()) {
				if(!existe) {
					perfilusuarios.add(perfilusuario);
				}
			} else {
				if(perfilusuarioEncontrado!=null && permiteQuitar)  {
					perfilusuarios.remove(perfilusuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PerfilUsuario perfilusuario,List<PerfilUsuario> perfilusuarios) throws Exception {
		try	{			
			for(PerfilUsuario perfilusuarioLocal:perfilusuarios) {
				if(perfilusuarioLocal.getId().equals(perfilusuario.getId())) {
					perfilusuarioLocal.setIsSelected(perfilusuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPerfilUsuario(List<PerfilUsuario> perfilusuariosAux) throws Exception {
		//this.perfilusuariosAux=perfilusuariosAux;
		
		for(PerfilUsuario perfilusuarioAux:perfilusuariosAux) {
			if(perfilusuarioAux.getIsChanged()) {
				perfilusuarioAux.setIsChanged(false);
			}		
			
			if(perfilusuarioAux.getIsNew()) {
				perfilusuarioAux.setIsNew(false);
			}	
			
			if(perfilusuarioAux.getIsDeleted()) {
				perfilusuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPerfilUsuario(PerfilUsuario perfilusuarioAux) throws Exception {
		//this.perfilusuarioAux=perfilusuarioAux;
		
			if(perfilusuarioAux.getIsChanged()) {
				perfilusuarioAux.setIsChanged(false);
			}		
			
			if(perfilusuarioAux.getIsNew()) {
				perfilusuarioAux.setIsNew(false);
			}	
			
			if(perfilusuarioAux.getIsDeleted()) {
				perfilusuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PerfilUsuario perfilusuarioAsignar,PerfilUsuario perfilusuario) throws Exception {
		perfilusuarioAsignar.setId(perfilusuario.getId());	
		perfilusuarioAsignar.setVersionRow(perfilusuario.getVersionRow());	
		perfilusuarioAsignar.setid_perfil(perfilusuario.getid_perfil());
		perfilusuarioAsignar.setperfil_descripcion(perfilusuario.getperfil_descripcion());	
		perfilusuarioAsignar.setid_usuario(perfilusuario.getid_usuario());
		perfilusuarioAsignar.setusuario_descripcion(perfilusuario.getusuario_descripcion());	
		perfilusuarioAsignar.setestado(perfilusuario.getestado());	
	}
	
	public static void inicializarPerfilUsuario(PerfilUsuario perfilusuario) throws Exception {
		try {
				perfilusuario.setId(0L);	
					
				perfilusuario.setid_perfil(-1L);	
				perfilusuario.setid_usuario(-1L);	
				perfilusuario.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPerfilUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilUsuarioConstantesFunciones.LABEL_IDPERFIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilUsuarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilUsuarioConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPerfilUsuario(String sTipo,Row row,Workbook workbook,PerfilUsuario perfilusuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilusuario.getperfil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilusuario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilusuario.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPerfilUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPerfilUsuario() {
		return this.sFinalQueryPerfilUsuario;
	}
	
	public void setsFinalQueryPerfilUsuario(String sFinalQueryPerfilUsuario) {
		this.sFinalQueryPerfilUsuario= sFinalQueryPerfilUsuario;
	}
	
	public Border resaltarSeleccionarPerfilUsuario=null;
	
	public Border setResaltarSeleccionarPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//perfilusuarioBeanSwingJInternalFrame.jTtoolBarPerfilUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPerfilUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPerfilUsuario() {
		return this.resaltarSeleccionarPerfilUsuario;
	}
	
	public void setResaltarSeleccionarPerfilUsuario(Border borderResaltarSeleccionarPerfilUsuario) {
		this.resaltarSeleccionarPerfilUsuario= borderResaltarSeleccionarPerfilUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPerfilUsuario=null;
	public Boolean mostraridPerfilUsuario=true;
	public Boolean activaridPerfilUsuario=true;

	public Border resaltarid_perfilPerfilUsuario=null;
	public Boolean mostrarid_perfilPerfilUsuario=true;
	public Boolean activarid_perfilPerfilUsuario=true;
	public Boolean cargarid_perfilPerfilUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_perfilPerfilUsuario=false;//ConEventDepend=true

	public Border resaltarid_usuarioPerfilUsuario=null;
	public Boolean mostrarid_usuarioPerfilUsuario=true;
	public Boolean activarid_usuarioPerfilUsuario=true;
	public Boolean cargarid_usuarioPerfilUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPerfilUsuario=false;//ConEventDepend=true

	public Border resaltarestadoPerfilUsuario=null;
	public Boolean mostrarestadoPerfilUsuario=true;
	public Boolean activarestadoPerfilUsuario=true;

	
	

	public Border setResaltaridPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilusuarioBeanSwingJInternalFrame.jTtoolBarPerfilUsuario.setBorder(borderResaltar);
		
		this.resaltaridPerfilUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPerfilUsuario() {
		return this.resaltaridPerfilUsuario;
	}

	public void setResaltaridPerfilUsuario(Border borderResaltar) {
		this.resaltaridPerfilUsuario= borderResaltar;
	}

	public Boolean getMostraridPerfilUsuario() {
		return this.mostraridPerfilUsuario;
	}

	public void setMostraridPerfilUsuario(Boolean mostraridPerfilUsuario) {
		this.mostraridPerfilUsuario= mostraridPerfilUsuario;
	}

	public Boolean getActivaridPerfilUsuario() {
		return this.activaridPerfilUsuario;
	}

	public void setActivaridPerfilUsuario(Boolean activaridPerfilUsuario) {
		this.activaridPerfilUsuario= activaridPerfilUsuario;
	}

	public Border setResaltarid_perfilPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilusuarioBeanSwingJInternalFrame.jTtoolBarPerfilUsuario.setBorder(borderResaltar);
		
		this.resaltarid_perfilPerfilUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_perfilPerfilUsuario() {
		return this.resaltarid_perfilPerfilUsuario;
	}

	public void setResaltarid_perfilPerfilUsuario(Border borderResaltar) {
		this.resaltarid_perfilPerfilUsuario= borderResaltar;
	}

	public Boolean getMostrarid_perfilPerfilUsuario() {
		return this.mostrarid_perfilPerfilUsuario;
	}

	public void setMostrarid_perfilPerfilUsuario(Boolean mostrarid_perfilPerfilUsuario) {
		this.mostrarid_perfilPerfilUsuario= mostrarid_perfilPerfilUsuario;
	}

	public Boolean getActivarid_perfilPerfilUsuario() {
		return this.activarid_perfilPerfilUsuario;
	}

	public void setActivarid_perfilPerfilUsuario(Boolean activarid_perfilPerfilUsuario) {
		this.activarid_perfilPerfilUsuario= activarid_perfilPerfilUsuario;
	}

	public Boolean getCargarid_perfilPerfilUsuario() {
		return this.cargarid_perfilPerfilUsuario;
	}

	public void setCargarid_perfilPerfilUsuario(Boolean cargarid_perfilPerfilUsuario) {
		this.cargarid_perfilPerfilUsuario= cargarid_perfilPerfilUsuario;
	}

	public Border setResaltarid_usuarioPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilusuarioBeanSwingJInternalFrame.jTtoolBarPerfilUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPerfilUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPerfilUsuario() {
		return this.resaltarid_usuarioPerfilUsuario;
	}

	public void setResaltarid_usuarioPerfilUsuario(Border borderResaltar) {
		this.resaltarid_usuarioPerfilUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPerfilUsuario() {
		return this.mostrarid_usuarioPerfilUsuario;
	}

	public void setMostrarid_usuarioPerfilUsuario(Boolean mostrarid_usuarioPerfilUsuario) {
		this.mostrarid_usuarioPerfilUsuario= mostrarid_usuarioPerfilUsuario;
	}

	public Boolean getActivarid_usuarioPerfilUsuario() {
		return this.activarid_usuarioPerfilUsuario;
	}

	public void setActivarid_usuarioPerfilUsuario(Boolean activarid_usuarioPerfilUsuario) {
		this.activarid_usuarioPerfilUsuario= activarid_usuarioPerfilUsuario;
	}

	public Boolean getCargarid_usuarioPerfilUsuario() {
		return this.cargarid_usuarioPerfilUsuario;
	}

	public void setCargarid_usuarioPerfilUsuario(Boolean cargarid_usuarioPerfilUsuario) {
		this.cargarid_usuarioPerfilUsuario= cargarid_usuarioPerfilUsuario;
	}

	public Border setResaltarestadoPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilusuarioBeanSwingJInternalFrame.jTtoolBarPerfilUsuario.setBorder(borderResaltar);
		
		this.resaltarestadoPerfilUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPerfilUsuario() {
		return this.resaltarestadoPerfilUsuario;
	}

	public void setResaltarestadoPerfilUsuario(Border borderResaltar) {
		this.resaltarestadoPerfilUsuario= borderResaltar;
	}

	public Boolean getMostrarestadoPerfilUsuario() {
		return this.mostrarestadoPerfilUsuario;
	}

	public void setMostrarestadoPerfilUsuario(Boolean mostrarestadoPerfilUsuario) {
		this.mostrarestadoPerfilUsuario= mostrarestadoPerfilUsuario;
	}

	public Boolean getActivarestadoPerfilUsuario() {
		return this.activarestadoPerfilUsuario;
	}

	public void setActivarestadoPerfilUsuario(Boolean activarestadoPerfilUsuario) {
		this.activarestadoPerfilUsuario= activarestadoPerfilUsuario;
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
		
		
		this.setMostraridPerfilUsuario(esInicial);
		this.setMostrarid_perfilPerfilUsuario(esInicial);
		this.setMostrarid_usuarioPerfilUsuario(esInicial);
		this.setMostrarestadoPerfilUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ID)) {
				this.setMostraridPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDPERFIL)) {
				this.setMostrarid_perfilPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPerfilUsuario(esAsigna);
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
		
		
		this.setActivaridPerfilUsuario(esInicial);
		this.setActivarid_perfilPerfilUsuario(esInicial);
		this.setActivarid_usuarioPerfilUsuario(esInicial);
		this.setActivarestadoPerfilUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ID)) {
				this.setActivaridPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDPERFIL)) {
				this.setActivarid_perfilPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ESTADO)) {
				this.setActivarestadoPerfilUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPerfilUsuario(esInicial);
		this.setResaltarid_perfilPerfilUsuario(esInicial);
		this.setResaltarid_usuarioPerfilUsuario(esInicial);
		this.setResaltarestadoPerfilUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ID)) {
				this.setResaltaridPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDPERFIL)) {
				this.setResaltarid_perfilPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPerfilUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilUsuarioConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPerfilUsuario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPerfilPerfilUsuario=true;

	public Boolean getMostrarFK_IdPerfilPerfilUsuario() {
		return this.mostrarFK_IdPerfilPerfilUsuario;
	}

	public void setMostrarFK_IdPerfilPerfilUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPerfilPerfilUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPerfilUsuario=true;

	public Boolean getMostrarFK_IdUsuarioPerfilUsuario() {
		return this.mostrarFK_IdUsuarioPerfilUsuario;
	}

	public void setMostrarFK_IdUsuarioPerfilUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPerfilUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPerfilPerfilUsuario=true;

	public Boolean getActivarFK_IdPerfilPerfilUsuario() {
		return this.activarFK_IdPerfilPerfilUsuario;
	}

	public void setActivarFK_IdPerfilPerfilUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdPerfilPerfilUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPerfilUsuario=true;

	public Boolean getActivarFK_IdUsuarioPerfilUsuario() {
		return this.activarFK_IdUsuarioPerfilUsuario;
	}

	public void setActivarFK_IdUsuarioPerfilUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPerfilUsuario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPerfilPerfilUsuario=null;

	public Border getResaltarFK_IdPerfilPerfilUsuario() {
		return this.resaltarFK_IdPerfilPerfilUsuario;
	}

	public void setResaltarFK_IdPerfilPerfilUsuario(Border borderResaltar) {
		this.resaltarFK_IdPerfilPerfilUsuario= borderResaltar;
	}

	public void setResaltarFK_IdPerfilPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPerfilPerfilUsuario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPerfilUsuario=null;

	public Border getResaltarFK_IdUsuarioPerfilUsuario() {
		return this.resaltarFK_IdUsuarioPerfilUsuario;
	}

	public void setResaltarFK_IdUsuarioPerfilUsuario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPerfilUsuario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPerfilUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilUsuarioBeanSwingJInternalFrame perfilusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPerfilUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}