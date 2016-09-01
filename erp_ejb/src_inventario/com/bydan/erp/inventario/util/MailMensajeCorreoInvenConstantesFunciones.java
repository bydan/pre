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


import com.bydan.erp.inventario.util.MailMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.MailMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MailMensajeCorreoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MailMensajeCorreoInvenConstantesFunciones extends MailMensajeCorreoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MailMensajeCorreoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MailMensajeCorreoInven"+MailMensajeCorreoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MailMensajeCorreoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MailMensajeCorreoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MailMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MailMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MailMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MailMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MailMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MailMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MailMensajeCorreoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MailMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MailMensajeCorreoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mail Mensaje Correo Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Mail Mensaje Correo Inven";
	public static final String SCLASSWEBTITULO_LOWER="Mail Mensaje Correo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MailMensajeCorreoInven";
	public static final String OBJECTNAME="mailmensajecorreoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="mail_mensaje_correo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mailmensajecorreoinven from "+MailMensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" mailmensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_mensaje_correo_inven,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empresa,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".mail,"+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME+".esta_activo from "+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MailMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+MailMensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MailMensajeCorreoInvenConstantesFuncionesAdditional mailmensajecorreoinvenConstantesFuncionesAdditional=null;
	
	public MailMensajeCorreoInvenConstantesFuncionesAdditional getMailMensajeCorreoInvenConstantesFuncionesAdditional() {
		return this.mailmensajecorreoinvenConstantesFuncionesAdditional;
	}
	
	public void setMailMensajeCorreoInvenConstantesFuncionesAdditional(MailMensajeCorreoInvenConstantesFuncionesAdditional mailmensajecorreoinvenConstantesFuncionesAdditional) {
		try {
			this.mailmensajecorreoinvenConstantesFuncionesAdditional=mailmensajecorreoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMENSAJECORREOINVEN= "id_mensaje_correo_inven";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String MAIL= "mail";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMENSAJECORREOINVEN= "Mensaje Correo Inven";
		public static final String LABEL_IDMENSAJECORREOINVEN_LOWER= "Mensaje Correo Inven";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_MAIL= "Mail";
		public static final String LABEL_MAIL_LOWER= "Mail";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXMAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
		
	
	public static String getMailMensajeCorreoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN;}
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.IDMODULO)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.MAIL)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_MAIL;}
		if(sNombreColumna.equals(MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {sLabelColumna=MailMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!mailmensajecorreoinven.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(mailmensajecorreoinven.getId(),mailmensajecorreoinven.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getMailMensajeCorreoInvenDescripcion(MailMensajeCorreoInven mailmensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mailmensajecorreoinven !=null/* && mailmensajecorreoinven.getId()!=0*/) {
			if(mailmensajecorreoinven.getId()!=null) {
				sDescripcion=mailmensajecorreoinven.getId().toString();
			}//mailmensajecorreoinvenmailmensajecorreoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMailMensajeCorreoInvenDescripcionDetallado(MailMensajeCorreoInven mailmensajecorreoinven) {
		String sDescripcion="";
			
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.ID+"=";
		sDescripcion+=mailmensajecorreoinven.getId().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mailmensajecorreoinven.getVersionRow().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN+"=";
		sDescripcion+=mailmensajecorreoinven.getid_mensaje_correo_inven().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mailmensajecorreoinven.getid_empresa().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=mailmensajecorreoinven.getid_sucursal().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.IDMODULO+"=";
		sDescripcion+=mailmensajecorreoinven.getid_modulo().toString()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.MAIL+"=";
		sDescripcion+=mailmensajecorreoinven.getmail()+",";
		sDescripcion+=MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=mailmensajecorreoinven.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMailMensajeCorreoInvenDescripcion(MailMensajeCorreoInven mailmensajecorreoinven,String sValor) throws Exception {			
		if(mailmensajecorreoinven !=null) {
			//mailmensajecorreoinvenmailmensajecorreoinven.getId().toString();
		}		
	}
	
		

	public static String getMensajeCorreoInvenDescripcion(MensajeCorreoInven mensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mensajecorreoinven!=null/*&&mensajecorreoinven.getId()>0*/) {
			sDescripcion=MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(mensajecorreoinven);
		}

		return sDescripcion;
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMensajeCorreoInven")) {
			sNombreIndice="Tipo=  Por Mensaje Correo Inven";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMensajeCorreoInven(Long id_mensaje_correo_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_mensaje_correo_inven!=null) {sDetalleIndice+=" Codigo Unico De Mensaje Correo Inven="+id_mensaje_correo_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mailmensajecorreoinven.setmail(mailmensajecorreoinven.getmail().trim());
	}
	
	public static void quitarEspaciosMailMensajeCorreoInvens(List<MailMensajeCorreoInven> mailmensajecorreoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MailMensajeCorreoInven mailmensajecorreoinven: mailmensajecorreoinvens) {
			mailmensajecorreoinven.setmail(mailmensajecorreoinven.getmail().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mailmensajecorreoinven.getConCambioAuxiliar()) {
			mailmensajecorreoinven.setIsDeleted(mailmensajecorreoinven.getIsDeletedAuxiliar());	
			mailmensajecorreoinven.setIsNew(mailmensajecorreoinven.getIsNewAuxiliar());	
			mailmensajecorreoinven.setIsChanged(mailmensajecorreoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mailmensajecorreoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mailmensajecorreoinven.setIsDeletedAuxiliar(false);	
			mailmensajecorreoinven.setIsNewAuxiliar(false);	
			mailmensajecorreoinven.setIsChangedAuxiliar(false);
			
			mailmensajecorreoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMailMensajeCorreoInvens(List<MailMensajeCorreoInven> mailmensajecorreoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MailMensajeCorreoInven mailmensajecorreoinven : mailmensajecorreoinvens) {
			if(conAsignarBase && mailmensajecorreoinven.getConCambioAuxiliar()) {
				mailmensajecorreoinven.setIsDeleted(mailmensajecorreoinven.getIsDeletedAuxiliar());	
				mailmensajecorreoinven.setIsNew(mailmensajecorreoinven.getIsNewAuxiliar());	
				mailmensajecorreoinven.setIsChanged(mailmensajecorreoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mailmensajecorreoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mailmensajecorreoinven.setIsDeletedAuxiliar(false);	
				mailmensajecorreoinven.setIsNewAuxiliar(false);	
				mailmensajecorreoinven.setIsChangedAuxiliar(false);
				
				mailmensajecorreoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMailMensajeCorreoInvens(List<MailMensajeCorreoInven> mailmensajecorreoinvens,Boolean conEnteros) throws Exception  {
		
		for(MailMensajeCorreoInven mailmensajecorreoinven: mailmensajecorreoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMailMensajeCorreoInven(List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInven mailmensajecorreoinvenAux) throws Exception  {
		MailMensajeCorreoInvenConstantesFunciones.InicializarValoresMailMensajeCorreoInven(mailmensajecorreoinvenAux,true);
		
		for(MailMensajeCorreoInven mailmensajecorreoinven: mailmensajecorreoinvens) {
			if(mailmensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMailMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MailMensajeCorreoInvenConstantesFunciones.getArrayColumnasGlobalesMailMensajeCorreoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMailMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MailMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MailMensajeCorreoInvenConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMailMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInven mailmensajecorreoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MailMensajeCorreoInven mailmensajecorreoinvenAux: mailmensajecorreoinvens) {
			if(mailmensajecorreoinvenAux!=null && mailmensajecorreoinven!=null) {
				if((mailmensajecorreoinvenAux.getId()==null && mailmensajecorreoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mailmensajecorreoinvenAux.getId()!=null && mailmensajecorreoinven.getId()!=null){
					if(mailmensajecorreoinvenAux.getId().equals(mailmensajecorreoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMailMensajeCorreoInven(List<MailMensajeCorreoInven> mailmensajecorreoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(MailMensajeCorreoInven mailmensajecorreoinven: mailmensajecorreoinvens) {			
			if(mailmensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMailMensajeCorreoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_ID, MailMensajeCorreoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_VERSIONROW, MailMensajeCorreoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN, MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA, MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL, MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO, MailMensajeCorreoInvenConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_MAIL, MailMensajeCorreoInvenConstantesFunciones.MAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MailMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO, MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMailMensajeCorreoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.MAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMailMensajeCorreoInven() throws Exception  {
		return MailMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarMailMensajeCorreoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMailMensajeCorreoInven(Boolean conFk) throws Exception  {
		return MailMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarMailMensajeCorreoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMailMensajeCorreoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_MAIL);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_MAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MailMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(MailMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMailMensajeCorreoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinvenAux) throws Exception {
		
			mailmensajecorreoinvenAux.setmensajecorreoinven_descripcion(MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(mailmensajecorreoinvenAux.getMensajeCorreoInven()));
			mailmensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mailmensajecorreoinvenAux.getEmpresa()));
			mailmensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mailmensajecorreoinvenAux.getSucursal()));
			mailmensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(mailmensajecorreoinvenAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMailMensajeCorreoInven(List<MailMensajeCorreoInven> mailmensajecorreoinvensTemp) throws Exception {
		for(MailMensajeCorreoInven mailmensajecorreoinvenAux:mailmensajecorreoinvensTemp) {
			
			mailmensajecorreoinvenAux.setmensajecorreoinven_descripcion(MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(mailmensajecorreoinvenAux.getMensajeCorreoInven()));
			mailmensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mailmensajecorreoinvenAux.getEmpresa()));
			mailmensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mailmensajecorreoinvenAux.getSucursal()));
			mailmensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(mailmensajecorreoinvenAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMailMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MensajeCorreoInven.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MensajeCorreoInven.class)) {
						classes.add(new Classe(MensajeCorreoInven.class));
					}
				}

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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMailMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MensajeCorreoInven.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MensajeCorreoInven.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMailMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MailMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfMailMensajeCorreoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMailMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMailMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MailMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfMailMensajeCorreoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMailMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MailMensajeCorreoInven mailmensajecorreoinven,List<MailMensajeCorreoInven> mailmensajecorreoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MailMensajeCorreoInven mailmensajecorreoinvenEncontrado=null;
			
			for(MailMensajeCorreoInven mailmensajecorreoinvenLocal:mailmensajecorreoinvens) {
				if(mailmensajecorreoinvenLocal.getId().equals(mailmensajecorreoinven.getId())) {
					mailmensajecorreoinvenEncontrado=mailmensajecorreoinvenLocal;
					
					mailmensajecorreoinvenLocal.setIsChanged(mailmensajecorreoinven.getIsChanged());
					mailmensajecorreoinvenLocal.setIsNew(mailmensajecorreoinven.getIsNew());
					mailmensajecorreoinvenLocal.setIsDeleted(mailmensajecorreoinven.getIsDeleted());
					
					mailmensajecorreoinvenLocal.setGeneralEntityOriginal(mailmensajecorreoinven.getGeneralEntityOriginal());
					
					mailmensajecorreoinvenLocal.setId(mailmensajecorreoinven.getId());	
					mailmensajecorreoinvenLocal.setVersionRow(mailmensajecorreoinven.getVersionRow());	
					mailmensajecorreoinvenLocal.setid_mensaje_correo_inven(mailmensajecorreoinven.getid_mensaje_correo_inven());	
					mailmensajecorreoinvenLocal.setid_empresa(mailmensajecorreoinven.getid_empresa());	
					mailmensajecorreoinvenLocal.setid_sucursal(mailmensajecorreoinven.getid_sucursal());	
					mailmensajecorreoinvenLocal.setid_modulo(mailmensajecorreoinven.getid_modulo());	
					mailmensajecorreoinvenLocal.setmail(mailmensajecorreoinven.getmail());	
					mailmensajecorreoinvenLocal.setesta_activo(mailmensajecorreoinven.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!mailmensajecorreoinven.getIsDeleted()) {
				if(!existe) {
					mailmensajecorreoinvens.add(mailmensajecorreoinven);
				}
			} else {
				if(mailmensajecorreoinvenEncontrado!=null && permiteQuitar)  {
					mailmensajecorreoinvens.remove(mailmensajecorreoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MailMensajeCorreoInven mailmensajecorreoinven,List<MailMensajeCorreoInven> mailmensajecorreoinvens) throws Exception {
		try	{			
			for(MailMensajeCorreoInven mailmensajecorreoinvenLocal:mailmensajecorreoinvens) {
				if(mailmensajecorreoinvenLocal.getId().equals(mailmensajecorreoinven.getId())) {
					mailmensajecorreoinvenLocal.setIsSelected(mailmensajecorreoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMailMensajeCorreoInven(List<MailMensajeCorreoInven> mailmensajecorreoinvensAux) throws Exception {
		//this.mailmensajecorreoinvensAux=mailmensajecorreoinvensAux;
		
		for(MailMensajeCorreoInven mailmensajecorreoinvenAux:mailmensajecorreoinvensAux) {
			if(mailmensajecorreoinvenAux.getIsChanged()) {
				mailmensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(mailmensajecorreoinvenAux.getIsNew()) {
				mailmensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(mailmensajecorreoinvenAux.getIsDeleted()) {
				mailmensajecorreoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinvenAux) throws Exception {
		//this.mailmensajecorreoinvenAux=mailmensajecorreoinvenAux;
		
			if(mailmensajecorreoinvenAux.getIsChanged()) {
				mailmensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(mailmensajecorreoinvenAux.getIsNew()) {
				mailmensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(mailmensajecorreoinvenAux.getIsDeleted()) {
				mailmensajecorreoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MailMensajeCorreoInven mailmensajecorreoinvenAsignar,MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		mailmensajecorreoinvenAsignar.setId(mailmensajecorreoinven.getId());	
		mailmensajecorreoinvenAsignar.setVersionRow(mailmensajecorreoinven.getVersionRow());	
		mailmensajecorreoinvenAsignar.setid_mensaje_correo_inven(mailmensajecorreoinven.getid_mensaje_correo_inven());
		mailmensajecorreoinvenAsignar.setmensajecorreoinven_descripcion(mailmensajecorreoinven.getmensajecorreoinven_descripcion());	
		mailmensajecorreoinvenAsignar.setid_empresa(mailmensajecorreoinven.getid_empresa());
		mailmensajecorreoinvenAsignar.setempresa_descripcion(mailmensajecorreoinven.getempresa_descripcion());	
		mailmensajecorreoinvenAsignar.setid_sucursal(mailmensajecorreoinven.getid_sucursal());
		mailmensajecorreoinvenAsignar.setsucursal_descripcion(mailmensajecorreoinven.getsucursal_descripcion());	
		mailmensajecorreoinvenAsignar.setid_modulo(mailmensajecorreoinven.getid_modulo());
		mailmensajecorreoinvenAsignar.setmodulo_descripcion(mailmensajecorreoinven.getmodulo_descripcion());	
		mailmensajecorreoinvenAsignar.setmail(mailmensajecorreoinven.getmail());	
		mailmensajecorreoinvenAsignar.setesta_activo(mailmensajecorreoinven.getesta_activo());	
	}
	
	public static void inicializarMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		try {
				mailmensajecorreoinven.setId(0L);	
					
				mailmensajecorreoinven.setid_mensaje_correo_inven(-1L);	
				mailmensajecorreoinven.setid_empresa(-1L);	
				mailmensajecorreoinven.setid_sucursal(-1L);	
				mailmensajecorreoinven.setid_modulo(-1L);	
				mailmensajecorreoinven.setmail("");	
				mailmensajecorreoinven.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMailMensajeCorreoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_MAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MailMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMailMensajeCorreoInven(String sTipo,Row row,Workbook workbook,MailMensajeCorreoInven mailmensajecorreoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mailmensajecorreoinven.getmensajecorreoinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mailmensajecorreoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mailmensajecorreoinven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mailmensajecorreoinven.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mailmensajecorreoinven.getmail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(mailmensajecorreoinven.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMailMensajeCorreoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMailMensajeCorreoInven() {
		return this.sFinalQueryMailMensajeCorreoInven;
	}
	
	public void setsFinalQueryMailMensajeCorreoInven(String sFinalQueryMailMensajeCorreoInven) {
		this.sFinalQueryMailMensajeCorreoInven= sFinalQueryMailMensajeCorreoInven;
	}
	
	public Border resaltarSeleccionarMailMensajeCorreoInven=null;
	
	public Border setResaltarSeleccionarMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMailMensajeCorreoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMailMensajeCorreoInven() {
		return this.resaltarSeleccionarMailMensajeCorreoInven;
	}
	
	public void setResaltarSeleccionarMailMensajeCorreoInven(Border borderResaltarSeleccionarMailMensajeCorreoInven) {
		this.resaltarSeleccionarMailMensajeCorreoInven= borderResaltarSeleccionarMailMensajeCorreoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMailMensajeCorreoInven=null;
	public Boolean mostraridMailMensajeCorreoInven=true;
	public Boolean activaridMailMensajeCorreoInven=true;

	public Border resaltarid_mensaje_correo_invenMailMensajeCorreoInven=null;
	public Boolean mostrarid_mensaje_correo_invenMailMensajeCorreoInven=true;
	public Boolean activarid_mensaje_correo_invenMailMensajeCorreoInven=true;
	public Boolean cargarid_mensaje_correo_invenMailMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mensaje_correo_invenMailMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_empresaMailMensajeCorreoInven=null;
	public Boolean mostrarid_empresaMailMensajeCorreoInven=true;
	public Boolean activarid_empresaMailMensajeCorreoInven=true;
	public Boolean cargarid_empresaMailMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMailMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalMailMensajeCorreoInven=null;
	public Boolean mostrarid_sucursalMailMensajeCorreoInven=true;
	public Boolean activarid_sucursalMailMensajeCorreoInven=true;
	public Boolean cargarid_sucursalMailMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMailMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_moduloMailMensajeCorreoInven=null;
	public Boolean mostrarid_moduloMailMensajeCorreoInven=true;
	public Boolean activarid_moduloMailMensajeCorreoInven=true;
	public Boolean cargarid_moduloMailMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloMailMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarmailMailMensajeCorreoInven=null;
	public Boolean mostrarmailMailMensajeCorreoInven=true;
	public Boolean activarmailMailMensajeCorreoInven=true;

	public Border resaltaresta_activoMailMensajeCorreoInven=null;
	public Boolean mostraresta_activoMailMensajeCorreoInven=true;
	public Boolean activaresta_activoMailMensajeCorreoInven=true;

	
	

	public Border setResaltaridMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaridMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMailMensajeCorreoInven() {
		return this.resaltaridMailMensajeCorreoInven;
	}

	public void setResaltaridMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltaridMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraridMailMensajeCorreoInven() {
		return this.mostraridMailMensajeCorreoInven;
	}

	public void setMostraridMailMensajeCorreoInven(Boolean mostraridMailMensajeCorreoInven) {
		this.mostraridMailMensajeCorreoInven= mostraridMailMensajeCorreoInven;
	}

	public Boolean getActivaridMailMensajeCorreoInven() {
		return this.activaridMailMensajeCorreoInven;
	}

	public void setActivaridMailMensajeCorreoInven(Boolean activaridMailMensajeCorreoInven) {
		this.activaridMailMensajeCorreoInven= activaridMailMensajeCorreoInven;
	}

	public Border setResaltarid_mensaje_correo_invenMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_mensaje_correo_invenMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mensaje_correo_invenMailMensajeCorreoInven() {
		return this.resaltarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public void setResaltarid_mensaje_correo_invenMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_mensaje_correo_invenMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_mensaje_correo_invenMailMensajeCorreoInven() {
		return this.mostrarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public void setMostrarid_mensaje_correo_invenMailMensajeCorreoInven(Boolean mostrarid_mensaje_correo_invenMailMensajeCorreoInven) {
		this.mostrarid_mensaje_correo_invenMailMensajeCorreoInven= mostrarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public Boolean getActivarid_mensaje_correo_invenMailMensajeCorreoInven() {
		return this.activarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public void setActivarid_mensaje_correo_invenMailMensajeCorreoInven(Boolean activarid_mensaje_correo_invenMailMensajeCorreoInven) {
		this.activarid_mensaje_correo_invenMailMensajeCorreoInven= activarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public Boolean getCargarid_mensaje_correo_invenMailMensajeCorreoInven() {
		return this.cargarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public void setCargarid_mensaje_correo_invenMailMensajeCorreoInven(Boolean cargarid_mensaje_correo_invenMailMensajeCorreoInven) {
		this.cargarid_mensaje_correo_invenMailMensajeCorreoInven= cargarid_mensaje_correo_invenMailMensajeCorreoInven;
	}

	public Border setResaltarid_empresaMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMailMensajeCorreoInven() {
		return this.resaltarid_empresaMailMensajeCorreoInven;
	}

	public void setResaltarid_empresaMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_empresaMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaMailMensajeCorreoInven() {
		return this.mostrarid_empresaMailMensajeCorreoInven;
	}

	public void setMostrarid_empresaMailMensajeCorreoInven(Boolean mostrarid_empresaMailMensajeCorreoInven) {
		this.mostrarid_empresaMailMensajeCorreoInven= mostrarid_empresaMailMensajeCorreoInven;
	}

	public Boolean getActivarid_empresaMailMensajeCorreoInven() {
		return this.activarid_empresaMailMensajeCorreoInven;
	}

	public void setActivarid_empresaMailMensajeCorreoInven(Boolean activarid_empresaMailMensajeCorreoInven) {
		this.activarid_empresaMailMensajeCorreoInven= activarid_empresaMailMensajeCorreoInven;
	}

	public Boolean getCargarid_empresaMailMensajeCorreoInven() {
		return this.cargarid_empresaMailMensajeCorreoInven;
	}

	public void setCargarid_empresaMailMensajeCorreoInven(Boolean cargarid_empresaMailMensajeCorreoInven) {
		this.cargarid_empresaMailMensajeCorreoInven= cargarid_empresaMailMensajeCorreoInven;
	}

	public Border setResaltarid_sucursalMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMailMensajeCorreoInven() {
		return this.resaltarid_sucursalMailMensajeCorreoInven;
	}

	public void setResaltarid_sucursalMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_sucursalMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMailMensajeCorreoInven() {
		return this.mostrarid_sucursalMailMensajeCorreoInven;
	}

	public void setMostrarid_sucursalMailMensajeCorreoInven(Boolean mostrarid_sucursalMailMensajeCorreoInven) {
		this.mostrarid_sucursalMailMensajeCorreoInven= mostrarid_sucursalMailMensajeCorreoInven;
	}

	public Boolean getActivarid_sucursalMailMensajeCorreoInven() {
		return this.activarid_sucursalMailMensajeCorreoInven;
	}

	public void setActivarid_sucursalMailMensajeCorreoInven(Boolean activarid_sucursalMailMensajeCorreoInven) {
		this.activarid_sucursalMailMensajeCorreoInven= activarid_sucursalMailMensajeCorreoInven;
	}

	public Boolean getCargarid_sucursalMailMensajeCorreoInven() {
		return this.cargarid_sucursalMailMensajeCorreoInven;
	}

	public void setCargarid_sucursalMailMensajeCorreoInven(Boolean cargarid_sucursalMailMensajeCorreoInven) {
		this.cargarid_sucursalMailMensajeCorreoInven= cargarid_sucursalMailMensajeCorreoInven;
	}

	public Border setResaltarid_moduloMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_moduloMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloMailMensajeCorreoInven() {
		return this.resaltarid_moduloMailMensajeCorreoInven;
	}

	public void setResaltarid_moduloMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_moduloMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_moduloMailMensajeCorreoInven() {
		return this.mostrarid_moduloMailMensajeCorreoInven;
	}

	public void setMostrarid_moduloMailMensajeCorreoInven(Boolean mostrarid_moduloMailMensajeCorreoInven) {
		this.mostrarid_moduloMailMensajeCorreoInven= mostrarid_moduloMailMensajeCorreoInven;
	}

	public Boolean getActivarid_moduloMailMensajeCorreoInven() {
		return this.activarid_moduloMailMensajeCorreoInven;
	}

	public void setActivarid_moduloMailMensajeCorreoInven(Boolean activarid_moduloMailMensajeCorreoInven) {
		this.activarid_moduloMailMensajeCorreoInven= activarid_moduloMailMensajeCorreoInven;
	}

	public Boolean getCargarid_moduloMailMensajeCorreoInven() {
		return this.cargarid_moduloMailMensajeCorreoInven;
	}

	public void setCargarid_moduloMailMensajeCorreoInven(Boolean cargarid_moduloMailMensajeCorreoInven) {
		this.cargarid_moduloMailMensajeCorreoInven= cargarid_moduloMailMensajeCorreoInven;
	}

	public Border setResaltarmailMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarmailMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmailMailMensajeCorreoInven() {
		return this.resaltarmailMailMensajeCorreoInven;
	}

	public void setResaltarmailMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarmailMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarmailMailMensajeCorreoInven() {
		return this.mostrarmailMailMensajeCorreoInven;
	}

	public void setMostrarmailMailMensajeCorreoInven(Boolean mostrarmailMailMensajeCorreoInven) {
		this.mostrarmailMailMensajeCorreoInven= mostrarmailMailMensajeCorreoInven;
	}

	public Boolean getActivarmailMailMensajeCorreoInven() {
		return this.activarmailMailMensajeCorreoInven;
	}

	public void setActivarmailMailMensajeCorreoInven(Boolean activarmailMailMensajeCorreoInven) {
		this.activarmailMailMensajeCorreoInven= activarmailMailMensajeCorreoInven;
	}

	public Border setResaltaresta_activoMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mailmensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMailMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaresta_activoMailMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoMailMensajeCorreoInven() {
		return this.resaltaresta_activoMailMensajeCorreoInven;
	}

	public void setResaltaresta_activoMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltaresta_activoMailMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraresta_activoMailMensajeCorreoInven() {
		return this.mostraresta_activoMailMensajeCorreoInven;
	}

	public void setMostraresta_activoMailMensajeCorreoInven(Boolean mostraresta_activoMailMensajeCorreoInven) {
		this.mostraresta_activoMailMensajeCorreoInven= mostraresta_activoMailMensajeCorreoInven;
	}

	public Boolean getActivaresta_activoMailMensajeCorreoInven() {
		return this.activaresta_activoMailMensajeCorreoInven;
	}

	public void setActivaresta_activoMailMensajeCorreoInven(Boolean activaresta_activoMailMensajeCorreoInven) {
		this.activaresta_activoMailMensajeCorreoInven= activaresta_activoMailMensajeCorreoInven;
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
		
		
		this.setMostraridMailMensajeCorreoInven(esInicial);
		this.setMostrarid_mensaje_correo_invenMailMensajeCorreoInven(esInicial);
		this.setMostrarid_empresaMailMensajeCorreoInven(esInicial);
		this.setMostrarid_sucursalMailMensajeCorreoInven(esInicial);
		this.setMostrarid_moduloMailMensajeCorreoInven(esInicial);
		this.setMostrarmailMailMensajeCorreoInven(esInicial);
		this.setMostraresta_activoMailMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setMostraridMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setMostrarid_mensaje_correo_invenMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.MAIL)) {
				this.setMostrarmailMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoMailMensajeCorreoInven(esAsigna);
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
		
		
		this.setActivaridMailMensajeCorreoInven(esInicial);
		this.setActivarid_mensaje_correo_invenMailMensajeCorreoInven(esInicial);
		this.setActivarid_empresaMailMensajeCorreoInven(esInicial);
		this.setActivarid_sucursalMailMensajeCorreoInven(esInicial);
		this.setActivarid_moduloMailMensajeCorreoInven(esInicial);
		this.setActivarmailMailMensajeCorreoInven(esInicial);
		this.setActivaresta_activoMailMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setActivaridMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setActivarid_mensaje_correo_invenMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.MAIL)) {
				this.setActivarmailMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoMailMensajeCorreoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMailMensajeCorreoInven(esInicial);
		this.setResaltarid_mensaje_correo_invenMailMensajeCorreoInven(esInicial);
		this.setResaltarid_empresaMailMensajeCorreoInven(esInicial);
		this.setResaltarid_sucursalMailMensajeCorreoInven(esInicial);
		this.setResaltarid_moduloMailMensajeCorreoInven(esInicial);
		this.setResaltarmailMailMensajeCorreoInven(esInicial);
		this.setResaltaresta_activoMailMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setResaltaridMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setResaltarid_mensaje_correo_invenMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.MAIL)) {
				this.setResaltarmailMailMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoMailMensajeCorreoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaMailMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdEmpresaMailMensajeCorreoInven() {
		return this.mostrarFK_IdEmpresaMailMensajeCorreoInven;
	}

	public void setMostrarFK_IdEmpresaMailMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMailMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMensajeCorreoInvenMailMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdMensajeCorreoInvenMailMensajeCorreoInven() {
		return this.mostrarFK_IdMensajeCorreoInvenMailMensajeCorreoInven;
	}

	public void setMostrarFK_IdMensajeCorreoInvenMailMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMensajeCorreoInvenMailMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloMailMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdModuloMailMensajeCorreoInven() {
		return this.mostrarFK_IdModuloMailMensajeCorreoInven;
	}

	public void setMostrarFK_IdModuloMailMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloMailMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMailMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdSucursalMailMensajeCorreoInven() {
		return this.mostrarFK_IdSucursalMailMensajeCorreoInven;
	}

	public void setMostrarFK_IdSucursalMailMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMailMensajeCorreoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaMailMensajeCorreoInven=true;

	public Boolean getActivarFK_IdEmpresaMailMensajeCorreoInven() {
		return this.activarFK_IdEmpresaMailMensajeCorreoInven;
	}

	public void setActivarFK_IdEmpresaMailMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMailMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdMensajeCorreoInvenMailMensajeCorreoInven=true;

	public Boolean getActivarFK_IdMensajeCorreoInvenMailMensajeCorreoInven() {
		return this.activarFK_IdMensajeCorreoInvenMailMensajeCorreoInven;
	}

	public void setActivarFK_IdMensajeCorreoInvenMailMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdMensajeCorreoInvenMailMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloMailMensajeCorreoInven=true;

	public Boolean getActivarFK_IdModuloMailMensajeCorreoInven() {
		return this.activarFK_IdModuloMailMensajeCorreoInven;
	}

	public void setActivarFK_IdModuloMailMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdModuloMailMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMailMensajeCorreoInven=true;

	public Boolean getActivarFK_IdSucursalMailMensajeCorreoInven() {
		return this.activarFK_IdSucursalMailMensajeCorreoInven;
	}

	public void setActivarFK_IdSucursalMailMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMailMensajeCorreoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaMailMensajeCorreoInven=null;

	public Border getResaltarFK_IdEmpresaMailMensajeCorreoInven() {
		return this.resaltarFK_IdEmpresaMailMensajeCorreoInven;
	}

	public void setResaltarFK_IdEmpresaMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMailMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMailMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven=null;

	public Border getResaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven() {
		return this.resaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven;
	}

	public void setResaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMensajeCorreoInvenMailMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdModuloMailMensajeCorreoInven=null;

	public Border getResaltarFK_IdModuloMailMensajeCorreoInven() {
		return this.resaltarFK_IdModuloMailMensajeCorreoInven;
	}

	public void setResaltarFK_IdModuloMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdModuloMailMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdModuloMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloMailMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMailMensajeCorreoInven=null;

	public Border getResaltarFK_IdSucursalMailMensajeCorreoInven() {
		return this.resaltarFK_IdSucursalMailMensajeCorreoInven;
	}

	public void setResaltarFK_IdSucursalMailMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalMailMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMailMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MailMensajeCorreoInvenBeanSwingJInternalFrame mailmensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMailMensajeCorreoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}