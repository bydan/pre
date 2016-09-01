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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.AccionistaConstantesFunciones;
import com.bydan.erp.cartera.util.AccionistaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.AccionistaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AccionistaConstantesFunciones extends AccionistaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Accionista";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Accionista"+AccionistaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AccionistaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AccionistaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AccionistaConstantesFunciones.SCHEMA+"_"+AccionistaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AccionistaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AccionistaConstantesFunciones.SCHEMA+"_"+AccionistaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AccionistaConstantesFunciones.SCHEMA+"_"+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AccionistaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AccionistaConstantesFunciones.SCHEMA+"_"+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AccionistaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AccionistaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AccionistaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AccionistaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AccionistaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AccionistaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Accionistas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Accionista";
	public static final String SCLASSWEBTITULO_LOWER="Accionista";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Accionista";
	public static final String OBJECTNAME="accionista";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="accionista";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select accionista from "+AccionistaConstantesFunciones.SPERSISTENCENAME+" accionista";
	public static String QUERYSELECTNATIVE="select "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".id,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".version_row,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idcliente,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idvalorclienteinversion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idvaloridentificacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".identificacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".apellidopaterno,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".apellidomaterno,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".primernombre,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".segundonombre,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".nombrecorto,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".participacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".esactivo from "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME;//+" as "+AccionistaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AccionistaConstantesFuncionesAdditional accionistaConstantesFuncionesAdditional=null;
	
	public AccionistaConstantesFuncionesAdditional getAccionistaConstantesFuncionesAdditional() {
		return this.accionistaConstantesFuncionesAdditional;
	}
	
	public void setAccionistaConstantesFuncionesAdditional(AccionistaConstantesFuncionesAdditional accionistaConstantesFuncionesAdditional) {
		try {
			this.accionistaConstantesFuncionesAdditional=accionistaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOINVERSION= "idvalorclienteinversion";
    public static final String IDTIPOIDENTIFICACION= "idvaloridentificacion";
    public static final String IDENTIFICACION= "identificacion";
    public static final String APELLIDOPATERNO= "apellidopaterno";
    public static final String APELLIDOMATERNO= "apellidomaterno";
    public static final String PRIMERNOMBRE= "primernombre";
    public static final String SEGUNDONOMBRE= "segundonombre";
    public static final String NOMBRECORTO= "nombrecorto";
    public static final String PARTICIPACION= "participacion";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOINVERSION= "Tipo Inversion";
		public static final String LABEL_IDTIPOINVERSION_LOWER= "Tipo Inversion";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_APELLIDOPATERNO= "Apellido Paterno";
		public static final String LABEL_APELLIDOPATERNO_LOWER= "Apellido Paterno";
    	public static final String LABEL_APELLIDOMATERNO= "Apellido Materno";
		public static final String LABEL_APELLIDOMATERNO_LOWER= "Apellido Materno";
    	public static final String LABEL_PRIMERNOMBRE= "Primer Nombre";
		public static final String LABEL_PRIMERNOMBRE_LOWER= "Primer Nombre";
    	public static final String LABEL_SEGUNDONOMBRE= "Segundo Nombre";
		public static final String LABEL_SEGUNDONOMBRE_LOWER= "Segundo Nombre";
    	public static final String LABEL_NOMBRECORTO= "Nombre Corto";
		public static final String LABEL_NOMBRECORTO_LOWER= "Nombre Corto";
    	public static final String LABEL_PARTICIPACION= "Participacion";
		public static final String LABEL_PARTICIPACION_LOWER= "Participacion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOPATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOPATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOMATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOMATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPRIMERNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPRIMERNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEGUNDONOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEGUNDONOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRECORTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRECORTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getAccionistaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AccionistaConstantesFunciones.IDCLIENTE)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.IDTIPOINVERSION)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_IDTIPOINVERSION;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.IDENTIFICACION)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.APELLIDOPATERNO)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_APELLIDOPATERNO;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.APELLIDOMATERNO)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_APELLIDOMATERNO;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.PRIMERNOMBRE)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_PRIMERNOMBRE;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.SEGUNDONOMBRE)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_SEGUNDONOMBRE;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.NOMBRECORTO)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_NOMBRECORTO;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.PARTICIPACION)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_PARTICIPACION;}
		if(sNombreColumna.equals(AccionistaConstantesFunciones.ESACTIVO)) {sLabelColumna=AccionistaConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(Accionista accionista) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!accionista.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(Accionista accionista) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(accionista.getId(),accionista.getesactivo());

		return sDescripcion;
	}	
	
	public static String getAccionistaDescripcion(Accionista accionista) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(accionista !=null/* && accionista.getId()!=0*/) {
			if(accionista.getId()!=null) {
				sDescripcion=accionista.getId().toString();
			}//accionistaaccionista.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAccionistaDescripcionDetallado(Accionista accionista) {
		String sDescripcion="";
			
		sDescripcion+=AccionistaConstantesFunciones.ID+"=";
		sDescripcion+=accionista.getId().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=accionista.getVersionRow().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=accionista.getidcliente().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.IDTIPOINVERSION+"=";
		sDescripcion+=accionista.getidvalorclienteinversion().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=accionista.getidvaloridentificacion().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=accionista.getidentificacion()+",";
		sDescripcion+=AccionistaConstantesFunciones.APELLIDOPATERNO+"=";
		sDescripcion+=accionista.getapellidopaterno()+",";
		sDescripcion+=AccionistaConstantesFunciones.APELLIDOMATERNO+"=";
		sDescripcion+=accionista.getapellidomaterno()+",";
		sDescripcion+=AccionistaConstantesFunciones.PRIMERNOMBRE+"=";
		sDescripcion+=accionista.getprimernombre()+",";
		sDescripcion+=AccionistaConstantesFunciones.SEGUNDONOMBRE+"=";
		sDescripcion+=accionista.getsegundonombre()+",";
		sDescripcion+=AccionistaConstantesFunciones.NOMBRECORTO+"=";
		sDescripcion+=accionista.getnombrecorto()+",";
		sDescripcion+=AccionistaConstantesFunciones.PARTICIPACION+"=";
		sDescripcion+=accionista.getparticipacion().toString()+",";
		sDescripcion+=AccionistaConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=accionista.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAccionistaDescripcion(Accionista accionista,String sValor) throws Exception {			
		if(accionista !=null) {
			//accionistaaccionista.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoInversionDescripcion(TipoInversion tipoinversion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoinversion!=null/*&&tipoinversion.getId()>0*/) {
			sDescripcion=TipoInversionConstantesFunciones.getTipoInversionDescripcion(tipoinversion);
		}

		return sDescripcion;
	}

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdClientePorNombreCorto")) {
			sNombreIndice="Tipo=  Por Cliente Por Nombre Corto";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdValorClienteInversion")) {
			sNombreIndice="Tipo=  Por Tipo Inversion";
		} else if(sNombreIndice.equals("FK_IdValorIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdClientePorNombreCorto(Long idcliente,String nombrecorto) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();}
		if(nombrecorto!=null) {sDetalleIndice+=" Nombre Corto="+nombrecorto;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteInversion(Long idvalorclienteinversion) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclienteinversion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Inversion="+idvalorclienteinversion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorIdentificacion(Long idvaloridentificacion) {
		String sDetalleIndice=" Parametros->";
		if(idvaloridentificacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+idvaloridentificacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAccionista(Accionista accionista,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		accionista.setidentificacion(accionista.getidentificacion().trim());
		accionista.setapellidopaterno(accionista.getapellidopaterno().trim());
		accionista.setapellidomaterno(accionista.getapellidomaterno().trim());
		accionista.setprimernombre(accionista.getprimernombre().trim());
		accionista.setsegundonombre(accionista.getsegundonombre().trim());
		accionista.setnombrecorto(accionista.getnombrecorto().trim());
	}
	
	public static void quitarEspaciosAccionistas(List<Accionista> accionistas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Accionista accionista: accionistas) {
			accionista.setidentificacion(accionista.getidentificacion().trim());
			accionista.setapellidopaterno(accionista.getapellidopaterno().trim());
			accionista.setapellidomaterno(accionista.getapellidomaterno().trim());
			accionista.setprimernombre(accionista.getprimernombre().trim());
			accionista.setsegundonombre(accionista.getsegundonombre().trim());
			accionista.setnombrecorto(accionista.getnombrecorto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAccionista(Accionista accionista,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && accionista.getConCambioAuxiliar()) {
			accionista.setIsDeleted(accionista.getIsDeletedAuxiliar());	
			accionista.setIsNew(accionista.getIsNewAuxiliar());	
			accionista.setIsChanged(accionista.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			accionista.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			accionista.setIsDeletedAuxiliar(false);	
			accionista.setIsNewAuxiliar(false);	
			accionista.setIsChangedAuxiliar(false);
			
			accionista.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAccionistas(List<Accionista> accionistas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Accionista accionista : accionistas) {
			if(conAsignarBase && accionista.getConCambioAuxiliar()) {
				accionista.setIsDeleted(accionista.getIsDeletedAuxiliar());	
				accionista.setIsNew(accionista.getIsNewAuxiliar());	
				accionista.setIsChanged(accionista.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				accionista.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				accionista.setIsDeletedAuxiliar(false);	
				accionista.setIsNewAuxiliar(false);	
				accionista.setIsChangedAuxiliar(false);
				
				accionista.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAccionista(Accionista accionista,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			accionista.setparticipacion(0);
		}
	}		
	
	public static void InicializarValoresAccionistas(List<Accionista> accionistas,Boolean conEnteros) throws Exception  {
		
		for(Accionista accionista: accionistas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				accionista.setparticipacion(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAccionista(List<Accionista> accionistas,Accionista accionistaAux) throws Exception  {
		AccionistaConstantesFunciones.InicializarValoresAccionista(accionistaAux,true);
		
		for(Accionista accionista: accionistas) {
			if(accionista.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			accionistaAux.setparticipacion(accionistaAux.getparticipacion()+accionista.getparticipacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAccionista(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AccionistaConstantesFunciones.getArrayColumnasGlobalesAccionista(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAccionista(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAccionista(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Accionista> accionistas,Accionista accionista,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Accionista accionistaAux: accionistas) {
			if(accionistaAux!=null && accionista!=null) {
				if((accionistaAux.getId()==null && accionista.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(accionistaAux.getId()!=null && accionista.getId()!=null){
					if(accionistaAux.getId().equals(accionista.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAccionista(List<Accionista> accionistas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Accionista accionista: accionistas) {			
			if(accionista.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAccionista() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_ID, AccionistaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_VERSIONROW, AccionistaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_IDCLIENTE, AccionistaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_IDTIPOINVERSION, AccionistaConstantesFunciones.IDTIPOINVERSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, AccionistaConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_IDENTIFICACION, AccionistaConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_APELLIDOPATERNO, AccionistaConstantesFunciones.APELLIDOPATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_APELLIDOMATERNO, AccionistaConstantesFunciones.APELLIDOMATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_PRIMERNOMBRE, AccionistaConstantesFunciones.PRIMERNOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_SEGUNDONOMBRE, AccionistaConstantesFunciones.SEGUNDONOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_NOMBRECORTO, AccionistaConstantesFunciones.NOMBRECORTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_PARTICIPACION, AccionistaConstantesFunciones.PARTICIPACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionistaConstantesFunciones.LABEL_ESACTIVO, AccionistaConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAccionista() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.IDTIPOINVERSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.APELLIDOPATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.APELLIDOMATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.PRIMERNOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.SEGUNDONOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.NOMBRECORTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.PARTICIPACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionistaConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccionista() throws Exception  {
		return AccionistaConstantesFunciones.getTiposSeleccionarAccionista(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccionista(Boolean conFk) throws Exception  {
		return AccionistaConstantesFunciones.getTiposSeleccionarAccionista(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccionista(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_IDTIPOINVERSION);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_IDTIPOINVERSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_APELLIDOPATERNO);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_APELLIDOPATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_APELLIDOMATERNO);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_APELLIDOMATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_PRIMERNOMBRE);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_PRIMERNOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_SEGUNDONOMBRE);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_SEGUNDONOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_NOMBRECORTO);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_NOMBRECORTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_PARTICIPACION);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_PARTICIPACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionistaConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(AccionistaConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAccionista(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAccionista(Accionista accionistaAux) throws Exception {
		
			accionistaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(accionistaAux.getCliente()));
			accionistaAux.settipoinversion_descripcion(TipoInversionConstantesFunciones.getTipoInversionDescripcion(accionistaAux.getTipoInversion()));
			accionistaAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(accionistaAux.getTipoIdentificacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAccionista(List<Accionista> accionistasTemp) throws Exception {
		for(Accionista accionistaAux:accionistasTemp) {
			
			accionistaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(accionistaAux.getCliente()));
			accionistaAux.settipoinversion_descripcion(TipoInversionConstantesFunciones.getTipoInversionDescripcion(accionistaAux.getTipoInversion()));
			accionistaAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(accionistaAux.getTipoIdentificacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAccionista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoInversion.class));
				classes.add(new Classe(TipoIdentificacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoInversion.class)) {
						classes.add(new Classe(TipoInversion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAccionista(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoInversion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInversion.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoInversion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInversion.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccionista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AccionistaConstantesFunciones.getClassesRelationshipsOfAccionista(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccionista(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAccionista(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AccionistaConstantesFunciones.getClassesRelationshipsFromStringsOfAccionista(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAccionista(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Accionista accionista,List<Accionista> accionistas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Accionista accionistaEncontrado=null;
			
			for(Accionista accionistaLocal:accionistas) {
				if(accionistaLocal.getId().equals(accionista.getId())) {
					accionistaEncontrado=accionistaLocal;
					
					accionistaLocal.setIsChanged(accionista.getIsChanged());
					accionistaLocal.setIsNew(accionista.getIsNew());
					accionistaLocal.setIsDeleted(accionista.getIsDeleted());
					
					accionistaLocal.setGeneralEntityOriginal(accionista.getGeneralEntityOriginal());
					
					accionistaLocal.setId(accionista.getId());	
					accionistaLocal.setVersionRow(accionista.getVersionRow());	
					accionistaLocal.setidcliente(accionista.getidcliente());	
					accionistaLocal.setidvalorclienteinversion(accionista.getidvalorclienteinversion());	
					accionistaLocal.setidvaloridentificacion(accionista.getidvaloridentificacion());	
					accionistaLocal.setidentificacion(accionista.getidentificacion());	
					accionistaLocal.setapellidopaterno(accionista.getapellidopaterno());	
					accionistaLocal.setapellidomaterno(accionista.getapellidomaterno());	
					accionistaLocal.setprimernombre(accionista.getprimernombre());	
					accionistaLocal.setsegundonombre(accionista.getsegundonombre());	
					accionistaLocal.setnombrecorto(accionista.getnombrecorto());	
					accionistaLocal.setparticipacion(accionista.getparticipacion());	
					accionistaLocal.setesactivo(accionista.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!accionista.getIsDeleted()) {
				if(!existe) {
					accionistas.add(accionista);
				}
			} else {
				if(accionistaEncontrado!=null && permiteQuitar)  {
					accionistas.remove(accionistaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Accionista accionista,List<Accionista> accionistas) throws Exception {
		try	{			
			for(Accionista accionistaLocal:accionistas) {
				if(accionistaLocal.getId().equals(accionista.getId())) {
					accionistaLocal.setIsSelected(accionista.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAccionista(List<Accionista> accionistasAux) throws Exception {
		//this.accionistasAux=accionistasAux;
		
		for(Accionista accionistaAux:accionistasAux) {
			if(accionistaAux.getIsChanged()) {
				accionistaAux.setIsChanged(false);
			}		
			
			if(accionistaAux.getIsNew()) {
				accionistaAux.setIsNew(false);
			}	
			
			if(accionistaAux.getIsDeleted()) {
				accionistaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAccionista(Accionista accionistaAux) throws Exception {
		//this.accionistaAux=accionistaAux;
		
			if(accionistaAux.getIsChanged()) {
				accionistaAux.setIsChanged(false);
			}		
			
			if(accionistaAux.getIsNew()) {
				accionistaAux.setIsNew(false);
			}	
			
			if(accionistaAux.getIsDeleted()) {
				accionistaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Accionista accionistaAsignar,Accionista accionista) throws Exception {
		accionistaAsignar.setId(accionista.getId());	
		accionistaAsignar.setVersionRow(accionista.getVersionRow());	
		accionistaAsignar.setidcliente(accionista.getidcliente());
		accionistaAsignar.setcliente_descripcion(accionista.getcliente_descripcion());	
		accionistaAsignar.setidvalorclienteinversion(accionista.getidvalorclienteinversion());
		accionistaAsignar.settipoinversion_descripcion(accionista.gettipoinversion_descripcion());	
		accionistaAsignar.setidvaloridentificacion(accionista.getidvaloridentificacion());
		accionistaAsignar.settipoidentificacion_descripcion(accionista.gettipoidentificacion_descripcion());	
		accionistaAsignar.setidentificacion(accionista.getidentificacion());	
		accionistaAsignar.setapellidopaterno(accionista.getapellidopaterno());	
		accionistaAsignar.setapellidomaterno(accionista.getapellidomaterno());	
		accionistaAsignar.setprimernombre(accionista.getprimernombre());	
		accionistaAsignar.setsegundonombre(accionista.getsegundonombre());	
		accionistaAsignar.setnombrecorto(accionista.getnombrecorto());	
		accionistaAsignar.setparticipacion(accionista.getparticipacion());	
		accionistaAsignar.setesactivo(accionista.getesactivo());	
	}
	
	public static void inicializarAccionista(Accionista accionista) throws Exception {
		try {
				accionista.setId(0L);	
					
				accionista.setidcliente(-1L);	
				accionista.setidvalorclienteinversion(-1L);	
				accionista.setidvaloridentificacion(-1L);	
				accionista.setidentificacion("");	
				accionista.setapellidopaterno("");	
				accionista.setapellidomaterno("");	
				accionista.setprimernombre("");	
				accionista.setsegundonombre("");	
				accionista.setnombrecorto("");	
				accionista.setparticipacion(0);	
				accionista.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAccionista(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_IDTIPOINVERSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_APELLIDOPATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_APELLIDOMATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_PRIMERNOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_SEGUNDONOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_NOMBRECORTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_PARTICIPACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionistaConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAccionista(String sTipo,Row row,Workbook workbook,Accionista accionista,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.gettipoinversion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getapellidopaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getapellidomaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getprimernombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getsegundonombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getnombrecorto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accionista.getparticipacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(accionista.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAccionista=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAccionista() {
		return this.sFinalQueryAccionista;
	}
	
	public void setsFinalQueryAccionista(String sFinalQueryAccionista) {
		this.sFinalQueryAccionista= sFinalQueryAccionista;
	}
	
	public Border resaltarSeleccionarAccionista=null;
	
	public Border setResaltarSeleccionarAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAccionista= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAccionista() {
		return this.resaltarSeleccionarAccionista;
	}
	
	public void setResaltarSeleccionarAccionista(Border borderResaltarSeleccionarAccionista) {
		this.resaltarSeleccionarAccionista= borderResaltarSeleccionarAccionista;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAccionista=null;
	public Boolean mostraridAccionista=true;
	public Boolean activaridAccionista=true;

	public Border resaltaridclienteAccionista=null;
	public Boolean mostraridclienteAccionista=true;
	public Boolean activaridclienteAccionista=true;
	public Boolean cargaridclienteAccionista=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteAccionista=false;//ConEventDepend=true

	public Border resaltaridvalorclienteinversionAccionista=null;
	public Boolean mostraridvalorclienteinversionAccionista=true;
	public Boolean activaridvalorclienteinversionAccionista=true;
	public Boolean cargaridvalorclienteinversionAccionista=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclienteinversionAccionista=false;//ConEventDepend=true

	public Border resaltaridvaloridentificacionAccionista=null;
	public Boolean mostraridvaloridentificacionAccionista=true;
	public Boolean activaridvaloridentificacionAccionista=true;
	public Boolean cargaridvaloridentificacionAccionista=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvaloridentificacionAccionista=false;//ConEventDepend=true

	public Border resaltaridentificacionAccionista=null;
	public Boolean mostraridentificacionAccionista=true;
	public Boolean activaridentificacionAccionista=true;

	public Border resaltarapellidopaternoAccionista=null;
	public Boolean mostrarapellidopaternoAccionista=true;
	public Boolean activarapellidopaternoAccionista=true;

	public Border resaltarapellidomaternoAccionista=null;
	public Boolean mostrarapellidomaternoAccionista=true;
	public Boolean activarapellidomaternoAccionista=true;

	public Border resaltarprimernombreAccionista=null;
	public Boolean mostrarprimernombreAccionista=true;
	public Boolean activarprimernombreAccionista=true;

	public Border resaltarsegundonombreAccionista=null;
	public Boolean mostrarsegundonombreAccionista=true;
	public Boolean activarsegundonombreAccionista=true;

	public Border resaltarnombrecortoAccionista=null;
	public Boolean mostrarnombrecortoAccionista=true;
	public Boolean activarnombrecortoAccionista=true;

	public Border resaltarparticipacionAccionista=null;
	public Boolean mostrarparticipacionAccionista=true;
	public Boolean activarparticipacionAccionista=true;

	public Border resaltaresactivoAccionista=null;
	public Boolean mostraresactivoAccionista=true;
	public Boolean activaresactivoAccionista=true;

	
	

	public Border setResaltaridAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaridAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAccionista() {
		return this.resaltaridAccionista;
	}

	public void setResaltaridAccionista(Border borderResaltar) {
		this.resaltaridAccionista= borderResaltar;
	}

	public Boolean getMostraridAccionista() {
		return this.mostraridAccionista;
	}

	public void setMostraridAccionista(Boolean mostraridAccionista) {
		this.mostraridAccionista= mostraridAccionista;
	}

	public Boolean getActivaridAccionista() {
		return this.activaridAccionista;
	}

	public void setActivaridAccionista(Boolean activaridAccionista) {
		this.activaridAccionista= activaridAccionista;
	}

	public Border setResaltaridclienteAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaridclienteAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteAccionista() {
		return this.resaltaridclienteAccionista;
	}

	public void setResaltaridclienteAccionista(Border borderResaltar) {
		this.resaltaridclienteAccionista= borderResaltar;
	}

	public Boolean getMostraridclienteAccionista() {
		return this.mostraridclienteAccionista;
	}

	public void setMostraridclienteAccionista(Boolean mostraridclienteAccionista) {
		this.mostraridclienteAccionista= mostraridclienteAccionista;
	}

	public Boolean getActivaridclienteAccionista() {
		return this.activaridclienteAccionista;
	}

	public void setActivaridclienteAccionista(Boolean activaridclienteAccionista) {
		this.activaridclienteAccionista= activaridclienteAccionista;
	}

	public Boolean getCargaridclienteAccionista() {
		return this.cargaridclienteAccionista;
	}

	public void setCargaridclienteAccionista(Boolean cargaridclienteAccionista) {
		this.cargaridclienteAccionista= cargaridclienteAccionista;
	}

	public Border setResaltaridvalorclienteinversionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaridvalorclienteinversionAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclienteinversionAccionista() {
		return this.resaltaridvalorclienteinversionAccionista;
	}

	public void setResaltaridvalorclienteinversionAccionista(Border borderResaltar) {
		this.resaltaridvalorclienteinversionAccionista= borderResaltar;
	}

	public Boolean getMostraridvalorclienteinversionAccionista() {
		return this.mostraridvalorclienteinversionAccionista;
	}

	public void setMostraridvalorclienteinversionAccionista(Boolean mostraridvalorclienteinversionAccionista) {
		this.mostraridvalorclienteinversionAccionista= mostraridvalorclienteinversionAccionista;
	}

	public Boolean getActivaridvalorclienteinversionAccionista() {
		return this.activaridvalorclienteinversionAccionista;
	}

	public void setActivaridvalorclienteinversionAccionista(Boolean activaridvalorclienteinversionAccionista) {
		this.activaridvalorclienteinversionAccionista= activaridvalorclienteinversionAccionista;
	}

	public Boolean getCargaridvalorclienteinversionAccionista() {
		return this.cargaridvalorclienteinversionAccionista;
	}

	public void setCargaridvalorclienteinversionAccionista(Boolean cargaridvalorclienteinversionAccionista) {
		this.cargaridvalorclienteinversionAccionista= cargaridvalorclienteinversionAccionista;
	}

	public Border setResaltaridvaloridentificacionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaridvaloridentificacionAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvaloridentificacionAccionista() {
		return this.resaltaridvaloridentificacionAccionista;
	}

	public void setResaltaridvaloridentificacionAccionista(Border borderResaltar) {
		this.resaltaridvaloridentificacionAccionista= borderResaltar;
	}

	public Boolean getMostraridvaloridentificacionAccionista() {
		return this.mostraridvaloridentificacionAccionista;
	}

	public void setMostraridvaloridentificacionAccionista(Boolean mostraridvaloridentificacionAccionista) {
		this.mostraridvaloridentificacionAccionista= mostraridvaloridentificacionAccionista;
	}

	public Boolean getActivaridvaloridentificacionAccionista() {
		return this.activaridvaloridentificacionAccionista;
	}

	public void setActivaridvaloridentificacionAccionista(Boolean activaridvaloridentificacionAccionista) {
		this.activaridvaloridentificacionAccionista= activaridvaloridentificacionAccionista;
	}

	public Boolean getCargaridvaloridentificacionAccionista() {
		return this.cargaridvaloridentificacionAccionista;
	}

	public void setCargaridvaloridentificacionAccionista(Boolean cargaridvaloridentificacionAccionista) {
		this.cargaridvaloridentificacionAccionista= cargaridvaloridentificacionAccionista;
	}

	public Border setResaltaridentificacionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaridentificacionAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionAccionista() {
		return this.resaltaridentificacionAccionista;
	}

	public void setResaltaridentificacionAccionista(Border borderResaltar) {
		this.resaltaridentificacionAccionista= borderResaltar;
	}

	public Boolean getMostraridentificacionAccionista() {
		return this.mostraridentificacionAccionista;
	}

	public void setMostraridentificacionAccionista(Boolean mostraridentificacionAccionista) {
		this.mostraridentificacionAccionista= mostraridentificacionAccionista;
	}

	public Boolean getActivaridentificacionAccionista() {
		return this.activaridentificacionAccionista;
	}

	public void setActivaridentificacionAccionista(Boolean activaridentificacionAccionista) {
		this.activaridentificacionAccionista= activaridentificacionAccionista;
	}

	public Border setResaltarapellidopaternoAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarapellidopaternoAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidopaternoAccionista() {
		return this.resaltarapellidopaternoAccionista;
	}

	public void setResaltarapellidopaternoAccionista(Border borderResaltar) {
		this.resaltarapellidopaternoAccionista= borderResaltar;
	}

	public Boolean getMostrarapellidopaternoAccionista() {
		return this.mostrarapellidopaternoAccionista;
	}

	public void setMostrarapellidopaternoAccionista(Boolean mostrarapellidopaternoAccionista) {
		this.mostrarapellidopaternoAccionista= mostrarapellidopaternoAccionista;
	}

	public Boolean getActivarapellidopaternoAccionista() {
		return this.activarapellidopaternoAccionista;
	}

	public void setActivarapellidopaternoAccionista(Boolean activarapellidopaternoAccionista) {
		this.activarapellidopaternoAccionista= activarapellidopaternoAccionista;
	}

	public Border setResaltarapellidomaternoAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarapellidomaternoAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidomaternoAccionista() {
		return this.resaltarapellidomaternoAccionista;
	}

	public void setResaltarapellidomaternoAccionista(Border borderResaltar) {
		this.resaltarapellidomaternoAccionista= borderResaltar;
	}

	public Boolean getMostrarapellidomaternoAccionista() {
		return this.mostrarapellidomaternoAccionista;
	}

	public void setMostrarapellidomaternoAccionista(Boolean mostrarapellidomaternoAccionista) {
		this.mostrarapellidomaternoAccionista= mostrarapellidomaternoAccionista;
	}

	public Boolean getActivarapellidomaternoAccionista() {
		return this.activarapellidomaternoAccionista;
	}

	public void setActivarapellidomaternoAccionista(Boolean activarapellidomaternoAccionista) {
		this.activarapellidomaternoAccionista= activarapellidomaternoAccionista;
	}

	public Border setResaltarprimernombreAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarprimernombreAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprimernombreAccionista() {
		return this.resaltarprimernombreAccionista;
	}

	public void setResaltarprimernombreAccionista(Border borderResaltar) {
		this.resaltarprimernombreAccionista= borderResaltar;
	}

	public Boolean getMostrarprimernombreAccionista() {
		return this.mostrarprimernombreAccionista;
	}

	public void setMostrarprimernombreAccionista(Boolean mostrarprimernombreAccionista) {
		this.mostrarprimernombreAccionista= mostrarprimernombreAccionista;
	}

	public Boolean getActivarprimernombreAccionista() {
		return this.activarprimernombreAccionista;
	}

	public void setActivarprimernombreAccionista(Boolean activarprimernombreAccionista) {
		this.activarprimernombreAccionista= activarprimernombreAccionista;
	}

	public Border setResaltarsegundonombreAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarsegundonombreAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsegundonombreAccionista() {
		return this.resaltarsegundonombreAccionista;
	}

	public void setResaltarsegundonombreAccionista(Border borderResaltar) {
		this.resaltarsegundonombreAccionista= borderResaltar;
	}

	public Boolean getMostrarsegundonombreAccionista() {
		return this.mostrarsegundonombreAccionista;
	}

	public void setMostrarsegundonombreAccionista(Boolean mostrarsegundonombreAccionista) {
		this.mostrarsegundonombreAccionista= mostrarsegundonombreAccionista;
	}

	public Boolean getActivarsegundonombreAccionista() {
		return this.activarsegundonombreAccionista;
	}

	public void setActivarsegundonombreAccionista(Boolean activarsegundonombreAccionista) {
		this.activarsegundonombreAccionista= activarsegundonombreAccionista;
	}

	public Border setResaltarnombrecortoAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarnombrecortoAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrecortoAccionista() {
		return this.resaltarnombrecortoAccionista;
	}

	public void setResaltarnombrecortoAccionista(Border borderResaltar) {
		this.resaltarnombrecortoAccionista= borderResaltar;
	}

	public Boolean getMostrarnombrecortoAccionista() {
		return this.mostrarnombrecortoAccionista;
	}

	public void setMostrarnombrecortoAccionista(Boolean mostrarnombrecortoAccionista) {
		this.mostrarnombrecortoAccionista= mostrarnombrecortoAccionista;
	}

	public Boolean getActivarnombrecortoAccionista() {
		return this.activarnombrecortoAccionista;
	}

	public void setActivarnombrecortoAccionista(Boolean activarnombrecortoAccionista) {
		this.activarnombrecortoAccionista= activarnombrecortoAccionista;
	}

	public Border setResaltarparticipacionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltarparticipacionAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarparticipacionAccionista() {
		return this.resaltarparticipacionAccionista;
	}

	public void setResaltarparticipacionAccionista(Border borderResaltar) {
		this.resaltarparticipacionAccionista= borderResaltar;
	}

	public Boolean getMostrarparticipacionAccionista() {
		return this.mostrarparticipacionAccionista;
	}

	public void setMostrarparticipacionAccionista(Boolean mostrarparticipacionAccionista) {
		this.mostrarparticipacionAccionista= mostrarparticipacionAccionista;
	}

	public Boolean getActivarparticipacionAccionista() {
		return this.activarparticipacionAccionista;
	}

	public void setActivarparticipacionAccionista(Boolean activarparticipacionAccionista) {
		this.activarparticipacionAccionista= activarparticipacionAccionista;
	}

	public Border setResaltaresactivoAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionistaBeanSwingJInternalFrame.jTtoolBarAccionista.setBorder(borderResaltar);
		
		this.resaltaresactivoAccionista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoAccionista() {
		return this.resaltaresactivoAccionista;
	}

	public void setResaltaresactivoAccionista(Border borderResaltar) {
		this.resaltaresactivoAccionista= borderResaltar;
	}

	public Boolean getMostraresactivoAccionista() {
		return this.mostraresactivoAccionista;
	}

	public void setMostraresactivoAccionista(Boolean mostraresactivoAccionista) {
		this.mostraresactivoAccionista= mostraresactivoAccionista;
	}

	public Boolean getActivaresactivoAccionista() {
		return this.activaresactivoAccionista;
	}

	public void setActivaresactivoAccionista(Boolean activaresactivoAccionista) {
		this.activaresactivoAccionista= activaresactivoAccionista;
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
		
		
		this.setMostraridAccionista(esInicial);
		this.setMostraridclienteAccionista(esInicial);
		this.setMostraridvalorclienteinversionAccionista(esInicial);
		this.setMostraridvaloridentificacionAccionista(esInicial);
		this.setMostraridentificacionAccionista(esInicial);
		this.setMostrarapellidopaternoAccionista(esInicial);
		this.setMostrarapellidomaternoAccionista(esInicial);
		this.setMostrarprimernombreAccionista(esInicial);
		this.setMostrarsegundonombreAccionista(esInicial);
		this.setMostrarnombrecortoAccionista(esInicial);
		this.setMostrarparticipacionAccionista(esInicial);
		this.setMostraresactivoAccionista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionistaConstantesFunciones.ID)) {
				this.setMostraridAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOINVERSION)) {
				this.setMostraridvalorclienteinversionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostraridvaloridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOPATERNO)) {
				this.setMostrarapellidopaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOMATERNO)) {
				this.setMostrarapellidomaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PRIMERNOMBRE)) {
				this.setMostrarprimernombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.SEGUNDONOMBRE)) {
				this.setMostrarsegundonombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.NOMBRECORTO)) {
				this.setMostrarnombrecortoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PARTICIPACION)) {
				this.setMostrarparticipacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoAccionista(esAsigna);
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
		
		
		this.setActivaridAccionista(esInicial);
		this.setActivaridclienteAccionista(esInicial);
		this.setActivaridvalorclienteinversionAccionista(esInicial);
		this.setActivaridvaloridentificacionAccionista(esInicial);
		this.setActivaridentificacionAccionista(esInicial);
		this.setActivarapellidopaternoAccionista(esInicial);
		this.setActivarapellidomaternoAccionista(esInicial);
		this.setActivarprimernombreAccionista(esInicial);
		this.setActivarsegundonombreAccionista(esInicial);
		this.setActivarnombrecortoAccionista(esInicial);
		this.setActivarparticipacionAccionista(esInicial);
		this.setActivaresactivoAccionista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionistaConstantesFunciones.ID)) {
				this.setActivaridAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOINVERSION)) {
				this.setActivaridvalorclienteinversionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivaridvaloridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOPATERNO)) {
				this.setActivarapellidopaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOMATERNO)) {
				this.setActivarapellidomaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PRIMERNOMBRE)) {
				this.setActivarprimernombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.SEGUNDONOMBRE)) {
				this.setActivarsegundonombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.NOMBRECORTO)) {
				this.setActivarnombrecortoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PARTICIPACION)) {
				this.setActivarparticipacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoAccionista(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAccionista(esInicial);
		this.setResaltaridclienteAccionista(esInicial);
		this.setResaltaridvalorclienteinversionAccionista(esInicial);
		this.setResaltaridvaloridentificacionAccionista(esInicial);
		this.setResaltaridentificacionAccionista(esInicial);
		this.setResaltarapellidopaternoAccionista(esInicial);
		this.setResaltarapellidomaternoAccionista(esInicial);
		this.setResaltarprimernombreAccionista(esInicial);
		this.setResaltarsegundonombreAccionista(esInicial);
		this.setResaltarnombrecortoAccionista(esInicial);
		this.setResaltarparticipacionAccionista(esInicial);
		this.setResaltaresactivoAccionista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionistaConstantesFunciones.ID)) {
				this.setResaltaridAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOINVERSION)) {
				this.setResaltaridvalorclienteinversionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltaridvaloridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOPATERNO)) {
				this.setResaltarapellidopaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.APELLIDOMATERNO)) {
				this.setResaltarapellidomaternoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PRIMERNOMBRE)) {
				this.setResaltarprimernombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.SEGUNDONOMBRE)) {
				this.setResaltarsegundonombreAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.NOMBRECORTO)) {
				this.setResaltarnombrecortoAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.PARTICIPACION)) {
				this.setResaltarparticipacionAccionista(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionistaConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoAccionista(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdClientePorNombreCortoAccionista=true;

	public Boolean getMostrarBusquedaPorIdClientePorNombreCortoAccionista() {
		return this.mostrarBusquedaPorIdClientePorNombreCortoAccionista;
	}

	public void setMostrarBusquedaPorIdClientePorNombreCortoAccionista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdClientePorNombreCortoAccionista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteAccionista=true;

	public Boolean getMostrarFK_IdClienteAccionista() {
		return this.mostrarFK_IdClienteAccionista;
	}

	public void setMostrarFK_IdClienteAccionista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAccionista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteInversionAccionista=true;

	public Boolean getMostrarFK_IdValorClienteInversionAccionista() {
		return this.mostrarFK_IdValorClienteInversionAccionista;
	}

	public void setMostrarFK_IdValorClienteInversionAccionista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteInversionAccionista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorIdentificacionAccionista=true;

	public Boolean getMostrarFK_IdValorIdentificacionAccionista() {
		return this.mostrarFK_IdValorIdentificacionAccionista;
	}

	public void setMostrarFK_IdValorIdentificacionAccionista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorIdentificacionAccionista= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdClientePorNombreCortoAccionista=true;

	public Boolean getActivarBusquedaPorIdClientePorNombreCortoAccionista() {
		return this.activarBusquedaPorIdClientePorNombreCortoAccionista;
	}

	public void setActivarBusquedaPorIdClientePorNombreCortoAccionista(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdClientePorNombreCortoAccionista= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteAccionista=true;

	public Boolean getActivarFK_IdClienteAccionista() {
		return this.activarFK_IdClienteAccionista;
	}

	public void setActivarFK_IdClienteAccionista(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAccionista= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteInversionAccionista=true;

	public Boolean getActivarFK_IdValorClienteInversionAccionista() {
		return this.activarFK_IdValorClienteInversionAccionista;
	}

	public void setActivarFK_IdValorClienteInversionAccionista(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteInversionAccionista= habilitarResaltar;
	}

	public Boolean activarFK_IdValorIdentificacionAccionista=true;

	public Boolean getActivarFK_IdValorIdentificacionAccionista() {
		return this.activarFK_IdValorIdentificacionAccionista;
	}

	public void setActivarFK_IdValorIdentificacionAccionista(Boolean habilitarResaltar) {
		this.activarFK_IdValorIdentificacionAccionista= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdClientePorNombreCortoAccionista=null;

	public Border getResaltarBusquedaPorIdClientePorNombreCortoAccionista() {
		return this.resaltarBusquedaPorIdClientePorNombreCortoAccionista;
	}

	public void setResaltarBusquedaPorIdClientePorNombreCortoAccionista(Border borderResaltar) {
		this.resaltarBusquedaPorIdClientePorNombreCortoAccionista= borderResaltar;
	}

	public void setResaltarBusquedaPorIdClientePorNombreCortoAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdClientePorNombreCortoAccionista= borderResaltar;
	}

	public Border resaltarFK_IdClienteAccionista=null;

	public Border getResaltarFK_IdClienteAccionista() {
		return this.resaltarFK_IdClienteAccionista;
	}

	public void setResaltarFK_IdClienteAccionista(Border borderResaltar) {
		this.resaltarFK_IdClienteAccionista= borderResaltar;
	}

	public void setResaltarFK_IdClienteAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAccionista= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteInversionAccionista=null;

	public Border getResaltarFK_IdValorClienteInversionAccionista() {
		return this.resaltarFK_IdValorClienteInversionAccionista;
	}

	public void setResaltarFK_IdValorClienteInversionAccionista(Border borderResaltar) {
		this.resaltarFK_IdValorClienteInversionAccionista= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteInversionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteInversionAccionista= borderResaltar;
	}

	public Border resaltarFK_IdValorIdentificacionAccionista=null;

	public Border getResaltarFK_IdValorIdentificacionAccionista() {
		return this.resaltarFK_IdValorIdentificacionAccionista;
	}

	public void setResaltarFK_IdValorIdentificacionAccionista(Border borderResaltar) {
		this.resaltarFK_IdValorIdentificacionAccionista= borderResaltar;
	}

	public void setResaltarFK_IdValorIdentificacionAccionista(ParametroGeneralUsuario parametroGeneralUsuario/*AccionistaBeanSwingJInternalFrame accionistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorIdentificacionAccionista= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}