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


import com.bydan.erp.seguridad.util.UsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.UsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UsuarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UsuarioConstantesFunciones extends UsuarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UsuarioFinal";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Usuario"+UsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UsuarioConstantesFunciones.SCHEMA+"_"+UsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UsuarioConstantesFunciones.SCHEMA+"_"+UsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UsuarioConstantesFunciones.SCHEMA+"_"+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UsuarioConstantesFunciones.SCHEMA+"_"+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Usuarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Usuario";
	public static final String SCLASSWEBTITULO_LOWER="Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Usuario";
	public static final String OBJECTNAME="usuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select usuario from "+UsuarioConstantesFunciones.SPERSISTENCENAME+" usuario";
	public static String QUERYSELECTNATIVE="select "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".id,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".version_row,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".id_empresa,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".user_name,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".clave,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".confirmar_clave,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".nombre,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".codigo_alterno,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".tipo,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".estado from "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME;//+" as "+UsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UsuarioConstantesFuncionesAdditional usuarioConstantesFuncionesAdditional=null;
	
	public UsuarioConstantesFuncionesAdditional getUsuarioConstantesFuncionesAdditional() {
		return this.usuarioConstantesFuncionesAdditional;
	}
	
	public void setUsuarioConstantesFuncionesAdditional(UsuarioConstantesFuncionesAdditional usuarioConstantesFuncionesAdditional) {
		try {
			this.usuarioConstantesFuncionesAdditional=usuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String USERNAME= "user_name";
    public static final String CLAVE= "clave";
    public static final String CONFIRMARCLAVE= "confirmar_clave";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOALTERNO= "codigo_alterno";
    public static final String TIPO= "tipo";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_USERNAME= "Nombre Usuario";
		public static final String LABEL_USERNAME_LOWER= "User Name";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_CONFIRMARCLAVE= "Confirmar Clave";
		public static final String LABEL_CONFIRMARCLAVE_LOWER= "Confirmar Clave";
    	public static final String LABEL_NOMBRE= "Nombre Completo";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOALTERNO= "Codigo Alterno";
		public static final String LABEL_CODIGOALTERNO_LOWER= "Codigo Alterno";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
	public static final String SREGEXUSER_NAME=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUSER_NAME=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCONFIRMAR_CLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONFIRMAR_CLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ALTERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ALTERNO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UsuarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.USERNAME)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_USERNAME;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.CLAVE)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.CONFIRMARCLAVE)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_CONFIRMARCLAVE;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.NOMBRE)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.CODIGOALTERNO)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_CODIGOALTERNO;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.TIPO)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_TIPO;}
		if(sNombreColumna.equals(UsuarioConstantesFunciones.ESTADO)) {sLabelColumna=UsuarioConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String gettipoDescripcion(Usuario usuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!usuario.gettipo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettipoHtmlDescripcion(Usuario usuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(usuario.getId(),usuario.gettipo());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(Usuario usuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!usuario.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Usuario usuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(usuario.getId(),usuario.getestado());

		return sDescripcion;
	}	
	
	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(usuario !=null/* && usuario.getId()!=0*/) {
			sDescripcion=usuario.getuser_name();//usuariousuario.getuser_name().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getUsuarioDescripcionDetallado(Usuario usuario) {
		String sDescripcion="";
			
		sDescripcion+=UsuarioConstantesFunciones.ID+"=";
		sDescripcion+=usuario.getId().toString()+",";
		sDescripcion+=UsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=usuario.getVersionRow().toString()+",";
		sDescripcion+=UsuarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=usuario.getid_empresa().toString()+",";
		sDescripcion+=UsuarioConstantesFunciones.USERNAME+"=";
		sDescripcion+=usuario.getuser_name()+",";
		sDescripcion+=UsuarioConstantesFunciones.CLAVE+"=";
		sDescripcion+=usuario.getclave()+",";
		sDescripcion+=UsuarioConstantesFunciones.CONFIRMARCLAVE+"=";
		sDescripcion+=usuario.getconfirmar_clave()+",";
		sDescripcion+=UsuarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=usuario.getnombre()+",";
		sDescripcion+=UsuarioConstantesFunciones.CODIGOALTERNO+"=";
		sDescripcion+=usuario.getcodigo_alterno()+",";
		sDescripcion+=UsuarioConstantesFunciones.TIPO+"=";
		sDescripcion+=usuario.gettipo().toString()+",";
		sDescripcion+=UsuarioConstantesFunciones.ESTADO+"=";
		sDescripcion+=usuario.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUsuarioDescripcion(Usuario usuario,String sValor) throws Exception {			
		if(usuario !=null) {
			usuario.setuser_name(sValor);;//usuariousuario.getuser_name().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre Completo";
		} else if(sNombreIndice.equals("BusquedaPorUserName")) {
			sNombreIndice="Tipo=  Por Nombre Usuario";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorCodigoAlterno")) {
			sNombreIndice="Tipo=  Por Codigo Alterno";
		} else if(sNombreIndice.equals("PorUserName")) {
			sNombreIndice="Tipo=  Por Nombre Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre Completo="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorUserName(String user_name) {
		String sDetalleIndice=" Parametros->";
		if(user_name!=null) {sDetalleIndice+=" Nombre Usuario="+user_name;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorCodigoAlterno(String codigo_alterno) {
		String sDetalleIndice=" Parametros->";
		if(codigo_alterno!=null) {sDetalleIndice+=" Codigo Alterno="+codigo_alterno;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorUserName(String user_name) {
		String sDetalleIndice=" Parametros->";
		if(user_name!=null) {sDetalleIndice+=" Nombre Usuario="+user_name;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUsuario(Usuario usuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		usuario.setuser_name(usuario.getuser_name().trim());
		usuario.setclave(usuario.getclave().trim());
		usuario.setconfirmar_clave(usuario.getconfirmar_clave().trim());
		usuario.setnombre(usuario.getnombre().trim());
		usuario.setcodigo_alterno(usuario.getcodigo_alterno().trim());
	}
	
	public static void quitarEspaciosUsuarios(List<Usuario> usuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Usuario usuario: usuarios) {
			usuario.setuser_name(usuario.getuser_name().trim());
			usuario.setclave(usuario.getclave().trim());
			usuario.setconfirmar_clave(usuario.getconfirmar_clave().trim());
			usuario.setnombre(usuario.getnombre().trim());
			usuario.setcodigo_alterno(usuario.getcodigo_alterno().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUsuario(Usuario usuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && usuario.getConCambioAuxiliar()) {
			usuario.setIsDeleted(usuario.getIsDeletedAuxiliar());	
			usuario.setIsNew(usuario.getIsNewAuxiliar());	
			usuario.setIsChanged(usuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			usuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			usuario.setIsDeletedAuxiliar(false);	
			usuario.setIsNewAuxiliar(false);	
			usuario.setIsChangedAuxiliar(false);
			
			usuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUsuarios(List<Usuario> usuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Usuario usuario : usuarios) {
			if(conAsignarBase && usuario.getConCambioAuxiliar()) {
				usuario.setIsDeleted(usuario.getIsDeletedAuxiliar());	
				usuario.setIsNew(usuario.getIsNewAuxiliar());	
				usuario.setIsChanged(usuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				usuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				usuario.setIsDeletedAuxiliar(false);	
				usuario.setIsNewAuxiliar(false);	
				usuario.setIsChangedAuxiliar(false);
				
				usuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUsuario(Usuario usuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUsuarios(List<Usuario> usuarios,Boolean conEnteros) throws Exception  {
		
		for(Usuario usuario: usuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUsuario(List<Usuario> usuarios,Usuario usuarioAux) throws Exception  {
		UsuarioConstantesFunciones.InicializarValoresUsuario(usuarioAux,true);
		
		for(Usuario usuario: usuarios) {
			if(usuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UsuarioConstantesFunciones.getArrayColumnasGlobalesUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UsuarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UsuarioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Usuario> usuarios,Usuario usuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Usuario usuarioAux: usuarios) {
			if(usuarioAux!=null && usuario!=null) {
				if((usuarioAux.getId()==null && usuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(usuarioAux.getId()!=null && usuario.getId()!=null){
					if(usuarioAux.getId().equals(usuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUsuario(List<Usuario> usuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Usuario usuario: usuarios) {			
			if(usuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_ID, UsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_VERSIONROW, UsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_IDEMPRESA, UsuarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_USERNAME, UsuarioConstantesFunciones.USERNAME,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_CLAVE, UsuarioConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_CONFIRMARCLAVE, UsuarioConstantesFunciones.CONFIRMARCLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_NOMBRE, UsuarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_CODIGOALTERNO, UsuarioConstantesFunciones.CODIGOALTERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_TIPO, UsuarioConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UsuarioConstantesFunciones.LABEL_ESTADO, UsuarioConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.USERNAME;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.CONFIRMARCLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.CODIGOALTERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UsuarioConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuario() throws Exception  {
		return UsuarioConstantesFunciones.getTiposSeleccionarUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuario(Boolean conFk) throws Exception  {
		return UsuarioConstantesFunciones.getTiposSeleccionarUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_USERNAME);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_USERNAME);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_CONFIRMARCLAVE);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_CONFIRMARCLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_CODIGOALTERNO);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_CODIGOALTERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UsuarioConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(UsuarioConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUsuario(Usuario usuarioAux) throws Exception {
		
			usuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(usuarioAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUsuario(List<Usuario> usuariosTemp) throws Exception {
		for(Usuario usuarioAux:usuariosTemp) {
			
			usuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(usuarioAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UsuarioConstantesFunciones.getClassesRelationshipsOfUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DepositoBanco.class));
				classes.add(new Classe(HistorialCambioClave.class));
				classes.add(new Classe(AutoriRetencion.class));
				classes.add(new Classe(CajeroTurno.class));
				classes.add(new Classe(DetalleLiquidacionImpor.class));
				classes.add(new Classe(NotaCreditoSoli.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(DescuentoTipoPrecio.class));
				classes.add(new Classe(GuiaRemision.class));
				classes.add(new Classe(PedidoPuntoVenta.class));
				classes.add(new Classe(GastoEmpleado.class));
				classes.add(new Classe(SecuencialUsuario.class));
				classes.add(new Classe(MovimientoActivoFijo.class));
				classes.add(new Classe(UsuarioOpcion.class));
				classes.add(new Classe(PedidoCompraImpor.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(TurnoPunVen.class));
				classes.add(new Classe(Novedad.class));
				classes.add(new Classe(ParametroGeneralUsuario.class));
				classes.add(new Classe(AutoriPagoOrdenCompra.class));
				classes.add(new Classe(CierreCaja.class));
				classes.add(new Classe(DescuentoMonto.class));
				classes.add(new Classe(CajaEgreso.class));
				classes.add(new Classe(RequisicionCompra.class));
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				classes.add(new Classe(PlaneacionCompra.class));
				classes.add(new Classe(PedidoCompra.class));
				classes.add(new Classe(PerfilUsuario.class));
				classes.add(new Classe(Consignatario.class));
				classes.add(new Classe(Transferencia.class));
				classes.add(new Classe(DatoGeneralUsuario.class));
				classes.add(new Classe(CajaIngreso.class));
				classes.add(new Classe(ClienteCoa.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(DetalleMensajeCorreoInven.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DepositoBanco.class)) {
						classes.add(new Classe(DepositoBanco.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialCambioClave.class)) {
						classes.add(new Classe(HistorialCambioClave.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriRetencion.class)) {
						classes.add(new Classe(AutoriRetencion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajeroTurno.class)) {
						classes.add(new Classe(CajeroTurno.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleLiquidacionImpor.class)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DescuentoTipoPrecio.class)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoEmpleado.class)) {
						classes.add(new Classe(GastoEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SecuencialUsuario.class)) {
						classes.add(new Classe(SecuencialUsuario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoActivoFijo.class)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UsuarioOpcion.class)) {
						classes.add(new Classe(UsuarioOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompraImpor.class)) {
						classes.add(new Classe(PedidoCompraImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TurnoPunVen.class)) {
						classes.add(new Classe(TurnoPunVen.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Novedad.class)) {
						classes.add(new Classe(Novedad.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroGeneralUsuario.class)) {
						classes.add(new Classe(ParametroGeneralUsuario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPagoOrdenCompra.class)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CierreCaja.class)) {
						classes.add(new Classe(CierreCaja.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DescuentoMonto.class)) {
						classes.add(new Classe(DescuentoMonto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaEgreso.class)) {
						classes.add(new Classe(CajaEgreso.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RequisicionCompra.class)) {
						classes.add(new Classe(RequisicionCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PlaneacionCompra.class)) {
						classes.add(new Classe(PlaneacionCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompra.class)) {
						classes.add(new Classe(PedidoCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilUsuario.class)) {
						classes.add(new Classe(PerfilUsuario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignatario.class)) {
						classes.add(new Classe(Consignatario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transferencia.class)) {
						classes.add(new Classe(Transferencia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralUsuario.class)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaIngreso.class)) {
						classes.add(new Classe(CajaIngreso.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClienteCoa.class)) {
						classes.add(new Classe(ClienteCoa.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMensajeCorreoInven.class)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DepositoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepositoBanco.class)); continue;
					}

					if(HistorialCambioClave.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialCambioClave.class)); continue;
					}

					if(AutoriRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriRetencion.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(DescuentoTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
					}

					if(SecuencialUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SecuencialUsuario.class)); continue;
					}

					if(MovimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(ParametroGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroGeneralUsuario.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(CierreCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreCaja.class)); continue;
					}

					if(DescuentoMonto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoMonto.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
					}

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(PlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaneacionCompra.class)); continue;
					}

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
					}

					if(PerfilUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilUsuario.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
					}

					if(DatoGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); continue;
					}

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(ClienteCoa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteCoa.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(DetalleMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DepositoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepositoBanco.class)); continue;
					}

					if(HistorialCambioClave.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialCambioClave.class)); continue;
					}

					if(AutoriRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriRetencion.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(DescuentoTipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoTipoPrecio.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
					}

					if(SecuencialUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SecuencialUsuario.class)); continue;
					}

					if(MovimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(ParametroGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroGeneralUsuario.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(CierreCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreCaja.class)); continue;
					}

					if(DescuentoMonto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DescuentoMonto.class)); continue;
					}

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
					}

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(PlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaneacionCompra.class)); continue;
					}

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
					}

					if(PerfilUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilUsuario.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
					}

					if(DatoGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); continue;
					}

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(ClienteCoa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteCoa.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(DetalleMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); continue;
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
	public static void actualizarLista(Usuario usuario,List<Usuario> usuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Usuario usuarioEncontrado=null;
			
			for(Usuario usuarioLocal:usuarios) {
				if(usuarioLocal.getId().equals(usuario.getId())) {
					usuarioEncontrado=usuarioLocal;
					
					usuarioLocal.setIsChanged(usuario.getIsChanged());
					usuarioLocal.setIsNew(usuario.getIsNew());
					usuarioLocal.setIsDeleted(usuario.getIsDeleted());
					
					usuarioLocal.setGeneralEntityOriginal(usuario.getGeneralEntityOriginal());
					
					usuarioLocal.setId(usuario.getId());	
					usuarioLocal.setVersionRow(usuario.getVersionRow());	
					usuarioLocal.setid_empresa(usuario.getid_empresa());	
					usuarioLocal.setuser_name(usuario.getuser_name());	
					usuarioLocal.setclave(usuario.getclave());	
					usuarioLocal.setconfirmar_clave(usuario.getconfirmar_clave());	
					usuarioLocal.setnombre(usuario.getnombre());	
					usuarioLocal.setcodigo_alterno(usuario.getcodigo_alterno());	
					usuarioLocal.settipo(usuario.gettipo());	
					usuarioLocal.setestado(usuario.getestado());	
					
					
					usuarioLocal.setDepositoBancos(usuario.getDepositoBancos());
					usuarioLocal.setHistorialCambioClaves(usuario.getHistorialCambioClaves());
					usuarioLocal.setAutoriRetencions(usuario.getAutoriRetencions());
					usuarioLocal.setCajeroTurnos(usuario.getCajeroTurnos());
					usuarioLocal.setDetalleLiquidacionImpors(usuario.getDetalleLiquidacionImpors());
					usuarioLocal.setNotaCreditoSolis(usuario.getNotaCreditoSolis());
					usuarioLocal.setPedidoExpors(usuario.getPedidoExpors());
					usuarioLocal.setDescuentoTipoPrecios(usuario.getDescuentoTipoPrecios());
					usuarioLocal.setGuiaRemisions(usuario.getGuiaRemisions());
					usuarioLocal.setPedidoPuntoVentas(usuario.getPedidoPuntoVentas());
					usuarioLocal.setGastoEmpleados(usuario.getGastoEmpleados());
					usuarioLocal.setSecuencialUsuarios(usuario.getSecuencialUsuarios());
					usuarioLocal.setMovimientoActivoFijos(usuario.getMovimientoActivoFijos());
					usuarioLocal.setUsuarioOpcions(usuario.getUsuarioOpcions());
					usuarioLocal.setPedidoCompraImpors(usuario.getPedidoCompraImpors());
					usuarioLocal.setOrdenCompras(usuario.getOrdenCompras());
					usuarioLocal.setTurnoPunVens(usuario.getTurnoPunVens());
					usuarioLocal.setNovedads(usuario.getNovedads());
					usuarioLocal.setParametroGeneralUsuario(usuario.getParametroGeneralUsuario());
					usuarioLocal.setAutoriPagoOrdenCompras(usuario.getAutoriPagoOrdenCompras());
					usuarioLocal.setCierreCajas(usuario.getCierreCajas());
					usuarioLocal.setDescuentoMontos(usuario.getDescuentoMontos());
					usuarioLocal.setCajaEgresos(usuario.getCajaEgresos());
					usuarioLocal.setRequisicionCompras(usuario.getRequisicionCompras());
					usuarioLocal.setNotaCreditoPuntoVentas(usuario.getNotaCreditoPuntoVentas());
					usuarioLocal.setPlaneacionCompras(usuario.getPlaneacionCompras());
					usuarioLocal.setPedidoCompras(usuario.getPedidoCompras());
					usuarioLocal.setPerfilUsuarios(usuario.getPerfilUsuarios());
					usuarioLocal.setConsignatarios(usuario.getConsignatarios());
					usuarioLocal.setTransferencias(usuario.getTransferencias());
					usuarioLocal.setDatoGeneralUsuario(usuario.getDatoGeneralUsuario());
					usuarioLocal.setCajaIngresos(usuario.getCajaIngresos());
					usuarioLocal.setClienteCoas(usuario.getClienteCoas());
					usuarioLocal.setConsignacions(usuario.getConsignacions());
					usuarioLocal.setDetalleMensajeCorreoInvens(usuario.getDetalleMensajeCorreoInvens());
					
					existe=true;
					break;
				}
			}
			
			if(!usuario.getIsDeleted()) {
				if(!existe) {
					usuarios.add(usuario);
				}
			} else {
				if(usuarioEncontrado!=null && permiteQuitar)  {
					usuarios.remove(usuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Usuario usuario,List<Usuario> usuarios) throws Exception {
		try	{			
			for(Usuario usuarioLocal:usuarios) {
				if(usuarioLocal.getId().equals(usuario.getId())) {
					usuarioLocal.setIsSelected(usuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUsuario(List<Usuario> usuariosAux) throws Exception {
		//this.usuariosAux=usuariosAux;
		
		for(Usuario usuarioAux:usuariosAux) {
			if(usuarioAux.getIsChanged()) {
				usuarioAux.setIsChanged(false);
			}		
			
			if(usuarioAux.getIsNew()) {
				usuarioAux.setIsNew(false);
			}	
			
			if(usuarioAux.getIsDeleted()) {
				usuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUsuario(Usuario usuarioAux) throws Exception {
		//this.usuarioAux=usuarioAux;
		
			if(usuarioAux.getIsChanged()) {
				usuarioAux.setIsChanged(false);
			}		
			
			if(usuarioAux.getIsNew()) {
				usuarioAux.setIsNew(false);
			}	
			
			if(usuarioAux.getIsDeleted()) {
				usuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Usuario usuarioAsignar,Usuario usuario) throws Exception {
		usuarioAsignar.setId(usuario.getId());	
		usuarioAsignar.setVersionRow(usuario.getVersionRow());	
		usuarioAsignar.setid_empresa(usuario.getid_empresa());
		usuarioAsignar.setempresa_descripcion(usuario.getempresa_descripcion());	
		usuarioAsignar.setuser_name(usuario.getuser_name());	
		usuarioAsignar.setclave(usuario.getclave());	
		usuarioAsignar.setconfirmar_clave(usuario.getconfirmar_clave());	
		usuarioAsignar.setnombre(usuario.getnombre());	
		usuarioAsignar.setcodigo_alterno(usuario.getcodigo_alterno());	
		usuarioAsignar.settipo(usuario.gettipo());	
		usuarioAsignar.setestado(usuario.getestado());	
	}
	
	public static void inicializarUsuario(Usuario usuario) throws Exception {
		try {
				usuario.setId(0L);	
					
				usuario.setid_empresa(-1L);	
				usuario.setuser_name("");	
				usuario.setclave("");	
				usuario.setconfirmar_clave("");	
				usuario.setnombre("");	
				usuario.setcodigo_alterno("");	
				usuario.settipo(false);	
				usuario.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_USERNAME);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_CONFIRMARCLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_CODIGOALTERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UsuarioConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUsuario(String sTipo,Row row,Workbook workbook,Usuario usuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getuser_name());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getconfirmar_clave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(usuario.getcodigo_alterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(usuario.gettipo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(usuario.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUsuario() {
		return this.sFinalQueryUsuario;
	}
	
	public void setsFinalQueryUsuario(String sFinalQueryUsuario) {
		this.sFinalQueryUsuario= sFinalQueryUsuario;
	}
	
	public Border resaltarSeleccionarUsuario=null;
	
	public Border setResaltarSeleccionarUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUsuario() {
		return this.resaltarSeleccionarUsuario;
	}
	
	public void setResaltarSeleccionarUsuario(Border borderResaltarSeleccionarUsuario) {
		this.resaltarSeleccionarUsuario= borderResaltarSeleccionarUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUsuario=null;
	public Boolean mostraridUsuario=true;
	public Boolean activaridUsuario=true;

	public Border resaltarid_empresaUsuario=null;
	public Boolean mostrarid_empresaUsuario=true;
	public Boolean activarid_empresaUsuario=true;
	public Boolean cargarid_empresaUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUsuario=false;//ConEventDepend=true

	public Border resaltaruser_nameUsuario=null;
	public Boolean mostraruser_nameUsuario=true;
	public Boolean activaruser_nameUsuario=true;

	public Border resaltarclaveUsuario=null;
	public Boolean mostrarclaveUsuario=true;
	public Boolean activarclaveUsuario=true;

	public Border resaltarconfirmar_claveUsuario=null;
	public Boolean mostrarconfirmar_claveUsuario=true;
	public Boolean activarconfirmar_claveUsuario=true;

	public Border resaltarnombreUsuario=null;
	public Boolean mostrarnombreUsuario=true;
	public Boolean activarnombreUsuario=true;

	public Border resaltarcodigo_alternoUsuario=null;
	public Boolean mostrarcodigo_alternoUsuario=true;
	public Boolean activarcodigo_alternoUsuario=true;

	public Border resaltartipoUsuario=null;
	public Boolean mostrartipoUsuario=true;
	public Boolean activartipoUsuario=true;

	public Border resaltarestadoUsuario=null;
	public Boolean mostrarestadoUsuario=true;
	public Boolean activarestadoUsuario=true;

	
	

	public Border setResaltaridUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltaridUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUsuario() {
		return this.resaltaridUsuario;
	}

	public void setResaltaridUsuario(Border borderResaltar) {
		this.resaltaridUsuario= borderResaltar;
	}

	public Boolean getMostraridUsuario() {
		return this.mostraridUsuario;
	}

	public void setMostraridUsuario(Boolean mostraridUsuario) {
		this.mostraridUsuario= mostraridUsuario;
	}

	public Boolean getActivaridUsuario() {
		return this.activaridUsuario;
	}

	public void setActivaridUsuario(Boolean activaridUsuario) {
		this.activaridUsuario= activaridUsuario;
	}

	public Border setResaltarid_empresaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarid_empresaUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUsuario() {
		return this.resaltarid_empresaUsuario;
	}

	public void setResaltarid_empresaUsuario(Border borderResaltar) {
		this.resaltarid_empresaUsuario= borderResaltar;
	}

	public Boolean getMostrarid_empresaUsuario() {
		return this.mostrarid_empresaUsuario;
	}

	public void setMostrarid_empresaUsuario(Boolean mostrarid_empresaUsuario) {
		this.mostrarid_empresaUsuario= mostrarid_empresaUsuario;
	}

	public Boolean getActivarid_empresaUsuario() {
		return this.activarid_empresaUsuario;
	}

	public void setActivarid_empresaUsuario(Boolean activarid_empresaUsuario) {
		this.activarid_empresaUsuario= activarid_empresaUsuario;
	}

	public Boolean getCargarid_empresaUsuario() {
		return this.cargarid_empresaUsuario;
	}

	public void setCargarid_empresaUsuario(Boolean cargarid_empresaUsuario) {
		this.cargarid_empresaUsuario= cargarid_empresaUsuario;
	}

	public Border setResaltaruser_nameUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltaruser_nameUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaruser_nameUsuario() {
		return this.resaltaruser_nameUsuario;
	}

	public void setResaltaruser_nameUsuario(Border borderResaltar) {
		this.resaltaruser_nameUsuario= borderResaltar;
	}

	public Boolean getMostraruser_nameUsuario() {
		return this.mostraruser_nameUsuario;
	}

	public void setMostraruser_nameUsuario(Boolean mostraruser_nameUsuario) {
		this.mostraruser_nameUsuario= mostraruser_nameUsuario;
	}

	public Boolean getActivaruser_nameUsuario() {
		return this.activaruser_nameUsuario;
	}

	public void setActivaruser_nameUsuario(Boolean activaruser_nameUsuario) {
		this.activaruser_nameUsuario= activaruser_nameUsuario;
	}

	public Border setResaltarclaveUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarclaveUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveUsuario() {
		return this.resaltarclaveUsuario;
	}

	public void setResaltarclaveUsuario(Border borderResaltar) {
		this.resaltarclaveUsuario= borderResaltar;
	}

	public Boolean getMostrarclaveUsuario() {
		return this.mostrarclaveUsuario;
	}

	public void setMostrarclaveUsuario(Boolean mostrarclaveUsuario) {
		this.mostrarclaveUsuario= mostrarclaveUsuario;
	}

	public Boolean getActivarclaveUsuario() {
		return this.activarclaveUsuario;
	}

	public void setActivarclaveUsuario(Boolean activarclaveUsuario) {
		this.activarclaveUsuario= activarclaveUsuario;
	}

	public Border setResaltarconfirmar_claveUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarconfirmar_claveUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconfirmar_claveUsuario() {
		return this.resaltarconfirmar_claveUsuario;
	}

	public void setResaltarconfirmar_claveUsuario(Border borderResaltar) {
		this.resaltarconfirmar_claveUsuario= borderResaltar;
	}

	public Boolean getMostrarconfirmar_claveUsuario() {
		return this.mostrarconfirmar_claveUsuario;
	}

	public void setMostrarconfirmar_claveUsuario(Boolean mostrarconfirmar_claveUsuario) {
		this.mostrarconfirmar_claveUsuario= mostrarconfirmar_claveUsuario;
	}

	public Boolean getActivarconfirmar_claveUsuario() {
		return this.activarconfirmar_claveUsuario;
	}

	public void setActivarconfirmar_claveUsuario(Boolean activarconfirmar_claveUsuario) {
		this.activarconfirmar_claveUsuario= activarconfirmar_claveUsuario;
	}

	public Border setResaltarnombreUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarnombreUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreUsuario() {
		return this.resaltarnombreUsuario;
	}

	public void setResaltarnombreUsuario(Border borderResaltar) {
		this.resaltarnombreUsuario= borderResaltar;
	}

	public Boolean getMostrarnombreUsuario() {
		return this.mostrarnombreUsuario;
	}

	public void setMostrarnombreUsuario(Boolean mostrarnombreUsuario) {
		this.mostrarnombreUsuario= mostrarnombreUsuario;
	}

	public Boolean getActivarnombreUsuario() {
		return this.activarnombreUsuario;
	}

	public void setActivarnombreUsuario(Boolean activarnombreUsuario) {
		this.activarnombreUsuario= activarnombreUsuario;
	}

	public Border setResaltarcodigo_alternoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarcodigo_alternoUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_alternoUsuario() {
		return this.resaltarcodigo_alternoUsuario;
	}

	public void setResaltarcodigo_alternoUsuario(Border borderResaltar) {
		this.resaltarcodigo_alternoUsuario= borderResaltar;
	}

	public Boolean getMostrarcodigo_alternoUsuario() {
		return this.mostrarcodigo_alternoUsuario;
	}

	public void setMostrarcodigo_alternoUsuario(Boolean mostrarcodigo_alternoUsuario) {
		this.mostrarcodigo_alternoUsuario= mostrarcodigo_alternoUsuario;
	}

	public Boolean getActivarcodigo_alternoUsuario() {
		return this.activarcodigo_alternoUsuario;
	}

	public void setActivarcodigo_alternoUsuario(Boolean activarcodigo_alternoUsuario) {
		this.activarcodigo_alternoUsuario= activarcodigo_alternoUsuario;
	}

	public Border setResaltartipoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltartipoUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoUsuario() {
		return this.resaltartipoUsuario;
	}

	public void setResaltartipoUsuario(Border borderResaltar) {
		this.resaltartipoUsuario= borderResaltar;
	}

	public Boolean getMostrartipoUsuario() {
		return this.mostrartipoUsuario;
	}

	public void setMostrartipoUsuario(Boolean mostrartipoUsuario) {
		this.mostrartipoUsuario= mostrartipoUsuario;
	}

	public Boolean getActivartipoUsuario() {
		return this.activartipoUsuario;
	}

	public void setActivartipoUsuario(Boolean activartipoUsuario) {
		this.activartipoUsuario= activartipoUsuario;
	}

	public Border setResaltarestadoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltar);
		
		this.resaltarestadoUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoUsuario() {
		return this.resaltarestadoUsuario;
	}

	public void setResaltarestadoUsuario(Border borderResaltar) {
		this.resaltarestadoUsuario= borderResaltar;
	}

	public Boolean getMostrarestadoUsuario() {
		return this.mostrarestadoUsuario;
	}

	public void setMostrarestadoUsuario(Boolean mostrarestadoUsuario) {
		this.mostrarestadoUsuario= mostrarestadoUsuario;
	}

	public Boolean getActivarestadoUsuario() {
		return this.activarestadoUsuario;
	}

	public void setActivarestadoUsuario(Boolean activarestadoUsuario) {
		this.activarestadoUsuario= activarestadoUsuario;
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
		
		
		this.setMostraridUsuario(esInicial);
		this.setMostrarid_empresaUsuario(esInicial);
		this.setMostraruser_nameUsuario(esInicial);
		this.setMostrarclaveUsuario(esInicial);
		this.setMostrarconfirmar_claveUsuario(esInicial);
		this.setMostrarnombreUsuario(esInicial);
		this.setMostrarcodigo_alternoUsuario(esInicial);
		this.setMostrartipoUsuario(esInicial);
		this.setMostrarestadoUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioConstantesFunciones.ID)) {
				this.setMostraridUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.USERNAME)) {
				this.setMostraruser_nameUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CLAVE)) {
				this.setMostrarclaveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CONFIRMARCLAVE)) {
				this.setMostrarconfirmar_claveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CODIGOALTERNO)) {
				this.setMostrarcodigo_alternoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.TIPO)) {
				this.setMostrartipoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.ESTADO)) {
				this.setMostrarestadoUsuario(esAsigna);
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
		
		
		this.setActivaridUsuario(esInicial);
		this.setActivarid_empresaUsuario(esInicial);
		this.setActivaruser_nameUsuario(esInicial);
		this.setActivarclaveUsuario(esInicial);
		this.setActivarconfirmar_claveUsuario(esInicial);
		this.setActivarnombreUsuario(esInicial);
		this.setActivarcodigo_alternoUsuario(esInicial);
		this.setActivartipoUsuario(esInicial);
		this.setActivarestadoUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioConstantesFunciones.ID)) {
				this.setActivaridUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.USERNAME)) {
				this.setActivaruser_nameUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CLAVE)) {
				this.setActivarclaveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CONFIRMARCLAVE)) {
				this.setActivarconfirmar_claveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CODIGOALTERNO)) {
				this.setActivarcodigo_alternoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.TIPO)) {
				this.setActivartipoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.ESTADO)) {
				this.setActivarestadoUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUsuario(esInicial);
		this.setResaltarid_empresaUsuario(esInicial);
		this.setResaltaruser_nameUsuario(esInicial);
		this.setResaltarclaveUsuario(esInicial);
		this.setResaltarconfirmar_claveUsuario(esInicial);
		this.setResaltarnombreUsuario(esInicial);
		this.setResaltarcodigo_alternoUsuario(esInicial);
		this.setResaltartipoUsuario(esInicial);
		this.setResaltarestadoUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UsuarioConstantesFunciones.ID)) {
				this.setResaltaridUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.USERNAME)) {
				this.setResaltaruser_nameUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CLAVE)) {
				this.setResaltarclaveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CONFIRMARCLAVE)) {
				this.setResaltarconfirmar_claveUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.CODIGOALTERNO)) {
				this.setResaltarcodigo_alternoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.TIPO)) {
				this.setResaltartipoUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(UsuarioConstantesFunciones.ESTADO)) {
				this.setResaltarestadoUsuario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDepositoBancoUsuario=null;

	public Border getResaltarDepositoBancoUsuario() {
		return this.resaltarDepositoBancoUsuario;
	}

	public void setResaltarDepositoBancoUsuario(Border borderResaltarDepositoBanco) {
		if(borderResaltarDepositoBanco!=null) {
			this.resaltarDepositoBancoUsuario= borderResaltarDepositoBanco;
		}
	}

	public Border setResaltarDepositoBancoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDepositoBanco=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDepositoBanco);
			
		this.resaltarDepositoBancoUsuario= borderResaltarDepositoBanco;

		 return borderResaltarDepositoBanco;
	}



	public Boolean mostrarDepositoBancoUsuario=true;

	public Boolean getMostrarDepositoBancoUsuario() {
		return this.mostrarDepositoBancoUsuario;
	}

	public void setMostrarDepositoBancoUsuario(Boolean visibilidadResaltarDepositoBanco) {
		this.mostrarDepositoBancoUsuario= visibilidadResaltarDepositoBanco;
	}



	public Boolean activarDepositoBancoUsuario=true;

	public Boolean gethabilitarResaltarDepositoBancoUsuario() {
		return this.activarDepositoBancoUsuario;
	}

	public void setActivarDepositoBancoUsuario(Boolean habilitarResaltarDepositoBanco) {
		this.activarDepositoBancoUsuario= habilitarResaltarDepositoBanco;
	}


	public Border resaltarHistorialCambioClaveUsuario=null;

	public Border getResaltarHistorialCambioClaveUsuario() {
		return this.resaltarHistorialCambioClaveUsuario;
	}

	public void setResaltarHistorialCambioClaveUsuario(Border borderResaltarHistorialCambioClave) {
		if(borderResaltarHistorialCambioClave!=null) {
			this.resaltarHistorialCambioClaveUsuario= borderResaltarHistorialCambioClave;
		}
	}

	public Border setResaltarHistorialCambioClaveUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarHistorialCambioClave=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarHistorialCambioClave);
			
		this.resaltarHistorialCambioClaveUsuario= borderResaltarHistorialCambioClave;

		 return borderResaltarHistorialCambioClave;
	}



	public Boolean mostrarHistorialCambioClaveUsuario=true;

	public Boolean getMostrarHistorialCambioClaveUsuario() {
		return this.mostrarHistorialCambioClaveUsuario;
	}

	public void setMostrarHistorialCambioClaveUsuario(Boolean visibilidadResaltarHistorialCambioClave) {
		this.mostrarHistorialCambioClaveUsuario= visibilidadResaltarHistorialCambioClave;
	}



	public Boolean activarHistorialCambioClaveUsuario=true;

	public Boolean gethabilitarResaltarHistorialCambioClaveUsuario() {
		return this.activarHistorialCambioClaveUsuario;
	}

	public void setActivarHistorialCambioClaveUsuario(Boolean habilitarResaltarHistorialCambioClave) {
		this.activarHistorialCambioClaveUsuario= habilitarResaltarHistorialCambioClave;
	}


	public Border resaltarAutoriRetencionUsuario=null;

	public Border getResaltarAutoriRetencionUsuario() {
		return this.resaltarAutoriRetencionUsuario;
	}

	public void setResaltarAutoriRetencionUsuario(Border borderResaltarAutoriRetencion) {
		if(borderResaltarAutoriRetencion!=null) {
			this.resaltarAutoriRetencionUsuario= borderResaltarAutoriRetencion;
		}
	}

	public Border setResaltarAutoriRetencionUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriRetencion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarAutoriRetencion);
			
		this.resaltarAutoriRetencionUsuario= borderResaltarAutoriRetencion;

		 return borderResaltarAutoriRetencion;
	}



	public Boolean mostrarAutoriRetencionUsuario=true;

	public Boolean getMostrarAutoriRetencionUsuario() {
		return this.mostrarAutoriRetencionUsuario;
	}

	public void setMostrarAutoriRetencionUsuario(Boolean visibilidadResaltarAutoriRetencion) {
		this.mostrarAutoriRetencionUsuario= visibilidadResaltarAutoriRetencion;
	}



	public Boolean activarAutoriRetencionUsuario=true;

	public Boolean gethabilitarResaltarAutoriRetencionUsuario() {
		return this.activarAutoriRetencionUsuario;
	}

	public void setActivarAutoriRetencionUsuario(Boolean habilitarResaltarAutoriRetencion) {
		this.activarAutoriRetencionUsuario= habilitarResaltarAutoriRetencion;
	}


	public Border resaltarCajeroTurnoUsuario=null;

	public Border getResaltarCajeroTurnoUsuario() {
		return this.resaltarCajeroTurnoUsuario;
	}

	public void setResaltarCajeroTurnoUsuario(Border borderResaltarCajeroTurno) {
		if(borderResaltarCajeroTurno!=null) {
			this.resaltarCajeroTurnoUsuario= borderResaltarCajeroTurno;
		}
	}

	public Border setResaltarCajeroTurnoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarCajeroTurno=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarCajeroTurno);
			
		this.resaltarCajeroTurnoUsuario= borderResaltarCajeroTurno;

		 return borderResaltarCajeroTurno;
	}



	public Boolean mostrarCajeroTurnoUsuario=true;

	public Boolean getMostrarCajeroTurnoUsuario() {
		return this.mostrarCajeroTurnoUsuario;
	}

	public void setMostrarCajeroTurnoUsuario(Boolean visibilidadResaltarCajeroTurno) {
		this.mostrarCajeroTurnoUsuario= visibilidadResaltarCajeroTurno;
	}



	public Boolean activarCajeroTurnoUsuario=true;

	public Boolean gethabilitarResaltarCajeroTurnoUsuario() {
		return this.activarCajeroTurnoUsuario;
	}

	public void setActivarCajeroTurnoUsuario(Boolean habilitarResaltarCajeroTurno) {
		this.activarCajeroTurnoUsuario= habilitarResaltarCajeroTurno;
	}


	public Border resaltarDetalleLiquidacionImporUsuario=null;

	public Border getResaltarDetalleLiquidacionImporUsuario() {
		return this.resaltarDetalleLiquidacionImporUsuario;
	}

	public void setResaltarDetalleLiquidacionImporUsuario(Border borderResaltarDetalleLiquidacionImpor) {
		if(borderResaltarDetalleLiquidacionImpor!=null) {
			this.resaltarDetalleLiquidacionImporUsuario= borderResaltarDetalleLiquidacionImpor;
		}
	}

	public Border setResaltarDetalleLiquidacionImporUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleLiquidacionImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDetalleLiquidacionImpor);
			
		this.resaltarDetalleLiquidacionImporUsuario= borderResaltarDetalleLiquidacionImpor;

		 return borderResaltarDetalleLiquidacionImpor;
	}



	public Boolean mostrarDetalleLiquidacionImporUsuario=true;

	public Boolean getMostrarDetalleLiquidacionImporUsuario() {
		return this.mostrarDetalleLiquidacionImporUsuario;
	}

	public void setMostrarDetalleLiquidacionImporUsuario(Boolean visibilidadResaltarDetalleLiquidacionImpor) {
		this.mostrarDetalleLiquidacionImporUsuario= visibilidadResaltarDetalleLiquidacionImpor;
	}



	public Boolean activarDetalleLiquidacionImporUsuario=true;

	public Boolean gethabilitarResaltarDetalleLiquidacionImporUsuario() {
		return this.activarDetalleLiquidacionImporUsuario;
	}

	public void setActivarDetalleLiquidacionImporUsuario(Boolean habilitarResaltarDetalleLiquidacionImpor) {
		this.activarDetalleLiquidacionImporUsuario= habilitarResaltarDetalleLiquidacionImpor;
	}


	public Border resaltarNotaCreditoSoliUsuario=null;

	public Border getResaltarNotaCreditoSoliUsuario() {
		return this.resaltarNotaCreditoSoliUsuario;
	}

	public void setResaltarNotaCreditoSoliUsuario(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliUsuario= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliUsuario= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliUsuario=true;

	public Boolean getMostrarNotaCreditoSoliUsuario() {
		return this.mostrarNotaCreditoSoliUsuario;
	}

	public void setMostrarNotaCreditoSoliUsuario(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliUsuario= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliUsuario=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliUsuario() {
		return this.activarNotaCreditoSoliUsuario;
	}

	public void setActivarNotaCreditoSoliUsuario(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliUsuario= habilitarResaltarNotaCreditoSoli;
	}


	public Border resaltarPedidoExporUsuario=null;

	public Border getResaltarPedidoExporUsuario() {
		return this.resaltarPedidoExporUsuario;
	}

	public void setResaltarPedidoExporUsuario(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporUsuario= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporUsuario= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporUsuario=true;

	public Boolean getMostrarPedidoExporUsuario() {
		return this.mostrarPedidoExporUsuario;
	}

	public void setMostrarPedidoExporUsuario(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporUsuario= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporUsuario=true;

	public Boolean gethabilitarResaltarPedidoExporUsuario() {
		return this.activarPedidoExporUsuario;
	}

	public void setActivarPedidoExporUsuario(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporUsuario= habilitarResaltarPedidoExpor;
	}


	public Border resaltarDescuentoTipoPrecioUsuario=null;

	public Border getResaltarDescuentoTipoPrecioUsuario() {
		return this.resaltarDescuentoTipoPrecioUsuario;
	}

	public void setResaltarDescuentoTipoPrecioUsuario(Border borderResaltarDescuentoTipoPrecio) {
		if(borderResaltarDescuentoTipoPrecio!=null) {
			this.resaltarDescuentoTipoPrecioUsuario= borderResaltarDescuentoTipoPrecio;
		}
	}

	public Border setResaltarDescuentoTipoPrecioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDescuentoTipoPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDescuentoTipoPrecio);
			
		this.resaltarDescuentoTipoPrecioUsuario= borderResaltarDescuentoTipoPrecio;

		 return borderResaltarDescuentoTipoPrecio;
	}



	public Boolean mostrarDescuentoTipoPrecioUsuario=true;

	public Boolean getMostrarDescuentoTipoPrecioUsuario() {
		return this.mostrarDescuentoTipoPrecioUsuario;
	}

	public void setMostrarDescuentoTipoPrecioUsuario(Boolean visibilidadResaltarDescuentoTipoPrecio) {
		this.mostrarDescuentoTipoPrecioUsuario= visibilidadResaltarDescuentoTipoPrecio;
	}



	public Boolean activarDescuentoTipoPrecioUsuario=true;

	public Boolean gethabilitarResaltarDescuentoTipoPrecioUsuario() {
		return this.activarDescuentoTipoPrecioUsuario;
	}

	public void setActivarDescuentoTipoPrecioUsuario(Boolean habilitarResaltarDescuentoTipoPrecio) {
		this.activarDescuentoTipoPrecioUsuario= habilitarResaltarDescuentoTipoPrecio;
	}


	public Border resaltarGuiaRemisionUsuario=null;

	public Border getResaltarGuiaRemisionUsuario() {
		return this.resaltarGuiaRemisionUsuario;
	}

	public void setResaltarGuiaRemisionUsuario(Border borderResaltarGuiaRemision) {
		if(borderResaltarGuiaRemision!=null) {
			this.resaltarGuiaRemisionUsuario= borderResaltarGuiaRemision;
		}
	}

	public Border setResaltarGuiaRemisionUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarGuiaRemision=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarGuiaRemision);
			
		this.resaltarGuiaRemisionUsuario= borderResaltarGuiaRemision;

		 return borderResaltarGuiaRemision;
	}



	public Boolean mostrarGuiaRemisionUsuario=true;

	public Boolean getMostrarGuiaRemisionUsuario() {
		return this.mostrarGuiaRemisionUsuario;
	}

	public void setMostrarGuiaRemisionUsuario(Boolean visibilidadResaltarGuiaRemision) {
		this.mostrarGuiaRemisionUsuario= visibilidadResaltarGuiaRemision;
	}



	public Boolean activarGuiaRemisionUsuario=true;

	public Boolean gethabilitarResaltarGuiaRemisionUsuario() {
		return this.activarGuiaRemisionUsuario;
	}

	public void setActivarGuiaRemisionUsuario(Boolean habilitarResaltarGuiaRemision) {
		this.activarGuiaRemisionUsuario= habilitarResaltarGuiaRemision;
	}


	public Border resaltarPedidoPuntoVentaUsuario=null;

	public Border getResaltarPedidoPuntoVentaUsuario() {
		return this.resaltarPedidoPuntoVentaUsuario;
	}

	public void setResaltarPedidoPuntoVentaUsuario(Border borderResaltarPedidoPuntoVenta) {
		if(borderResaltarPedidoPuntoVenta!=null) {
			this.resaltarPedidoPuntoVentaUsuario= borderResaltarPedidoPuntoVenta;
		}
	}

	public Border setResaltarPedidoPuntoVentaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPedidoPuntoVenta);
			
		this.resaltarPedidoPuntoVentaUsuario= borderResaltarPedidoPuntoVenta;

		 return borderResaltarPedidoPuntoVenta;
	}



	public Boolean mostrarPedidoPuntoVentaUsuario=true;

	public Boolean getMostrarPedidoPuntoVentaUsuario() {
		return this.mostrarPedidoPuntoVentaUsuario;
	}

	public void setMostrarPedidoPuntoVentaUsuario(Boolean visibilidadResaltarPedidoPuntoVenta) {
		this.mostrarPedidoPuntoVentaUsuario= visibilidadResaltarPedidoPuntoVenta;
	}



	public Boolean activarPedidoPuntoVentaUsuario=true;

	public Boolean gethabilitarResaltarPedidoPuntoVentaUsuario() {
		return this.activarPedidoPuntoVentaUsuario;
	}

	public void setActivarPedidoPuntoVentaUsuario(Boolean habilitarResaltarPedidoPuntoVenta) {
		this.activarPedidoPuntoVentaUsuario= habilitarResaltarPedidoPuntoVenta;
	}


	public Border resaltarGastoEmpleadoUsuario=null;

	public Border getResaltarGastoEmpleadoUsuario() {
		return this.resaltarGastoEmpleadoUsuario;
	}

	public void setResaltarGastoEmpleadoUsuario(Border borderResaltarGastoEmpleado) {
		if(borderResaltarGastoEmpleado!=null) {
			this.resaltarGastoEmpleadoUsuario= borderResaltarGastoEmpleado;
		}
	}

	public Border setResaltarGastoEmpleadoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarGastoEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarGastoEmpleado);
			
		this.resaltarGastoEmpleadoUsuario= borderResaltarGastoEmpleado;

		 return borderResaltarGastoEmpleado;
	}



	public Boolean mostrarGastoEmpleadoUsuario=true;

	public Boolean getMostrarGastoEmpleadoUsuario() {
		return this.mostrarGastoEmpleadoUsuario;
	}

	public void setMostrarGastoEmpleadoUsuario(Boolean visibilidadResaltarGastoEmpleado) {
		this.mostrarGastoEmpleadoUsuario= visibilidadResaltarGastoEmpleado;
	}



	public Boolean activarGastoEmpleadoUsuario=true;

	public Boolean gethabilitarResaltarGastoEmpleadoUsuario() {
		return this.activarGastoEmpleadoUsuario;
	}

	public void setActivarGastoEmpleadoUsuario(Boolean habilitarResaltarGastoEmpleado) {
		this.activarGastoEmpleadoUsuario= habilitarResaltarGastoEmpleado;
	}


	public Border resaltarSecuencialUsuarioUsuario=null;

	public Border getResaltarSecuencialUsuarioUsuario() {
		return this.resaltarSecuencialUsuarioUsuario;
	}

	public void setResaltarSecuencialUsuarioUsuario(Border borderResaltarSecuencialUsuario) {
		if(borderResaltarSecuencialUsuario!=null) {
			this.resaltarSecuencialUsuarioUsuario= borderResaltarSecuencialUsuario;
		}
	}

	public Border setResaltarSecuencialUsuarioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarSecuencialUsuario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarSecuencialUsuario);
			
		this.resaltarSecuencialUsuarioUsuario= borderResaltarSecuencialUsuario;

		 return borderResaltarSecuencialUsuario;
	}



	public Boolean mostrarSecuencialUsuarioUsuario=true;

	public Boolean getMostrarSecuencialUsuarioUsuario() {
		return this.mostrarSecuencialUsuarioUsuario;
	}

	public void setMostrarSecuencialUsuarioUsuario(Boolean visibilidadResaltarSecuencialUsuario) {
		this.mostrarSecuencialUsuarioUsuario= visibilidadResaltarSecuencialUsuario;
	}



	public Boolean activarSecuencialUsuarioUsuario=true;

	public Boolean gethabilitarResaltarSecuencialUsuarioUsuario() {
		return this.activarSecuencialUsuarioUsuario;
	}

	public void setActivarSecuencialUsuarioUsuario(Boolean habilitarResaltarSecuencialUsuario) {
		this.activarSecuencialUsuarioUsuario= habilitarResaltarSecuencialUsuario;
	}


	public Border resaltarMovimientoActivoFijoUsuario=null;

	public Border getResaltarMovimientoActivoFijoUsuario() {
		return this.resaltarMovimientoActivoFijoUsuario;
	}

	public void setResaltarMovimientoActivoFijoUsuario(Border borderResaltarMovimientoActivoFijo) {
		if(borderResaltarMovimientoActivoFijo!=null) {
			this.resaltarMovimientoActivoFijoUsuario= borderResaltarMovimientoActivoFijo;
		}
	}

	public Border setResaltarMovimientoActivoFijoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarMovimientoActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarMovimientoActivoFijo);
			
		this.resaltarMovimientoActivoFijoUsuario= borderResaltarMovimientoActivoFijo;

		 return borderResaltarMovimientoActivoFijo;
	}



	public Boolean mostrarMovimientoActivoFijoUsuario=true;

	public Boolean getMostrarMovimientoActivoFijoUsuario() {
		return this.mostrarMovimientoActivoFijoUsuario;
	}

	public void setMostrarMovimientoActivoFijoUsuario(Boolean visibilidadResaltarMovimientoActivoFijo) {
		this.mostrarMovimientoActivoFijoUsuario= visibilidadResaltarMovimientoActivoFijo;
	}



	public Boolean activarMovimientoActivoFijoUsuario=true;

	public Boolean gethabilitarResaltarMovimientoActivoFijoUsuario() {
		return this.activarMovimientoActivoFijoUsuario;
	}

	public void setActivarMovimientoActivoFijoUsuario(Boolean habilitarResaltarMovimientoActivoFijo) {
		this.activarMovimientoActivoFijoUsuario= habilitarResaltarMovimientoActivoFijo;
	}


	public Border resaltarUsuarioOpcionUsuario=null;

	public Border getResaltarUsuarioOpcionUsuario() {
		return this.resaltarUsuarioOpcionUsuario;
	}

	public void setResaltarUsuarioOpcionUsuario(Border borderResaltarUsuarioOpcion) {
		if(borderResaltarUsuarioOpcion!=null) {
			this.resaltarUsuarioOpcionUsuario= borderResaltarUsuarioOpcion;
		}
	}

	public Border setResaltarUsuarioOpcionUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarUsuarioOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarUsuarioOpcion);
			
		this.resaltarUsuarioOpcionUsuario= borderResaltarUsuarioOpcion;

		 return borderResaltarUsuarioOpcion;
	}



	public Boolean mostrarUsuarioOpcionUsuario=true;

	public Boolean getMostrarUsuarioOpcionUsuario() {
		return this.mostrarUsuarioOpcionUsuario;
	}

	public void setMostrarUsuarioOpcionUsuario(Boolean visibilidadResaltarUsuarioOpcion) {
		this.mostrarUsuarioOpcionUsuario= visibilidadResaltarUsuarioOpcion;
	}



	public Boolean activarUsuarioOpcionUsuario=true;

	public Boolean gethabilitarResaltarUsuarioOpcionUsuario() {
		return this.activarUsuarioOpcionUsuario;
	}

	public void setActivarUsuarioOpcionUsuario(Boolean habilitarResaltarUsuarioOpcion) {
		this.activarUsuarioOpcionUsuario= habilitarResaltarUsuarioOpcion;
	}


	public Border resaltarPedidoCompraImporUsuario=null;

	public Border getResaltarPedidoCompraImporUsuario() {
		return this.resaltarPedidoCompraImporUsuario;
	}

	public void setResaltarPedidoCompraImporUsuario(Border borderResaltarPedidoCompraImpor) {
		if(borderResaltarPedidoCompraImpor!=null) {
			this.resaltarPedidoCompraImporUsuario= borderResaltarPedidoCompraImpor;
		}
	}

	public Border setResaltarPedidoCompraImporUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoCompraImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPedidoCompraImpor);
			
		this.resaltarPedidoCompraImporUsuario= borderResaltarPedidoCompraImpor;

		 return borderResaltarPedidoCompraImpor;
	}



	public Boolean mostrarPedidoCompraImporUsuario=true;

	public Boolean getMostrarPedidoCompraImporUsuario() {
		return this.mostrarPedidoCompraImporUsuario;
	}

	public void setMostrarPedidoCompraImporUsuario(Boolean visibilidadResaltarPedidoCompraImpor) {
		this.mostrarPedidoCompraImporUsuario= visibilidadResaltarPedidoCompraImpor;
	}



	public Boolean activarPedidoCompraImporUsuario=true;

	public Boolean gethabilitarResaltarPedidoCompraImporUsuario() {
		return this.activarPedidoCompraImporUsuario;
	}

	public void setActivarPedidoCompraImporUsuario(Boolean habilitarResaltarPedidoCompraImpor) {
		this.activarPedidoCompraImporUsuario= habilitarResaltarPedidoCompraImpor;
	}


	public Border resaltarOrdenCompraUsuario=null;

	public Border getResaltarOrdenCompraUsuario() {
		return this.resaltarOrdenCompraUsuario;
	}

	public void setResaltarOrdenCompraUsuario(Border borderResaltarOrdenCompra) {
		if(borderResaltarOrdenCompra!=null) {
			this.resaltarOrdenCompraUsuario= borderResaltarOrdenCompra;
		}
	}

	public Border setResaltarOrdenCompraUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarOrdenCompra);
			
		this.resaltarOrdenCompraUsuario= borderResaltarOrdenCompra;

		 return borderResaltarOrdenCompra;
	}



	public Boolean mostrarOrdenCompraUsuario=true;

	public Boolean getMostrarOrdenCompraUsuario() {
		return this.mostrarOrdenCompraUsuario;
	}

	public void setMostrarOrdenCompraUsuario(Boolean visibilidadResaltarOrdenCompra) {
		this.mostrarOrdenCompraUsuario= visibilidadResaltarOrdenCompra;
	}



	public Boolean activarOrdenCompraUsuario=true;

	public Boolean gethabilitarResaltarOrdenCompraUsuario() {
		return this.activarOrdenCompraUsuario;
	}

	public void setActivarOrdenCompraUsuario(Boolean habilitarResaltarOrdenCompra) {
		this.activarOrdenCompraUsuario= habilitarResaltarOrdenCompra;
	}


	public Border resaltarTurnoPunVenUsuario=null;

	public Border getResaltarTurnoPunVenUsuario() {
		return this.resaltarTurnoPunVenUsuario;
	}

	public void setResaltarTurnoPunVenUsuario(Border borderResaltarTurnoPunVen) {
		if(borderResaltarTurnoPunVen!=null) {
			this.resaltarTurnoPunVenUsuario= borderResaltarTurnoPunVen;
		}
	}

	public Border setResaltarTurnoPunVenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarTurnoPunVen=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarTurnoPunVen);
			
		this.resaltarTurnoPunVenUsuario= borderResaltarTurnoPunVen;

		 return borderResaltarTurnoPunVen;
	}



	public Boolean mostrarTurnoPunVenUsuario=true;

	public Boolean getMostrarTurnoPunVenUsuario() {
		return this.mostrarTurnoPunVenUsuario;
	}

	public void setMostrarTurnoPunVenUsuario(Boolean visibilidadResaltarTurnoPunVen) {
		this.mostrarTurnoPunVenUsuario= visibilidadResaltarTurnoPunVen;
	}



	public Boolean activarTurnoPunVenUsuario=true;

	public Boolean gethabilitarResaltarTurnoPunVenUsuario() {
		return this.activarTurnoPunVenUsuario;
	}

	public void setActivarTurnoPunVenUsuario(Boolean habilitarResaltarTurnoPunVen) {
		this.activarTurnoPunVenUsuario= habilitarResaltarTurnoPunVen;
	}


	public Border resaltarNovedadUsuario=null;

	public Border getResaltarNovedadUsuario() {
		return this.resaltarNovedadUsuario;
	}

	public void setResaltarNovedadUsuario(Border borderResaltarNovedad) {
		if(borderResaltarNovedad!=null) {
			this.resaltarNovedadUsuario= borderResaltarNovedad;
		}
	}

	public Border setResaltarNovedadUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarNovedad);
			
		this.resaltarNovedadUsuario= borderResaltarNovedad;

		 return borderResaltarNovedad;
	}



	public Boolean mostrarNovedadUsuario=true;

	public Boolean getMostrarNovedadUsuario() {
		return this.mostrarNovedadUsuario;
	}

	public void setMostrarNovedadUsuario(Boolean visibilidadResaltarNovedad) {
		this.mostrarNovedadUsuario= visibilidadResaltarNovedad;
	}



	public Boolean activarNovedadUsuario=true;

	public Boolean gethabilitarResaltarNovedadUsuario() {
		return this.activarNovedadUsuario;
	}

	public void setActivarNovedadUsuario(Boolean habilitarResaltarNovedad) {
		this.activarNovedadUsuario= habilitarResaltarNovedad;
	}


	public Border resaltarParametroGeneralUsuarioUsuario=null;

	public Border getResaltarParametroGeneralUsuarioUsuario() {
		return this.resaltarParametroGeneralUsuarioUsuario;
	}

	public void setResaltarParametroGeneralUsuarioUsuario(Border borderResaltarParametroGeneralUsuario) {
		if(borderResaltarParametroGeneralUsuario!=null) {
			this.resaltarParametroGeneralUsuarioUsuario= borderResaltarParametroGeneralUsuario;
		}
	}

	public Border setResaltarParametroGeneralUsuarioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroGeneralUsuario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarParametroGeneralUsuario);
			
		this.resaltarParametroGeneralUsuarioUsuario= borderResaltarParametroGeneralUsuario;

		 return borderResaltarParametroGeneralUsuario;
	}



	public Boolean mostrarParametroGeneralUsuarioUsuario=true;

	public Boolean getMostrarParametroGeneralUsuarioUsuario() {
		return this.mostrarParametroGeneralUsuarioUsuario;
	}

	public void setMostrarParametroGeneralUsuarioUsuario(Boolean visibilidadResaltarParametroGeneralUsuario) {
		this.mostrarParametroGeneralUsuarioUsuario= visibilidadResaltarParametroGeneralUsuario;
	}



	public Boolean activarParametroGeneralUsuarioUsuario=true;

	public Boolean gethabilitarResaltarParametroGeneralUsuarioUsuario() {
		return this.activarParametroGeneralUsuarioUsuario;
	}

	public void setActivarParametroGeneralUsuarioUsuario(Boolean habilitarResaltarParametroGeneralUsuario) {
		this.activarParametroGeneralUsuarioUsuario= habilitarResaltarParametroGeneralUsuario;
	}


	public Border resaltarAutoriPagoOrdenCompraUsuario=null;

	public Border getResaltarAutoriPagoOrdenCompraUsuario() {
		return this.resaltarAutoriPagoOrdenCompraUsuario;
	}

	public void setResaltarAutoriPagoOrdenCompraUsuario(Border borderResaltarAutoriPagoOrdenCompra) {
		if(borderResaltarAutoriPagoOrdenCompra!=null) {
			this.resaltarAutoriPagoOrdenCompraUsuario= borderResaltarAutoriPagoOrdenCompra;
		}
	}

	public Border setResaltarAutoriPagoOrdenCompraUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPagoOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarAutoriPagoOrdenCompra);
			
		this.resaltarAutoriPagoOrdenCompraUsuario= borderResaltarAutoriPagoOrdenCompra;

		 return borderResaltarAutoriPagoOrdenCompra;
	}



	public Boolean mostrarAutoriPagoOrdenCompraUsuario=true;

	public Boolean getMostrarAutoriPagoOrdenCompraUsuario() {
		return this.mostrarAutoriPagoOrdenCompraUsuario;
	}

	public void setMostrarAutoriPagoOrdenCompraUsuario(Boolean visibilidadResaltarAutoriPagoOrdenCompra) {
		this.mostrarAutoriPagoOrdenCompraUsuario= visibilidadResaltarAutoriPagoOrdenCompra;
	}



	public Boolean activarAutoriPagoOrdenCompraUsuario=true;

	public Boolean gethabilitarResaltarAutoriPagoOrdenCompraUsuario() {
		return this.activarAutoriPagoOrdenCompraUsuario;
	}

	public void setActivarAutoriPagoOrdenCompraUsuario(Boolean habilitarResaltarAutoriPagoOrdenCompra) {
		this.activarAutoriPagoOrdenCompraUsuario= habilitarResaltarAutoriPagoOrdenCompra;
	}


	public Border resaltarCierreCajaUsuario=null;

	public Border getResaltarCierreCajaUsuario() {
		return this.resaltarCierreCajaUsuario;
	}

	public void setResaltarCierreCajaUsuario(Border borderResaltarCierreCaja) {
		if(borderResaltarCierreCaja!=null) {
			this.resaltarCierreCajaUsuario= borderResaltarCierreCaja;
		}
	}

	public Border setResaltarCierreCajaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarCierreCaja=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarCierreCaja);
			
		this.resaltarCierreCajaUsuario= borderResaltarCierreCaja;

		 return borderResaltarCierreCaja;
	}



	public Boolean mostrarCierreCajaUsuario=true;

	public Boolean getMostrarCierreCajaUsuario() {
		return this.mostrarCierreCajaUsuario;
	}

	public void setMostrarCierreCajaUsuario(Boolean visibilidadResaltarCierreCaja) {
		this.mostrarCierreCajaUsuario= visibilidadResaltarCierreCaja;
	}



	public Boolean activarCierreCajaUsuario=true;

	public Boolean gethabilitarResaltarCierreCajaUsuario() {
		return this.activarCierreCajaUsuario;
	}

	public void setActivarCierreCajaUsuario(Boolean habilitarResaltarCierreCaja) {
		this.activarCierreCajaUsuario= habilitarResaltarCierreCaja;
	}


	public Border resaltarDescuentoMontoUsuario=null;

	public Border getResaltarDescuentoMontoUsuario() {
		return this.resaltarDescuentoMontoUsuario;
	}

	public void setResaltarDescuentoMontoUsuario(Border borderResaltarDescuentoMonto) {
		if(borderResaltarDescuentoMonto!=null) {
			this.resaltarDescuentoMontoUsuario= borderResaltarDescuentoMonto;
		}
	}

	public Border setResaltarDescuentoMontoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDescuentoMonto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDescuentoMonto);
			
		this.resaltarDescuentoMontoUsuario= borderResaltarDescuentoMonto;

		 return borderResaltarDescuentoMonto;
	}



	public Boolean mostrarDescuentoMontoUsuario=true;

	public Boolean getMostrarDescuentoMontoUsuario() {
		return this.mostrarDescuentoMontoUsuario;
	}

	public void setMostrarDescuentoMontoUsuario(Boolean visibilidadResaltarDescuentoMonto) {
		this.mostrarDescuentoMontoUsuario= visibilidadResaltarDescuentoMonto;
	}



	public Boolean activarDescuentoMontoUsuario=true;

	public Boolean gethabilitarResaltarDescuentoMontoUsuario() {
		return this.activarDescuentoMontoUsuario;
	}

	public void setActivarDescuentoMontoUsuario(Boolean habilitarResaltarDescuentoMonto) {
		this.activarDescuentoMontoUsuario= habilitarResaltarDescuentoMonto;
	}


	public Border resaltarCajaEgresoUsuario=null;

	public Border getResaltarCajaEgresoUsuario() {
		return this.resaltarCajaEgresoUsuario;
	}

	public void setResaltarCajaEgresoUsuario(Border borderResaltarCajaEgreso) {
		if(borderResaltarCajaEgreso!=null) {
			this.resaltarCajaEgresoUsuario= borderResaltarCajaEgreso;
		}
	}

	public Border setResaltarCajaEgresoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaEgreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarCajaEgreso);
			
		this.resaltarCajaEgresoUsuario= borderResaltarCajaEgreso;

		 return borderResaltarCajaEgreso;
	}



	public Boolean mostrarCajaEgresoUsuario=true;

	public Boolean getMostrarCajaEgresoUsuario() {
		return this.mostrarCajaEgresoUsuario;
	}

	public void setMostrarCajaEgresoUsuario(Boolean visibilidadResaltarCajaEgreso) {
		this.mostrarCajaEgresoUsuario= visibilidadResaltarCajaEgreso;
	}



	public Boolean activarCajaEgresoUsuario=true;

	public Boolean gethabilitarResaltarCajaEgresoUsuario() {
		return this.activarCajaEgresoUsuario;
	}

	public void setActivarCajaEgresoUsuario(Boolean habilitarResaltarCajaEgreso) {
		this.activarCajaEgresoUsuario= habilitarResaltarCajaEgreso;
	}


	public Border resaltarRequisicionCompraUsuario=null;

	public Border getResaltarRequisicionCompraUsuario() {
		return this.resaltarRequisicionCompraUsuario;
	}

	public void setResaltarRequisicionCompraUsuario(Border borderResaltarRequisicionCompra) {
		if(borderResaltarRequisicionCompra!=null) {
			this.resaltarRequisicionCompraUsuario= borderResaltarRequisicionCompra;
		}
	}

	public Border setResaltarRequisicionCompraUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarRequisicionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarRequisicionCompra);
			
		this.resaltarRequisicionCompraUsuario= borderResaltarRequisicionCompra;

		 return borderResaltarRequisicionCompra;
	}



	public Boolean mostrarRequisicionCompraUsuario=true;

	public Boolean getMostrarRequisicionCompraUsuario() {
		return this.mostrarRequisicionCompraUsuario;
	}

	public void setMostrarRequisicionCompraUsuario(Boolean visibilidadResaltarRequisicionCompra) {
		this.mostrarRequisicionCompraUsuario= visibilidadResaltarRequisicionCompra;
	}



	public Boolean activarRequisicionCompraUsuario=true;

	public Boolean gethabilitarResaltarRequisicionCompraUsuario() {
		return this.activarRequisicionCompraUsuario;
	}

	public void setActivarRequisicionCompraUsuario(Boolean habilitarResaltarRequisicionCompra) {
		this.activarRequisicionCompraUsuario= habilitarResaltarRequisicionCompra;
	}


	public Border resaltarNotaCreditoPuntoVentaUsuario=null;

	public Border getResaltarNotaCreditoPuntoVentaUsuario() {
		return this.resaltarNotaCreditoPuntoVentaUsuario;
	}

	public void setResaltarNotaCreditoPuntoVentaUsuario(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaUsuario= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaUsuario= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaUsuario=true;

	public Boolean getMostrarNotaCreditoPuntoVentaUsuario() {
		return this.mostrarNotaCreditoPuntoVentaUsuario;
	}

	public void setMostrarNotaCreditoPuntoVentaUsuario(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaUsuario= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaUsuario=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaUsuario() {
		return this.activarNotaCreditoPuntoVentaUsuario;
	}

	public void setActivarNotaCreditoPuntoVentaUsuario(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaUsuario= habilitarResaltarNotaCreditoPuntoVenta;
	}


	public Border resaltarPlaneacionCompraUsuario=null;

	public Border getResaltarPlaneacionCompraUsuario() {
		return this.resaltarPlaneacionCompraUsuario;
	}

	public void setResaltarPlaneacionCompraUsuario(Border borderResaltarPlaneacionCompra) {
		if(borderResaltarPlaneacionCompra!=null) {
			this.resaltarPlaneacionCompraUsuario= borderResaltarPlaneacionCompra;
		}
	}

	public Border setResaltarPlaneacionCompraUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPlaneacionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPlaneacionCompra);
			
		this.resaltarPlaneacionCompraUsuario= borderResaltarPlaneacionCompra;

		 return borderResaltarPlaneacionCompra;
	}



	public Boolean mostrarPlaneacionCompraUsuario=true;

	public Boolean getMostrarPlaneacionCompraUsuario() {
		return this.mostrarPlaneacionCompraUsuario;
	}

	public void setMostrarPlaneacionCompraUsuario(Boolean visibilidadResaltarPlaneacionCompra) {
		this.mostrarPlaneacionCompraUsuario= visibilidadResaltarPlaneacionCompra;
	}



	public Boolean activarPlaneacionCompraUsuario=true;

	public Boolean gethabilitarResaltarPlaneacionCompraUsuario() {
		return this.activarPlaneacionCompraUsuario;
	}

	public void setActivarPlaneacionCompraUsuario(Boolean habilitarResaltarPlaneacionCompra) {
		this.activarPlaneacionCompraUsuario= habilitarResaltarPlaneacionCompra;
	}


	public Border resaltarPedidoCompraUsuario=null;

	public Border getResaltarPedidoCompraUsuario() {
		return this.resaltarPedidoCompraUsuario;
	}

	public void setResaltarPedidoCompraUsuario(Border borderResaltarPedidoCompra) {
		if(borderResaltarPedidoCompra!=null) {
			this.resaltarPedidoCompraUsuario= borderResaltarPedidoCompra;
		}
	}

	public Border setResaltarPedidoCompraUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPedidoCompra);
			
		this.resaltarPedidoCompraUsuario= borderResaltarPedidoCompra;

		 return borderResaltarPedidoCompra;
	}



	public Boolean mostrarPedidoCompraUsuario=true;

	public Boolean getMostrarPedidoCompraUsuario() {
		return this.mostrarPedidoCompraUsuario;
	}

	public void setMostrarPedidoCompraUsuario(Boolean visibilidadResaltarPedidoCompra) {
		this.mostrarPedidoCompraUsuario= visibilidadResaltarPedidoCompra;
	}



	public Boolean activarPedidoCompraUsuario=true;

	public Boolean gethabilitarResaltarPedidoCompraUsuario() {
		return this.activarPedidoCompraUsuario;
	}

	public void setActivarPedidoCompraUsuario(Boolean habilitarResaltarPedidoCompra) {
		this.activarPedidoCompraUsuario= habilitarResaltarPedidoCompra;
	}


	public Border resaltarPerfilUsuarioUsuario=null;

	public Border getResaltarPerfilUsuarioUsuario() {
		return this.resaltarPerfilUsuarioUsuario;
	}

	public void setResaltarPerfilUsuarioUsuario(Border borderResaltarPerfilUsuario) {
		if(borderResaltarPerfilUsuario!=null) {
			this.resaltarPerfilUsuarioUsuario= borderResaltarPerfilUsuario;
		}
	}

	public Border setResaltarPerfilUsuarioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilUsuario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarPerfilUsuario);
			
		this.resaltarPerfilUsuarioUsuario= borderResaltarPerfilUsuario;

		 return borderResaltarPerfilUsuario;
	}



	public Boolean mostrarPerfilUsuarioUsuario=true;

	public Boolean getMostrarPerfilUsuarioUsuario() {
		return this.mostrarPerfilUsuarioUsuario;
	}

	public void setMostrarPerfilUsuarioUsuario(Boolean visibilidadResaltarPerfilUsuario) {
		this.mostrarPerfilUsuarioUsuario= visibilidadResaltarPerfilUsuario;
	}



	public Boolean activarPerfilUsuarioUsuario=true;

	public Boolean gethabilitarResaltarPerfilUsuarioUsuario() {
		return this.activarPerfilUsuarioUsuario;
	}

	public void setActivarPerfilUsuarioUsuario(Boolean habilitarResaltarPerfilUsuario) {
		this.activarPerfilUsuarioUsuario= habilitarResaltarPerfilUsuario;
	}


	public Border resaltarConsignatarioUsuario=null;

	public Border getResaltarConsignatarioUsuario() {
		return this.resaltarConsignatarioUsuario;
	}

	public void setResaltarConsignatarioUsuario(Border borderResaltarConsignatario) {
		if(borderResaltarConsignatario!=null) {
			this.resaltarConsignatarioUsuario= borderResaltarConsignatario;
		}
	}

	public Border setResaltarConsignatarioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignatario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarConsignatario);
			
		this.resaltarConsignatarioUsuario= borderResaltarConsignatario;

		 return borderResaltarConsignatario;
	}



	public Boolean mostrarConsignatarioUsuario=true;

	public Boolean getMostrarConsignatarioUsuario() {
		return this.mostrarConsignatarioUsuario;
	}

	public void setMostrarConsignatarioUsuario(Boolean visibilidadResaltarConsignatario) {
		this.mostrarConsignatarioUsuario= visibilidadResaltarConsignatario;
	}



	public Boolean activarConsignatarioUsuario=true;

	public Boolean gethabilitarResaltarConsignatarioUsuario() {
		return this.activarConsignatarioUsuario;
	}

	public void setActivarConsignatarioUsuario(Boolean habilitarResaltarConsignatario) {
		this.activarConsignatarioUsuario= habilitarResaltarConsignatario;
	}


	public Border resaltarTransferenciaUsuario=null;

	public Border getResaltarTransferenciaUsuario() {
		return this.resaltarTransferenciaUsuario;
	}

	public void setResaltarTransferenciaUsuario(Border borderResaltarTransferencia) {
		if(borderResaltarTransferencia!=null) {
			this.resaltarTransferenciaUsuario= borderResaltarTransferencia;
		}
	}

	public Border setResaltarTransferenciaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarTransferencia);
			
		this.resaltarTransferenciaUsuario= borderResaltarTransferencia;

		 return borderResaltarTransferencia;
	}



	public Boolean mostrarTransferenciaUsuario=true;

	public Boolean getMostrarTransferenciaUsuario() {
		return this.mostrarTransferenciaUsuario;
	}

	public void setMostrarTransferenciaUsuario(Boolean visibilidadResaltarTransferencia) {
		this.mostrarTransferenciaUsuario= visibilidadResaltarTransferencia;
	}



	public Boolean activarTransferenciaUsuario=true;

	public Boolean gethabilitarResaltarTransferenciaUsuario() {
		return this.activarTransferenciaUsuario;
	}

	public void setActivarTransferenciaUsuario(Boolean habilitarResaltarTransferencia) {
		this.activarTransferenciaUsuario= habilitarResaltarTransferencia;
	}


	public Border resaltarDatoGeneralUsuarioUsuario=null;

	public Border getResaltarDatoGeneralUsuarioUsuario() {
		return this.resaltarDatoGeneralUsuarioUsuario;
	}

	public void setResaltarDatoGeneralUsuarioUsuario(Border borderResaltarDatoGeneralUsuario) {
		if(borderResaltarDatoGeneralUsuario!=null) {
			this.resaltarDatoGeneralUsuarioUsuario= borderResaltarDatoGeneralUsuario;
		}
	}

	public Border setResaltarDatoGeneralUsuarioUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralUsuario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDatoGeneralUsuario);
			
		this.resaltarDatoGeneralUsuarioUsuario= borderResaltarDatoGeneralUsuario;

		 return borderResaltarDatoGeneralUsuario;
	}



	public Boolean mostrarDatoGeneralUsuarioUsuario=true;

	public Boolean getMostrarDatoGeneralUsuarioUsuario() {
		return this.mostrarDatoGeneralUsuarioUsuario;
	}

	public void setMostrarDatoGeneralUsuarioUsuario(Boolean visibilidadResaltarDatoGeneralUsuario) {
		this.mostrarDatoGeneralUsuarioUsuario= visibilidadResaltarDatoGeneralUsuario;
	}



	public Boolean activarDatoGeneralUsuarioUsuario=true;

	public Boolean gethabilitarResaltarDatoGeneralUsuarioUsuario() {
		return this.activarDatoGeneralUsuarioUsuario;
	}

	public void setActivarDatoGeneralUsuarioUsuario(Boolean habilitarResaltarDatoGeneralUsuario) {
		this.activarDatoGeneralUsuarioUsuario= habilitarResaltarDatoGeneralUsuario;
	}


	public Border resaltarCajaIngresoUsuario=null;

	public Border getResaltarCajaIngresoUsuario() {
		return this.resaltarCajaIngresoUsuario;
	}

	public void setResaltarCajaIngresoUsuario(Border borderResaltarCajaIngreso) {
		if(borderResaltarCajaIngreso!=null) {
			this.resaltarCajaIngresoUsuario= borderResaltarCajaIngreso;
		}
	}

	public Border setResaltarCajaIngresoUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaIngreso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarCajaIngreso);
			
		this.resaltarCajaIngresoUsuario= borderResaltarCajaIngreso;

		 return borderResaltarCajaIngreso;
	}



	public Boolean mostrarCajaIngresoUsuario=true;

	public Boolean getMostrarCajaIngresoUsuario() {
		return this.mostrarCajaIngresoUsuario;
	}

	public void setMostrarCajaIngresoUsuario(Boolean visibilidadResaltarCajaIngreso) {
		this.mostrarCajaIngresoUsuario= visibilidadResaltarCajaIngreso;
	}



	public Boolean activarCajaIngresoUsuario=true;

	public Boolean gethabilitarResaltarCajaIngresoUsuario() {
		return this.activarCajaIngresoUsuario;
	}

	public void setActivarCajaIngresoUsuario(Boolean habilitarResaltarCajaIngreso) {
		this.activarCajaIngresoUsuario= habilitarResaltarCajaIngreso;
	}


	public Border resaltarClienteCoaUsuario=null;

	public Border getResaltarClienteCoaUsuario() {
		return this.resaltarClienteCoaUsuario;
	}

	public void setResaltarClienteCoaUsuario(Border borderResaltarClienteCoa) {
		if(borderResaltarClienteCoa!=null) {
			this.resaltarClienteCoaUsuario= borderResaltarClienteCoa;
		}
	}

	public Border setResaltarClienteCoaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarClienteCoa=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarClienteCoa);
			
		this.resaltarClienteCoaUsuario= borderResaltarClienteCoa;

		 return borderResaltarClienteCoa;
	}



	public Boolean mostrarClienteCoaUsuario=true;

	public Boolean getMostrarClienteCoaUsuario() {
		return this.mostrarClienteCoaUsuario;
	}

	public void setMostrarClienteCoaUsuario(Boolean visibilidadResaltarClienteCoa) {
		this.mostrarClienteCoaUsuario= visibilidadResaltarClienteCoa;
	}



	public Boolean activarClienteCoaUsuario=true;

	public Boolean gethabilitarResaltarClienteCoaUsuario() {
		return this.activarClienteCoaUsuario;
	}

	public void setActivarClienteCoaUsuario(Boolean habilitarResaltarClienteCoa) {
		this.activarClienteCoaUsuario= habilitarResaltarClienteCoa;
	}


	public Border resaltarConsignacionUsuario=null;

	public Border getResaltarConsignacionUsuario() {
		return this.resaltarConsignacionUsuario;
	}

	public void setResaltarConsignacionUsuario(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionUsuario= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionUsuario= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionUsuario=true;

	public Boolean getMostrarConsignacionUsuario() {
		return this.mostrarConsignacionUsuario;
	}

	public void setMostrarConsignacionUsuario(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionUsuario= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionUsuario=true;

	public Boolean gethabilitarResaltarConsignacionUsuario() {
		return this.activarConsignacionUsuario;
	}

	public void setActivarConsignacionUsuario(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionUsuario= habilitarResaltarConsignacion;
	}


	public Border resaltarDetalleMensajeCorreoInvenUsuario=null;

	public Border getResaltarDetalleMensajeCorreoInvenUsuario() {
		return this.resaltarDetalleMensajeCorreoInvenUsuario;
	}

	public void setResaltarDetalleMensajeCorreoInvenUsuario(Border borderResaltarDetalleMensajeCorreoInven) {
		if(borderResaltarDetalleMensajeCorreoInven!=null) {
			this.resaltarDetalleMensajeCorreoInvenUsuario= borderResaltarDetalleMensajeCorreoInven;
		}
	}

	public Border setResaltarDetalleMensajeCorreoInvenUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMensajeCorreoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//usuarioBeanSwingJInternalFrame.jTtoolBarUsuario.setBorder(borderResaltarDetalleMensajeCorreoInven);
			
		this.resaltarDetalleMensajeCorreoInvenUsuario= borderResaltarDetalleMensajeCorreoInven;

		 return borderResaltarDetalleMensajeCorreoInven;
	}



	public Boolean mostrarDetalleMensajeCorreoInvenUsuario=true;

	public Boolean getMostrarDetalleMensajeCorreoInvenUsuario() {
		return this.mostrarDetalleMensajeCorreoInvenUsuario;
	}

	public void setMostrarDetalleMensajeCorreoInvenUsuario(Boolean visibilidadResaltarDetalleMensajeCorreoInven) {
		this.mostrarDetalleMensajeCorreoInvenUsuario= visibilidadResaltarDetalleMensajeCorreoInven;
	}



	public Boolean activarDetalleMensajeCorreoInvenUsuario=true;

	public Boolean gethabilitarResaltarDetalleMensajeCorreoInvenUsuario() {
		return this.activarDetalleMensajeCorreoInvenUsuario;
	}

	public void setActivarDetalleMensajeCorreoInvenUsuario(Boolean habilitarResaltarDetalleMensajeCorreoInven) {
		this.activarDetalleMensajeCorreoInvenUsuario= habilitarResaltarDetalleMensajeCorreoInven;
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

		this.setMostrarDepositoBancoUsuario(esInicial);
		this.setMostrarHistorialCambioClaveUsuario(esInicial);
		this.setMostrarAutoriRetencionUsuario(esInicial);
		this.setMostrarCajeroTurnoUsuario(esInicial);
		this.setMostrarDetalleLiquidacionImporUsuario(esInicial);
		this.setMostrarNotaCreditoSoliUsuario(esInicial);
		this.setMostrarPedidoExporUsuario(esInicial);
		this.setMostrarDescuentoTipoPrecioUsuario(esInicial);
		this.setMostrarGuiaRemisionUsuario(esInicial);
		this.setMostrarPedidoPuntoVentaUsuario(esInicial);
		this.setMostrarGastoEmpleadoUsuario(esInicial);
		this.setMostrarSecuencialUsuarioUsuario(esInicial);
		this.setMostrarMovimientoActivoFijoUsuario(esInicial);
		this.setMostrarUsuarioOpcionUsuario(esInicial);
		this.setMostrarPedidoCompraImporUsuario(esInicial);
		this.setMostrarOrdenCompraUsuario(esInicial);
		this.setMostrarTurnoPunVenUsuario(esInicial);
		this.setMostrarNovedadUsuario(esInicial);
		this.setMostrarParametroGeneralUsuarioUsuario(esInicial);
		this.setMostrarAutoriPagoOrdenCompraUsuario(esInicial);
		this.setMostrarCierreCajaUsuario(esInicial);
		this.setMostrarDescuentoMontoUsuario(esInicial);
		this.setMostrarCajaEgresoUsuario(esInicial);
		this.setMostrarRequisicionCompraUsuario(esInicial);
		this.setMostrarNotaCreditoPuntoVentaUsuario(esInicial);
		this.setMostrarPlaneacionCompraUsuario(esInicial);
		this.setMostrarPedidoCompraUsuario(esInicial);
		this.setMostrarPerfilUsuarioUsuario(esInicial);
		this.setMostrarConsignatarioUsuario(esInicial);
		this.setMostrarTransferenciaUsuario(esInicial);
		this.setMostrarDatoGeneralUsuarioUsuario(esInicial);
		this.setMostrarCajaIngresoUsuario(esInicial);
		this.setMostrarClienteCoaUsuario(esInicial);
		this.setMostrarConsignacionUsuario(esInicial);
		this.setMostrarDetalleMensajeCorreoInvenUsuario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepositoBanco.class)) {
				this.setMostrarDepositoBancoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialCambioClave.class)) {
				this.setMostrarHistorialCambioClaveUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriRetencion.class)) {
				this.setMostrarAutoriRetencionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setMostrarCajeroTurnoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setMostrarDetalleLiquidacionImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setMostrarDescuentoTipoPrecioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setMostrarGuiaRemisionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setMostrarPedidoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setMostrarGastoEmpleadoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(SecuencialUsuario.class)) {
				this.setMostrarSecuencialUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setMostrarMovimientoActivoFijoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setMostrarUsuarioOpcionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setMostrarPedidoCompraImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setMostrarOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(TurnoPunVen.class)) {
				this.setMostrarTurnoPunVenUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setMostrarNovedadUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroGeneralUsuario.class)) {
				this.setMostrarParametroGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setMostrarAutoriPagoOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setMostrarCierreCajaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoMonto.class)) {
				this.setMostrarDescuentoMontoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setMostrarCajaEgresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setMostrarRequisicionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaneacionCompra.class)) {
				this.setMostrarPlaneacionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompra.class)) {
				this.setMostrarPedidoCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setMostrarPerfilUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setMostrarConsignatarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transferencia.class)) {
				this.setMostrarTransferenciaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralUsuario.class)) {
				this.setMostrarDatoGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setMostrarCajaIngresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setMostrarClienteCoaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setMostrarDetalleMensajeCorreoInvenUsuario(esAsigna);
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

		this.setActivarDepositoBancoUsuario(esInicial);
		this.setActivarHistorialCambioClaveUsuario(esInicial);
		this.setActivarAutoriRetencionUsuario(esInicial);
		this.setActivarCajeroTurnoUsuario(esInicial);
		this.setActivarDetalleLiquidacionImporUsuario(esInicial);
		this.setActivarNotaCreditoSoliUsuario(esInicial);
		this.setActivarPedidoExporUsuario(esInicial);
		this.setActivarDescuentoTipoPrecioUsuario(esInicial);
		this.setActivarGuiaRemisionUsuario(esInicial);
		this.setActivarPedidoPuntoVentaUsuario(esInicial);
		this.setActivarGastoEmpleadoUsuario(esInicial);
		this.setActivarSecuencialUsuarioUsuario(esInicial);
		this.setActivarMovimientoActivoFijoUsuario(esInicial);
		this.setActivarUsuarioOpcionUsuario(esInicial);
		this.setActivarPedidoCompraImporUsuario(esInicial);
		this.setActivarOrdenCompraUsuario(esInicial);
		this.setActivarTurnoPunVenUsuario(esInicial);
		this.setActivarNovedadUsuario(esInicial);
		this.setActivarParametroGeneralUsuarioUsuario(esInicial);
		this.setActivarAutoriPagoOrdenCompraUsuario(esInicial);
		this.setActivarCierreCajaUsuario(esInicial);
		this.setActivarDescuentoMontoUsuario(esInicial);
		this.setActivarCajaEgresoUsuario(esInicial);
		this.setActivarRequisicionCompraUsuario(esInicial);
		this.setActivarNotaCreditoPuntoVentaUsuario(esInicial);
		this.setActivarPlaneacionCompraUsuario(esInicial);
		this.setActivarPedidoCompraUsuario(esInicial);
		this.setActivarPerfilUsuarioUsuario(esInicial);
		this.setActivarConsignatarioUsuario(esInicial);
		this.setActivarTransferenciaUsuario(esInicial);
		this.setActivarDatoGeneralUsuarioUsuario(esInicial);
		this.setActivarCajaIngresoUsuario(esInicial);
		this.setActivarClienteCoaUsuario(esInicial);
		this.setActivarConsignacionUsuario(esInicial);
		this.setActivarDetalleMensajeCorreoInvenUsuario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepositoBanco.class)) {
				this.setActivarDepositoBancoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialCambioClave.class)) {
				this.setActivarHistorialCambioClaveUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriRetencion.class)) {
				this.setActivarAutoriRetencionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setActivarCajeroTurnoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setActivarDetalleLiquidacionImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setActivarDescuentoTipoPrecioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setActivarGuiaRemisionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setActivarPedidoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setActivarGastoEmpleadoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(SecuencialUsuario.class)) {
				this.setActivarSecuencialUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setActivarMovimientoActivoFijoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setActivarUsuarioOpcionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setActivarPedidoCompraImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setActivarOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(TurnoPunVen.class)) {
				this.setActivarTurnoPunVenUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setActivarNovedadUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroGeneralUsuario.class)) {
				this.setActivarParametroGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setActivarAutoriPagoOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setActivarCierreCajaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoMonto.class)) {
				this.setActivarDescuentoMontoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setActivarCajaEgresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setActivarRequisicionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaneacionCompra.class)) {
				this.setActivarPlaneacionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompra.class)) {
				this.setActivarPedidoCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setActivarPerfilUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setActivarConsignatarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transferencia.class)) {
				this.setActivarTransferenciaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralUsuario.class)) {
				this.setActivarDatoGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setActivarCajaIngresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setActivarClienteCoaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setActivarDetalleMensajeCorreoInvenUsuario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDepositoBancoUsuario(esInicial);
		this.setResaltarHistorialCambioClaveUsuario(esInicial);
		this.setResaltarAutoriRetencionUsuario(esInicial);
		this.setResaltarCajeroTurnoUsuario(esInicial);
		this.setResaltarDetalleLiquidacionImporUsuario(esInicial);
		this.setResaltarNotaCreditoSoliUsuario(esInicial);
		this.setResaltarPedidoExporUsuario(esInicial);
		this.setResaltarDescuentoTipoPrecioUsuario(esInicial);
		this.setResaltarGuiaRemisionUsuario(esInicial);
		this.setResaltarPedidoPuntoVentaUsuario(esInicial);
		this.setResaltarGastoEmpleadoUsuario(esInicial);
		this.setResaltarSecuencialUsuarioUsuario(esInicial);
		this.setResaltarMovimientoActivoFijoUsuario(esInicial);
		this.setResaltarUsuarioOpcionUsuario(esInicial);
		this.setResaltarPedidoCompraImporUsuario(esInicial);
		this.setResaltarOrdenCompraUsuario(esInicial);
		this.setResaltarTurnoPunVenUsuario(esInicial);
		this.setResaltarNovedadUsuario(esInicial);
		this.setResaltarParametroGeneralUsuarioUsuario(esInicial);
		this.setResaltarAutoriPagoOrdenCompraUsuario(esInicial);
		this.setResaltarCierreCajaUsuario(esInicial);
		this.setResaltarDescuentoMontoUsuario(esInicial);
		this.setResaltarCajaEgresoUsuario(esInicial);
		this.setResaltarRequisicionCompraUsuario(esInicial);
		this.setResaltarNotaCreditoPuntoVentaUsuario(esInicial);
		this.setResaltarPlaneacionCompraUsuario(esInicial);
		this.setResaltarPedidoCompraUsuario(esInicial);
		this.setResaltarPerfilUsuarioUsuario(esInicial);
		this.setResaltarConsignatarioUsuario(esInicial);
		this.setResaltarTransferenciaUsuario(esInicial);
		this.setResaltarDatoGeneralUsuarioUsuario(esInicial);
		this.setResaltarCajaIngresoUsuario(esInicial);
		this.setResaltarClienteCoaUsuario(esInicial);
		this.setResaltarConsignacionUsuario(esInicial);
		this.setResaltarDetalleMensajeCorreoInvenUsuario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepositoBanco.class)) {
				this.setResaltarDepositoBancoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialCambioClave.class)) {
				this.setResaltarHistorialCambioClaveUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriRetencion.class)) {
				this.setResaltarAutoriRetencionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setResaltarCajeroTurnoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setResaltarDetalleLiquidacionImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoTipoPrecio.class)) {
				this.setResaltarDescuentoTipoPrecioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setResaltarGuiaRemisionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setResaltarPedidoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setResaltarGastoEmpleadoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(SecuencialUsuario.class)) {
				this.setResaltarSecuencialUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setResaltarMovimientoActivoFijoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setResaltarUsuarioOpcionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setResaltarPedidoCompraImporUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(OrdenCompra.class)) {
				this.setResaltarOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(TurnoPunVen.class)) {
				this.setResaltarTurnoPunVenUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setResaltarNovedadUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroGeneralUsuario.class)) {
				this.setResaltarParametroGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setResaltarAutoriPagoOrdenCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setResaltarCierreCajaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DescuentoMonto.class)) {
				this.setResaltarDescuentoMontoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaEgreso.class)) {
				this.setResaltarCajaEgresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setResaltarRequisicionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaneacionCompra.class)) {
				this.setResaltarPlaneacionCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoCompra.class)) {
				this.setResaltarPedidoCompraUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setResaltarPerfilUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setResaltarConsignatarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transferencia.class)) {
				this.setResaltarTransferenciaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralUsuario.class)) {
				this.setResaltarDatoGeneralUsuarioUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajaIngreso.class)) {
				this.setResaltarCajaIngresoUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setResaltarClienteCoaUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionUsuario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setResaltarDetalleMensajeCorreoInvenUsuario(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreUsuario=true;

	public Boolean getMostrarBusquedaPorNombreUsuario() {
		return this.mostrarBusquedaPorNombreUsuario;
	}

	public void setMostrarBusquedaPorNombreUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreUsuario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorUserNameUsuario=true;

	public Boolean getMostrarBusquedaPorUserNameUsuario() {
		return this.mostrarBusquedaPorUserNameUsuario;
	}

	public void setMostrarBusquedaPorUserNameUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorUserNameUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUsuario=true;

	public Boolean getMostrarFK_IdEmpresaUsuario() {
		return this.mostrarFK_IdEmpresaUsuario;
	}

	public void setMostrarFK_IdEmpresaUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreUsuario=true;

	public Boolean getActivarBusquedaPorNombreUsuario() {
		return this.activarBusquedaPorNombreUsuario;
	}

	public void setActivarBusquedaPorNombreUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreUsuario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorUserNameUsuario=true;

	public Boolean getActivarBusquedaPorUserNameUsuario() {
		return this.activarBusquedaPorUserNameUsuario;
	}

	public void setActivarBusquedaPorUserNameUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorUserNameUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUsuario=true;

	public Boolean getActivarFK_IdEmpresaUsuario() {
		return this.activarFK_IdEmpresaUsuario;
	}

	public void setActivarFK_IdEmpresaUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUsuario= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreUsuario=null;

	public Border getResaltarBusquedaPorNombreUsuario() {
		return this.resaltarBusquedaPorNombreUsuario;
	}

	public void setResaltarBusquedaPorNombreUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorNombreUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreUsuario= borderResaltar;
	}

	public Border resaltarBusquedaPorUserNameUsuario=null;

	public Border getResaltarBusquedaPorUserNameUsuario() {
		return this.resaltarBusquedaPorUserNameUsuario;
	}

	public void setResaltarBusquedaPorUserNameUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorUserNameUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorUserNameUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorUserNameUsuario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUsuario=null;

	public Border getResaltarFK_IdEmpresaUsuario() {
		return this.resaltarFK_IdEmpresaUsuario;
	}

	public void setResaltarFK_IdEmpresaUsuario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUsuario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*UsuarioBeanSwingJInternalFrame usuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}