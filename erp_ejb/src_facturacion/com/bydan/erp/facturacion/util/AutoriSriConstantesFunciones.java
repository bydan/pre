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


import com.bydan.erp.facturacion.util.AutoriSriConstantesFunciones;
import com.bydan.erp.facturacion.util.AutoriSriParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.AutoriSriParameterGeneral;

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
final public class AutoriSriConstantesFunciones extends AutoriSriConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AutoriSri";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutoriSri"+AutoriSriConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutoriSriHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutoriSriHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutoriSriConstantesFunciones.SCHEMA+"_"+AutoriSriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutoriSriHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutoriSriConstantesFunciones.SCHEMA+"_"+AutoriSriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutoriSriConstantesFunciones.SCHEMA+"_"+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutoriSriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutoriSriConstantesFunciones.SCHEMA+"_"+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriSriHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriSriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutoriSriConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutoriSriConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutoriSriConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutoriSriConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autorizaciones Sris";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Autorizaciones Sri";
	public static final String SCLASSWEBTITULO_LOWER="Autori Sri";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutoriSri";
	public static final String OBJECTNAME="autorisri";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="autori_sri";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autorisri from "+AutoriSriConstantesFunciones.SPERSISTENCENAME+" autorisri";
	public static String QUERYSELECTNATIVE="select "+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".id,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".version_row,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".id_empresa,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".numero_secuencial,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".numero_autor,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".fecha_inicio,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".fecha_fin,"+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME+".esta_activo from "+AutoriSriConstantesFunciones.SCHEMA+"."+AutoriSriConstantesFunciones.TABLENAME;//+" as "+AutoriSriConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AutoriSriConstantesFuncionesAdditional autorisriConstantesFuncionesAdditional=null;
	
	public AutoriSriConstantesFuncionesAdditional getAutoriSriConstantesFuncionesAdditional() {
		return this.autorisriConstantesFuncionesAdditional;
	}
	
	public void setAutoriSriConstantesFuncionesAdditional(AutoriSriConstantesFuncionesAdditional autorisriConstantesFuncionesAdditional) {
		try {
			this.autorisriConstantesFuncionesAdditional=autorisriConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPODOCUMENTOGENERAL= "id_tipo_documento_general";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String NUMEROAUTOR= "numero_autor";
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
    	public static final String LABEL_IDTIPODOCUMENTOGENERAL= "T. Documento General";
		public static final String LABEL_IDTIPODOCUMENTOGENERAL_LOWER= "Tipo Documento General";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_NUMEROAUTOR= "No Autorizacion";
		public static final String LABEL_NUMEROAUTOR_LOWER= "Numero Autor";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getAutoriSriLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.NUMEROAUTOR)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_NUMEROAUTOR;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.FECHAINICIO)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.FECHAFIN)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(AutoriSriConstantesFunciones.ESTAACTIVO)) {sLabelColumna=AutoriSriConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(AutoriSri autorisri) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!autorisri.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(AutoriSri autorisri) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(autorisri.getId(),autorisri.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getAutoriSriDescripcion(AutoriSri autorisri) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autorisri !=null/* && autorisri.getId()!=0*/) {
			if(autorisri.getId()!=null) {
				sDescripcion=autorisri.getId().toString();
			}//autorisriautorisri.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAutoriSriDescripcionDetallado(AutoriSri autorisri) {
		String sDescripcion="";
			
		sDescripcion+=AutoriSriConstantesFunciones.ID+"=";
		sDescripcion+=autorisri.getId().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autorisri.getVersionRow().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autorisri.getid_empresa().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=autorisri.getid_sucursal().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL+"=";
		sDescripcion+=autorisri.getid_tipo_documento_general().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=autorisri.getnumero_secuencial()+",";
		sDescripcion+=AutoriSriConstantesFunciones.NUMEROAUTOR+"=";
		sDescripcion+=autorisri.getnumero_autor()+",";
		sDescripcion+=AutoriSriConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=autorisri.getfecha_inicio().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=autorisri.getfecha_fin().toString()+",";
		sDescripcion+=AutoriSriConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=autorisri.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAutoriSriDescripcion(AutoriSri autorisri,String sValor) throws Exception {			
		if(autorisri !=null) {
			//autorisriautorisri.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPorFechaFin")) {
			sNombreIndice="Tipo=  Por Fecha Fin";
		} else if(sNombreIndice.equals("BusquedaPorFechaInicio")) {
			sNombreIndice="Tipo=  Por Fecha Inicio";
		} else if(sNombreIndice.equals("BusquedaPorNumeroAutor")) {
			sNombreIndice="Tipo=  Por No Autorizacion";
		} else if(sNombreIndice.equals("BusquedaPorNumeroSecuencial")) {
			sNombreIndice="Tipo=  Por No Secuencial";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoGeneral")) {
			sNombreIndice="Tipo=  Por T. Documento General";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceBusquedaPorNumeroAutor(String numero_autor) {
		String sDetalleIndice=" Parametros->";
		if(numero_autor!=null) {sDetalleIndice+=" No Autorizacion="+numero_autor;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroSecuencial(String numero_secuencial) {
		String sDetalleIndice=" Parametros->";
		if(numero_secuencial!=null) {sDetalleIndice+=" No Secuencial="+numero_secuencial;} 

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
	
	
	
	
	
	
	public static void quitarEspaciosAutoriSri(AutoriSri autorisri,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autorisri.setnumero_secuencial(autorisri.getnumero_secuencial().trim());
		autorisri.setnumero_autor(autorisri.getnumero_autor().trim());
	}
	
	public static void quitarEspaciosAutoriSris(List<AutoriSri> autorisris,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutoriSri autorisri: autorisris) {
			autorisri.setnumero_secuencial(autorisri.getnumero_secuencial().trim());
			autorisri.setnumero_autor(autorisri.getnumero_autor().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriSri(AutoriSri autorisri,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autorisri.getConCambioAuxiliar()) {
			autorisri.setIsDeleted(autorisri.getIsDeletedAuxiliar());	
			autorisri.setIsNew(autorisri.getIsNewAuxiliar());	
			autorisri.setIsChanged(autorisri.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autorisri.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autorisri.setIsDeletedAuxiliar(false);	
			autorisri.setIsNewAuxiliar(false);	
			autorisri.setIsChangedAuxiliar(false);
			
			autorisri.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriSris(List<AutoriSri> autorisris,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutoriSri autorisri : autorisris) {
			if(conAsignarBase && autorisri.getConCambioAuxiliar()) {
				autorisri.setIsDeleted(autorisri.getIsDeletedAuxiliar());	
				autorisri.setIsNew(autorisri.getIsNewAuxiliar());	
				autorisri.setIsChanged(autorisri.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autorisri.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autorisri.setIsDeletedAuxiliar(false);	
				autorisri.setIsNewAuxiliar(false);	
				autorisri.setIsChangedAuxiliar(false);
				
				autorisri.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutoriSri(AutoriSri autorisri,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAutoriSris(List<AutoriSri> autorisris,Boolean conEnteros) throws Exception  {
		
		for(AutoriSri autorisri: autorisris) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutoriSri(List<AutoriSri> autorisris,AutoriSri autorisriAux) throws Exception  {
		AutoriSriConstantesFunciones.InicializarValoresAutoriSri(autorisriAux,true);
		
		for(AutoriSri autorisri: autorisris) {
			if(autorisri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutoriSriConstantesFunciones.getArrayColumnasGlobalesAutoriSri(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriSri(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriSriConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriSriConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriSriConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriSriConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutoriSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutoriSri> autorisris,AutoriSri autorisri,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutoriSri autorisriAux: autorisris) {
			if(autorisriAux!=null && autorisri!=null) {
				if((autorisriAux.getId()==null && autorisri.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autorisriAux.getId()!=null && autorisri.getId()!=null){
					if(autorisriAux.getId().equals(autorisri.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutoriSri(List<AutoriSri> autorisris) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AutoriSri autorisri: autorisris) {			
			if(autorisri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutoriSri() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_ID, AutoriSriConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_VERSIONROW, AutoriSriConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_IDEMPRESA, AutoriSriConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_IDSUCURSAL, AutoriSriConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL, AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_NUMEROSECUENCIAL, AutoriSriConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_NUMEROAUTOR, AutoriSriConstantesFunciones.NUMEROAUTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_FECHAINICIO, AutoriSriConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_FECHAFIN, AutoriSriConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriSriConstantesFunciones.LABEL_ESTAACTIVO, AutoriSriConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutoriSri() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.NUMEROAUTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriSriConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriSri() throws Exception  {
		return AutoriSriConstantesFunciones.getTiposSeleccionarAutoriSri(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriSri(Boolean conFk) throws Exception  {
		return AutoriSriConstantesFunciones.getTiposSeleccionarAutoriSri(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriSri(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_NUMEROAUTOR);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_NUMEROAUTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriSriConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(AutoriSriConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutoriSri(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriSri(AutoriSri autorisriAux) throws Exception {
		
			autorisriAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autorisriAux.getEmpresa()));
			autorisriAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autorisriAux.getSucursal()));
			autorisriAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(autorisriAux.getTipoDocumentoGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriSri(List<AutoriSri> autorisrisTemp) throws Exception {
		for(AutoriSri autorisriAux:autorisrisTemp) {
			
			autorisriAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autorisriAux.getEmpresa()));
			autorisriAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autorisriAux.getSucursal()));
			autorisriAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(autorisriAux.getTipoDocumentoGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutoriSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriSriConstantesFunciones.getClassesRelationshipsOfAutoriSri(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriSriConstantesFunciones.getClassesRelationshipsFromStringsOfAutoriSri(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AutoriSri autorisri,List<AutoriSri> autorisris,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AutoriSri autorisriEncontrado=null;
			
			for(AutoriSri autorisriLocal:autorisris) {
				if(autorisriLocal.getId().equals(autorisri.getId())) {
					autorisriEncontrado=autorisriLocal;
					
					autorisriLocal.setIsChanged(autorisri.getIsChanged());
					autorisriLocal.setIsNew(autorisri.getIsNew());
					autorisriLocal.setIsDeleted(autorisri.getIsDeleted());
					
					autorisriLocal.setGeneralEntityOriginal(autorisri.getGeneralEntityOriginal());
					
					autorisriLocal.setId(autorisri.getId());	
					autorisriLocal.setVersionRow(autorisri.getVersionRow());	
					autorisriLocal.setid_empresa(autorisri.getid_empresa());	
					autorisriLocal.setid_sucursal(autorisri.getid_sucursal());	
					autorisriLocal.setid_tipo_documento_general(autorisri.getid_tipo_documento_general());	
					autorisriLocal.setnumero_secuencial(autorisri.getnumero_secuencial());	
					autorisriLocal.setnumero_autor(autorisri.getnumero_autor());	
					autorisriLocal.setfecha_inicio(autorisri.getfecha_inicio());	
					autorisriLocal.setfecha_fin(autorisri.getfecha_fin());	
					autorisriLocal.setesta_activo(autorisri.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!autorisri.getIsDeleted()) {
				if(!existe) {
					autorisris.add(autorisri);
				}
			} else {
				if(autorisriEncontrado!=null && permiteQuitar)  {
					autorisris.remove(autorisriEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AutoriSri autorisri,List<AutoriSri> autorisris) throws Exception {
		try	{			
			for(AutoriSri autorisriLocal:autorisris) {
				if(autorisriLocal.getId().equals(autorisri.getId())) {
					autorisriLocal.setIsSelected(autorisri.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutoriSri(List<AutoriSri> autorisrisAux) throws Exception {
		//this.autorisrisAux=autorisrisAux;
		
		for(AutoriSri autorisriAux:autorisrisAux) {
			if(autorisriAux.getIsChanged()) {
				autorisriAux.setIsChanged(false);
			}		
			
			if(autorisriAux.getIsNew()) {
				autorisriAux.setIsNew(false);
			}	
			
			if(autorisriAux.getIsDeleted()) {
				autorisriAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutoriSri(AutoriSri autorisriAux) throws Exception {
		//this.autorisriAux=autorisriAux;
		
			if(autorisriAux.getIsChanged()) {
				autorisriAux.setIsChanged(false);
			}		
			
			if(autorisriAux.getIsNew()) {
				autorisriAux.setIsNew(false);
			}	
			
			if(autorisriAux.getIsDeleted()) {
				autorisriAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutoriSri autorisriAsignar,AutoriSri autorisri) throws Exception {
		autorisriAsignar.setId(autorisri.getId());	
		autorisriAsignar.setVersionRow(autorisri.getVersionRow());	
		autorisriAsignar.setid_empresa(autorisri.getid_empresa());
		autorisriAsignar.setempresa_descripcion(autorisri.getempresa_descripcion());	
		autorisriAsignar.setid_sucursal(autorisri.getid_sucursal());
		autorisriAsignar.setsucursal_descripcion(autorisri.getsucursal_descripcion());	
		autorisriAsignar.setid_tipo_documento_general(autorisri.getid_tipo_documento_general());
		autorisriAsignar.settipodocumentogeneral_descripcion(autorisri.gettipodocumentogeneral_descripcion());	
		autorisriAsignar.setnumero_secuencial(autorisri.getnumero_secuencial());	
		autorisriAsignar.setnumero_autor(autorisri.getnumero_autor());	
		autorisriAsignar.setfecha_inicio(autorisri.getfecha_inicio());	
		autorisriAsignar.setfecha_fin(autorisri.getfecha_fin());	
		autorisriAsignar.setesta_activo(autorisri.getesta_activo());	
	}
	
	public static void inicializarAutoriSri(AutoriSri autorisri) throws Exception {
		try {
				autorisri.setId(0L);	
					
				autorisri.setid_empresa(-1L);	
				autorisri.setid_sucursal(-1L);	
				autorisri.setid_tipo_documento_general(-1L);	
				autorisri.setnumero_secuencial("");	
				autorisri.setnumero_autor("");	
				autorisri.setfecha_inicio(new Date());	
				autorisri.setfecha_fin(new Date());	
				autorisri.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutoriSri(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_NUMEROAUTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriSriConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutoriSri(String sTipo,Row row,Workbook workbook,AutoriSri autorisri,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.gettipodocumentogeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getnumero_autor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorisri.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(autorisri.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutoriSri=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAutoriSri() {
		return this.sFinalQueryAutoriSri;
	}
	
	public void setsFinalQueryAutoriSri(String sFinalQueryAutoriSri) {
		this.sFinalQueryAutoriSri= sFinalQueryAutoriSri;
	}
	
	public Border resaltarSeleccionarAutoriSri=null;
	
	public Border setResaltarSeleccionarAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutoriSri= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutoriSri() {
		return this.resaltarSeleccionarAutoriSri;
	}
	
	public void setResaltarSeleccionarAutoriSri(Border borderResaltarSeleccionarAutoriSri) {
		this.resaltarSeleccionarAutoriSri= borderResaltarSeleccionarAutoriSri;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutoriSri=null;
	public Boolean mostraridAutoriSri=true;
	public Boolean activaridAutoriSri=true;

	public Border resaltarid_empresaAutoriSri=null;
	public Boolean mostrarid_empresaAutoriSri=true;
	public Boolean activarid_empresaAutoriSri=true;
	public Boolean cargarid_empresaAutoriSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutoriSri=false;//ConEventDepend=true

	public Border resaltarid_sucursalAutoriSri=null;
	public Boolean mostrarid_sucursalAutoriSri=true;
	public Boolean activarid_sucursalAutoriSri=true;
	public Boolean cargarid_sucursalAutoriSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAutoriSri=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_generalAutoriSri=null;
	public Boolean mostrarid_tipo_documento_generalAutoriSri=true;
	public Boolean activarid_tipo_documento_generalAutoriSri=true;
	public Boolean cargarid_tipo_documento_generalAutoriSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_generalAutoriSri=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialAutoriSri=null;
	public Boolean mostrarnumero_secuencialAutoriSri=true;
	public Boolean activarnumero_secuencialAutoriSri=true;

	public Border resaltarnumero_autorAutoriSri=null;
	public Boolean mostrarnumero_autorAutoriSri=true;
	public Boolean activarnumero_autorAutoriSri=true;

	public Border resaltarfecha_inicioAutoriSri=null;
	public Boolean mostrarfecha_inicioAutoriSri=true;
	public Boolean activarfecha_inicioAutoriSri=true;

	public Border resaltarfecha_finAutoriSri=null;
	public Boolean mostrarfecha_finAutoriSri=true;
	public Boolean activarfecha_finAutoriSri=true;

	public Border resaltaresta_activoAutoriSri=null;
	public Boolean mostraresta_activoAutoriSri=true;
	public Boolean activaresta_activoAutoriSri=true;

	
	

	public Border setResaltaridAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltaridAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutoriSri() {
		return this.resaltaridAutoriSri;
	}

	public void setResaltaridAutoriSri(Border borderResaltar) {
		this.resaltaridAutoriSri= borderResaltar;
	}

	public Boolean getMostraridAutoriSri() {
		return this.mostraridAutoriSri;
	}

	public void setMostraridAutoriSri(Boolean mostraridAutoriSri) {
		this.mostraridAutoriSri= mostraridAutoriSri;
	}

	public Boolean getActivaridAutoriSri() {
		return this.activaridAutoriSri;
	}

	public void setActivaridAutoriSri(Boolean activaridAutoriSri) {
		this.activaridAutoriSri= activaridAutoriSri;
	}

	public Border setResaltarid_empresaAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutoriSri() {
		return this.resaltarid_empresaAutoriSri;
	}

	public void setResaltarid_empresaAutoriSri(Border borderResaltar) {
		this.resaltarid_empresaAutoriSri= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutoriSri() {
		return this.mostrarid_empresaAutoriSri;
	}

	public void setMostrarid_empresaAutoriSri(Boolean mostrarid_empresaAutoriSri) {
		this.mostrarid_empresaAutoriSri= mostrarid_empresaAutoriSri;
	}

	public Boolean getActivarid_empresaAutoriSri() {
		return this.activarid_empresaAutoriSri;
	}

	public void setActivarid_empresaAutoriSri(Boolean activarid_empresaAutoriSri) {
		this.activarid_empresaAutoriSri= activarid_empresaAutoriSri;
	}

	public Boolean getCargarid_empresaAutoriSri() {
		return this.cargarid_empresaAutoriSri;
	}

	public void setCargarid_empresaAutoriSri(Boolean cargarid_empresaAutoriSri) {
		this.cargarid_empresaAutoriSri= cargarid_empresaAutoriSri;
	}

	public Border setResaltarid_sucursalAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAutoriSri() {
		return this.resaltarid_sucursalAutoriSri;
	}

	public void setResaltarid_sucursalAutoriSri(Border borderResaltar) {
		this.resaltarid_sucursalAutoriSri= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAutoriSri() {
		return this.mostrarid_sucursalAutoriSri;
	}

	public void setMostrarid_sucursalAutoriSri(Boolean mostrarid_sucursalAutoriSri) {
		this.mostrarid_sucursalAutoriSri= mostrarid_sucursalAutoriSri;
	}

	public Boolean getActivarid_sucursalAutoriSri() {
		return this.activarid_sucursalAutoriSri;
	}

	public void setActivarid_sucursalAutoriSri(Boolean activarid_sucursalAutoriSri) {
		this.activarid_sucursalAutoriSri= activarid_sucursalAutoriSri;
	}

	public Boolean getCargarid_sucursalAutoriSri() {
		return this.cargarid_sucursalAutoriSri;
	}

	public void setCargarid_sucursalAutoriSri(Boolean cargarid_sucursalAutoriSri) {
		this.cargarid_sucursalAutoriSri= cargarid_sucursalAutoriSri;
	}

	public Border setResaltarid_tipo_documento_generalAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_generalAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_generalAutoriSri() {
		return this.resaltarid_tipo_documento_generalAutoriSri;
	}

	public void setResaltarid_tipo_documento_generalAutoriSri(Border borderResaltar) {
		this.resaltarid_tipo_documento_generalAutoriSri= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_generalAutoriSri() {
		return this.mostrarid_tipo_documento_generalAutoriSri;
	}

	public void setMostrarid_tipo_documento_generalAutoriSri(Boolean mostrarid_tipo_documento_generalAutoriSri) {
		this.mostrarid_tipo_documento_generalAutoriSri= mostrarid_tipo_documento_generalAutoriSri;
	}

	public Boolean getActivarid_tipo_documento_generalAutoriSri() {
		return this.activarid_tipo_documento_generalAutoriSri;
	}

	public void setActivarid_tipo_documento_generalAutoriSri(Boolean activarid_tipo_documento_generalAutoriSri) {
		this.activarid_tipo_documento_generalAutoriSri= activarid_tipo_documento_generalAutoriSri;
	}

	public Boolean getCargarid_tipo_documento_generalAutoriSri() {
		return this.cargarid_tipo_documento_generalAutoriSri;
	}

	public void setCargarid_tipo_documento_generalAutoriSri(Boolean cargarid_tipo_documento_generalAutoriSri) {
		this.cargarid_tipo_documento_generalAutoriSri= cargarid_tipo_documento_generalAutoriSri;
	}

	public Border setResaltarnumero_secuencialAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialAutoriSri() {
		return this.resaltarnumero_secuencialAutoriSri;
	}

	public void setResaltarnumero_secuencialAutoriSri(Border borderResaltar) {
		this.resaltarnumero_secuencialAutoriSri= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialAutoriSri() {
		return this.mostrarnumero_secuencialAutoriSri;
	}

	public void setMostrarnumero_secuencialAutoriSri(Boolean mostrarnumero_secuencialAutoriSri) {
		this.mostrarnumero_secuencialAutoriSri= mostrarnumero_secuencialAutoriSri;
	}

	public Boolean getActivarnumero_secuencialAutoriSri() {
		return this.activarnumero_secuencialAutoriSri;
	}

	public void setActivarnumero_secuencialAutoriSri(Boolean activarnumero_secuencialAutoriSri) {
		this.activarnumero_secuencialAutoriSri= activarnumero_secuencialAutoriSri;
	}

	public Border setResaltarnumero_autorAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarnumero_autorAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorAutoriSri() {
		return this.resaltarnumero_autorAutoriSri;
	}

	public void setResaltarnumero_autorAutoriSri(Border borderResaltar) {
		this.resaltarnumero_autorAutoriSri= borderResaltar;
	}

	public Boolean getMostrarnumero_autorAutoriSri() {
		return this.mostrarnumero_autorAutoriSri;
	}

	public void setMostrarnumero_autorAutoriSri(Boolean mostrarnumero_autorAutoriSri) {
		this.mostrarnumero_autorAutoriSri= mostrarnumero_autorAutoriSri;
	}

	public Boolean getActivarnumero_autorAutoriSri() {
		return this.activarnumero_autorAutoriSri;
	}

	public void setActivarnumero_autorAutoriSri(Boolean activarnumero_autorAutoriSri) {
		this.activarnumero_autorAutoriSri= activarnumero_autorAutoriSri;
	}

	public Border setResaltarfecha_inicioAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioAutoriSri() {
		return this.resaltarfecha_inicioAutoriSri;
	}

	public void setResaltarfecha_inicioAutoriSri(Border borderResaltar) {
		this.resaltarfecha_inicioAutoriSri= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioAutoriSri() {
		return this.mostrarfecha_inicioAutoriSri;
	}

	public void setMostrarfecha_inicioAutoriSri(Boolean mostrarfecha_inicioAutoriSri) {
		this.mostrarfecha_inicioAutoriSri= mostrarfecha_inicioAutoriSri;
	}

	public Boolean getActivarfecha_inicioAutoriSri() {
		return this.activarfecha_inicioAutoriSri;
	}

	public void setActivarfecha_inicioAutoriSri(Boolean activarfecha_inicioAutoriSri) {
		this.activarfecha_inicioAutoriSri= activarfecha_inicioAutoriSri;
	}

	public Border setResaltarfecha_finAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltarfecha_finAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finAutoriSri() {
		return this.resaltarfecha_finAutoriSri;
	}

	public void setResaltarfecha_finAutoriSri(Border borderResaltar) {
		this.resaltarfecha_finAutoriSri= borderResaltar;
	}

	public Boolean getMostrarfecha_finAutoriSri() {
		return this.mostrarfecha_finAutoriSri;
	}

	public void setMostrarfecha_finAutoriSri(Boolean mostrarfecha_finAutoriSri) {
		this.mostrarfecha_finAutoriSri= mostrarfecha_finAutoriSri;
	}

	public Boolean getActivarfecha_finAutoriSri() {
		return this.activarfecha_finAutoriSri;
	}

	public void setActivarfecha_finAutoriSri(Boolean activarfecha_finAutoriSri) {
		this.activarfecha_finAutoriSri= activarfecha_finAutoriSri;
	}

	public Border setResaltaresta_activoAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorisriBeanSwingJInternalFrame.jTtoolBarAutoriSri.setBorder(borderResaltar);
		
		this.resaltaresta_activoAutoriSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoAutoriSri() {
		return this.resaltaresta_activoAutoriSri;
	}

	public void setResaltaresta_activoAutoriSri(Border borderResaltar) {
		this.resaltaresta_activoAutoriSri= borderResaltar;
	}

	public Boolean getMostraresta_activoAutoriSri() {
		return this.mostraresta_activoAutoriSri;
	}

	public void setMostraresta_activoAutoriSri(Boolean mostraresta_activoAutoriSri) {
		this.mostraresta_activoAutoriSri= mostraresta_activoAutoriSri;
	}

	public Boolean getActivaresta_activoAutoriSri() {
		return this.activaresta_activoAutoriSri;
	}

	public void setActivaresta_activoAutoriSri(Boolean activaresta_activoAutoriSri) {
		this.activaresta_activoAutoriSri= activaresta_activoAutoriSri;
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
		
		
		this.setMostraridAutoriSri(esInicial);
		this.setMostrarid_empresaAutoriSri(esInicial);
		this.setMostrarid_sucursalAutoriSri(esInicial);
		this.setMostrarid_tipo_documento_generalAutoriSri(esInicial);
		this.setMostrarnumero_secuencialAutoriSri(esInicial);
		this.setMostrarnumero_autorAutoriSri(esInicial);
		this.setMostrarfecha_inicioAutoriSri(esInicial);
		this.setMostrarfecha_finAutoriSri(esInicial);
		this.setMostraresta_activoAutoriSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriSriConstantesFunciones.ID)) {
				this.setMostraridAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setMostrarid_tipo_documento_generalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROAUTOR)) {
				this.setMostrarnumero_autorAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoAutoriSri(esAsigna);
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
		
		
		this.setActivaridAutoriSri(esInicial);
		this.setActivarid_empresaAutoriSri(esInicial);
		this.setActivarid_sucursalAutoriSri(esInicial);
		this.setActivarid_tipo_documento_generalAutoriSri(esInicial);
		this.setActivarnumero_secuencialAutoriSri(esInicial);
		this.setActivarnumero_autorAutoriSri(esInicial);
		this.setActivarfecha_inicioAutoriSri(esInicial);
		this.setActivarfecha_finAutoriSri(esInicial);
		this.setActivaresta_activoAutoriSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriSriConstantesFunciones.ID)) {
				this.setActivaridAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setActivarid_tipo_documento_generalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROAUTOR)) {
				this.setActivarnumero_autorAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoAutoriSri(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutoriSri(esInicial);
		this.setResaltarid_empresaAutoriSri(esInicial);
		this.setResaltarid_sucursalAutoriSri(esInicial);
		this.setResaltarid_tipo_documento_generalAutoriSri(esInicial);
		this.setResaltarnumero_secuencialAutoriSri(esInicial);
		this.setResaltarnumero_autorAutoriSri(esInicial);
		this.setResaltarfecha_inicioAutoriSri(esInicial);
		this.setResaltarfecha_finAutoriSri(esInicial);
		this.setResaltaresta_activoAutoriSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriSriConstantesFunciones.ID)) {
				this.setResaltaridAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setResaltarid_tipo_documento_generalAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.NUMEROAUTOR)) {
				this.setResaltarnumero_autorAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finAutoriSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriSriConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoAutoriSri(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorFechaFinAutoriSri=true;

	public Boolean getMostrarBusquedaPorFechaFinAutoriSri() {
		return this.mostrarBusquedaPorFechaFinAutoriSri;
	}

	public void setMostrarBusquedaPorFechaFinAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaFinAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaInicioAutoriSri=true;

	public Boolean getMostrarBusquedaPorFechaInicioAutoriSri() {
		return this.mostrarBusquedaPorFechaInicioAutoriSri;
	}

	public void setMostrarBusquedaPorFechaInicioAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaInicioAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroAutorAutoriSri=true;

	public Boolean getMostrarBusquedaPorNumeroAutorAutoriSri() {
		return this.mostrarBusquedaPorNumeroAutorAutoriSri;
	}

	public void setMostrarBusquedaPorNumeroAutorAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroAutorAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroSecuencialAutoriSri=true;

	public Boolean getMostrarBusquedaPorNumeroSecuencialAutoriSri() {
		return this.mostrarBusquedaPorNumeroSecuencialAutoriSri;
	}

	public void setMostrarBusquedaPorNumeroSecuencialAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroSecuencialAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAutoriSri=true;

	public Boolean getMostrarFK_IdEmpresaAutoriSri() {
		return this.mostrarFK_IdEmpresaAutoriSri;
	}

	public void setMostrarFK_IdEmpresaAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAutoriSri=true;

	public Boolean getMostrarFK_IdSucursalAutoriSri() {
		return this.mostrarFK_IdSucursalAutoriSri;
	}

	public void setMostrarFK_IdSucursalAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAutoriSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoGeneralAutoriSri=true;

	public Boolean getMostrarFK_IdTipoDocumentoGeneralAutoriSri() {
		return this.mostrarFK_IdTipoDocumentoGeneralAutoriSri;
	}

	public void setMostrarFK_IdTipoDocumentoGeneralAutoriSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoGeneralAutoriSri= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorFechaFinAutoriSri=true;

	public Boolean getActivarBusquedaPorFechaFinAutoriSri() {
		return this.activarBusquedaPorFechaFinAutoriSri;
	}

	public void setActivarBusquedaPorFechaFinAutoriSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaFinAutoriSri= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaInicioAutoriSri=true;

	public Boolean getActivarBusquedaPorFechaInicioAutoriSri() {
		return this.activarBusquedaPorFechaInicioAutoriSri;
	}

	public void setActivarBusquedaPorFechaInicioAutoriSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaInicioAutoriSri= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroAutorAutoriSri=true;

	public Boolean getActivarBusquedaPorNumeroAutorAutoriSri() {
		return this.activarBusquedaPorNumeroAutorAutoriSri;
	}

	public void setActivarBusquedaPorNumeroAutorAutoriSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroAutorAutoriSri= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroSecuencialAutoriSri=true;

	public Boolean getActivarBusquedaPorNumeroSecuencialAutoriSri() {
		return this.activarBusquedaPorNumeroSecuencialAutoriSri;
	}

	public void setActivarBusquedaPorNumeroSecuencialAutoriSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroSecuencialAutoriSri= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAutoriSri=true;

	public Boolean getActivarFK_IdEmpresaAutoriSri() {
		return this.activarFK_IdEmpresaAutoriSri;
	}

	public void setActivarFK_IdEmpresaAutoriSri(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAutoriSri= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAutoriSri=true;

	public Boolean getActivarFK_IdSucursalAutoriSri() {
		return this.activarFK_IdSucursalAutoriSri;
	}

	public void setActivarFK_IdSucursalAutoriSri(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAutoriSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoGeneralAutoriSri=true;

	public Boolean getActivarFK_IdTipoDocumentoGeneralAutoriSri() {
		return this.activarFK_IdTipoDocumentoGeneralAutoriSri;
	}

	public void setActivarFK_IdTipoDocumentoGeneralAutoriSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoGeneralAutoriSri= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorFechaFinAutoriSri=null;

	public Border getResaltarBusquedaPorFechaFinAutoriSri() {
		return this.resaltarBusquedaPorFechaFinAutoriSri;
	}

	public void setResaltarBusquedaPorFechaFinAutoriSri(Border borderResaltar) {
		this.resaltarBusquedaPorFechaFinAutoriSri= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaFinAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaFinAutoriSri= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaInicioAutoriSri=null;

	public Border getResaltarBusquedaPorFechaInicioAutoriSri() {
		return this.resaltarBusquedaPorFechaInicioAutoriSri;
	}

	public void setResaltarBusquedaPorFechaInicioAutoriSri(Border borderResaltar) {
		this.resaltarBusquedaPorFechaInicioAutoriSri= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaInicioAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaInicioAutoriSri= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroAutorAutoriSri=null;

	public Border getResaltarBusquedaPorNumeroAutorAutoriSri() {
		return this.resaltarBusquedaPorNumeroAutorAutoriSri;
	}

	public void setResaltarBusquedaPorNumeroAutorAutoriSri(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroAutorAutoriSri= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroAutorAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroAutorAutoriSri= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroSecuencialAutoriSri=null;

	public Border getResaltarBusquedaPorNumeroSecuencialAutoriSri() {
		return this.resaltarBusquedaPorNumeroSecuencialAutoriSri;
	}

	public void setResaltarBusquedaPorNumeroSecuencialAutoriSri(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroSecuencialAutoriSri= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroSecuencialAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroSecuencialAutoriSri= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAutoriSri=null;

	public Border getResaltarFK_IdEmpresaAutoriSri() {
		return this.resaltarFK_IdEmpresaAutoriSri;
	}

	public void setResaltarFK_IdEmpresaAutoriSri(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAutoriSri= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAutoriSri= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAutoriSri=null;

	public Border getResaltarFK_IdSucursalAutoriSri() {
		return this.resaltarFK_IdSucursalAutoriSri;
	}

	public void setResaltarFK_IdSucursalAutoriSri(Border borderResaltar) {
		this.resaltarFK_IdSucursalAutoriSri= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAutoriSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoGeneralAutoriSri=null;

	public Border getResaltarFK_IdTipoDocumentoGeneralAutoriSri() {
		return this.resaltarFK_IdTipoDocumentoGeneralAutoriSri;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralAutoriSri(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoGeneralAutoriSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralAutoriSri(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriSriBeanSwingJInternalFrame autorisriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoGeneralAutoriSri= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}