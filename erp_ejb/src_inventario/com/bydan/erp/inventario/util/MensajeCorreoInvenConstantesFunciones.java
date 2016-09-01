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


import com.bydan.erp.inventario.util.MensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.MensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MensajeCorreoInvenParameterGeneral;

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
final public class MensajeCorreoInvenConstantesFunciones extends MensajeCorreoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MensajeCorreoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MensajeCorreoInven"+MensajeCorreoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MensajeCorreoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MensajeCorreoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MensajeCorreoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MensajeCorreoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mensaje Correoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Mensaje Correo";
	public static final String SCLASSWEBTITULO_LOWER="Mensaje Correo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MensajeCorreoInven";
	public static final String OBJECTNAME="mensajecorreoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="mensaje_correo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mensajecorreoinven from "+MensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" mensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empresa,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_tipo_mensaje_correo_inven,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".tema,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".mensaje,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".aviso,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".esta_activo from "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+MensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MensajeCorreoInvenConstantesFuncionesAdditional mensajecorreoinvenConstantesFuncionesAdditional=null;
	
	public MensajeCorreoInvenConstantesFuncionesAdditional getMensajeCorreoInvenConstantesFuncionesAdditional() {
		return this.mensajecorreoinvenConstantesFuncionesAdditional;
	}
	
	public void setMensajeCorreoInvenConstantesFuncionesAdditional(MensajeCorreoInvenConstantesFuncionesAdditional mensajecorreoinvenConstantesFuncionesAdditional) {
		try {
			this.mensajecorreoinvenConstantesFuncionesAdditional=mensajecorreoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMENSAJECORREOINVEN= "id_tipo_mensaje_correo_inven";
    public static final String TEMA= "tema";
    public static final String MENSAJE= "mensaje";
    public static final String AVISO= "aviso";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMENSAJECORREOINVEN= "T. Mensaje Correo";
		public static final String LABEL_IDTIPOMENSAJECORREOINVEN_LOWER= "Tipo Mensaje Correo Inven";
    	public static final String LABEL_TEMA= "Tema";
		public static final String LABEL_TEMA_LOWER= "Tema";
    	public static final String LABEL_MENSAJE= "Mensaje";
		public static final String LABEL_MENSAJE_LOWER= "Mensaje";
    	public static final String LABEL_AVISO= "Aviso";
		public static final String LABEL_AVISO_LOWER= "Aviso";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXTEMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTEMA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMENSAJE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMENSAJE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAVISO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAVISO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getMensajeCorreoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.IDMODULO)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_IDTIPOMENSAJECORREOINVEN;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.TEMA)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_TEMA;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.MENSAJE)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_MENSAJE;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.AVISO)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_AVISO;}
		if(sNombreColumna.equals(MensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {sLabelColumna=MensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(MensajeCorreoInven mensajecorreoinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!mensajecorreoinven.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(MensajeCorreoInven mensajecorreoinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(mensajecorreoinven.getId(),mensajecorreoinven.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getMensajeCorreoInvenDescripcion(MensajeCorreoInven mensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mensajecorreoinven !=null/* && mensajecorreoinven.getId()!=0*/) {
			if(mensajecorreoinven.getId()!=null) {
				sDescripcion=mensajecorreoinven.getId().toString();
			}//mensajecorreoinvenmensajecorreoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMensajeCorreoInvenDescripcionDetallado(MensajeCorreoInven mensajecorreoinven) {
		String sDescripcion="";
			
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.ID+"=";
		sDescripcion+=mensajecorreoinven.getId().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mensajecorreoinven.getVersionRow().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mensajecorreoinven.getid_empresa().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=mensajecorreoinven.getid_sucursal().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.IDMODULO+"=";
		sDescripcion+=mensajecorreoinven.getid_modulo().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN+"=";
		sDescripcion+=mensajecorreoinven.getid_tipo_mensaje_correo_inven().toString()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.TEMA+"=";
		sDescripcion+=mensajecorreoinven.gettema()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.MENSAJE+"=";
		sDescripcion+=mensajecorreoinven.getmensaje()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.AVISO+"=";
		sDescripcion+=mensajecorreoinven.getaviso()+",";
		sDescripcion+=MensajeCorreoInvenConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=mensajecorreoinven.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMensajeCorreoInvenDescripcion(MensajeCorreoInven mensajecorreoinven,String sValor) throws Exception {			
		if(mensajecorreoinven !=null) {
			//mensajecorreoinvenmensajecorreoinven.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoMensajeCorreoInvenDescripcion(TipoMensajeCorreoInven tipomensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomensajecorreoinven!=null/*&&tipomensajecorreoinven.getId()>0*/) {
			sDescripcion=TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenDescripcion(tipomensajecorreoinven);
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
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMensajeCorreoInven")) {
			sNombreIndice="Tipo=  Por T. Mensaje Correo";
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

	public static String getDetalleIndiceFK_IdTipoMensajeCorreoInven(Long id_tipo_mensaje_correo_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_mensaje_correo_inven!=null) {sDetalleIndice+=" Codigo Unico De T. Mensaje Correo="+id_tipo_mensaje_correo_inven.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mensajecorreoinven.settema(mensajecorreoinven.gettema().trim());
		mensajecorreoinven.setmensaje(mensajecorreoinven.getmensaje().trim());
		mensajecorreoinven.setaviso(mensajecorreoinven.getaviso().trim());
	}
	
	public static void quitarEspaciosMensajeCorreoInvens(List<MensajeCorreoInven> mensajecorreoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MensajeCorreoInven mensajecorreoinven: mensajecorreoinvens) {
			mensajecorreoinven.settema(mensajecorreoinven.gettema().trim());
			mensajecorreoinven.setmensaje(mensajecorreoinven.getmensaje().trim());
			mensajecorreoinven.setaviso(mensajecorreoinven.getaviso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mensajecorreoinven.getConCambioAuxiliar()) {
			mensajecorreoinven.setIsDeleted(mensajecorreoinven.getIsDeletedAuxiliar());	
			mensajecorreoinven.setIsNew(mensajecorreoinven.getIsNewAuxiliar());	
			mensajecorreoinven.setIsChanged(mensajecorreoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mensajecorreoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mensajecorreoinven.setIsDeletedAuxiliar(false);	
			mensajecorreoinven.setIsNewAuxiliar(false);	
			mensajecorreoinven.setIsChangedAuxiliar(false);
			
			mensajecorreoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMensajeCorreoInvens(List<MensajeCorreoInven> mensajecorreoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MensajeCorreoInven mensajecorreoinven : mensajecorreoinvens) {
			if(conAsignarBase && mensajecorreoinven.getConCambioAuxiliar()) {
				mensajecorreoinven.setIsDeleted(mensajecorreoinven.getIsDeletedAuxiliar());	
				mensajecorreoinven.setIsNew(mensajecorreoinven.getIsNewAuxiliar());	
				mensajecorreoinven.setIsChanged(mensajecorreoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mensajecorreoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mensajecorreoinven.setIsDeletedAuxiliar(false);	
				mensajecorreoinven.setIsNewAuxiliar(false);	
				mensajecorreoinven.setIsChangedAuxiliar(false);
				
				mensajecorreoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMensajeCorreoInvens(List<MensajeCorreoInven> mensajecorreoinvens,Boolean conEnteros) throws Exception  {
		
		for(MensajeCorreoInven mensajecorreoinven: mensajecorreoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMensajeCorreoInven(List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInven mensajecorreoinvenAux) throws Exception  {
		MensajeCorreoInvenConstantesFunciones.InicializarValoresMensajeCorreoInven(mensajecorreoinvenAux,true);
		
		for(MensajeCorreoInven mensajecorreoinven: mensajecorreoinvens) {
			if(mensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MensajeCorreoInvenConstantesFunciones.getArrayColumnasGlobalesMensajeCorreoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MensajeCorreoInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MensajeCorreoInvenConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInven mensajecorreoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MensajeCorreoInven mensajecorreoinvenAux: mensajecorreoinvens) {
			if(mensajecorreoinvenAux!=null && mensajecorreoinven!=null) {
				if((mensajecorreoinvenAux.getId()==null && mensajecorreoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mensajecorreoinvenAux.getId()!=null && mensajecorreoinven.getId()!=null){
					if(mensajecorreoinvenAux.getId().equals(mensajecorreoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMensajeCorreoInven(List<MensajeCorreoInven> mensajecorreoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(MensajeCorreoInven mensajecorreoinven: mensajecorreoinvens) {			
			if(mensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMensajeCorreoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_ID, MensajeCorreoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_VERSIONROW, MensajeCorreoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA, MensajeCorreoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL, MensajeCorreoInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO, MensajeCorreoInvenConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_IDTIPOMENSAJECORREOINVEN, MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_TEMA, MensajeCorreoInvenConstantesFunciones.TEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_MENSAJE, MensajeCorreoInvenConstantesFunciones.MENSAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_AVISO, MensajeCorreoInvenConstantesFunciones.AVISO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO, MensajeCorreoInvenConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMensajeCorreoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.TEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.MENSAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.AVISO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MensajeCorreoInvenConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMensajeCorreoInven() throws Exception  {
		return MensajeCorreoInvenConstantesFunciones.getTiposSeleccionarMensajeCorreoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMensajeCorreoInven(Boolean conFk) throws Exception  {
		return MensajeCorreoInvenConstantesFunciones.getTiposSeleccionarMensajeCorreoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMensajeCorreoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_IDTIPOMENSAJECORREOINVEN);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_IDTIPOMENSAJECORREOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_TEMA);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_TEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_MENSAJE);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_MENSAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_AVISO);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_AVISO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(MensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMensajeCorreoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMensajeCorreoInven(MensajeCorreoInven mensajecorreoinvenAux) throws Exception {
		
			mensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mensajecorreoinvenAux.getEmpresa()));
			mensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mensajecorreoinvenAux.getSucursal()));
			mensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(mensajecorreoinvenAux.getModulo()));
			mensajecorreoinvenAux.settipomensajecorreoinven_descripcion(TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenDescripcion(mensajecorreoinvenAux.getTipoMensajeCorreoInven()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMensajeCorreoInven(List<MensajeCorreoInven> mensajecorreoinvensTemp) throws Exception {
		for(MensajeCorreoInven mensajecorreoinvenAux:mensajecorreoinvensTemp) {
			
			mensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mensajecorreoinvenAux.getEmpresa()));
			mensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mensajecorreoinvenAux.getSucursal()));
			mensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(mensajecorreoinvenAux.getModulo()));
			mensajecorreoinvenAux.settipomensajecorreoinven_descripcion(TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenDescripcion(mensajecorreoinvenAux.getTipoMensajeCorreoInven()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMensajeCorreoInven.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
						classes.add(new Classe(TipoMensajeCorreoInven.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMensajeCorreoInven.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMensajeCorreoInven.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfMensajeCorreoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleMensajeCorreoInven.class));
				classes.add(new Classe(MailMensajeCorreoInven.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMensajeCorreoInven.class)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MailMensajeCorreoInven.class)) {
						classes.add(new Classe(MailMensajeCorreoInven.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MensajeCorreoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfMensajeCorreoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); continue;
					}

					if(MailMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MailMensajeCorreoInven.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMensajeCorreoInven.class)); continue;
					}

					if(MailMensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MailMensajeCorreoInven.class)); continue;
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
	public static void actualizarLista(MensajeCorreoInven mensajecorreoinven,List<MensajeCorreoInven> mensajecorreoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MensajeCorreoInven mensajecorreoinvenEncontrado=null;
			
			for(MensajeCorreoInven mensajecorreoinvenLocal:mensajecorreoinvens) {
				if(mensajecorreoinvenLocal.getId().equals(mensajecorreoinven.getId())) {
					mensajecorreoinvenEncontrado=mensajecorreoinvenLocal;
					
					mensajecorreoinvenLocal.setIsChanged(mensajecorreoinven.getIsChanged());
					mensajecorreoinvenLocal.setIsNew(mensajecorreoinven.getIsNew());
					mensajecorreoinvenLocal.setIsDeleted(mensajecorreoinven.getIsDeleted());
					
					mensajecorreoinvenLocal.setGeneralEntityOriginal(mensajecorreoinven.getGeneralEntityOriginal());
					
					mensajecorreoinvenLocal.setId(mensajecorreoinven.getId());	
					mensajecorreoinvenLocal.setVersionRow(mensajecorreoinven.getVersionRow());	
					mensajecorreoinvenLocal.setid_empresa(mensajecorreoinven.getid_empresa());	
					mensajecorreoinvenLocal.setid_sucursal(mensajecorreoinven.getid_sucursal());	
					mensajecorreoinvenLocal.setid_modulo(mensajecorreoinven.getid_modulo());	
					mensajecorreoinvenLocal.setid_tipo_mensaje_correo_inven(mensajecorreoinven.getid_tipo_mensaje_correo_inven());	
					mensajecorreoinvenLocal.settema(mensajecorreoinven.gettema());	
					mensajecorreoinvenLocal.setmensaje(mensajecorreoinven.getmensaje());	
					mensajecorreoinvenLocal.setaviso(mensajecorreoinven.getaviso());	
					mensajecorreoinvenLocal.setesta_activo(mensajecorreoinven.getesta_activo());	
					
					
					mensajecorreoinvenLocal.setDetalleMensajeCorreoInvens(mensajecorreoinven.getDetalleMensajeCorreoInvens());
					mensajecorreoinvenLocal.setMailMensajeCorreoInvens(mensajecorreoinven.getMailMensajeCorreoInvens());
					
					existe=true;
					break;
				}
			}
			
			if(!mensajecorreoinven.getIsDeleted()) {
				if(!existe) {
					mensajecorreoinvens.add(mensajecorreoinven);
				}
			} else {
				if(mensajecorreoinvenEncontrado!=null && permiteQuitar)  {
					mensajecorreoinvens.remove(mensajecorreoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MensajeCorreoInven mensajecorreoinven,List<MensajeCorreoInven> mensajecorreoinvens) throws Exception {
		try	{			
			for(MensajeCorreoInven mensajecorreoinvenLocal:mensajecorreoinvens) {
				if(mensajecorreoinvenLocal.getId().equals(mensajecorreoinven.getId())) {
					mensajecorreoinvenLocal.setIsSelected(mensajecorreoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMensajeCorreoInven(List<MensajeCorreoInven> mensajecorreoinvensAux) throws Exception {
		//this.mensajecorreoinvensAux=mensajecorreoinvensAux;
		
		for(MensajeCorreoInven mensajecorreoinvenAux:mensajecorreoinvensAux) {
			if(mensajecorreoinvenAux.getIsChanged()) {
				mensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(mensajecorreoinvenAux.getIsNew()) {
				mensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(mensajecorreoinvenAux.getIsDeleted()) {
				mensajecorreoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMensajeCorreoInven(MensajeCorreoInven mensajecorreoinvenAux) throws Exception {
		//this.mensajecorreoinvenAux=mensajecorreoinvenAux;
		
			if(mensajecorreoinvenAux.getIsChanged()) {
				mensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(mensajecorreoinvenAux.getIsNew()) {
				mensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(mensajecorreoinvenAux.getIsDeleted()) {
				mensajecorreoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MensajeCorreoInven mensajecorreoinvenAsignar,MensajeCorreoInven mensajecorreoinven) throws Exception {
		mensajecorreoinvenAsignar.setId(mensajecorreoinven.getId());	
		mensajecorreoinvenAsignar.setVersionRow(mensajecorreoinven.getVersionRow());	
		mensajecorreoinvenAsignar.setid_empresa(mensajecorreoinven.getid_empresa());
		mensajecorreoinvenAsignar.setempresa_descripcion(mensajecorreoinven.getempresa_descripcion());	
		mensajecorreoinvenAsignar.setid_sucursal(mensajecorreoinven.getid_sucursal());
		mensajecorreoinvenAsignar.setsucursal_descripcion(mensajecorreoinven.getsucursal_descripcion());	
		mensajecorreoinvenAsignar.setid_modulo(mensajecorreoinven.getid_modulo());
		mensajecorreoinvenAsignar.setmodulo_descripcion(mensajecorreoinven.getmodulo_descripcion());	
		mensajecorreoinvenAsignar.setid_tipo_mensaje_correo_inven(mensajecorreoinven.getid_tipo_mensaje_correo_inven());
		mensajecorreoinvenAsignar.settipomensajecorreoinven_descripcion(mensajecorreoinven.gettipomensajecorreoinven_descripcion());	
		mensajecorreoinvenAsignar.settema(mensajecorreoinven.gettema());	
		mensajecorreoinvenAsignar.setmensaje(mensajecorreoinven.getmensaje());	
		mensajecorreoinvenAsignar.setaviso(mensajecorreoinven.getaviso());	
		mensajecorreoinvenAsignar.setesta_activo(mensajecorreoinven.getesta_activo());	
	}
	
	public static void inicializarMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven) throws Exception {
		try {
				mensajecorreoinven.setId(0L);	
					
				mensajecorreoinven.setid_empresa(-1L);	
				mensajecorreoinven.setid_sucursal(-1L);	
				mensajecorreoinven.setid_modulo(-1L);	
				mensajecorreoinven.setid_tipo_mensaje_correo_inven(-1L);	
				mensajecorreoinven.settema("");	
				mensajecorreoinven.setmensaje("");	
				mensajecorreoinven.setaviso("");	
				mensajecorreoinven.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMensajeCorreoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_IDTIPOMENSAJECORREOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_TEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_MENSAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_AVISO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMensajeCorreoInven(String sTipo,Row row,Workbook workbook,MensajeCorreoInven mensajecorreoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.gettipomensajecorreoinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.gettema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.getmensaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mensajecorreoinven.getaviso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(mensajecorreoinven.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMensajeCorreoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMensajeCorreoInven() {
		return this.sFinalQueryMensajeCorreoInven;
	}
	
	public void setsFinalQueryMensajeCorreoInven(String sFinalQueryMensajeCorreoInven) {
		this.sFinalQueryMensajeCorreoInven= sFinalQueryMensajeCorreoInven;
	}
	
	public Border resaltarSeleccionarMensajeCorreoInven=null;
	
	public Border setResaltarSeleccionarMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMensajeCorreoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMensajeCorreoInven() {
		return this.resaltarSeleccionarMensajeCorreoInven;
	}
	
	public void setResaltarSeleccionarMensajeCorreoInven(Border borderResaltarSeleccionarMensajeCorreoInven) {
		this.resaltarSeleccionarMensajeCorreoInven= borderResaltarSeleccionarMensajeCorreoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMensajeCorreoInven=null;
	public Boolean mostraridMensajeCorreoInven=true;
	public Boolean activaridMensajeCorreoInven=true;

	public Border resaltarid_empresaMensajeCorreoInven=null;
	public Boolean mostrarid_empresaMensajeCorreoInven=true;
	public Boolean activarid_empresaMensajeCorreoInven=true;
	public Boolean cargarid_empresaMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalMensajeCorreoInven=null;
	public Boolean mostrarid_sucursalMensajeCorreoInven=true;
	public Boolean activarid_sucursalMensajeCorreoInven=true;
	public Boolean cargarid_sucursalMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_moduloMensajeCorreoInven=null;
	public Boolean mostrarid_moduloMensajeCorreoInven=true;
	public Boolean activarid_moduloMensajeCorreoInven=true;
	public Boolean cargarid_moduloMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_tipo_mensaje_correo_invenMensajeCorreoInven=null;
	public Boolean mostrarid_tipo_mensaje_correo_invenMensajeCorreoInven=true;
	public Boolean activarid_tipo_mensaje_correo_invenMensajeCorreoInven=true;
	public Boolean cargarid_tipo_mensaje_correo_invenMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_mensaje_correo_invenMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltartemaMensajeCorreoInven=null;
	public Boolean mostrartemaMensajeCorreoInven=true;
	public Boolean activartemaMensajeCorreoInven=true;

	public Border resaltarmensajeMensajeCorreoInven=null;
	public Boolean mostrarmensajeMensajeCorreoInven=true;
	public Boolean activarmensajeMensajeCorreoInven=true;

	public Border resaltaravisoMensajeCorreoInven=null;
	public Boolean mostraravisoMensajeCorreoInven=true;
	public Boolean activaravisoMensajeCorreoInven=true;

	public Border resaltaresta_activoMensajeCorreoInven=null;
	public Boolean mostraresta_activoMensajeCorreoInven=true;
	public Boolean activaresta_activoMensajeCorreoInven=true;

	
	

	public Border setResaltaridMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaridMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMensajeCorreoInven() {
		return this.resaltaridMensajeCorreoInven;
	}

	public void setResaltaridMensajeCorreoInven(Border borderResaltar) {
		this.resaltaridMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraridMensajeCorreoInven() {
		return this.mostraridMensajeCorreoInven;
	}

	public void setMostraridMensajeCorreoInven(Boolean mostraridMensajeCorreoInven) {
		this.mostraridMensajeCorreoInven= mostraridMensajeCorreoInven;
	}

	public Boolean getActivaridMensajeCorreoInven() {
		return this.activaridMensajeCorreoInven;
	}

	public void setActivaridMensajeCorreoInven(Boolean activaridMensajeCorreoInven) {
		this.activaridMensajeCorreoInven= activaridMensajeCorreoInven;
	}

	public Border setResaltarid_empresaMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMensajeCorreoInven() {
		return this.resaltarid_empresaMensajeCorreoInven;
	}

	public void setResaltarid_empresaMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_empresaMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaMensajeCorreoInven() {
		return this.mostrarid_empresaMensajeCorreoInven;
	}

	public void setMostrarid_empresaMensajeCorreoInven(Boolean mostrarid_empresaMensajeCorreoInven) {
		this.mostrarid_empresaMensajeCorreoInven= mostrarid_empresaMensajeCorreoInven;
	}

	public Boolean getActivarid_empresaMensajeCorreoInven() {
		return this.activarid_empresaMensajeCorreoInven;
	}

	public void setActivarid_empresaMensajeCorreoInven(Boolean activarid_empresaMensajeCorreoInven) {
		this.activarid_empresaMensajeCorreoInven= activarid_empresaMensajeCorreoInven;
	}

	public Boolean getCargarid_empresaMensajeCorreoInven() {
		return this.cargarid_empresaMensajeCorreoInven;
	}

	public void setCargarid_empresaMensajeCorreoInven(Boolean cargarid_empresaMensajeCorreoInven) {
		this.cargarid_empresaMensajeCorreoInven= cargarid_empresaMensajeCorreoInven;
	}

	public Border setResaltarid_sucursalMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMensajeCorreoInven() {
		return this.resaltarid_sucursalMensajeCorreoInven;
	}

	public void setResaltarid_sucursalMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_sucursalMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMensajeCorreoInven() {
		return this.mostrarid_sucursalMensajeCorreoInven;
	}

	public void setMostrarid_sucursalMensajeCorreoInven(Boolean mostrarid_sucursalMensajeCorreoInven) {
		this.mostrarid_sucursalMensajeCorreoInven= mostrarid_sucursalMensajeCorreoInven;
	}

	public Boolean getActivarid_sucursalMensajeCorreoInven() {
		return this.activarid_sucursalMensajeCorreoInven;
	}

	public void setActivarid_sucursalMensajeCorreoInven(Boolean activarid_sucursalMensajeCorreoInven) {
		this.activarid_sucursalMensajeCorreoInven= activarid_sucursalMensajeCorreoInven;
	}

	public Boolean getCargarid_sucursalMensajeCorreoInven() {
		return this.cargarid_sucursalMensajeCorreoInven;
	}

	public void setCargarid_sucursalMensajeCorreoInven(Boolean cargarid_sucursalMensajeCorreoInven) {
		this.cargarid_sucursalMensajeCorreoInven= cargarid_sucursalMensajeCorreoInven;
	}

	public Border setResaltarid_moduloMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_moduloMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloMensajeCorreoInven() {
		return this.resaltarid_moduloMensajeCorreoInven;
	}

	public void setResaltarid_moduloMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_moduloMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_moduloMensajeCorreoInven() {
		return this.mostrarid_moduloMensajeCorreoInven;
	}

	public void setMostrarid_moduloMensajeCorreoInven(Boolean mostrarid_moduloMensajeCorreoInven) {
		this.mostrarid_moduloMensajeCorreoInven= mostrarid_moduloMensajeCorreoInven;
	}

	public Boolean getActivarid_moduloMensajeCorreoInven() {
		return this.activarid_moduloMensajeCorreoInven;
	}

	public void setActivarid_moduloMensajeCorreoInven(Boolean activarid_moduloMensajeCorreoInven) {
		this.activarid_moduloMensajeCorreoInven= activarid_moduloMensajeCorreoInven;
	}

	public Boolean getCargarid_moduloMensajeCorreoInven() {
		return this.cargarid_moduloMensajeCorreoInven;
	}

	public void setCargarid_moduloMensajeCorreoInven(Boolean cargarid_moduloMensajeCorreoInven) {
		this.cargarid_moduloMensajeCorreoInven= cargarid_moduloMensajeCorreoInven;
	}

	public Border setResaltarid_tipo_mensaje_correo_invenMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_tipo_mensaje_correo_invenMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_mensaje_correo_invenMensajeCorreoInven() {
		return this.resaltarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public void setResaltarid_tipo_mensaje_correo_invenMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_tipo_mensaje_correo_invenMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_tipo_mensaje_correo_invenMensajeCorreoInven() {
		return this.mostrarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public void setMostrarid_tipo_mensaje_correo_invenMensajeCorreoInven(Boolean mostrarid_tipo_mensaje_correo_invenMensajeCorreoInven) {
		this.mostrarid_tipo_mensaje_correo_invenMensajeCorreoInven= mostrarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public Boolean getActivarid_tipo_mensaje_correo_invenMensajeCorreoInven() {
		return this.activarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public void setActivarid_tipo_mensaje_correo_invenMensajeCorreoInven(Boolean activarid_tipo_mensaje_correo_invenMensajeCorreoInven) {
		this.activarid_tipo_mensaje_correo_invenMensajeCorreoInven= activarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public Boolean getCargarid_tipo_mensaje_correo_invenMensajeCorreoInven() {
		return this.cargarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public void setCargarid_tipo_mensaje_correo_invenMensajeCorreoInven(Boolean cargarid_tipo_mensaje_correo_invenMensajeCorreoInven) {
		this.cargarid_tipo_mensaje_correo_invenMensajeCorreoInven= cargarid_tipo_mensaje_correo_invenMensajeCorreoInven;
	}

	public Border setResaltartemaMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltartemaMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartemaMensajeCorreoInven() {
		return this.resaltartemaMensajeCorreoInven;
	}

	public void setResaltartemaMensajeCorreoInven(Border borderResaltar) {
		this.resaltartemaMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrartemaMensajeCorreoInven() {
		return this.mostrartemaMensajeCorreoInven;
	}

	public void setMostrartemaMensajeCorreoInven(Boolean mostrartemaMensajeCorreoInven) {
		this.mostrartemaMensajeCorreoInven= mostrartemaMensajeCorreoInven;
	}

	public Boolean getActivartemaMensajeCorreoInven() {
		return this.activartemaMensajeCorreoInven;
	}

	public void setActivartemaMensajeCorreoInven(Boolean activartemaMensajeCorreoInven) {
		this.activartemaMensajeCorreoInven= activartemaMensajeCorreoInven;
	}

	public Border setResaltarmensajeMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarmensajeMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmensajeMensajeCorreoInven() {
		return this.resaltarmensajeMensajeCorreoInven;
	}

	public void setResaltarmensajeMensajeCorreoInven(Border borderResaltar) {
		this.resaltarmensajeMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarmensajeMensajeCorreoInven() {
		return this.mostrarmensajeMensajeCorreoInven;
	}

	public void setMostrarmensajeMensajeCorreoInven(Boolean mostrarmensajeMensajeCorreoInven) {
		this.mostrarmensajeMensajeCorreoInven= mostrarmensajeMensajeCorreoInven;
	}

	public Boolean getActivarmensajeMensajeCorreoInven() {
		return this.activarmensajeMensajeCorreoInven;
	}

	public void setActivarmensajeMensajeCorreoInven(Boolean activarmensajeMensajeCorreoInven) {
		this.activarmensajeMensajeCorreoInven= activarmensajeMensajeCorreoInven;
	}

	public Border setResaltaravisoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaravisoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaravisoMensajeCorreoInven() {
		return this.resaltaravisoMensajeCorreoInven;
	}

	public void setResaltaravisoMensajeCorreoInven(Border borderResaltar) {
		this.resaltaravisoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraravisoMensajeCorreoInven() {
		return this.mostraravisoMensajeCorreoInven;
	}

	public void setMostraravisoMensajeCorreoInven(Boolean mostraravisoMensajeCorreoInven) {
		this.mostraravisoMensajeCorreoInven= mostraravisoMensajeCorreoInven;
	}

	public Boolean getActivaravisoMensajeCorreoInven() {
		return this.activaravisoMensajeCorreoInven;
	}

	public void setActivaravisoMensajeCorreoInven(Boolean activaravisoMensajeCorreoInven) {
		this.activaravisoMensajeCorreoInven= activaravisoMensajeCorreoInven;
	}

	public Border setResaltaresta_activoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaresta_activoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoMensajeCorreoInven() {
		return this.resaltaresta_activoMensajeCorreoInven;
	}

	public void setResaltaresta_activoMensajeCorreoInven(Border borderResaltar) {
		this.resaltaresta_activoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraresta_activoMensajeCorreoInven() {
		return this.mostraresta_activoMensajeCorreoInven;
	}

	public void setMostraresta_activoMensajeCorreoInven(Boolean mostraresta_activoMensajeCorreoInven) {
		this.mostraresta_activoMensajeCorreoInven= mostraresta_activoMensajeCorreoInven;
	}

	public Boolean getActivaresta_activoMensajeCorreoInven() {
		return this.activaresta_activoMensajeCorreoInven;
	}

	public void setActivaresta_activoMensajeCorreoInven(Boolean activaresta_activoMensajeCorreoInven) {
		this.activaresta_activoMensajeCorreoInven= activaresta_activoMensajeCorreoInven;
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
		
		
		this.setMostraridMensajeCorreoInven(esInicial);
		this.setMostrarid_empresaMensajeCorreoInven(esInicial);
		this.setMostrarid_sucursalMensajeCorreoInven(esInicial);
		this.setMostrarid_moduloMensajeCorreoInven(esInicial);
		this.setMostrarid_tipo_mensaje_correo_invenMensajeCorreoInven(esInicial);
		this.setMostrartemaMensajeCorreoInven(esInicial);
		this.setMostrarmensajeMensajeCorreoInven(esInicial);
		this.setMostraravisoMensajeCorreoInven(esInicial);
		this.setMostraresta_activoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ID)) {
				this.setMostraridMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN)) {
				this.setMostrarid_tipo_mensaje_correo_invenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.TEMA)) {
				this.setMostrartemaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.MENSAJE)) {
				this.setMostrarmensajeMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.AVISO)) {
				this.setMostraravisoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoMensajeCorreoInven(esAsigna);
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
		
		
		this.setActivaridMensajeCorreoInven(esInicial);
		this.setActivarid_empresaMensajeCorreoInven(esInicial);
		this.setActivarid_sucursalMensajeCorreoInven(esInicial);
		this.setActivarid_moduloMensajeCorreoInven(esInicial);
		this.setActivarid_tipo_mensaje_correo_invenMensajeCorreoInven(esInicial);
		this.setActivartemaMensajeCorreoInven(esInicial);
		this.setActivarmensajeMensajeCorreoInven(esInicial);
		this.setActivaravisoMensajeCorreoInven(esInicial);
		this.setActivaresta_activoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ID)) {
				this.setActivaridMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN)) {
				this.setActivarid_tipo_mensaje_correo_invenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.TEMA)) {
				this.setActivartemaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.MENSAJE)) {
				this.setActivarmensajeMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.AVISO)) {
				this.setActivaravisoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoMensajeCorreoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMensajeCorreoInven(esInicial);
		this.setResaltarid_empresaMensajeCorreoInven(esInicial);
		this.setResaltarid_sucursalMensajeCorreoInven(esInicial);
		this.setResaltarid_moduloMensajeCorreoInven(esInicial);
		this.setResaltarid_tipo_mensaje_correo_invenMensajeCorreoInven(esInicial);
		this.setResaltartemaMensajeCorreoInven(esInicial);
		this.setResaltarmensajeMensajeCorreoInven(esInicial);
		this.setResaltaravisoMensajeCorreoInven(esInicial);
		this.setResaltaresta_activoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ID)) {
				this.setResaltaridMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN)) {
				this.setResaltarid_tipo_mensaje_correo_invenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.TEMA)) {
				this.setResaltartemaMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.MENSAJE)) {
				this.setResaltarmensajeMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.AVISO)) {
				this.setResaltaravisoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(MensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoMensajeCorreoInven(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleMensajeCorreoInvenMensajeCorreoInven=null;

	public Border getResaltarDetalleMensajeCorreoInvenMensajeCorreoInven() {
		return this.resaltarDetalleMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setResaltarDetalleMensajeCorreoInvenMensajeCorreoInven(Border borderResaltarDetalleMensajeCorreoInven) {
		if(borderResaltarDetalleMensajeCorreoInven!=null) {
			this.resaltarDetalleMensajeCorreoInvenMensajeCorreoInven= borderResaltarDetalleMensajeCorreoInven;
		}
	}

	public Border setResaltarDetalleMensajeCorreoInvenMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMensajeCorreoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltarDetalleMensajeCorreoInven);
			
		this.resaltarDetalleMensajeCorreoInvenMensajeCorreoInven= borderResaltarDetalleMensajeCorreoInven;

		 return borderResaltarDetalleMensajeCorreoInven;
	}



	public Boolean mostrarDetalleMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean getMostrarDetalleMensajeCorreoInvenMensajeCorreoInven() {
		return this.mostrarDetalleMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setMostrarDetalleMensajeCorreoInvenMensajeCorreoInven(Boolean visibilidadResaltarDetalleMensajeCorreoInven) {
		this.mostrarDetalleMensajeCorreoInvenMensajeCorreoInven= visibilidadResaltarDetalleMensajeCorreoInven;
	}



	public Boolean activarDetalleMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean gethabilitarResaltarDetalleMensajeCorreoInvenMensajeCorreoInven() {
		return this.activarDetalleMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setActivarDetalleMensajeCorreoInvenMensajeCorreoInven(Boolean habilitarResaltarDetalleMensajeCorreoInven) {
		this.activarDetalleMensajeCorreoInvenMensajeCorreoInven= habilitarResaltarDetalleMensajeCorreoInven;
	}


	public Border resaltarMailMensajeCorreoInvenMensajeCorreoInven=null;

	public Border getResaltarMailMensajeCorreoInvenMensajeCorreoInven() {
		return this.resaltarMailMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setResaltarMailMensajeCorreoInvenMensajeCorreoInven(Border borderResaltarMailMensajeCorreoInven) {
		if(borderResaltarMailMensajeCorreoInven!=null) {
			this.resaltarMailMensajeCorreoInvenMensajeCorreoInven= borderResaltarMailMensajeCorreoInven;
		}
	}

	public Border setResaltarMailMensajeCorreoInvenMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltarMailMensajeCorreoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarMensajeCorreoInven.setBorder(borderResaltarMailMensajeCorreoInven);
			
		this.resaltarMailMensajeCorreoInvenMensajeCorreoInven= borderResaltarMailMensajeCorreoInven;

		 return borderResaltarMailMensajeCorreoInven;
	}



	public Boolean mostrarMailMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean getMostrarMailMensajeCorreoInvenMensajeCorreoInven() {
		return this.mostrarMailMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setMostrarMailMensajeCorreoInvenMensajeCorreoInven(Boolean visibilidadResaltarMailMensajeCorreoInven) {
		this.mostrarMailMensajeCorreoInvenMensajeCorreoInven= visibilidadResaltarMailMensajeCorreoInven;
	}



	public Boolean activarMailMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean gethabilitarResaltarMailMensajeCorreoInvenMensajeCorreoInven() {
		return this.activarMailMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setActivarMailMensajeCorreoInvenMensajeCorreoInven(Boolean habilitarResaltarMailMensajeCorreoInven) {
		this.activarMailMensajeCorreoInvenMensajeCorreoInven= habilitarResaltarMailMensajeCorreoInven;
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

		this.setMostrarDetalleMensajeCorreoInvenMensajeCorreoInven(esInicial);
		this.setMostrarMailMensajeCorreoInvenMensajeCorreoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setMostrarDetalleMensajeCorreoInvenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(MailMensajeCorreoInven.class)) {
				this.setMostrarMailMensajeCorreoInvenMensajeCorreoInven(esAsigna);
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

		this.setActivarDetalleMensajeCorreoInvenMensajeCorreoInven(esInicial);
		this.setActivarMailMensajeCorreoInvenMensajeCorreoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setActivarDetalleMensajeCorreoInvenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(MailMensajeCorreoInven.class)) {
				this.setActivarMailMensajeCorreoInvenMensajeCorreoInven(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleMensajeCorreoInvenMensajeCorreoInven(esInicial);
		this.setResaltarMailMensajeCorreoInvenMensajeCorreoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMensajeCorreoInven.class)) {
				this.setResaltarDetalleMensajeCorreoInvenMensajeCorreoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(MailMensajeCorreoInven.class)) {
				this.setResaltarMailMensajeCorreoInvenMensajeCorreoInven(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdEmpresaMensajeCorreoInven() {
		return this.mostrarFK_IdEmpresaMensajeCorreoInven;
	}

	public void setMostrarFK_IdEmpresaMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdModuloMensajeCorreoInven() {
		return this.mostrarFK_IdModuloMensajeCorreoInven;
	}

	public void setMostrarFK_IdModuloMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdSucursalMensajeCorreoInven() {
		return this.mostrarFK_IdSucursalMensajeCorreoInven;
	}

	public void setMostrarFK_IdSucursalMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven() {
		return this.mostrarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setMostrarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaMensajeCorreoInven=true;

	public Boolean getActivarFK_IdEmpresaMensajeCorreoInven() {
		return this.activarFK_IdEmpresaMensajeCorreoInven;
	}

	public void setActivarFK_IdEmpresaMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloMensajeCorreoInven=true;

	public Boolean getActivarFK_IdModuloMensajeCorreoInven() {
		return this.activarFK_IdModuloMensajeCorreoInven;
	}

	public void setActivarFK_IdModuloMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdModuloMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMensajeCorreoInven=true;

	public Boolean getActivarFK_IdSucursalMensajeCorreoInven() {
		return this.activarFK_IdSucursalMensajeCorreoInven;
	}

	public void setActivarFK_IdSucursalMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven=true;

	public Boolean getActivarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven() {
		return this.activarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setActivarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaMensajeCorreoInven=null;

	public Border getResaltarFK_IdEmpresaMensajeCorreoInven() {
		return this.resaltarFK_IdEmpresaMensajeCorreoInven;
	}

	public void setResaltarFK_IdEmpresaMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdModuloMensajeCorreoInven=null;

	public Border getResaltarFK_IdModuloMensajeCorreoInven() {
		return this.resaltarFK_IdModuloMensajeCorreoInven;
	}

	public void setResaltarFK_IdModuloMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdModuloMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdModuloMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMensajeCorreoInven=null;

	public Border getResaltarFK_IdSucursalMensajeCorreoInven() {
		return this.resaltarFK_IdSucursalMensajeCorreoInven;
	}

	public void setResaltarFK_IdSucursalMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven=null;

	public Border getResaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven() {
		return this.resaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven;
	}

	public void setResaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*MensajeCorreoInvenBeanSwingJInternalFrame mensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMensajeCorreoInvenMensajeCorreoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}