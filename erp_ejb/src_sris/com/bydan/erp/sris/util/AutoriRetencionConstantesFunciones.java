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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.AutoriRetencionConstantesFunciones;
import com.bydan.erp.sris.util.AutoriRetencionParameterReturnGeneral;
//import com.bydan.erp.sris.util.AutoriRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AutoriRetencionConstantesFunciones extends AutoriRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AutoriRetencion";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutoriRetencion"+AutoriRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutoriRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutoriRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutoriRetencionConstantesFunciones.SCHEMA+"_"+AutoriRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutoriRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutoriRetencionConstantesFunciones.SCHEMA+"_"+AutoriRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutoriRetencionConstantesFunciones.SCHEMA+"_"+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutoriRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutoriRetencionConstantesFunciones.SCHEMA+"_"+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutoriRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutoriRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutoriRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutoriRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autori Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Autori Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Autori Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutoriRetencion";
	public static final String OBJECTNAME="autoriretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="autori_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autoriretencion from "+AutoriRetencionConstantesFunciones.SPERSISTENCENAME+" autoriretencion";
	public static String QUERYSELECTNATIVE="select "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".version_row,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_empresa,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_usuario,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_serie,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_autorizacion,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_inicial,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_final,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".fecha_caducidad,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".esta_activo from "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME;//+" as "+AutoriRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AutoriRetencionConstantesFuncionesAdditional autoriretencionConstantesFuncionesAdditional=null;
	
	public AutoriRetencionConstantesFuncionesAdditional getAutoriRetencionConstantesFuncionesAdditional() {
		return this.autoriretencionConstantesFuncionesAdditional;
	}
	
	public void setAutoriRetencionConstantesFuncionesAdditional(AutoriRetencionConstantesFuncionesAdditional autoriretencionConstantesFuncionesAdditional) {
		try {
			this.autoriretencionConstantesFuncionesAdditional=autoriretencionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String NUMEROINICIAL= "numero_inicial";
    public static final String NUMEROFINAL= "numero_final";
    public static final String FECHACADUCIDAD= "fecha_caducidad";
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
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NUMEROSERIE= "Numero Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_NUMEROINICIAL= "Numero Inicial";
		public static final String LABEL_NUMEROINICIAL_LOWER= "Numero Inicial";
    	public static final String LABEL_NUMEROFINAL= "Numero Final";
		public static final String LABEL_NUMEROFINAL_LOWER= "Numero Final";
    	public static final String LABEL_FECHACADUCIDAD= "Fecha Caducad";
		public static final String LABEL_FECHACADUCIDAD_LOWER= "Fecha Caducidad";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_INICIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_INICIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FINAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FINAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getAutoriRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.IDUSUARIO)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.NUMEROSERIE)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.NUMEROINICIAL)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_NUMEROINICIAL;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.NUMEROFINAL)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_NUMEROFINAL;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.FECHACADUCIDAD)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_FECHACADUCIDAD;}
		if(sNombreColumna.equals(AutoriRetencionConstantesFunciones.ESTAACTIVO)) {sLabelColumna=AutoriRetencionConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(AutoriRetencion autoriretencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!autoriretencion.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(AutoriRetencion autoriretencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(autoriretencion.getId(),autoriretencion.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getAutoriRetencionDescripcion(AutoriRetencion autoriretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autoriretencion !=null/* && autoriretencion.getId()!=0*/) {
			if(autoriretencion.getId()!=null) {
				sDescripcion=autoriretencion.getId().toString();
			}//autoriretencionautoriretencion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAutoriRetencionDescripcionDetallado(AutoriRetencion autoriretencion) {
		String sDescripcion="";
			
		sDescripcion+=AutoriRetencionConstantesFunciones.ID+"=";
		sDescripcion+=autoriretencion.getId().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autoriretencion.getVersionRow().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autoriretencion.getid_empresa().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=autoriretencion.getid_sucursal().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=autoriretencion.getid_usuario().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=autoriretencion.getnumero_serie()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=autoriretencion.getnumero_autorizacion()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.NUMEROINICIAL+"=";
		sDescripcion+=autoriretencion.getnumero_inicial()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.NUMEROFINAL+"=";
		sDescripcion+=autoriretencion.getnumero_final()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.FECHACADUCIDAD+"=";
		sDescripcion+=autoriretencion.getfecha_caducidad().toString()+",";
		sDescripcion+=AutoriRetencionConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=autoriretencion.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAutoriRetencionDescripcion(AutoriRetencion autoriretencion,String sValor) throws Exception {			
		if(autoriretencion !=null) {
			//autoriretencionautoriretencion.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAutoriRetencion(AutoriRetencion autoriretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autoriretencion.setnumero_serie(autoriretencion.getnumero_serie().trim());
		autoriretencion.setnumero_autorizacion(autoriretencion.getnumero_autorizacion().trim());
		autoriretencion.setnumero_inicial(autoriretencion.getnumero_inicial().trim());
		autoriretencion.setnumero_final(autoriretencion.getnumero_final().trim());
	}
	
	public static void quitarEspaciosAutoriRetencions(List<AutoriRetencion> autoriretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutoriRetencion autoriretencion: autoriretencions) {
			autoriretencion.setnumero_serie(autoriretencion.getnumero_serie().trim());
			autoriretencion.setnumero_autorizacion(autoriretencion.getnumero_autorizacion().trim());
			autoriretencion.setnumero_inicial(autoriretencion.getnumero_inicial().trim());
			autoriretencion.setnumero_final(autoriretencion.getnumero_final().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriRetencion(AutoriRetencion autoriretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autoriretencion.getConCambioAuxiliar()) {
			autoriretencion.setIsDeleted(autoriretencion.getIsDeletedAuxiliar());	
			autoriretencion.setIsNew(autoriretencion.getIsNewAuxiliar());	
			autoriretencion.setIsChanged(autoriretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autoriretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autoriretencion.setIsDeletedAuxiliar(false);	
			autoriretencion.setIsNewAuxiliar(false);	
			autoriretencion.setIsChangedAuxiliar(false);
			
			autoriretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriRetencions(List<AutoriRetencion> autoriretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutoriRetencion autoriretencion : autoriretencions) {
			if(conAsignarBase && autoriretencion.getConCambioAuxiliar()) {
				autoriretencion.setIsDeleted(autoriretencion.getIsDeletedAuxiliar());	
				autoriretencion.setIsNew(autoriretencion.getIsNewAuxiliar());	
				autoriretencion.setIsChanged(autoriretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autoriretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autoriretencion.setIsDeletedAuxiliar(false);	
				autoriretencion.setIsNewAuxiliar(false);	
				autoriretencion.setIsChangedAuxiliar(false);
				
				autoriretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutoriRetencion(AutoriRetencion autoriretencion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAutoriRetencions(List<AutoriRetencion> autoriretencions,Boolean conEnteros) throws Exception  {
		
		for(AutoriRetencion autoriretencion: autoriretencions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutoriRetencion(List<AutoriRetencion> autoriretencions,AutoriRetencion autoriretencionAux) throws Exception  {
		AutoriRetencionConstantesFunciones.InicializarValoresAutoriRetencion(autoriretencionAux,true);
		
		for(AutoriRetencion autoriretencion: autoriretencions) {
			if(autoriretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutoriRetencionConstantesFunciones.getArrayColumnasGlobalesAutoriRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriRetencionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriRetencionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriRetencionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriRetencionConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriRetencionConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutoriRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutoriRetencion> autoriretencions,AutoriRetencion autoriretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutoriRetencion autoriretencionAux: autoriretencions) {
			if(autoriretencionAux!=null && autoriretencion!=null) {
				if((autoriretencionAux.getId()==null && autoriretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autoriretencionAux.getId()!=null && autoriretencion.getId()!=null){
					if(autoriretencionAux.getId().equals(autoriretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutoriRetencion(List<AutoriRetencion> autoriretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AutoriRetencion autoriretencion: autoriretencions) {			
			if(autoriretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutoriRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_ID, AutoriRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_VERSIONROW, AutoriRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_IDEMPRESA, AutoriRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_IDSUCURSAL, AutoriRetencionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_IDUSUARIO, AutoriRetencionConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_NUMEROSERIE, AutoriRetencionConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_NUMEROAUTORIZACION, AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_NUMEROINICIAL, AutoriRetencionConstantesFunciones.NUMEROINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_NUMEROFINAL, AutoriRetencionConstantesFunciones.NUMEROFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_FECHACADUCIDAD, AutoriRetencionConstantesFunciones.FECHACADUCIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriRetencionConstantesFunciones.LABEL_ESTAACTIVO, AutoriRetencionConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutoriRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.NUMEROINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.NUMEROFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.FECHACADUCIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriRetencionConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriRetencion() throws Exception  {
		return AutoriRetencionConstantesFunciones.getTiposSeleccionarAutoriRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriRetencion(Boolean conFk) throws Exception  {
		return AutoriRetencionConstantesFunciones.getTiposSeleccionarAutoriRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_NUMEROINICIAL);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_NUMEROINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_NUMEROFINAL);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_NUMEROFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_FECHACADUCIDAD);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_FECHACADUCIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriRetencionConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(AutoriRetencionConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutoriRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriRetencion(AutoriRetencion autoriretencionAux) throws Exception {
		
			autoriretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoriretencionAux.getEmpresa()));
			autoriretencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoriretencionAux.getSucursal()));
			autoriretencionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoriretencionAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriRetencion(List<AutoriRetencion> autoriretencionsTemp) throws Exception {
		for(AutoriRetencion autoriretencionAux:autoriretencionsTemp) {
			
			autoriretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoriretencionAux.getEmpresa()));
			autoriretencionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoriretencionAux.getSucursal()));
			autoriretencionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoriretencionAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutoriRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriRetencionConstantesFunciones.getClassesRelationshipsOfAutoriRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfAutoriRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AutoriRetencion autoriretencion,List<AutoriRetencion> autoriretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AutoriRetencion autoriretencionEncontrado=null;
			
			for(AutoriRetencion autoriretencionLocal:autoriretencions) {
				if(autoriretencionLocal.getId().equals(autoriretencion.getId())) {
					autoriretencionEncontrado=autoriretencionLocal;
					
					autoriretencionLocal.setIsChanged(autoriretencion.getIsChanged());
					autoriretencionLocal.setIsNew(autoriretencion.getIsNew());
					autoriretencionLocal.setIsDeleted(autoriretencion.getIsDeleted());
					
					autoriretencionLocal.setGeneralEntityOriginal(autoriretencion.getGeneralEntityOriginal());
					
					autoriretencionLocal.setId(autoriretencion.getId());	
					autoriretencionLocal.setVersionRow(autoriretencion.getVersionRow());	
					autoriretencionLocal.setid_empresa(autoriretencion.getid_empresa());	
					autoriretencionLocal.setid_sucursal(autoriretencion.getid_sucursal());	
					autoriretencionLocal.setid_usuario(autoriretencion.getid_usuario());	
					autoriretencionLocal.setnumero_serie(autoriretencion.getnumero_serie());	
					autoriretencionLocal.setnumero_autorizacion(autoriretencion.getnumero_autorizacion());	
					autoriretencionLocal.setnumero_inicial(autoriretencion.getnumero_inicial());	
					autoriretencionLocal.setnumero_final(autoriretencion.getnumero_final());	
					autoriretencionLocal.setfecha_caducidad(autoriretencion.getfecha_caducidad());	
					autoriretencionLocal.setesta_activo(autoriretencion.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!autoriretencion.getIsDeleted()) {
				if(!existe) {
					autoriretencions.add(autoriretencion);
				}
			} else {
				if(autoriretencionEncontrado!=null && permiteQuitar)  {
					autoriretencions.remove(autoriretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AutoriRetencion autoriretencion,List<AutoriRetencion> autoriretencions) throws Exception {
		try	{			
			for(AutoriRetencion autoriretencionLocal:autoriretencions) {
				if(autoriretencionLocal.getId().equals(autoriretencion.getId())) {
					autoriretencionLocal.setIsSelected(autoriretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutoriRetencion(List<AutoriRetencion> autoriretencionsAux) throws Exception {
		//this.autoriretencionsAux=autoriretencionsAux;
		
		for(AutoriRetencion autoriretencionAux:autoriretencionsAux) {
			if(autoriretencionAux.getIsChanged()) {
				autoriretencionAux.setIsChanged(false);
			}		
			
			if(autoriretencionAux.getIsNew()) {
				autoriretencionAux.setIsNew(false);
			}	
			
			if(autoriretencionAux.getIsDeleted()) {
				autoriretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutoriRetencion(AutoriRetencion autoriretencionAux) throws Exception {
		//this.autoriretencionAux=autoriretencionAux;
		
			if(autoriretencionAux.getIsChanged()) {
				autoriretencionAux.setIsChanged(false);
			}		
			
			if(autoriretencionAux.getIsNew()) {
				autoriretencionAux.setIsNew(false);
			}	
			
			if(autoriretencionAux.getIsDeleted()) {
				autoriretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutoriRetencion autoriretencionAsignar,AutoriRetencion autoriretencion) throws Exception {
		autoriretencionAsignar.setId(autoriretencion.getId());	
		autoriretencionAsignar.setVersionRow(autoriretencion.getVersionRow());	
		autoriretencionAsignar.setid_empresa(autoriretencion.getid_empresa());
		autoriretencionAsignar.setempresa_descripcion(autoriretencion.getempresa_descripcion());	
		autoriretencionAsignar.setid_sucursal(autoriretencion.getid_sucursal());
		autoriretencionAsignar.setsucursal_descripcion(autoriretencion.getsucursal_descripcion());	
		autoriretencionAsignar.setid_usuario(autoriretencion.getid_usuario());
		autoriretencionAsignar.setusuario_descripcion(autoriretencion.getusuario_descripcion());	
		autoriretencionAsignar.setnumero_serie(autoriretencion.getnumero_serie());	
		autoriretencionAsignar.setnumero_autorizacion(autoriretencion.getnumero_autorizacion());	
		autoriretencionAsignar.setnumero_inicial(autoriretencion.getnumero_inicial());	
		autoriretencionAsignar.setnumero_final(autoriretencion.getnumero_final());	
		autoriretencionAsignar.setfecha_caducidad(autoriretencion.getfecha_caducidad());	
		autoriretencionAsignar.setesta_activo(autoriretencion.getesta_activo());	
	}
	
	public static void inicializarAutoriRetencion(AutoriRetencion autoriretencion) throws Exception {
		try {
				autoriretencion.setId(0L);	
					
				autoriretencion.setid_empresa(-1L);	
				autoriretencion.setid_sucursal(-1L);	
				autoriretencion.setid_usuario(-1L);	
				autoriretencion.setnumero_serie("");	
				autoriretencion.setnumero_autorizacion("");	
				autoriretencion.setnumero_inicial("");	
				autoriretencion.setnumero_final("");	
				autoriretencion.setfecha_caducidad(new Date());	
				autoriretencion.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutoriRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_NUMEROINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_NUMEROFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_FECHACADUCIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriRetencionConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutoriRetencion(String sTipo,Row row,Workbook workbook,AutoriRetencion autoriretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getnumero_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getnumero_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriretencion.getfecha_caducidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(autoriretencion.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutoriRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAutoriRetencion() {
		return this.sFinalQueryAutoriRetencion;
	}
	
	public void setsFinalQueryAutoriRetencion(String sFinalQueryAutoriRetencion) {
		this.sFinalQueryAutoriRetencion= sFinalQueryAutoriRetencion;
	}
	
	public Border resaltarSeleccionarAutoriRetencion=null;
	
	public Border setResaltarSeleccionarAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutoriRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutoriRetencion() {
		return this.resaltarSeleccionarAutoriRetencion;
	}
	
	public void setResaltarSeleccionarAutoriRetencion(Border borderResaltarSeleccionarAutoriRetencion) {
		this.resaltarSeleccionarAutoriRetencion= borderResaltarSeleccionarAutoriRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutoriRetencion=null;
	public Boolean mostraridAutoriRetencion=true;
	public Boolean activaridAutoriRetencion=true;

	public Border resaltarid_empresaAutoriRetencion=null;
	public Boolean mostrarid_empresaAutoriRetencion=true;
	public Boolean activarid_empresaAutoriRetencion=true;
	public Boolean cargarid_empresaAutoriRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutoriRetencion=false;//ConEventDepend=true

	public Border resaltarid_sucursalAutoriRetencion=null;
	public Boolean mostrarid_sucursalAutoriRetencion=true;
	public Boolean activarid_sucursalAutoriRetencion=true;
	public Boolean cargarid_sucursalAutoriRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAutoriRetencion=false;//ConEventDepend=true

	public Border resaltarid_usuarioAutoriRetencion=null;
	public Boolean mostrarid_usuarioAutoriRetencion=true;
	public Boolean activarid_usuarioAutoriRetencion=true;
	public Boolean cargarid_usuarioAutoriRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAutoriRetencion=false;//ConEventDepend=true

	public Border resaltarnumero_serieAutoriRetencion=null;
	public Boolean mostrarnumero_serieAutoriRetencion=true;
	public Boolean activarnumero_serieAutoriRetencion=true;

	public Border resaltarnumero_autorizacionAutoriRetencion=null;
	public Boolean mostrarnumero_autorizacionAutoriRetencion=true;
	public Boolean activarnumero_autorizacionAutoriRetencion=true;

	public Border resaltarnumero_inicialAutoriRetencion=null;
	public Boolean mostrarnumero_inicialAutoriRetencion=true;
	public Boolean activarnumero_inicialAutoriRetencion=true;

	public Border resaltarnumero_finalAutoriRetencion=null;
	public Boolean mostrarnumero_finalAutoriRetencion=true;
	public Boolean activarnumero_finalAutoriRetencion=true;

	public Border resaltarfecha_caducidadAutoriRetencion=null;
	public Boolean mostrarfecha_caducidadAutoriRetencion=true;
	public Boolean activarfecha_caducidadAutoriRetencion=true;

	public Border resaltaresta_activoAutoriRetencion=null;
	public Boolean mostraresta_activoAutoriRetencion=true;
	public Boolean activaresta_activoAutoriRetencion=true;

	
	

	public Border setResaltaridAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltaridAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutoriRetencion() {
		return this.resaltaridAutoriRetencion;
	}

	public void setResaltaridAutoriRetencion(Border borderResaltar) {
		this.resaltaridAutoriRetencion= borderResaltar;
	}

	public Boolean getMostraridAutoriRetencion() {
		return this.mostraridAutoriRetencion;
	}

	public void setMostraridAutoriRetencion(Boolean mostraridAutoriRetencion) {
		this.mostraridAutoriRetencion= mostraridAutoriRetencion;
	}

	public Boolean getActivaridAutoriRetencion() {
		return this.activaridAutoriRetencion;
	}

	public void setActivaridAutoriRetencion(Boolean activaridAutoriRetencion) {
		this.activaridAutoriRetencion= activaridAutoriRetencion;
	}

	public Border setResaltarid_empresaAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutoriRetencion() {
		return this.resaltarid_empresaAutoriRetencion;
	}

	public void setResaltarid_empresaAutoriRetencion(Border borderResaltar) {
		this.resaltarid_empresaAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutoriRetencion() {
		return this.mostrarid_empresaAutoriRetencion;
	}

	public void setMostrarid_empresaAutoriRetencion(Boolean mostrarid_empresaAutoriRetencion) {
		this.mostrarid_empresaAutoriRetencion= mostrarid_empresaAutoriRetencion;
	}

	public Boolean getActivarid_empresaAutoriRetencion() {
		return this.activarid_empresaAutoriRetencion;
	}

	public void setActivarid_empresaAutoriRetencion(Boolean activarid_empresaAutoriRetencion) {
		this.activarid_empresaAutoriRetencion= activarid_empresaAutoriRetencion;
	}

	public Boolean getCargarid_empresaAutoriRetencion() {
		return this.cargarid_empresaAutoriRetencion;
	}

	public void setCargarid_empresaAutoriRetencion(Boolean cargarid_empresaAutoriRetencion) {
		this.cargarid_empresaAutoriRetencion= cargarid_empresaAutoriRetencion;
	}

	public Border setResaltarid_sucursalAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAutoriRetencion() {
		return this.resaltarid_sucursalAutoriRetencion;
	}

	public void setResaltarid_sucursalAutoriRetencion(Border borderResaltar) {
		this.resaltarid_sucursalAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAutoriRetencion() {
		return this.mostrarid_sucursalAutoriRetencion;
	}

	public void setMostrarid_sucursalAutoriRetencion(Boolean mostrarid_sucursalAutoriRetencion) {
		this.mostrarid_sucursalAutoriRetencion= mostrarid_sucursalAutoriRetencion;
	}

	public Boolean getActivarid_sucursalAutoriRetencion() {
		return this.activarid_sucursalAutoriRetencion;
	}

	public void setActivarid_sucursalAutoriRetencion(Boolean activarid_sucursalAutoriRetencion) {
		this.activarid_sucursalAutoriRetencion= activarid_sucursalAutoriRetencion;
	}

	public Boolean getCargarid_sucursalAutoriRetencion() {
		return this.cargarid_sucursalAutoriRetencion;
	}

	public void setCargarid_sucursalAutoriRetencion(Boolean cargarid_sucursalAutoriRetencion) {
		this.cargarid_sucursalAutoriRetencion= cargarid_sucursalAutoriRetencion;
	}

	public Border setResaltarid_usuarioAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAutoriRetencion() {
		return this.resaltarid_usuarioAutoriRetencion;
	}

	public void setResaltarid_usuarioAutoriRetencion(Border borderResaltar) {
		this.resaltarid_usuarioAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAutoriRetencion() {
		return this.mostrarid_usuarioAutoriRetencion;
	}

	public void setMostrarid_usuarioAutoriRetencion(Boolean mostrarid_usuarioAutoriRetencion) {
		this.mostrarid_usuarioAutoriRetencion= mostrarid_usuarioAutoriRetencion;
	}

	public Boolean getActivarid_usuarioAutoriRetencion() {
		return this.activarid_usuarioAutoriRetencion;
	}

	public void setActivarid_usuarioAutoriRetencion(Boolean activarid_usuarioAutoriRetencion) {
		this.activarid_usuarioAutoriRetencion= activarid_usuarioAutoriRetencion;
	}

	public Boolean getCargarid_usuarioAutoriRetencion() {
		return this.cargarid_usuarioAutoriRetencion;
	}

	public void setCargarid_usuarioAutoriRetencion(Boolean cargarid_usuarioAutoriRetencion) {
		this.cargarid_usuarioAutoriRetencion= cargarid_usuarioAutoriRetencion;
	}

	public Border setResaltarnumero_serieAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarnumero_serieAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieAutoriRetencion() {
		return this.resaltarnumero_serieAutoriRetencion;
	}

	public void setResaltarnumero_serieAutoriRetencion(Border borderResaltar) {
		this.resaltarnumero_serieAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarnumero_serieAutoriRetencion() {
		return this.mostrarnumero_serieAutoriRetencion;
	}

	public void setMostrarnumero_serieAutoriRetencion(Boolean mostrarnumero_serieAutoriRetencion) {
		this.mostrarnumero_serieAutoriRetencion= mostrarnumero_serieAutoriRetencion;
	}

	public Boolean getActivarnumero_serieAutoriRetencion() {
		return this.activarnumero_serieAutoriRetencion;
	}

	public void setActivarnumero_serieAutoriRetencion(Boolean activarnumero_serieAutoriRetencion) {
		this.activarnumero_serieAutoriRetencion= activarnumero_serieAutoriRetencion;
	}

	public Border setResaltarnumero_autorizacionAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionAutoriRetencion() {
		return this.resaltarnumero_autorizacionAutoriRetencion;
	}

	public void setResaltarnumero_autorizacionAutoriRetencion(Border borderResaltar) {
		this.resaltarnumero_autorizacionAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionAutoriRetencion() {
		return this.mostrarnumero_autorizacionAutoriRetencion;
	}

	public void setMostrarnumero_autorizacionAutoriRetencion(Boolean mostrarnumero_autorizacionAutoriRetencion) {
		this.mostrarnumero_autorizacionAutoriRetencion= mostrarnumero_autorizacionAutoriRetencion;
	}

	public Boolean getActivarnumero_autorizacionAutoriRetencion() {
		return this.activarnumero_autorizacionAutoriRetencion;
	}

	public void setActivarnumero_autorizacionAutoriRetencion(Boolean activarnumero_autorizacionAutoriRetencion) {
		this.activarnumero_autorizacionAutoriRetencion= activarnumero_autorizacionAutoriRetencion;
	}

	public Border setResaltarnumero_inicialAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarnumero_inicialAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_inicialAutoriRetencion() {
		return this.resaltarnumero_inicialAutoriRetencion;
	}

	public void setResaltarnumero_inicialAutoriRetencion(Border borderResaltar) {
		this.resaltarnumero_inicialAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarnumero_inicialAutoriRetencion() {
		return this.mostrarnumero_inicialAutoriRetencion;
	}

	public void setMostrarnumero_inicialAutoriRetencion(Boolean mostrarnumero_inicialAutoriRetencion) {
		this.mostrarnumero_inicialAutoriRetencion= mostrarnumero_inicialAutoriRetencion;
	}

	public Boolean getActivarnumero_inicialAutoriRetencion() {
		return this.activarnumero_inicialAutoriRetencion;
	}

	public void setActivarnumero_inicialAutoriRetencion(Boolean activarnumero_inicialAutoriRetencion) {
		this.activarnumero_inicialAutoriRetencion= activarnumero_inicialAutoriRetencion;
	}

	public Border setResaltarnumero_finalAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarnumero_finalAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_finalAutoriRetencion() {
		return this.resaltarnumero_finalAutoriRetencion;
	}

	public void setResaltarnumero_finalAutoriRetencion(Border borderResaltar) {
		this.resaltarnumero_finalAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarnumero_finalAutoriRetencion() {
		return this.mostrarnumero_finalAutoriRetencion;
	}

	public void setMostrarnumero_finalAutoriRetencion(Boolean mostrarnumero_finalAutoriRetencion) {
		this.mostrarnumero_finalAutoriRetencion= mostrarnumero_finalAutoriRetencion;
	}

	public Boolean getActivarnumero_finalAutoriRetencion() {
		return this.activarnumero_finalAutoriRetencion;
	}

	public void setActivarnumero_finalAutoriRetencion(Boolean activarnumero_finalAutoriRetencion) {
		this.activarnumero_finalAutoriRetencion= activarnumero_finalAutoriRetencion;
	}

	public Border setResaltarfecha_caducidadAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltarfecha_caducidadAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidadAutoriRetencion() {
		return this.resaltarfecha_caducidadAutoriRetencion;
	}

	public void setResaltarfecha_caducidadAutoriRetencion(Border borderResaltar) {
		this.resaltarfecha_caducidadAutoriRetencion= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidadAutoriRetencion() {
		return this.mostrarfecha_caducidadAutoriRetencion;
	}

	public void setMostrarfecha_caducidadAutoriRetencion(Boolean mostrarfecha_caducidadAutoriRetencion) {
		this.mostrarfecha_caducidadAutoriRetencion= mostrarfecha_caducidadAutoriRetencion;
	}

	public Boolean getActivarfecha_caducidadAutoriRetencion() {
		return this.activarfecha_caducidadAutoriRetencion;
	}

	public void setActivarfecha_caducidadAutoriRetencion(Boolean activarfecha_caducidadAutoriRetencion) {
		this.activarfecha_caducidadAutoriRetencion= activarfecha_caducidadAutoriRetencion;
	}

	public Border setResaltaresta_activoAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriretencionBeanSwingJInternalFrame.jTtoolBarAutoriRetencion.setBorder(borderResaltar);
		
		this.resaltaresta_activoAutoriRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoAutoriRetencion() {
		return this.resaltaresta_activoAutoriRetencion;
	}

	public void setResaltaresta_activoAutoriRetencion(Border borderResaltar) {
		this.resaltaresta_activoAutoriRetencion= borderResaltar;
	}

	public Boolean getMostraresta_activoAutoriRetencion() {
		return this.mostraresta_activoAutoriRetencion;
	}

	public void setMostraresta_activoAutoriRetencion(Boolean mostraresta_activoAutoriRetencion) {
		this.mostraresta_activoAutoriRetencion= mostraresta_activoAutoriRetencion;
	}

	public Boolean getActivaresta_activoAutoriRetencion() {
		return this.activaresta_activoAutoriRetencion;
	}

	public void setActivaresta_activoAutoriRetencion(Boolean activaresta_activoAutoriRetencion) {
		this.activaresta_activoAutoriRetencion= activaresta_activoAutoriRetencion;
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
		
		
		this.setMostraridAutoriRetencion(esInicial);
		this.setMostrarid_empresaAutoriRetencion(esInicial);
		this.setMostrarid_sucursalAutoriRetencion(esInicial);
		this.setMostrarid_usuarioAutoriRetencion(esInicial);
		this.setMostrarnumero_serieAutoriRetencion(esInicial);
		this.setMostrarnumero_autorizacionAutoriRetencion(esInicial);
		this.setMostrarnumero_inicialAutoriRetencion(esInicial);
		this.setMostrarnumero_finalAutoriRetencion(esInicial);
		this.setMostrarfecha_caducidadAutoriRetencion(esInicial);
		this.setMostraresta_activoAutoriRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ID)) {
				this.setMostraridAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROINICIAL)) {
				this.setMostrarnumero_inicialAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROFINAL)) {
				this.setMostrarnumero_finalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.FECHACADUCIDAD)) {
				this.setMostrarfecha_caducidadAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoAutoriRetencion(esAsigna);
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
		
		
		this.setActivaridAutoriRetencion(esInicial);
		this.setActivarid_empresaAutoriRetencion(esInicial);
		this.setActivarid_sucursalAutoriRetencion(esInicial);
		this.setActivarid_usuarioAutoriRetencion(esInicial);
		this.setActivarnumero_serieAutoriRetencion(esInicial);
		this.setActivarnumero_autorizacionAutoriRetencion(esInicial);
		this.setActivarnumero_inicialAutoriRetencion(esInicial);
		this.setActivarnumero_finalAutoriRetencion(esInicial);
		this.setActivarfecha_caducidadAutoriRetencion(esInicial);
		this.setActivaresta_activoAutoriRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ID)) {
				this.setActivaridAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROINICIAL)) {
				this.setActivarnumero_inicialAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROFINAL)) {
				this.setActivarnumero_finalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.FECHACADUCIDAD)) {
				this.setActivarfecha_caducidadAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoAutoriRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutoriRetencion(esInicial);
		this.setResaltarid_empresaAutoriRetencion(esInicial);
		this.setResaltarid_sucursalAutoriRetencion(esInicial);
		this.setResaltarid_usuarioAutoriRetencion(esInicial);
		this.setResaltarnumero_serieAutoriRetencion(esInicial);
		this.setResaltarnumero_autorizacionAutoriRetencion(esInicial);
		this.setResaltarnumero_inicialAutoriRetencion(esInicial);
		this.setResaltarnumero_finalAutoriRetencion(esInicial);
		this.setResaltarfecha_caducidadAutoriRetencion(esInicial);
		this.setResaltaresta_activoAutoriRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ID)) {
				this.setResaltaridAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROINICIAL)) {
				this.setResaltarnumero_inicialAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.NUMEROFINAL)) {
				this.setResaltarnumero_finalAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.FECHACADUCIDAD)) {
				this.setResaltarfecha_caducidadAutoriRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriRetencionConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoAutoriRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaAutoriRetencion=true;

	public Boolean getMostrarFK_IdEmpresaAutoriRetencion() {
		return this.mostrarFK_IdEmpresaAutoriRetencion;
	}

	public void setMostrarFK_IdEmpresaAutoriRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAutoriRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAutoriRetencion=true;

	public Boolean getMostrarFK_IdSucursalAutoriRetencion() {
		return this.mostrarFK_IdSucursalAutoriRetencion;
	}

	public void setMostrarFK_IdSucursalAutoriRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAutoriRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioAutoriRetencion=true;

	public Boolean getMostrarFK_IdUsuarioAutoriRetencion() {
		return this.mostrarFK_IdUsuarioAutoriRetencion;
	}

	public void setMostrarFK_IdUsuarioAutoriRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioAutoriRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaAutoriRetencion=true;

	public Boolean getActivarFK_IdEmpresaAutoriRetencion() {
		return this.activarFK_IdEmpresaAutoriRetencion;
	}

	public void setActivarFK_IdEmpresaAutoriRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAutoriRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAutoriRetencion=true;

	public Boolean getActivarFK_IdSucursalAutoriRetencion() {
		return this.activarFK_IdSucursalAutoriRetencion;
	}

	public void setActivarFK_IdSucursalAutoriRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAutoriRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioAutoriRetencion=true;

	public Boolean getActivarFK_IdUsuarioAutoriRetencion() {
		return this.activarFK_IdUsuarioAutoriRetencion;
	}

	public void setActivarFK_IdUsuarioAutoriRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioAutoriRetencion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaAutoriRetencion=null;

	public Border getResaltarFK_IdEmpresaAutoriRetencion() {
		return this.resaltarFK_IdEmpresaAutoriRetencion;
	}

	public void setResaltarFK_IdEmpresaAutoriRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAutoriRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAutoriRetencion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAutoriRetencion=null;

	public Border getResaltarFK_IdSucursalAutoriRetencion() {
		return this.resaltarFK_IdSucursalAutoriRetencion;
	}

	public void setResaltarFK_IdSucursalAutoriRetencion(Border borderResaltar) {
		this.resaltarFK_IdSucursalAutoriRetencion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAutoriRetencion= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioAutoriRetencion=null;

	public Border getResaltarFK_IdUsuarioAutoriRetencion() {
		return this.resaltarFK_IdUsuarioAutoriRetencion;
	}

	public void setResaltarFK_IdUsuarioAutoriRetencion(Border borderResaltar) {
		this.resaltarFK_IdUsuarioAutoriRetencion= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioAutoriRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriRetencionBeanSwingJInternalFrame autoriretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioAutoriRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}