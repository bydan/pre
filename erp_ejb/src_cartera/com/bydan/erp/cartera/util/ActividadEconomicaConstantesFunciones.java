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


import com.bydan.erp.cartera.util.ActividadEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.ActividadEconomicaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ActividadEconomicaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ActividadEconomicaConstantesFunciones extends ActividadEconomicaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ActividadEconomica";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ActividadEconomica"+ActividadEconomicaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ActividadEconomicaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ActividadEconomicaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ActividadEconomicaConstantesFunciones.SCHEMA+"_"+ActividadEconomicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ActividadEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ActividadEconomicaConstantesFunciones.SCHEMA+"_"+ActividadEconomicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ActividadEconomicaConstantesFunciones.SCHEMA+"_"+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ActividadEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ActividadEconomicaConstantesFunciones.SCHEMA+"_"+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActividadEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActividadEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActividadEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ActividadEconomicaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ActividadEconomicaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ActividadEconomicaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ActividadEconomicaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Actividad Economicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Actividad Economica";
	public static final String SCLASSWEBTITULO_LOWER="Actividad Economica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ActividadEconomica";
	public static final String OBJECTNAME="actividadeconomica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="actividad_economica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select actividadeconomica from "+ActividadEconomicaConstantesFunciones.SPERSISTENCENAME+" actividadeconomica";
	public static String QUERYSELECTNATIVE="select "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".version_row,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_empresa,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_cliente,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".nombre_negocio,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".actividad,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_pais,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_ciudad,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".direccion,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".telefono,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".ingreso_neto,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".ingreso_bruto from "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME;//+" as "+ActividadEconomicaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ActividadEconomicaConstantesFuncionesAdditional actividadeconomicaConstantesFuncionesAdditional=null;
	
	public ActividadEconomicaConstantesFuncionesAdditional getActividadEconomicaConstantesFuncionesAdditional() {
		return this.actividadeconomicaConstantesFuncionesAdditional;
	}
	
	public void setActividadEconomicaConstantesFuncionesAdditional(ActividadEconomicaConstantesFuncionesAdditional actividadeconomicaConstantesFuncionesAdditional) {
		try {
			this.actividadeconomicaConstantesFuncionesAdditional=actividadeconomicaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBRENEGOCIO= "nombre_negocio";
    public static final String ACTIVIDAD= "actividad";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String INGRESONETO= "ingreso_neto";
    public static final String INGRESOBRUTO= "ingreso_bruto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBRENEGOCIO= "Nombre Negocio";
		public static final String LABEL_NOMBRENEGOCIO_LOWER= "Nombre Negocio";
    	public static final String LABEL_ACTIVIDAD= "Actividad";
		public static final String LABEL_ACTIVIDAD_LOWER= "Actividad";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_INGRESONETO= "Ingreso Neto";
		public static final String LABEL_INGRESONETO_LOWER= "Ingreso Neto";
    	public static final String LABEL_INGRESOBRUTO= "Ingreso Bruto";
		public static final String LABEL_INGRESOBRUTO_LOWER= "Ingreso Bruto";
	
		
		
		
		
	public static final String SREGEXNOMBRE_NEGOCIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_NEGOCIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACTIVIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACTIVIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
	
	public static String getActividadEconomicaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_NOMBRENEGOCIO;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.ACTIVIDAD)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_ACTIVIDAD;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.IDPAIS)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.IDCIUDAD)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.DIRECCION)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.TELEFONO)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.INGRESONETO)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO;}
		if(sNombreColumna.equals(ActividadEconomicaConstantesFunciones.INGRESOBRUTO)) {sLabelColumna=ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getActividadEconomicaDescripcion(ActividadEconomica actividadeconomica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(actividadeconomica !=null/* && actividadeconomica.getId()!=0*/) {
			sDescripcion=actividadeconomica.getnombre_negocio();//actividadeconomicaactividadeconomica.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getActividadEconomicaDescripcionDetallado(ActividadEconomica actividadeconomica) {
		String sDescripcion="";
			
		sDescripcion+=ActividadEconomicaConstantesFunciones.ID+"=";
		sDescripcion+=actividadeconomica.getId().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=actividadeconomica.getVersionRow().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=actividadeconomica.getid_empresa().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=actividadeconomica.getid_cliente().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO+"=";
		sDescripcion+=actividadeconomica.getnombre_negocio()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.ACTIVIDAD+"=";
		sDescripcion+=actividadeconomica.getactividad()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=actividadeconomica.getid_pais().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=actividadeconomica.getid_ciudad().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=actividadeconomica.getdireccion()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=actividadeconomica.gettelefono()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.INGRESONETO+"=";
		sDescripcion+=actividadeconomica.getingreso_neto().toString()+",";
		sDescripcion+=ActividadEconomicaConstantesFunciones.INGRESOBRUTO+"=";
		sDescripcion+=actividadeconomica.getingreso_bruto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setActividadEconomicaDescripcion(ActividadEconomica actividadeconomica,String sValor) throws Exception {			
		if(actividadeconomica !=null) {
			actividadeconomica.setnombre_negocio(sValor);//actividadeconomicaactividadeconomica.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosActividadEconomica(ActividadEconomica actividadeconomica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		actividadeconomica.setnombre_negocio(actividadeconomica.getnombre_negocio().trim());
		actividadeconomica.setactividad(actividadeconomica.getactividad().trim());
		actividadeconomica.setdireccion(actividadeconomica.getdireccion().trim());
		actividadeconomica.settelefono(actividadeconomica.gettelefono().trim());
	}
	
	public static void quitarEspaciosActividadEconomicas(List<ActividadEconomica> actividadeconomicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActividadEconomica actividadeconomica: actividadeconomicas) {
			actividadeconomica.setnombre_negocio(actividadeconomica.getnombre_negocio().trim());
			actividadeconomica.setactividad(actividadeconomica.getactividad().trim());
			actividadeconomica.setdireccion(actividadeconomica.getdireccion().trim());
			actividadeconomica.settelefono(actividadeconomica.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActividadEconomica(ActividadEconomica actividadeconomica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && actividadeconomica.getConCambioAuxiliar()) {
			actividadeconomica.setIsDeleted(actividadeconomica.getIsDeletedAuxiliar());	
			actividadeconomica.setIsNew(actividadeconomica.getIsNewAuxiliar());	
			actividadeconomica.setIsChanged(actividadeconomica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			actividadeconomica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			actividadeconomica.setIsDeletedAuxiliar(false);	
			actividadeconomica.setIsNewAuxiliar(false);	
			actividadeconomica.setIsChangedAuxiliar(false);
			
			actividadeconomica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActividadEconomicas(List<ActividadEconomica> actividadeconomicas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ActividadEconomica actividadeconomica : actividadeconomicas) {
			if(conAsignarBase && actividadeconomica.getConCambioAuxiliar()) {
				actividadeconomica.setIsDeleted(actividadeconomica.getIsDeletedAuxiliar());	
				actividadeconomica.setIsNew(actividadeconomica.getIsNewAuxiliar());	
				actividadeconomica.setIsChanged(actividadeconomica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				actividadeconomica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				actividadeconomica.setIsDeletedAuxiliar(false);	
				actividadeconomica.setIsNewAuxiliar(false);	
				actividadeconomica.setIsChangedAuxiliar(false);
				
				actividadeconomica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresActividadEconomica(ActividadEconomica actividadeconomica,Boolean conEnteros) throws Exception  {
		actividadeconomica.setingreso_neto(0.0);
		actividadeconomica.setingreso_bruto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresActividadEconomicas(List<ActividadEconomica> actividadeconomicas,Boolean conEnteros) throws Exception  {
		
		for(ActividadEconomica actividadeconomica: actividadeconomicas) {
			actividadeconomica.setingreso_neto(0.0);
			actividadeconomica.setingreso_bruto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaActividadEconomica(List<ActividadEconomica> actividadeconomicas,ActividadEconomica actividadeconomicaAux) throws Exception  {
		ActividadEconomicaConstantesFunciones.InicializarValoresActividadEconomica(actividadeconomicaAux,true);
		
		for(ActividadEconomica actividadeconomica: actividadeconomicas) {
			if(actividadeconomica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			actividadeconomicaAux.setingreso_neto(actividadeconomicaAux.getingreso_neto()+actividadeconomica.getingreso_neto());			
			actividadeconomicaAux.setingreso_bruto(actividadeconomicaAux.getingreso_bruto()+actividadeconomica.getingreso_bruto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActividadEconomica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ActividadEconomicaConstantesFunciones.getArrayColumnasGlobalesActividadEconomica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesActividadEconomica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ActividadEconomicaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ActividadEconomicaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoActividadEconomica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActividadEconomica> actividadeconomicas,ActividadEconomica actividadeconomica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActividadEconomica actividadeconomicaAux: actividadeconomicas) {
			if(actividadeconomicaAux!=null && actividadeconomica!=null) {
				if((actividadeconomicaAux.getId()==null && actividadeconomica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(actividadeconomicaAux.getId()!=null && actividadeconomica.getId()!=null){
					if(actividadeconomicaAux.getId().equals(actividadeconomica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActividadEconomica(List<ActividadEconomica> actividadeconomicas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingreso_netoTotal=0.0;
		Double ingreso_brutoTotal=0.0;
	
		for(ActividadEconomica actividadeconomica: actividadeconomicas) {			
			if(actividadeconomica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingreso_netoTotal+=actividadeconomica.getingreso_neto();
			ingreso_brutoTotal+=actividadeconomica.getingreso_bruto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActividadEconomicaConstantesFunciones.INGRESONETO);
		datoGeneral.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO);
		datoGeneral.setdValorDouble(ingreso_netoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActividadEconomicaConstantesFunciones.INGRESOBRUTO);
		datoGeneral.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO);
		datoGeneral.setdValorDouble(ingreso_brutoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaActividadEconomica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_ID, ActividadEconomicaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_VERSIONROW, ActividadEconomicaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_IDEMPRESA, ActividadEconomicaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_IDCLIENTE, ActividadEconomicaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_NOMBRENEGOCIO, ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_ACTIVIDAD, ActividadEconomicaConstantesFunciones.ACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_IDPAIS, ActividadEconomicaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_IDCIUDAD, ActividadEconomicaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_DIRECCION, ActividadEconomicaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_TELEFONO, ActividadEconomicaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO, ActividadEconomicaConstantesFunciones.INGRESONETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO, ActividadEconomicaConstantesFunciones.INGRESOBRUTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasActividadEconomica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.ACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.INGRESONETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActividadEconomicaConstantesFunciones.INGRESOBRUTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActividadEconomica() throws Exception  {
		return ActividadEconomicaConstantesFunciones.getTiposSeleccionarActividadEconomica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActividadEconomica(Boolean conFk) throws Exception  {
		return ActividadEconomicaConstantesFunciones.getTiposSeleccionarActividadEconomica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActividadEconomica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_NOMBRENEGOCIO);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_NOMBRENEGOCIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_ACTIVIDAD);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_ACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO);
			reporte.setsDescripcion(ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesActividadEconomica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesActividadEconomica(ActividadEconomica actividadeconomicaAux) throws Exception {
		
			actividadeconomicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(actividadeconomicaAux.getEmpresa()));
			actividadeconomicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(actividadeconomicaAux.getCliente()));
			actividadeconomicaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(actividadeconomicaAux.getPais()));
			actividadeconomicaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(actividadeconomicaAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesActividadEconomica(List<ActividadEconomica> actividadeconomicasTemp) throws Exception {
		for(ActividadEconomica actividadeconomicaAux:actividadeconomicasTemp) {
			
			actividadeconomicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(actividadeconomicaAux.getEmpresa()));
			actividadeconomicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(actividadeconomicaAux.getCliente()));
			actividadeconomicaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(actividadeconomicaAux.getPais()));
			actividadeconomicaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(actividadeconomicaAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfActividadEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfActividadEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfActividadEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActividadEconomicaConstantesFunciones.getClassesRelationshipsOfActividadEconomica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfActividadEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActividadEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActividadEconomicaConstantesFunciones.getClassesRelationshipsFromStringsOfActividadEconomica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActividadEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ActividadEconomica actividadeconomica,List<ActividadEconomica> actividadeconomicas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ActividadEconomica actividadeconomicaEncontrado=null;
			
			for(ActividadEconomica actividadeconomicaLocal:actividadeconomicas) {
				if(actividadeconomicaLocal.getId().equals(actividadeconomica.getId())) {
					actividadeconomicaEncontrado=actividadeconomicaLocal;
					
					actividadeconomicaLocal.setIsChanged(actividadeconomica.getIsChanged());
					actividadeconomicaLocal.setIsNew(actividadeconomica.getIsNew());
					actividadeconomicaLocal.setIsDeleted(actividadeconomica.getIsDeleted());
					
					actividadeconomicaLocal.setGeneralEntityOriginal(actividadeconomica.getGeneralEntityOriginal());
					
					actividadeconomicaLocal.setId(actividadeconomica.getId());	
					actividadeconomicaLocal.setVersionRow(actividadeconomica.getVersionRow());	
					actividadeconomicaLocal.setid_empresa(actividadeconomica.getid_empresa());	
					actividadeconomicaLocal.setid_cliente(actividadeconomica.getid_cliente());	
					actividadeconomicaLocal.setnombre_negocio(actividadeconomica.getnombre_negocio());	
					actividadeconomicaLocal.setactividad(actividadeconomica.getactividad());	
					actividadeconomicaLocal.setid_pais(actividadeconomica.getid_pais());	
					actividadeconomicaLocal.setid_ciudad(actividadeconomica.getid_ciudad());	
					actividadeconomicaLocal.setdireccion(actividadeconomica.getdireccion());	
					actividadeconomicaLocal.settelefono(actividadeconomica.gettelefono());	
					actividadeconomicaLocal.setingreso_neto(actividadeconomica.getingreso_neto());	
					actividadeconomicaLocal.setingreso_bruto(actividadeconomica.getingreso_bruto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!actividadeconomica.getIsDeleted()) {
				if(!existe) {
					actividadeconomicas.add(actividadeconomica);
				}
			} else {
				if(actividadeconomicaEncontrado!=null && permiteQuitar)  {
					actividadeconomicas.remove(actividadeconomicaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ActividadEconomica actividadeconomica,List<ActividadEconomica> actividadeconomicas) throws Exception {
		try	{			
			for(ActividadEconomica actividadeconomicaLocal:actividadeconomicas) {
				if(actividadeconomicaLocal.getId().equals(actividadeconomica.getId())) {
					actividadeconomicaLocal.setIsSelected(actividadeconomica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesActividadEconomica(List<ActividadEconomica> actividadeconomicasAux) throws Exception {
		//this.actividadeconomicasAux=actividadeconomicasAux;
		
		for(ActividadEconomica actividadeconomicaAux:actividadeconomicasAux) {
			if(actividadeconomicaAux.getIsChanged()) {
				actividadeconomicaAux.setIsChanged(false);
			}		
			
			if(actividadeconomicaAux.getIsNew()) {
				actividadeconomicaAux.setIsNew(false);
			}	
			
			if(actividadeconomicaAux.getIsDeleted()) {
				actividadeconomicaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesActividadEconomica(ActividadEconomica actividadeconomicaAux) throws Exception {
		//this.actividadeconomicaAux=actividadeconomicaAux;
		
			if(actividadeconomicaAux.getIsChanged()) {
				actividadeconomicaAux.setIsChanged(false);
			}		
			
			if(actividadeconomicaAux.getIsNew()) {
				actividadeconomicaAux.setIsNew(false);
			}	
			
			if(actividadeconomicaAux.getIsDeleted()) {
				actividadeconomicaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ActividadEconomica actividadeconomicaAsignar,ActividadEconomica actividadeconomica) throws Exception {
		actividadeconomicaAsignar.setId(actividadeconomica.getId());	
		actividadeconomicaAsignar.setVersionRow(actividadeconomica.getVersionRow());	
		actividadeconomicaAsignar.setid_empresa(actividadeconomica.getid_empresa());
		actividadeconomicaAsignar.setempresa_descripcion(actividadeconomica.getempresa_descripcion());	
		actividadeconomicaAsignar.setid_cliente(actividadeconomica.getid_cliente());
		actividadeconomicaAsignar.setcliente_descripcion(actividadeconomica.getcliente_descripcion());	
		actividadeconomicaAsignar.setnombre_negocio(actividadeconomica.getnombre_negocio());	
		actividadeconomicaAsignar.setactividad(actividadeconomica.getactividad());	
		actividadeconomicaAsignar.setid_pais(actividadeconomica.getid_pais());
		actividadeconomicaAsignar.setpais_descripcion(actividadeconomica.getpais_descripcion());	
		actividadeconomicaAsignar.setid_ciudad(actividadeconomica.getid_ciudad());
		actividadeconomicaAsignar.setciudad_descripcion(actividadeconomica.getciudad_descripcion());	
		actividadeconomicaAsignar.setdireccion(actividadeconomica.getdireccion());	
		actividadeconomicaAsignar.settelefono(actividadeconomica.gettelefono());	
		actividadeconomicaAsignar.setingreso_neto(actividadeconomica.getingreso_neto());	
		actividadeconomicaAsignar.setingreso_bruto(actividadeconomica.getingreso_bruto());	
	}
	
	public static void inicializarActividadEconomica(ActividadEconomica actividadeconomica) throws Exception {
		try {
				actividadeconomica.setId(0L);	
					
				actividadeconomica.setid_empresa(-1L);	
				actividadeconomica.setid_cliente(-1L);	
				actividadeconomica.setnombre_negocio("");	
				actividadeconomica.setactividad("");	
				actividadeconomica.setid_pais(-1L);	
				actividadeconomica.setid_ciudad(-1L);	
				actividadeconomica.setdireccion("");	
				actividadeconomica.settelefono("");	
				actividadeconomica.setingreso_neto(0.0);	
				actividadeconomica.setingreso_bruto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderActividadEconomica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_NOMBRENEGOCIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_ACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_INGRESONETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActividadEconomicaConstantesFunciones.LABEL_INGRESOBRUTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataActividadEconomica(String sTipo,Row row,Workbook workbook,ActividadEconomica actividadeconomica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getnombre_negocio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getactividad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getingreso_neto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(actividadeconomica.getingreso_bruto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryActividadEconomica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryActividadEconomica() {
		return this.sFinalQueryActividadEconomica;
	}
	
	public void setsFinalQueryActividadEconomica(String sFinalQueryActividadEconomica) {
		this.sFinalQueryActividadEconomica= sFinalQueryActividadEconomica;
	}
	
	public Border resaltarSeleccionarActividadEconomica=null;
	
	public Border setResaltarSeleccionarActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarActividadEconomica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarActividadEconomica() {
		return this.resaltarSeleccionarActividadEconomica;
	}
	
	public void setResaltarSeleccionarActividadEconomica(Border borderResaltarSeleccionarActividadEconomica) {
		this.resaltarSeleccionarActividadEconomica= borderResaltarSeleccionarActividadEconomica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridActividadEconomica=null;
	public Boolean mostraridActividadEconomica=true;
	public Boolean activaridActividadEconomica=true;

	public Border resaltarid_empresaActividadEconomica=null;
	public Boolean mostrarid_empresaActividadEconomica=true;
	public Boolean activarid_empresaActividadEconomica=true;
	public Boolean cargarid_empresaActividadEconomica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaActividadEconomica=false;//ConEventDepend=true

	public Border resaltarid_clienteActividadEconomica=null;
	public Boolean mostrarid_clienteActividadEconomica=true;
	public Boolean activarid_clienteActividadEconomica=true;
	public Boolean cargarid_clienteActividadEconomica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteActividadEconomica=false;//ConEventDepend=true

	public Border resaltarnombre_negocioActividadEconomica=null;
	public Boolean mostrarnombre_negocioActividadEconomica=true;
	public Boolean activarnombre_negocioActividadEconomica=true;

	public Border resaltaractividadActividadEconomica=null;
	public Boolean mostraractividadActividadEconomica=true;
	public Boolean activaractividadActividadEconomica=true;

	public Border resaltarid_paisActividadEconomica=null;
	public Boolean mostrarid_paisActividadEconomica=true;
	public Boolean activarid_paisActividadEconomica=true;
	public Boolean cargarid_paisActividadEconomica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisActividadEconomica=false;//ConEventDepend=true

	public Border resaltarid_ciudadActividadEconomica=null;
	public Boolean mostrarid_ciudadActividadEconomica=true;
	public Boolean activarid_ciudadActividadEconomica=true;
	public Boolean cargarid_ciudadActividadEconomica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadActividadEconomica=false;//ConEventDepend=true

	public Border resaltardireccionActividadEconomica=null;
	public Boolean mostrardireccionActividadEconomica=true;
	public Boolean activardireccionActividadEconomica=true;

	public Border resaltartelefonoActividadEconomica=null;
	public Boolean mostrartelefonoActividadEconomica=true;
	public Boolean activartelefonoActividadEconomica=true;

	public Border resaltaringreso_netoActividadEconomica=null;
	public Boolean mostraringreso_netoActividadEconomica=true;
	public Boolean activaringreso_netoActividadEconomica=true;

	public Border resaltaringreso_brutoActividadEconomica=null;
	public Boolean mostraringreso_brutoActividadEconomica=true;
	public Boolean activaringreso_brutoActividadEconomica=true;

	
	

	public Border setResaltaridActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltaridActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridActividadEconomica() {
		return this.resaltaridActividadEconomica;
	}

	public void setResaltaridActividadEconomica(Border borderResaltar) {
		this.resaltaridActividadEconomica= borderResaltar;
	}

	public Boolean getMostraridActividadEconomica() {
		return this.mostraridActividadEconomica;
	}

	public void setMostraridActividadEconomica(Boolean mostraridActividadEconomica) {
		this.mostraridActividadEconomica= mostraridActividadEconomica;
	}

	public Boolean getActivaridActividadEconomica() {
		return this.activaridActividadEconomica;
	}

	public void setActivaridActividadEconomica(Boolean activaridActividadEconomica) {
		this.activaridActividadEconomica= activaridActividadEconomica;
	}

	public Border setResaltarid_empresaActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarid_empresaActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaActividadEconomica() {
		return this.resaltarid_empresaActividadEconomica;
	}

	public void setResaltarid_empresaActividadEconomica(Border borderResaltar) {
		this.resaltarid_empresaActividadEconomica= borderResaltar;
	}

	public Boolean getMostrarid_empresaActividadEconomica() {
		return this.mostrarid_empresaActividadEconomica;
	}

	public void setMostrarid_empresaActividadEconomica(Boolean mostrarid_empresaActividadEconomica) {
		this.mostrarid_empresaActividadEconomica= mostrarid_empresaActividadEconomica;
	}

	public Boolean getActivarid_empresaActividadEconomica() {
		return this.activarid_empresaActividadEconomica;
	}

	public void setActivarid_empresaActividadEconomica(Boolean activarid_empresaActividadEconomica) {
		this.activarid_empresaActividadEconomica= activarid_empresaActividadEconomica;
	}

	public Boolean getCargarid_empresaActividadEconomica() {
		return this.cargarid_empresaActividadEconomica;
	}

	public void setCargarid_empresaActividadEconomica(Boolean cargarid_empresaActividadEconomica) {
		this.cargarid_empresaActividadEconomica= cargarid_empresaActividadEconomica;
	}

	public Border setResaltarid_clienteActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarid_clienteActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteActividadEconomica() {
		return this.resaltarid_clienteActividadEconomica;
	}

	public void setResaltarid_clienteActividadEconomica(Border borderResaltar) {
		this.resaltarid_clienteActividadEconomica= borderResaltar;
	}

	public Boolean getMostrarid_clienteActividadEconomica() {
		return this.mostrarid_clienteActividadEconomica;
	}

	public void setMostrarid_clienteActividadEconomica(Boolean mostrarid_clienteActividadEconomica) {
		this.mostrarid_clienteActividadEconomica= mostrarid_clienteActividadEconomica;
	}

	public Boolean getActivarid_clienteActividadEconomica() {
		return this.activarid_clienteActividadEconomica;
	}

	public void setActivarid_clienteActividadEconomica(Boolean activarid_clienteActividadEconomica) {
		this.activarid_clienteActividadEconomica= activarid_clienteActividadEconomica;
	}

	public Boolean getCargarid_clienteActividadEconomica() {
		return this.cargarid_clienteActividadEconomica;
	}

	public void setCargarid_clienteActividadEconomica(Boolean cargarid_clienteActividadEconomica) {
		this.cargarid_clienteActividadEconomica= cargarid_clienteActividadEconomica;
	}

	public Border setResaltarnombre_negocioActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarnombre_negocioActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_negocioActividadEconomica() {
		return this.resaltarnombre_negocioActividadEconomica;
	}

	public void setResaltarnombre_negocioActividadEconomica(Border borderResaltar) {
		this.resaltarnombre_negocioActividadEconomica= borderResaltar;
	}

	public Boolean getMostrarnombre_negocioActividadEconomica() {
		return this.mostrarnombre_negocioActividadEconomica;
	}

	public void setMostrarnombre_negocioActividadEconomica(Boolean mostrarnombre_negocioActividadEconomica) {
		this.mostrarnombre_negocioActividadEconomica= mostrarnombre_negocioActividadEconomica;
	}

	public Boolean getActivarnombre_negocioActividadEconomica() {
		return this.activarnombre_negocioActividadEconomica;
	}

	public void setActivarnombre_negocioActividadEconomica(Boolean activarnombre_negocioActividadEconomica) {
		this.activarnombre_negocioActividadEconomica= activarnombre_negocioActividadEconomica;
	}

	public Border setResaltaractividadActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltaractividadActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractividadActividadEconomica() {
		return this.resaltaractividadActividadEconomica;
	}

	public void setResaltaractividadActividadEconomica(Border borderResaltar) {
		this.resaltaractividadActividadEconomica= borderResaltar;
	}

	public Boolean getMostraractividadActividadEconomica() {
		return this.mostraractividadActividadEconomica;
	}

	public void setMostraractividadActividadEconomica(Boolean mostraractividadActividadEconomica) {
		this.mostraractividadActividadEconomica= mostraractividadActividadEconomica;
	}

	public Boolean getActivaractividadActividadEconomica() {
		return this.activaractividadActividadEconomica;
	}

	public void setActivaractividadActividadEconomica(Boolean activaractividadActividadEconomica) {
		this.activaractividadActividadEconomica= activaractividadActividadEconomica;
	}

	public Border setResaltarid_paisActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarid_paisActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisActividadEconomica() {
		return this.resaltarid_paisActividadEconomica;
	}

	public void setResaltarid_paisActividadEconomica(Border borderResaltar) {
		this.resaltarid_paisActividadEconomica= borderResaltar;
	}

	public Boolean getMostrarid_paisActividadEconomica() {
		return this.mostrarid_paisActividadEconomica;
	}

	public void setMostrarid_paisActividadEconomica(Boolean mostrarid_paisActividadEconomica) {
		this.mostrarid_paisActividadEconomica= mostrarid_paisActividadEconomica;
	}

	public Boolean getActivarid_paisActividadEconomica() {
		return this.activarid_paisActividadEconomica;
	}

	public void setActivarid_paisActividadEconomica(Boolean activarid_paisActividadEconomica) {
		this.activarid_paisActividadEconomica= activarid_paisActividadEconomica;
	}

	public Boolean getCargarid_paisActividadEconomica() {
		return this.cargarid_paisActividadEconomica;
	}

	public void setCargarid_paisActividadEconomica(Boolean cargarid_paisActividadEconomica) {
		this.cargarid_paisActividadEconomica= cargarid_paisActividadEconomica;
	}

	public Border setResaltarid_ciudadActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltarid_ciudadActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadActividadEconomica() {
		return this.resaltarid_ciudadActividadEconomica;
	}

	public void setResaltarid_ciudadActividadEconomica(Border borderResaltar) {
		this.resaltarid_ciudadActividadEconomica= borderResaltar;
	}

	public Boolean getMostrarid_ciudadActividadEconomica() {
		return this.mostrarid_ciudadActividadEconomica;
	}

	public void setMostrarid_ciudadActividadEconomica(Boolean mostrarid_ciudadActividadEconomica) {
		this.mostrarid_ciudadActividadEconomica= mostrarid_ciudadActividadEconomica;
	}

	public Boolean getActivarid_ciudadActividadEconomica() {
		return this.activarid_ciudadActividadEconomica;
	}

	public void setActivarid_ciudadActividadEconomica(Boolean activarid_ciudadActividadEconomica) {
		this.activarid_ciudadActividadEconomica= activarid_ciudadActividadEconomica;
	}

	public Boolean getCargarid_ciudadActividadEconomica() {
		return this.cargarid_ciudadActividadEconomica;
	}

	public void setCargarid_ciudadActividadEconomica(Boolean cargarid_ciudadActividadEconomica) {
		this.cargarid_ciudadActividadEconomica= cargarid_ciudadActividadEconomica;
	}

	public Border setResaltardireccionActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltardireccionActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionActividadEconomica() {
		return this.resaltardireccionActividadEconomica;
	}

	public void setResaltardireccionActividadEconomica(Border borderResaltar) {
		this.resaltardireccionActividadEconomica= borderResaltar;
	}

	public Boolean getMostrardireccionActividadEconomica() {
		return this.mostrardireccionActividadEconomica;
	}

	public void setMostrardireccionActividadEconomica(Boolean mostrardireccionActividadEconomica) {
		this.mostrardireccionActividadEconomica= mostrardireccionActividadEconomica;
	}

	public Boolean getActivardireccionActividadEconomica() {
		return this.activardireccionActividadEconomica;
	}

	public void setActivardireccionActividadEconomica(Boolean activardireccionActividadEconomica) {
		this.activardireccionActividadEconomica= activardireccionActividadEconomica;
	}

	public Border setResaltartelefonoActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltartelefonoActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoActividadEconomica() {
		return this.resaltartelefonoActividadEconomica;
	}

	public void setResaltartelefonoActividadEconomica(Border borderResaltar) {
		this.resaltartelefonoActividadEconomica= borderResaltar;
	}

	public Boolean getMostrartelefonoActividadEconomica() {
		return this.mostrartelefonoActividadEconomica;
	}

	public void setMostrartelefonoActividadEconomica(Boolean mostrartelefonoActividadEconomica) {
		this.mostrartelefonoActividadEconomica= mostrartelefonoActividadEconomica;
	}

	public Boolean getActivartelefonoActividadEconomica() {
		return this.activartelefonoActividadEconomica;
	}

	public void setActivartelefonoActividadEconomica(Boolean activartelefonoActividadEconomica) {
		this.activartelefonoActividadEconomica= activartelefonoActividadEconomica;
	}

	public Border setResaltaringreso_netoActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltaringreso_netoActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso_netoActividadEconomica() {
		return this.resaltaringreso_netoActividadEconomica;
	}

	public void setResaltaringreso_netoActividadEconomica(Border borderResaltar) {
		this.resaltaringreso_netoActividadEconomica= borderResaltar;
	}

	public Boolean getMostraringreso_netoActividadEconomica() {
		return this.mostraringreso_netoActividadEconomica;
	}

	public void setMostraringreso_netoActividadEconomica(Boolean mostraringreso_netoActividadEconomica) {
		this.mostraringreso_netoActividadEconomica= mostraringreso_netoActividadEconomica;
	}

	public Boolean getActivaringreso_netoActividadEconomica() {
		return this.activaringreso_netoActividadEconomica;
	}

	public void setActivaringreso_netoActividadEconomica(Boolean activaringreso_netoActividadEconomica) {
		this.activaringreso_netoActividadEconomica= activaringreso_netoActividadEconomica;
	}

	public Border setResaltaringreso_brutoActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//actividadeconomicaBeanSwingJInternalFrame.jTtoolBarActividadEconomica.setBorder(borderResaltar);
		
		this.resaltaringreso_brutoActividadEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso_brutoActividadEconomica() {
		return this.resaltaringreso_brutoActividadEconomica;
	}

	public void setResaltaringreso_brutoActividadEconomica(Border borderResaltar) {
		this.resaltaringreso_brutoActividadEconomica= borderResaltar;
	}

	public Boolean getMostraringreso_brutoActividadEconomica() {
		return this.mostraringreso_brutoActividadEconomica;
	}

	public void setMostraringreso_brutoActividadEconomica(Boolean mostraringreso_brutoActividadEconomica) {
		this.mostraringreso_brutoActividadEconomica= mostraringreso_brutoActividadEconomica;
	}

	public Boolean getActivaringreso_brutoActividadEconomica() {
		return this.activaringreso_brutoActividadEconomica;
	}

	public void setActivaringreso_brutoActividadEconomica(Boolean activaringreso_brutoActividadEconomica) {
		this.activaringreso_brutoActividadEconomica= activaringreso_brutoActividadEconomica;
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
		
		
		this.setMostraridActividadEconomica(esInicial);
		this.setMostrarid_empresaActividadEconomica(esInicial);
		this.setMostrarid_clienteActividadEconomica(esInicial);
		this.setMostrarnombre_negocioActividadEconomica(esInicial);
		this.setMostraractividadActividadEconomica(esInicial);
		this.setMostrarid_paisActividadEconomica(esInicial);
		this.setMostrarid_ciudadActividadEconomica(esInicial);
		this.setMostrardireccionActividadEconomica(esInicial);
		this.setMostrartelefonoActividadEconomica(esInicial);
		this.setMostraringreso_netoActividadEconomica(esInicial);
		this.setMostraringreso_brutoActividadEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ID)) {
				this.setMostraridActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO)) {
				this.setMostrarnombre_negocioActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ACTIVIDAD)) {
				this.setMostraractividadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESONETO)) {
				this.setMostraringreso_netoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESOBRUTO)) {
				this.setMostraringreso_brutoActividadEconomica(esAsigna);
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
		
		
		this.setActivaridActividadEconomica(esInicial);
		this.setActivarid_empresaActividadEconomica(esInicial);
		this.setActivarid_clienteActividadEconomica(esInicial);
		this.setActivarnombre_negocioActividadEconomica(esInicial);
		this.setActivaractividadActividadEconomica(esInicial);
		this.setActivarid_paisActividadEconomica(esInicial);
		this.setActivarid_ciudadActividadEconomica(esInicial);
		this.setActivardireccionActividadEconomica(esInicial);
		this.setActivartelefonoActividadEconomica(esInicial);
		this.setActivaringreso_netoActividadEconomica(esInicial);
		this.setActivaringreso_brutoActividadEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ID)) {
				this.setActivaridActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO)) {
				this.setActivarnombre_negocioActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ACTIVIDAD)) {
				this.setActivaractividadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESONETO)) {
				this.setActivaringreso_netoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESOBRUTO)) {
				this.setActivaringreso_brutoActividadEconomica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridActividadEconomica(esInicial);
		this.setResaltarid_empresaActividadEconomica(esInicial);
		this.setResaltarid_clienteActividadEconomica(esInicial);
		this.setResaltarnombre_negocioActividadEconomica(esInicial);
		this.setResaltaractividadActividadEconomica(esInicial);
		this.setResaltarid_paisActividadEconomica(esInicial);
		this.setResaltarid_ciudadActividadEconomica(esInicial);
		this.setResaltardireccionActividadEconomica(esInicial);
		this.setResaltartelefonoActividadEconomica(esInicial);
		this.setResaltaringreso_netoActividadEconomica(esInicial);
		this.setResaltaringreso_brutoActividadEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ID)) {
				this.setResaltaridActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO)) {
				this.setResaltarnombre_negocioActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.ACTIVIDAD)) {
				this.setResaltaractividadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESONETO)) {
				this.setResaltaringreso_netoActividadEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActividadEconomicaConstantesFunciones.INGRESOBRUTO)) {
				this.setResaltaringreso_brutoActividadEconomica(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadActividadEconomica=true;

	public Boolean getMostrarFK_IdCiudadActividadEconomica() {
		return this.mostrarFK_IdCiudadActividadEconomica;
	}

	public void setMostrarFK_IdCiudadActividadEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadActividadEconomica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteActividadEconomica=true;

	public Boolean getMostrarFK_IdClienteActividadEconomica() {
		return this.mostrarFK_IdClienteActividadEconomica;
	}

	public void setMostrarFK_IdClienteActividadEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteActividadEconomica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaActividadEconomica=true;

	public Boolean getMostrarFK_IdEmpresaActividadEconomica() {
		return this.mostrarFK_IdEmpresaActividadEconomica;
	}

	public void setMostrarFK_IdEmpresaActividadEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaActividadEconomica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisActividadEconomica=true;

	public Boolean getMostrarFK_IdPaisActividadEconomica() {
		return this.mostrarFK_IdPaisActividadEconomica;
	}

	public void setMostrarFK_IdPaisActividadEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisActividadEconomica= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadActividadEconomica=true;

	public Boolean getActivarFK_IdCiudadActividadEconomica() {
		return this.activarFK_IdCiudadActividadEconomica;
	}

	public void setActivarFK_IdCiudadActividadEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadActividadEconomica= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteActividadEconomica=true;

	public Boolean getActivarFK_IdClienteActividadEconomica() {
		return this.activarFK_IdClienteActividadEconomica;
	}

	public void setActivarFK_IdClienteActividadEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdClienteActividadEconomica= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaActividadEconomica=true;

	public Boolean getActivarFK_IdEmpresaActividadEconomica() {
		return this.activarFK_IdEmpresaActividadEconomica;
	}

	public void setActivarFK_IdEmpresaActividadEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaActividadEconomica= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisActividadEconomica=true;

	public Boolean getActivarFK_IdPaisActividadEconomica() {
		return this.activarFK_IdPaisActividadEconomica;
	}

	public void setActivarFK_IdPaisActividadEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdPaisActividadEconomica= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadActividadEconomica=null;

	public Border getResaltarFK_IdCiudadActividadEconomica() {
		return this.resaltarFK_IdCiudadActividadEconomica;
	}

	public void setResaltarFK_IdCiudadActividadEconomica(Border borderResaltar) {
		this.resaltarFK_IdCiudadActividadEconomica= borderResaltar;
	}

	public void setResaltarFK_IdCiudadActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadActividadEconomica= borderResaltar;
	}

	public Border resaltarFK_IdClienteActividadEconomica=null;

	public Border getResaltarFK_IdClienteActividadEconomica() {
		return this.resaltarFK_IdClienteActividadEconomica;
	}

	public void setResaltarFK_IdClienteActividadEconomica(Border borderResaltar) {
		this.resaltarFK_IdClienteActividadEconomica= borderResaltar;
	}

	public void setResaltarFK_IdClienteActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteActividadEconomica= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaActividadEconomica=null;

	public Border getResaltarFK_IdEmpresaActividadEconomica() {
		return this.resaltarFK_IdEmpresaActividadEconomica;
	}

	public void setResaltarFK_IdEmpresaActividadEconomica(Border borderResaltar) {
		this.resaltarFK_IdEmpresaActividadEconomica= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaActividadEconomica= borderResaltar;
	}

	public Border resaltarFK_IdPaisActividadEconomica=null;

	public Border getResaltarFK_IdPaisActividadEconomica() {
		return this.resaltarFK_IdPaisActividadEconomica;
	}

	public void setResaltarFK_IdPaisActividadEconomica(Border borderResaltar) {
		this.resaltarFK_IdPaisActividadEconomica= borderResaltar;
	}

	public void setResaltarFK_IdPaisActividadEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*ActividadEconomicaBeanSwingJInternalFrame actividadeconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisActividadEconomica= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}