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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.SecuencialUsuarioConstantesFunciones;
import com.bydan.erp.facturacion.util.SecuencialUsuarioParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.SecuencialUsuarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SecuencialUsuarioConstantesFunciones extends SecuencialUsuarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SecuencialUsuario";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SecuencialUsuario"+SecuencialUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SecuencialUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SecuencialUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SecuencialUsuarioConstantesFunciones.SCHEMA+"_"+SecuencialUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SecuencialUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SecuencialUsuarioConstantesFunciones.SCHEMA+"_"+SecuencialUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SecuencialUsuarioConstantesFunciones.SCHEMA+"_"+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SecuencialUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SecuencialUsuarioConstantesFunciones.SCHEMA+"_"+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SecuencialUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SecuencialUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SecuencialUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SecuencialUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SecuencialUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SecuencialUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Secuencial Usuarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Secuencial Usuario";
	public static final String SCLASSWEBTITULO_LOWER="Secuencial Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SecuencialUsuario";
	public static final String OBJECTNAME="secuencialusuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="secuencial_usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select secuencialusuario from "+SecuencialUsuarioConstantesFunciones.SPERSISTENCENAME+" secuencialusuario";
	public static String QUERYSELECTNATIVE="select "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".version_row,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_empresa,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_sucursal,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".serie,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".autorizacion,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".secuencial,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".digitos,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".fecha_inicio,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".fecha_fin,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".esta_activo from "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME;//+" as "+SecuencialUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SecuencialUsuarioConstantesFuncionesAdditional secuencialusuarioConstantesFuncionesAdditional=null;
	
	public SecuencialUsuarioConstantesFuncionesAdditional getSecuencialUsuarioConstantesFuncionesAdditional() {
		return this.secuencialusuarioConstantesFuncionesAdditional;
	}
	
	public void setSecuencialUsuarioConstantesFuncionesAdditional(SecuencialUsuarioConstantesFuncionesAdditional secuencialusuarioConstantesFuncionesAdditional) {
		try {
			this.secuencialusuarioConstantesFuncionesAdditional=secuencialusuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDTIPODOCUMENTOGENERAL= "id_tipo_documento_general";
    public static final String SERIE= "serie";
    public static final String AUTORIZACION= "autorizacion";
    public static final String SECUENCIAL= "secuencial";
    public static final String DIGITOS= "digitos";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDTIPODOCUMENTOGENERAL= "T. Documento General";
		public static final String LABEL_IDTIPODOCUMENTOGENERAL_LOWER= "Tipo Documento General";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_AUTORIZACION= "Autorizacion";
		public static final String LABEL_AUTORIZACION_LOWER= "Autorizacion";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_DIGITOS= "Digitos";
		public static final String LABEL_DIGITOS_LOWER= "Digitos";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getSecuencialUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.SERIE)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.AUTORIZACION)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_AUTORIZACION;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.SECUENCIAL)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.DIGITOS)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_DIGITOS;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.FECHAINICIO)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.FECHAFIN)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(SecuencialUsuarioConstantesFunciones.ESTAACTIVO)) {sLabelColumna=SecuencialUsuarioConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(SecuencialUsuario secuencialusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!secuencialusuario.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(SecuencialUsuario secuencialusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(secuencialusuario.getId(),secuencialusuario.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getSecuencialUsuarioDescripcion(SecuencialUsuario secuencialusuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(secuencialusuario !=null/* && secuencialusuario.getId()!=0*/) {
			if(secuencialusuario.getId()!=null) {
				sDescripcion=secuencialusuario.getId().toString();
			}//secuencialusuariosecuencialusuario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSecuencialUsuarioDescripcionDetallado(SecuencialUsuario secuencialusuario) {
		String sDescripcion="";
			
		sDescripcion+=SecuencialUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=secuencialusuario.getId().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=secuencialusuario.getVersionRow().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=secuencialusuario.getid_empresa().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=secuencialusuario.getid_sucursal().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=secuencialusuario.getid_usuario().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL+"=";
		sDescripcion+=secuencialusuario.getid_tipo_documento_general().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.SERIE+"=";
		sDescripcion+=secuencialusuario.getserie()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.AUTORIZACION+"=";
		sDescripcion+=secuencialusuario.getautorizacion()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=secuencialusuario.getsecuencial()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.DIGITOS+"=";
		sDescripcion+=secuencialusuario.getdigitos().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=secuencialusuario.getfecha_inicio().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=secuencialusuario.getfecha_fin().toString()+",";
		sDescripcion+=SecuencialUsuarioConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=secuencialusuario.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSecuencialUsuarioDescripcion(SecuencialUsuario secuencialusuario,String sValor) throws Exception {			
		if(secuencialusuario !=null) {
			//secuencialusuariosecuencialusuario.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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

	public static String getTipoDocumentoGeneralDescripcion(TipoDocumentoGeneral tipodocumentogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumentogeneral!=null/*&&tipodocumentogeneral.getId()>0*/) {
			sDescripcion=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(tipodocumentogeneral);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorAutorizacion")) {
			sNombreIndice="Tipo=  Por Autorizacion";
		} else if(sNombreIndice.equals("BusquedaPorFechaFin")) {
			sNombreIndice="Tipo=  Por Fecha Fin";
		} else if(sNombreIndice.equals("BusquedaPorFechaInicio")) {
			sNombreIndice="Tipo=  Por Fecha Inicio";
		} else if(sNombreIndice.equals("BusquedaPorIdUsuarioPorIdTipoDocumentoGeneral")) {
			sNombreIndice="Tipo=  Por Usuario Por T. Documento General";
		} else if(sNombreIndice.equals("BusquedaPorSerie")) {
			sNombreIndice="Tipo=  Por Serie";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoGeneral")) {
			sNombreIndice="Tipo=  Por T. Documento General";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("PorEmpresaPorSucursalPorUsuarioPorDocu")) {
			sNombreIndice="Tipo=  Por Empresa Por Sucursal Por Usuario Por T. Documento General";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorAutorizacion(String autorizacion) {
		String sDetalleIndice=" Parametros->";
		if(autorizacion!=null) {sDetalleIndice+=" Autorizacion="+autorizacion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaFin(Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaInicio(Date fecha_inicio) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdUsuarioPorIdTipoDocumentoGeneral(Long id_usuario,Long id_tipo_documento_general) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(id_tipo_documento_general!=null) {sDetalleIndice+=" Codigo Unico De T. Documento General="+id_tipo_documento_general.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSerie(String serie) {
		String sDetalleIndice=" Parametros->";
		if(serie!=null) {sDetalleIndice+=" Serie="+serie;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoGeneral(Long id_tipo_documento_general) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_general!=null) {sDetalleIndice+=" Codigo Unico De T. Documento General="+id_tipo_documento_general.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorSucursalPorUsuarioPorDocu(Long id_empresa,Long id_sucursal,Long id_usuario,Long id_tipo_documento_general) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();}
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(id_tipo_documento_general!=null) {sDetalleIndice+=" Codigo Unico De T. Documento General="+id_tipo_documento_general.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSecuencialUsuario(SecuencialUsuario secuencialusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		secuencialusuario.setserie(secuencialusuario.getserie().trim());
		secuencialusuario.setautorizacion(secuencialusuario.getautorizacion().trim());
		secuencialusuario.setsecuencial(secuencialusuario.getsecuencial().trim());
	}
	
	public static void quitarEspaciosSecuencialUsuarios(List<SecuencialUsuario> secuencialusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SecuencialUsuario secuencialusuario: secuencialusuarios) {
			secuencialusuario.setserie(secuencialusuario.getserie().trim());
			secuencialusuario.setautorizacion(secuencialusuario.getautorizacion().trim());
			secuencialusuario.setsecuencial(secuencialusuario.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSecuencialUsuario(SecuencialUsuario secuencialusuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && secuencialusuario.getConCambioAuxiliar()) {
			secuencialusuario.setIsDeleted(secuencialusuario.getIsDeletedAuxiliar());	
			secuencialusuario.setIsNew(secuencialusuario.getIsNewAuxiliar());	
			secuencialusuario.setIsChanged(secuencialusuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			secuencialusuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			secuencialusuario.setIsDeletedAuxiliar(false);	
			secuencialusuario.setIsNewAuxiliar(false);	
			secuencialusuario.setIsChangedAuxiliar(false);
			
			secuencialusuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSecuencialUsuarios(List<SecuencialUsuario> secuencialusuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SecuencialUsuario secuencialusuario : secuencialusuarios) {
			if(conAsignarBase && secuencialusuario.getConCambioAuxiliar()) {
				secuencialusuario.setIsDeleted(secuencialusuario.getIsDeletedAuxiliar());	
				secuencialusuario.setIsNew(secuencialusuario.getIsNewAuxiliar());	
				secuencialusuario.setIsChanged(secuencialusuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				secuencialusuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				secuencialusuario.setIsDeletedAuxiliar(false);	
				secuencialusuario.setIsNewAuxiliar(false);	
				secuencialusuario.setIsChangedAuxiliar(false);
				
				secuencialusuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSecuencialUsuario(SecuencialUsuario secuencialusuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			secuencialusuario.setdigitos(0);
		}
	}		
	
	public static void InicializarValoresSecuencialUsuarios(List<SecuencialUsuario> secuencialusuarios,Boolean conEnteros) throws Exception  {
		
		for(SecuencialUsuario secuencialusuario: secuencialusuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				secuencialusuario.setdigitos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSecuencialUsuario(List<SecuencialUsuario> secuencialusuarios,SecuencialUsuario secuencialusuarioAux) throws Exception  {
		SecuencialUsuarioConstantesFunciones.InicializarValoresSecuencialUsuario(secuencialusuarioAux,true);
		
		for(SecuencialUsuario secuencialusuario: secuencialusuarios) {
			if(secuencialusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			secuencialusuarioAux.setdigitos(secuencialusuarioAux.getdigitos()+secuencialusuario.getdigitos());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSecuencialUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SecuencialUsuarioConstantesFunciones.getArrayColumnasGlobalesSecuencialUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSecuencialUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialUsuarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialUsuarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialUsuarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialUsuarioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialUsuarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialUsuarioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSecuencialUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SecuencialUsuarioConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SecuencialUsuario> secuencialusuarios,SecuencialUsuario secuencialusuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SecuencialUsuario secuencialusuarioAux: secuencialusuarios) {
			if(secuencialusuarioAux!=null && secuencialusuario!=null) {
				if((secuencialusuarioAux.getId()==null && secuencialusuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(secuencialusuarioAux.getId()!=null && secuencialusuario.getId()!=null){
					if(secuencialusuarioAux.getId().equals(secuencialusuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSecuencialUsuario(List<SecuencialUsuario> secuencialusuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SecuencialUsuario secuencialusuario: secuencialusuarios) {			
			if(secuencialusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSecuencialUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_ID, SecuencialUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_VERSIONROW, SecuencialUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_IDEMPRESA, SecuencialUsuarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_IDSUCURSAL, SecuencialUsuarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_IDUSUARIO, SecuencialUsuarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL, SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_SERIE, SecuencialUsuarioConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_AUTORIZACION, SecuencialUsuarioConstantesFunciones.AUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_SECUENCIAL, SecuencialUsuarioConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_DIGITOS, SecuencialUsuarioConstantesFunciones.DIGITOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_FECHAINICIO, SecuencialUsuarioConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_FECHAFIN, SecuencialUsuarioConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialUsuarioConstantesFunciones.LABEL_ESTAACTIVO, SecuencialUsuarioConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSecuencialUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.AUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.DIGITOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialUsuarioConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencialUsuario() throws Exception  {
		return SecuencialUsuarioConstantesFunciones.getTiposSeleccionarSecuencialUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencialUsuario(Boolean conFk) throws Exception  {
		return SecuencialUsuarioConstantesFunciones.getTiposSeleccionarSecuencialUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencialUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_AUTORIZACION);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_AUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_DIGITOS);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_DIGITOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialUsuarioConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(SecuencialUsuarioConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSecuencialUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSecuencialUsuario(SecuencialUsuario secuencialusuarioAux) throws Exception {
		
			secuencialusuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(secuencialusuarioAux.getEmpresa()));
			secuencialusuarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(secuencialusuarioAux.getSucursal()));
			secuencialusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(secuencialusuarioAux.getUsuario()));
			secuencialusuarioAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(secuencialusuarioAux.getTipoDocumentoGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSecuencialUsuario(List<SecuencialUsuario> secuencialusuariosTemp) throws Exception {
		for(SecuencialUsuario secuencialusuarioAux:secuencialusuariosTemp) {
			
			secuencialusuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(secuencialusuarioAux.getEmpresa()));
			secuencialusuarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(secuencialusuarioAux.getSucursal()));
			secuencialusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(secuencialusuarioAux.getUsuario()));
			secuencialusuarioAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(secuencialusuarioAux.getTipoDocumentoGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSecuencialUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(TipoDocumentoGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumentoGeneral.class)) {
						classes.add(new Classe(TipoDocumentoGeneral.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSecuencialUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencialUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SecuencialUsuarioConstantesFunciones.getClassesRelationshipsOfSecuencialUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencialUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSecuencialUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SecuencialUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfSecuencialUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSecuencialUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SecuencialUsuario secuencialusuario,List<SecuencialUsuario> secuencialusuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SecuencialUsuario secuencialusuarioEncontrado=null;
			
			for(SecuencialUsuario secuencialusuarioLocal:secuencialusuarios) {
				if(secuencialusuarioLocal.getId().equals(secuencialusuario.getId())) {
					secuencialusuarioEncontrado=secuencialusuarioLocal;
					
					secuencialusuarioLocal.setIsChanged(secuencialusuario.getIsChanged());
					secuencialusuarioLocal.setIsNew(secuencialusuario.getIsNew());
					secuencialusuarioLocal.setIsDeleted(secuencialusuario.getIsDeleted());
					
					secuencialusuarioLocal.setGeneralEntityOriginal(secuencialusuario.getGeneralEntityOriginal());
					
					secuencialusuarioLocal.setId(secuencialusuario.getId());	
					secuencialusuarioLocal.setVersionRow(secuencialusuario.getVersionRow());	
					secuencialusuarioLocal.setid_empresa(secuencialusuario.getid_empresa());	
					secuencialusuarioLocal.setid_sucursal(secuencialusuario.getid_sucursal());	
					secuencialusuarioLocal.setid_usuario(secuencialusuario.getid_usuario());	
					secuencialusuarioLocal.setid_tipo_documento_general(secuencialusuario.getid_tipo_documento_general());	
					secuencialusuarioLocal.setserie(secuencialusuario.getserie());	
					secuencialusuarioLocal.setautorizacion(secuencialusuario.getautorizacion());	
					secuencialusuarioLocal.setsecuencial(secuencialusuario.getsecuencial());	
					secuencialusuarioLocal.setdigitos(secuencialusuario.getdigitos());	
					secuencialusuarioLocal.setfecha_inicio(secuencialusuario.getfecha_inicio());	
					secuencialusuarioLocal.setfecha_fin(secuencialusuario.getfecha_fin());	
					secuencialusuarioLocal.setesta_activo(secuencialusuario.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!secuencialusuario.getIsDeleted()) {
				if(!existe) {
					secuencialusuarios.add(secuencialusuario);
				}
			} else {
				if(secuencialusuarioEncontrado!=null && permiteQuitar)  {
					secuencialusuarios.remove(secuencialusuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SecuencialUsuario secuencialusuario,List<SecuencialUsuario> secuencialusuarios) throws Exception {
		try	{			
			for(SecuencialUsuario secuencialusuarioLocal:secuencialusuarios) {
				if(secuencialusuarioLocal.getId().equals(secuencialusuario.getId())) {
					secuencialusuarioLocal.setIsSelected(secuencialusuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSecuencialUsuario(List<SecuencialUsuario> secuencialusuariosAux) throws Exception {
		//this.secuencialusuariosAux=secuencialusuariosAux;
		
		for(SecuencialUsuario secuencialusuarioAux:secuencialusuariosAux) {
			if(secuencialusuarioAux.getIsChanged()) {
				secuencialusuarioAux.setIsChanged(false);
			}		
			
			if(secuencialusuarioAux.getIsNew()) {
				secuencialusuarioAux.setIsNew(false);
			}	
			
			if(secuencialusuarioAux.getIsDeleted()) {
				secuencialusuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSecuencialUsuario(SecuencialUsuario secuencialusuarioAux) throws Exception {
		//this.secuencialusuarioAux=secuencialusuarioAux;
		
			if(secuencialusuarioAux.getIsChanged()) {
				secuencialusuarioAux.setIsChanged(false);
			}		
			
			if(secuencialusuarioAux.getIsNew()) {
				secuencialusuarioAux.setIsNew(false);
			}	
			
			if(secuencialusuarioAux.getIsDeleted()) {
				secuencialusuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SecuencialUsuario secuencialusuarioAsignar,SecuencialUsuario secuencialusuario) throws Exception {
		secuencialusuarioAsignar.setId(secuencialusuario.getId());	
		secuencialusuarioAsignar.setVersionRow(secuencialusuario.getVersionRow());	
		secuencialusuarioAsignar.setid_empresa(secuencialusuario.getid_empresa());
		secuencialusuarioAsignar.setempresa_descripcion(secuencialusuario.getempresa_descripcion());	
		secuencialusuarioAsignar.setid_sucursal(secuencialusuario.getid_sucursal());
		secuencialusuarioAsignar.setsucursal_descripcion(secuencialusuario.getsucursal_descripcion());	
		secuencialusuarioAsignar.setid_usuario(secuencialusuario.getid_usuario());
		secuencialusuarioAsignar.setusuario_descripcion(secuencialusuario.getusuario_descripcion());	
		secuencialusuarioAsignar.setid_tipo_documento_general(secuencialusuario.getid_tipo_documento_general());
		secuencialusuarioAsignar.settipodocumentogeneral_descripcion(secuencialusuario.gettipodocumentogeneral_descripcion());	
		secuencialusuarioAsignar.setserie(secuencialusuario.getserie());	
		secuencialusuarioAsignar.setautorizacion(secuencialusuario.getautorizacion());	
		secuencialusuarioAsignar.setsecuencial(secuencialusuario.getsecuencial());	
		secuencialusuarioAsignar.setdigitos(secuencialusuario.getdigitos());	
		secuencialusuarioAsignar.setfecha_inicio(secuencialusuario.getfecha_inicio());	
		secuencialusuarioAsignar.setfecha_fin(secuencialusuario.getfecha_fin());	
		secuencialusuarioAsignar.setesta_activo(secuencialusuario.getesta_activo());	
	}
	
	public static void inicializarSecuencialUsuario(SecuencialUsuario secuencialusuario) throws Exception {
		try {
				secuencialusuario.setId(0L);	
					
				secuencialusuario.setid_empresa(-1L);	
				secuencialusuario.setid_sucursal(-1L);	
				secuencialusuario.setid_usuario(-1L);	
				secuencialusuario.setid_tipo_documento_general(-1L);	
				secuencialusuario.setserie("");	
				secuencialusuario.setautorizacion("");	
				secuencialusuario.setsecuencial("");	
				secuencialusuario.setdigitos(0);	
				secuencialusuario.setfecha_inicio(new Date());	
				secuencialusuario.setfecha_fin(new Date());	
				secuencialusuario.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSecuencialUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_AUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_DIGITOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialUsuarioConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSecuencialUsuario(String sTipo,Row row,Workbook workbook,SecuencialUsuario secuencialusuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.gettipodocumentogeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getautorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getdigitos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencialusuario.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(secuencialusuario.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySecuencialUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySecuencialUsuario() {
		return this.sFinalQuerySecuencialUsuario;
	}
	
	public void setsFinalQuerySecuencialUsuario(String sFinalQuerySecuencialUsuario) {
		this.sFinalQuerySecuencialUsuario= sFinalQuerySecuencialUsuario;
	}
	
	public Border resaltarSeleccionarSecuencialUsuario=null;
	
	public Border setResaltarSeleccionarSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSecuencialUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSecuencialUsuario() {
		return this.resaltarSeleccionarSecuencialUsuario;
	}
	
	public void setResaltarSeleccionarSecuencialUsuario(Border borderResaltarSeleccionarSecuencialUsuario) {
		this.resaltarSeleccionarSecuencialUsuario= borderResaltarSeleccionarSecuencialUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSecuencialUsuario=null;
	public Boolean mostraridSecuencialUsuario=true;
	public Boolean activaridSecuencialUsuario=true;

	public Border resaltarid_empresaSecuencialUsuario=null;
	public Boolean mostrarid_empresaSecuencialUsuario=true;
	public Boolean activarid_empresaSecuencialUsuario=true;
	public Boolean cargarid_empresaSecuencialUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSecuencialUsuario=false;//ConEventDepend=true

	public Border resaltarid_sucursalSecuencialUsuario=null;
	public Boolean mostrarid_sucursalSecuencialUsuario=true;
	public Boolean activarid_sucursalSecuencialUsuario=true;
	public Boolean cargarid_sucursalSecuencialUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSecuencialUsuario=false;//ConEventDepend=true

	public Border resaltarid_usuarioSecuencialUsuario=null;
	public Boolean mostrarid_usuarioSecuencialUsuario=true;
	public Boolean activarid_usuarioSecuencialUsuario=true;
	public Boolean cargarid_usuarioSecuencialUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioSecuencialUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_generalSecuencialUsuario=null;
	public Boolean mostrarid_tipo_documento_generalSecuencialUsuario=true;
	public Boolean activarid_tipo_documento_generalSecuencialUsuario=true;
	public Boolean cargarid_tipo_documento_generalSecuencialUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_generalSecuencialUsuario=false;//ConEventDepend=true

	public Border resaltarserieSecuencialUsuario=null;
	public Boolean mostrarserieSecuencialUsuario=true;
	public Boolean activarserieSecuencialUsuario=true;

	public Border resaltarautorizacionSecuencialUsuario=null;
	public Boolean mostrarautorizacionSecuencialUsuario=true;
	public Boolean activarautorizacionSecuencialUsuario=true;

	public Border resaltarsecuencialSecuencialUsuario=null;
	public Boolean mostrarsecuencialSecuencialUsuario=true;
	public Boolean activarsecuencialSecuencialUsuario=true;

	public Border resaltardigitosSecuencialUsuario=null;
	public Boolean mostrardigitosSecuencialUsuario=true;
	public Boolean activardigitosSecuencialUsuario=true;

	public Border resaltarfecha_inicioSecuencialUsuario=null;
	public Boolean mostrarfecha_inicioSecuencialUsuario=true;
	public Boolean activarfecha_inicioSecuencialUsuario=true;

	public Border resaltarfecha_finSecuencialUsuario=null;
	public Boolean mostrarfecha_finSecuencialUsuario=true;
	public Boolean activarfecha_finSecuencialUsuario=true;

	public Border resaltaresta_activoSecuencialUsuario=null;
	public Boolean mostraresta_activoSecuencialUsuario=true;
	public Boolean activaresta_activoSecuencialUsuario=true;

	
	

	public Border setResaltaridSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltaridSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSecuencialUsuario() {
		return this.resaltaridSecuencialUsuario;
	}

	public void setResaltaridSecuencialUsuario(Border borderResaltar) {
		this.resaltaridSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostraridSecuencialUsuario() {
		return this.mostraridSecuencialUsuario;
	}

	public void setMostraridSecuencialUsuario(Boolean mostraridSecuencialUsuario) {
		this.mostraridSecuencialUsuario= mostraridSecuencialUsuario;
	}

	public Boolean getActivaridSecuencialUsuario() {
		return this.activaridSecuencialUsuario;
	}

	public void setActivaridSecuencialUsuario(Boolean activaridSecuencialUsuario) {
		this.activaridSecuencialUsuario= activaridSecuencialUsuario;
	}

	public Border setResaltarid_empresaSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarid_empresaSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSecuencialUsuario() {
		return this.resaltarid_empresaSecuencialUsuario;
	}

	public void setResaltarid_empresaSecuencialUsuario(Border borderResaltar) {
		this.resaltarid_empresaSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarid_empresaSecuencialUsuario() {
		return this.mostrarid_empresaSecuencialUsuario;
	}

	public void setMostrarid_empresaSecuencialUsuario(Boolean mostrarid_empresaSecuencialUsuario) {
		this.mostrarid_empresaSecuencialUsuario= mostrarid_empresaSecuencialUsuario;
	}

	public Boolean getActivarid_empresaSecuencialUsuario() {
		return this.activarid_empresaSecuencialUsuario;
	}

	public void setActivarid_empresaSecuencialUsuario(Boolean activarid_empresaSecuencialUsuario) {
		this.activarid_empresaSecuencialUsuario= activarid_empresaSecuencialUsuario;
	}

	public Boolean getCargarid_empresaSecuencialUsuario() {
		return this.cargarid_empresaSecuencialUsuario;
	}

	public void setCargarid_empresaSecuencialUsuario(Boolean cargarid_empresaSecuencialUsuario) {
		this.cargarid_empresaSecuencialUsuario= cargarid_empresaSecuencialUsuario;
	}

	public Border setResaltarid_sucursalSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSecuencialUsuario() {
		return this.resaltarid_sucursalSecuencialUsuario;
	}

	public void setResaltarid_sucursalSecuencialUsuario(Border borderResaltar) {
		this.resaltarid_sucursalSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSecuencialUsuario() {
		return this.mostrarid_sucursalSecuencialUsuario;
	}

	public void setMostrarid_sucursalSecuencialUsuario(Boolean mostrarid_sucursalSecuencialUsuario) {
		this.mostrarid_sucursalSecuencialUsuario= mostrarid_sucursalSecuencialUsuario;
	}

	public Boolean getActivarid_sucursalSecuencialUsuario() {
		return this.activarid_sucursalSecuencialUsuario;
	}

	public void setActivarid_sucursalSecuencialUsuario(Boolean activarid_sucursalSecuencialUsuario) {
		this.activarid_sucursalSecuencialUsuario= activarid_sucursalSecuencialUsuario;
	}

	public Boolean getCargarid_sucursalSecuencialUsuario() {
		return this.cargarid_sucursalSecuencialUsuario;
	}

	public void setCargarid_sucursalSecuencialUsuario(Boolean cargarid_sucursalSecuencialUsuario) {
		this.cargarid_sucursalSecuencialUsuario= cargarid_sucursalSecuencialUsuario;
	}

	public Border setResaltarid_usuarioSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioSecuencialUsuario() {
		return this.resaltarid_usuarioSecuencialUsuario;
	}

	public void setResaltarid_usuarioSecuencialUsuario(Border borderResaltar) {
		this.resaltarid_usuarioSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioSecuencialUsuario() {
		return this.mostrarid_usuarioSecuencialUsuario;
	}

	public void setMostrarid_usuarioSecuencialUsuario(Boolean mostrarid_usuarioSecuencialUsuario) {
		this.mostrarid_usuarioSecuencialUsuario= mostrarid_usuarioSecuencialUsuario;
	}

	public Boolean getActivarid_usuarioSecuencialUsuario() {
		return this.activarid_usuarioSecuencialUsuario;
	}

	public void setActivarid_usuarioSecuencialUsuario(Boolean activarid_usuarioSecuencialUsuario) {
		this.activarid_usuarioSecuencialUsuario= activarid_usuarioSecuencialUsuario;
	}

	public Boolean getCargarid_usuarioSecuencialUsuario() {
		return this.cargarid_usuarioSecuencialUsuario;
	}

	public void setCargarid_usuarioSecuencialUsuario(Boolean cargarid_usuarioSecuencialUsuario) {
		this.cargarid_usuarioSecuencialUsuario= cargarid_usuarioSecuencialUsuario;
	}

	public Border setResaltarid_tipo_documento_generalSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_generalSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_generalSecuencialUsuario() {
		return this.resaltarid_tipo_documento_generalSecuencialUsuario;
	}

	public void setResaltarid_tipo_documento_generalSecuencialUsuario(Border borderResaltar) {
		this.resaltarid_tipo_documento_generalSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_generalSecuencialUsuario() {
		return this.mostrarid_tipo_documento_generalSecuencialUsuario;
	}

	public void setMostrarid_tipo_documento_generalSecuencialUsuario(Boolean mostrarid_tipo_documento_generalSecuencialUsuario) {
		this.mostrarid_tipo_documento_generalSecuencialUsuario= mostrarid_tipo_documento_generalSecuencialUsuario;
	}

	public Boolean getActivarid_tipo_documento_generalSecuencialUsuario() {
		return this.activarid_tipo_documento_generalSecuencialUsuario;
	}

	public void setActivarid_tipo_documento_generalSecuencialUsuario(Boolean activarid_tipo_documento_generalSecuencialUsuario) {
		this.activarid_tipo_documento_generalSecuencialUsuario= activarid_tipo_documento_generalSecuencialUsuario;
	}

	public Boolean getCargarid_tipo_documento_generalSecuencialUsuario() {
		return this.cargarid_tipo_documento_generalSecuencialUsuario;
	}

	public void setCargarid_tipo_documento_generalSecuencialUsuario(Boolean cargarid_tipo_documento_generalSecuencialUsuario) {
		this.cargarid_tipo_documento_generalSecuencialUsuario= cargarid_tipo_documento_generalSecuencialUsuario;
	}

	public Border setResaltarserieSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarserieSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieSecuencialUsuario() {
		return this.resaltarserieSecuencialUsuario;
	}

	public void setResaltarserieSecuencialUsuario(Border borderResaltar) {
		this.resaltarserieSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarserieSecuencialUsuario() {
		return this.mostrarserieSecuencialUsuario;
	}

	public void setMostrarserieSecuencialUsuario(Boolean mostrarserieSecuencialUsuario) {
		this.mostrarserieSecuencialUsuario= mostrarserieSecuencialUsuario;
	}

	public Boolean getActivarserieSecuencialUsuario() {
		return this.activarserieSecuencialUsuario;
	}

	public void setActivarserieSecuencialUsuario(Boolean activarserieSecuencialUsuario) {
		this.activarserieSecuencialUsuario= activarserieSecuencialUsuario;
	}

	public Border setResaltarautorizacionSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarautorizacionSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacionSecuencialUsuario() {
		return this.resaltarautorizacionSecuencialUsuario;
	}

	public void setResaltarautorizacionSecuencialUsuario(Border borderResaltar) {
		this.resaltarautorizacionSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarautorizacionSecuencialUsuario() {
		return this.mostrarautorizacionSecuencialUsuario;
	}

	public void setMostrarautorizacionSecuencialUsuario(Boolean mostrarautorizacionSecuencialUsuario) {
		this.mostrarautorizacionSecuencialUsuario= mostrarautorizacionSecuencialUsuario;
	}

	public Boolean getActivarautorizacionSecuencialUsuario() {
		return this.activarautorizacionSecuencialUsuario;
	}

	public void setActivarautorizacionSecuencialUsuario(Boolean activarautorizacionSecuencialUsuario) {
		this.activarautorizacionSecuencialUsuario= activarautorizacionSecuencialUsuario;
	}

	public Border setResaltarsecuencialSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarsecuencialSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialSecuencialUsuario() {
		return this.resaltarsecuencialSecuencialUsuario;
	}

	public void setResaltarsecuencialSecuencialUsuario(Border borderResaltar) {
		this.resaltarsecuencialSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarsecuencialSecuencialUsuario() {
		return this.mostrarsecuencialSecuencialUsuario;
	}

	public void setMostrarsecuencialSecuencialUsuario(Boolean mostrarsecuencialSecuencialUsuario) {
		this.mostrarsecuencialSecuencialUsuario= mostrarsecuencialSecuencialUsuario;
	}

	public Boolean getActivarsecuencialSecuencialUsuario() {
		return this.activarsecuencialSecuencialUsuario;
	}

	public void setActivarsecuencialSecuencialUsuario(Boolean activarsecuencialSecuencialUsuario) {
		this.activarsecuencialSecuencialUsuario= activarsecuencialSecuencialUsuario;
	}

	public Border setResaltardigitosSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltardigitosSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardigitosSecuencialUsuario() {
		return this.resaltardigitosSecuencialUsuario;
	}

	public void setResaltardigitosSecuencialUsuario(Border borderResaltar) {
		this.resaltardigitosSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrardigitosSecuencialUsuario() {
		return this.mostrardigitosSecuencialUsuario;
	}

	public void setMostrardigitosSecuencialUsuario(Boolean mostrardigitosSecuencialUsuario) {
		this.mostrardigitosSecuencialUsuario= mostrardigitosSecuencialUsuario;
	}

	public Boolean getActivardigitosSecuencialUsuario() {
		return this.activardigitosSecuencialUsuario;
	}

	public void setActivardigitosSecuencialUsuario(Boolean activardigitosSecuencialUsuario) {
		this.activardigitosSecuencialUsuario= activardigitosSecuencialUsuario;
	}

	public Border setResaltarfecha_inicioSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioSecuencialUsuario() {
		return this.resaltarfecha_inicioSecuencialUsuario;
	}

	public void setResaltarfecha_inicioSecuencialUsuario(Border borderResaltar) {
		this.resaltarfecha_inicioSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioSecuencialUsuario() {
		return this.mostrarfecha_inicioSecuencialUsuario;
	}

	public void setMostrarfecha_inicioSecuencialUsuario(Boolean mostrarfecha_inicioSecuencialUsuario) {
		this.mostrarfecha_inicioSecuencialUsuario= mostrarfecha_inicioSecuencialUsuario;
	}

	public Boolean getActivarfecha_inicioSecuencialUsuario() {
		return this.activarfecha_inicioSecuencialUsuario;
	}

	public void setActivarfecha_inicioSecuencialUsuario(Boolean activarfecha_inicioSecuencialUsuario) {
		this.activarfecha_inicioSecuencialUsuario= activarfecha_inicioSecuencialUsuario;
	}

	public Border setResaltarfecha_finSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_finSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finSecuencialUsuario() {
		return this.resaltarfecha_finSecuencialUsuario;
	}

	public void setResaltarfecha_finSecuencialUsuario(Border borderResaltar) {
		this.resaltarfecha_finSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_finSecuencialUsuario() {
		return this.mostrarfecha_finSecuencialUsuario;
	}

	public void setMostrarfecha_finSecuencialUsuario(Boolean mostrarfecha_finSecuencialUsuario) {
		this.mostrarfecha_finSecuencialUsuario= mostrarfecha_finSecuencialUsuario;
	}

	public Boolean getActivarfecha_finSecuencialUsuario() {
		return this.activarfecha_finSecuencialUsuario;
	}

	public void setActivarfecha_finSecuencialUsuario(Boolean activarfecha_finSecuencialUsuario) {
		this.activarfecha_finSecuencialUsuario= activarfecha_finSecuencialUsuario;
	}

	public Border setResaltaresta_activoSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialusuarioBeanSwingJInternalFrame.jTtoolBarSecuencialUsuario.setBorder(borderResaltar);
		
		this.resaltaresta_activoSecuencialUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoSecuencialUsuario() {
		return this.resaltaresta_activoSecuencialUsuario;
	}

	public void setResaltaresta_activoSecuencialUsuario(Border borderResaltar) {
		this.resaltaresta_activoSecuencialUsuario= borderResaltar;
	}

	public Boolean getMostraresta_activoSecuencialUsuario() {
		return this.mostraresta_activoSecuencialUsuario;
	}

	public void setMostraresta_activoSecuencialUsuario(Boolean mostraresta_activoSecuencialUsuario) {
		this.mostraresta_activoSecuencialUsuario= mostraresta_activoSecuencialUsuario;
	}

	public Boolean getActivaresta_activoSecuencialUsuario() {
		return this.activaresta_activoSecuencialUsuario;
	}

	public void setActivaresta_activoSecuencialUsuario(Boolean activaresta_activoSecuencialUsuario) {
		this.activaresta_activoSecuencialUsuario= activaresta_activoSecuencialUsuario;
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
		
		
		this.setMostraridSecuencialUsuario(esInicial);
		this.setMostrarid_empresaSecuencialUsuario(esInicial);
		this.setMostrarid_sucursalSecuencialUsuario(esInicial);
		this.setMostrarid_usuarioSecuencialUsuario(esInicial);
		this.setMostrarid_tipo_documento_generalSecuencialUsuario(esInicial);
		this.setMostrarserieSecuencialUsuario(esInicial);
		this.setMostrarautorizacionSecuencialUsuario(esInicial);
		this.setMostrarsecuencialSecuencialUsuario(esInicial);
		this.setMostrardigitosSecuencialUsuario(esInicial);
		this.setMostrarfecha_inicioSecuencialUsuario(esInicial);
		this.setMostrarfecha_finSecuencialUsuario(esInicial);
		this.setMostraresta_activoSecuencialUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ID)) {
				this.setMostraridSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setMostrarid_tipo_documento_generalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SERIE)) {
				this.setMostrarserieSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.AUTORIZACION)) {
				this.setMostrarautorizacionSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.DIGITOS)) {
				this.setMostrardigitosSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoSecuencialUsuario(esAsigna);
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
		
		
		this.setActivaridSecuencialUsuario(esInicial);
		this.setActivarid_empresaSecuencialUsuario(esInicial);
		this.setActivarid_sucursalSecuencialUsuario(esInicial);
		this.setActivarid_usuarioSecuencialUsuario(esInicial);
		this.setActivarid_tipo_documento_generalSecuencialUsuario(esInicial);
		this.setActivarserieSecuencialUsuario(esInicial);
		this.setActivarautorizacionSecuencialUsuario(esInicial);
		this.setActivarsecuencialSecuencialUsuario(esInicial);
		this.setActivardigitosSecuencialUsuario(esInicial);
		this.setActivarfecha_inicioSecuencialUsuario(esInicial);
		this.setActivarfecha_finSecuencialUsuario(esInicial);
		this.setActivaresta_activoSecuencialUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ID)) {
				this.setActivaridSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setActivarid_tipo_documento_generalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SERIE)) {
				this.setActivarserieSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.AUTORIZACION)) {
				this.setActivarautorizacionSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.DIGITOS)) {
				this.setActivardigitosSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoSecuencialUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSecuencialUsuario(esInicial);
		this.setResaltarid_empresaSecuencialUsuario(esInicial);
		this.setResaltarid_sucursalSecuencialUsuario(esInicial);
		this.setResaltarid_usuarioSecuencialUsuario(esInicial);
		this.setResaltarid_tipo_documento_generalSecuencialUsuario(esInicial);
		this.setResaltarserieSecuencialUsuario(esInicial);
		this.setResaltarautorizacionSecuencialUsuario(esInicial);
		this.setResaltarsecuencialSecuencialUsuario(esInicial);
		this.setResaltardigitosSecuencialUsuario(esInicial);
		this.setResaltarfecha_inicioSecuencialUsuario(esInicial);
		this.setResaltarfecha_finSecuencialUsuario(esInicial);
		this.setResaltaresta_activoSecuencialUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ID)) {
				this.setResaltaridSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setResaltarid_tipo_documento_generalSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SERIE)) {
				this.setResaltarserieSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.AUTORIZACION)) {
				this.setResaltarautorizacionSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.DIGITOS)) {
				this.setResaltardigitosSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finSecuencialUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialUsuarioConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoSecuencialUsuario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorAutorizacionSecuencialUsuario=true;

	public Boolean getMostrarBusquedaPorAutorizacionSecuencialUsuario() {
		return this.mostrarBusquedaPorAutorizacionSecuencialUsuario;
	}

	public void setMostrarBusquedaPorAutorizacionSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorAutorizacionSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaFinSecuencialUsuario=true;

	public Boolean getMostrarBusquedaPorFechaFinSecuencialUsuario() {
		return this.mostrarBusquedaPorFechaFinSecuencialUsuario;
	}

	public void setMostrarBusquedaPorFechaFinSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaFinSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaInicioSecuencialUsuario=true;

	public Boolean getMostrarBusquedaPorFechaInicioSecuencialUsuario() {
		return this.mostrarBusquedaPorFechaInicioSecuencialUsuario;
	}

	public void setMostrarBusquedaPorFechaInicioSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaInicioSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario=true;

	public Boolean getMostrarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario() {
		return this.mostrarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setMostrarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSerieSecuencialUsuario=true;

	public Boolean getMostrarBusquedaPorSerieSecuencialUsuario() {
		return this.mostrarBusquedaPorSerieSecuencialUsuario;
	}

	public void setMostrarBusquedaPorSerieSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSerieSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSecuencialUsuario=true;

	public Boolean getMostrarFK_IdEmpresaSecuencialUsuario() {
		return this.mostrarFK_IdEmpresaSecuencialUsuario;
	}

	public void setMostrarFK_IdEmpresaSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSecuencialUsuario=true;

	public Boolean getMostrarFK_IdSucursalSecuencialUsuario() {
		return this.mostrarFK_IdSucursalSecuencialUsuario;
	}

	public void setMostrarFK_IdSucursalSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoGeneralSecuencialUsuario=true;

	public Boolean getMostrarFK_IdTipoDocumentoGeneralSecuencialUsuario() {
		return this.mostrarFK_IdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setMostrarFK_IdTipoDocumentoGeneralSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoGeneralSecuencialUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioSecuencialUsuario=true;

	public Boolean getMostrarFK_IdUsuarioSecuencialUsuario() {
		return this.mostrarFK_IdUsuarioSecuencialUsuario;
	}

	public void setMostrarFK_IdUsuarioSecuencialUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioSecuencialUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorAutorizacionSecuencialUsuario=true;

	public Boolean getActivarBusquedaPorAutorizacionSecuencialUsuario() {
		return this.activarBusquedaPorAutorizacionSecuencialUsuario;
	}

	public void setActivarBusquedaPorAutorizacionSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorAutorizacionSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaFinSecuencialUsuario=true;

	public Boolean getActivarBusquedaPorFechaFinSecuencialUsuario() {
		return this.activarBusquedaPorFechaFinSecuencialUsuario;
	}

	public void setActivarBusquedaPorFechaFinSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaFinSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaInicioSecuencialUsuario=true;

	public Boolean getActivarBusquedaPorFechaInicioSecuencialUsuario() {
		return this.activarBusquedaPorFechaInicioSecuencialUsuario;
	}

	public void setActivarBusquedaPorFechaInicioSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaInicioSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario=true;

	public Boolean getActivarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario() {
		return this.activarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setActivarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSerieSecuencialUsuario=true;

	public Boolean getActivarBusquedaPorSerieSecuencialUsuario() {
		return this.activarBusquedaPorSerieSecuencialUsuario;
	}

	public void setActivarBusquedaPorSerieSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarBusquedaPorSerieSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSecuencialUsuario=true;

	public Boolean getActivarFK_IdEmpresaSecuencialUsuario() {
		return this.activarFK_IdEmpresaSecuencialUsuario;
	}

	public void setActivarFK_IdEmpresaSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSecuencialUsuario=true;

	public Boolean getActivarFK_IdSucursalSecuencialUsuario() {
		return this.activarFK_IdSucursalSecuencialUsuario;
	}

	public void setActivarFK_IdSucursalSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoGeneralSecuencialUsuario=true;

	public Boolean getActivarFK_IdTipoDocumentoGeneralSecuencialUsuario() {
		return this.activarFK_IdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setActivarFK_IdTipoDocumentoGeneralSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoGeneralSecuencialUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioSecuencialUsuario=true;

	public Boolean getActivarFK_IdUsuarioSecuencialUsuario() {
		return this.activarFK_IdUsuarioSecuencialUsuario;
	}

	public void setActivarFK_IdUsuarioSecuencialUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioSecuencialUsuario= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorAutorizacionSecuencialUsuario=null;

	public Border getResaltarBusquedaPorAutorizacionSecuencialUsuario() {
		return this.resaltarBusquedaPorAutorizacionSecuencialUsuario;
	}

	public void setResaltarBusquedaPorAutorizacionSecuencialUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorAutorizacionSecuencialUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorAutorizacionSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorAutorizacionSecuencialUsuario= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaFinSecuencialUsuario=null;

	public Border getResaltarBusquedaPorFechaFinSecuencialUsuario() {
		return this.resaltarBusquedaPorFechaFinSecuencialUsuario;
	}

	public void setResaltarBusquedaPorFechaFinSecuencialUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorFechaFinSecuencialUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaFinSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaFinSecuencialUsuario= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaInicioSecuencialUsuario=null;

	public Border getResaltarBusquedaPorFechaInicioSecuencialUsuario() {
		return this.resaltarBusquedaPorFechaInicioSecuencialUsuario;
	}

	public void setResaltarBusquedaPorFechaInicioSecuencialUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorFechaInicioSecuencialUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaInicioSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaInicioSecuencialUsuario= borderResaltar;
	}

	public Border resaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario=null;

	public Border getResaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario() {
		return this.resaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setResaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralSecuencialUsuario= borderResaltar;
	}

	public Border resaltarBusquedaPorSerieSecuencialUsuario=null;

	public Border getResaltarBusquedaPorSerieSecuencialUsuario() {
		return this.resaltarBusquedaPorSerieSecuencialUsuario;
	}

	public void setResaltarBusquedaPorSerieSecuencialUsuario(Border borderResaltar) {
		this.resaltarBusquedaPorSerieSecuencialUsuario= borderResaltar;
	}

	public void setResaltarBusquedaPorSerieSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSerieSecuencialUsuario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSecuencialUsuario=null;

	public Border getResaltarFK_IdEmpresaSecuencialUsuario() {
		return this.resaltarFK_IdEmpresaSecuencialUsuario;
	}

	public void setResaltarFK_IdEmpresaSecuencialUsuario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSecuencialUsuario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSecuencialUsuario= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSecuencialUsuario=null;

	public Border getResaltarFK_IdSucursalSecuencialUsuario() {
		return this.resaltarFK_IdSucursalSecuencialUsuario;
	}

	public void setResaltarFK_IdSucursalSecuencialUsuario(Border borderResaltar) {
		this.resaltarFK_IdSucursalSecuencialUsuario= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSecuencialUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoGeneralSecuencialUsuario=null;

	public Border getResaltarFK_IdTipoDocumentoGeneralSecuencialUsuario() {
		return this.resaltarFK_IdTipoDocumentoGeneralSecuencialUsuario;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralSecuencialUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoGeneralSecuencialUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoGeneralSecuencialUsuario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioSecuencialUsuario=null;

	public Border getResaltarFK_IdUsuarioSecuencialUsuario() {
		return this.resaltarFK_IdUsuarioSecuencialUsuario;
	}

	public void setResaltarFK_IdUsuarioSecuencialUsuario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioSecuencialUsuario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioSecuencialUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialUsuarioBeanSwingJInternalFrame secuencialusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioSecuencialUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}