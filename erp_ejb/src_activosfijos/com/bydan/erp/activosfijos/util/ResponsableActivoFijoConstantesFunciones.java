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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.ResponsableActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.ResponsableActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.ResponsableActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResponsableActivoFijoConstantesFunciones extends ResponsableActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ResponsableActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ResponsableActivoFijo"+ResponsableActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResponsableActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResponsableActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResponsableActivoFijoConstantesFunciones.SCHEMA+"_"+ResponsableActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResponsableActivoFijoConstantesFunciones.SCHEMA+"_"+ResponsableActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResponsableActivoFijoConstantesFunciones.SCHEMA+"_"+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResponsableActivoFijoConstantesFunciones.SCHEMA+"_"+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResponsableActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResponsableActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResponsableActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResponsableActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Responsable Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Responsable Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Responsable Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ResponsableActivoFijo";
	public static final String OBJECTNAME="responsableactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="responsable_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select responsableactivofijo from "+ResponsableActivoFijoConstantesFunciones.SPERSISTENCENAME+" responsableactivofijo";
	public static String QUERYSELECTNATIVE="select "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".version_row,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_estructura,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_empleado,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".ubicacion,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".fecha,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".descripcion from "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME;//+" as "+ResponsableActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ResponsableActivoFijoConstantesFuncionesAdditional responsableactivofijoConstantesFuncionesAdditional=null;
	
	public ResponsableActivoFijoConstantesFuncionesAdditional getResponsableActivoFijoConstantesFuncionesAdditional() {
		return this.responsableactivofijoConstantesFuncionesAdditional;
	}
	
	public void setResponsableActivoFijoConstantesFuncionesAdditional(ResponsableActivoFijoConstantesFuncionesAdditional responsableactivofijoConstantesFuncionesAdditional) {
		try {
			this.responsableactivofijoConstantesFuncionesAdditional=responsableactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String UBICACION= "ubicacion";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_UBICACION= "Ubicacion";
		public static final String LABEL_UBICACION_LOWER= "Ubicacion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXUBICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUBICACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getResponsableActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.UBICACION)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_UBICACION;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.FECHA)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ResponsableActivoFijoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ResponsableActivoFijoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getResponsableActivoFijoDescripcion(ResponsableActivoFijo responsableactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(responsableactivofijo !=null/* && responsableactivofijo.getId()!=0*/) {
			if(responsableactivofijo.getId()!=null) {
				sDescripcion=responsableactivofijo.getId().toString();
			}//responsableactivofijoresponsableactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getResponsableActivoFijoDescripcionDetallado(ResponsableActivoFijo responsableactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=responsableactivofijo.getId().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=responsableactivofijo.getVersionRow().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=responsableactivofijo.getid_empresa().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=responsableactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=responsableactivofijo.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=responsableactivofijo.getid_estructura().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=responsableactivofijo.getid_empleado().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.UBICACION+"=";
		sDescripcion+=responsableactivofijo.getubicacion()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.FECHA+"=";
		sDescripcion+=responsableactivofijo.getfecha().toString()+",";
		sDescripcion+=ResponsableActivoFijoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=responsableactivofijo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setResponsableActivoFijoDescripcion(ResponsableActivoFijo responsableactivofijo,String sValor) throws Exception {			
		if(responsableactivofijo !=null) {
			//responsableactivofijoresponsableactivofijo.getId().toString();
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

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsableactivofijo.setubicacion(responsableactivofijo.getubicacion().trim());
		responsableactivofijo.setdescripcion(responsableactivofijo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {
			responsableactivofijo.setubicacion(responsableactivofijo.getubicacion().trim());
			responsableactivofijo.setdescripcion(responsableactivofijo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && responsableactivofijo.getConCambioAuxiliar()) {
			responsableactivofijo.setIsDeleted(responsableactivofijo.getIsDeletedAuxiliar());	
			responsableactivofijo.setIsNew(responsableactivofijo.getIsNewAuxiliar());	
			responsableactivofijo.setIsChanged(responsableactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			responsableactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			responsableactivofijo.setIsDeletedAuxiliar(false);	
			responsableactivofijo.setIsNewAuxiliar(false);	
			responsableactivofijo.setIsChangedAuxiliar(false);
			
			responsableactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo : responsableactivofijos) {
			if(conAsignarBase && responsableactivofijo.getConCambioAuxiliar()) {
				responsableactivofijo.setIsDeleted(responsableactivofijo.getIsDeletedAuxiliar());	
				responsableactivofijo.setIsNew(responsableactivofijo.getIsNewAuxiliar());	
				responsableactivofijo.setIsChanged(responsableactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				responsableactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				responsableactivofijo.setIsDeletedAuxiliar(false);	
				responsableactivofijo.setIsNewAuxiliar(false);	
				responsableactivofijo.setIsChangedAuxiliar(false);
				
				responsableactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos,Boolean conEnteros) throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaResponsableActivoFijo(List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijo responsableactivofijoAux) throws Exception  {
		ResponsableActivoFijoConstantesFunciones.InicializarValoresResponsableActivoFijo(responsableactivofijoAux,true);
		
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {
			if(responsableactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsableActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResponsableActivoFijoConstantesFunciones.getArrayColumnasGlobalesResponsableActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsableActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResponsableActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijo responsableactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResponsableActivoFijo responsableactivofijoAux: responsableactivofijos) {
			if(responsableactivofijoAux!=null && responsableactivofijo!=null) {
				if((responsableactivofijoAux.getId()==null && responsableactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(responsableactivofijoAux.getId()!=null && responsableactivofijo.getId()!=null){
					if(responsableactivofijoAux.getId().equals(responsableactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsableActivoFijo(List<ResponsableActivoFijo> responsableactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {			
			if(responsableactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResponsableActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_ID, ResponsableActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_VERSIONROW, ResponsableActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPRESA, ResponsableActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, ResponsableActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_IDESTRUCTURA, ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPLEADO, ResponsableActivoFijoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_UBICACION, ResponsableActivoFijoConstantesFunciones.UBICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_FECHA, ResponsableActivoFijoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableActivoFijoConstantesFunciones.LABEL_DESCRIPCION, ResponsableActivoFijoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResponsableActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.UBICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableActivoFijoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableActivoFijo() throws Exception  {
		return ResponsableActivoFijoConstantesFunciones.getTiposSeleccionarResponsableActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableActivoFijo(Boolean conFk) throws Exception  {
		return ResponsableActivoFijoConstantesFunciones.getTiposSeleccionarResponsableActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_UBICACION);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_UBICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableActivoFijoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ResponsableActivoFijoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResponsableActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResponsableActivoFijo(ResponsableActivoFijo responsableactivofijoAux) throws Exception {
		
			responsableactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsableactivofijoAux.getEmpresa()));
			responsableactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsableactivofijoAux.getSucursal()));
			responsableactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(responsableactivofijoAux.getDetalleActivoFijo()));
			responsableactivofijoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(responsableactivofijoAux.getEstructura()));
			responsableactivofijoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(responsableactivofijoAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResponsableActivoFijo(List<ResponsableActivoFijo> responsableactivofijosTemp) throws Exception {
		for(ResponsableActivoFijo responsableactivofijoAux:responsableactivofijosTemp) {
			
			responsableactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsableactivofijoAux.getEmpresa()));
			responsableactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsableactivofijoAux.getSucursal()));
			responsableactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(responsableactivofijoAux.getDetalleActivoFijo()));
			responsableactivofijoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(responsableactivofijoAux.getEstructura()));
			responsableactivofijoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(responsableactivofijoAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResponsableActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResponsableActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableActivoFijoConstantesFunciones.getClassesRelationshipsOfResponsableActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsableActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfResponsableActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsableActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ResponsableActivoFijo responsableactivofijo,List<ResponsableActivoFijo> responsableactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ResponsableActivoFijo responsableactivofijoEncontrado=null;
			
			for(ResponsableActivoFijo responsableactivofijoLocal:responsableactivofijos) {
				if(responsableactivofijoLocal.getId().equals(responsableactivofijo.getId())) {
					responsableactivofijoEncontrado=responsableactivofijoLocal;
					
					responsableactivofijoLocal.setIsChanged(responsableactivofijo.getIsChanged());
					responsableactivofijoLocal.setIsNew(responsableactivofijo.getIsNew());
					responsableactivofijoLocal.setIsDeleted(responsableactivofijo.getIsDeleted());
					
					responsableactivofijoLocal.setGeneralEntityOriginal(responsableactivofijo.getGeneralEntityOriginal());
					
					responsableactivofijoLocal.setId(responsableactivofijo.getId());	
					responsableactivofijoLocal.setVersionRow(responsableactivofijo.getVersionRow());	
					responsableactivofijoLocal.setid_empresa(responsableactivofijo.getid_empresa());	
					responsableactivofijoLocal.setid_sucursal(responsableactivofijo.getid_sucursal());	
					responsableactivofijoLocal.setid_detalle_activo_fijo(responsableactivofijo.getid_detalle_activo_fijo());	
					responsableactivofijoLocal.setid_estructura(responsableactivofijo.getid_estructura());	
					responsableactivofijoLocal.setid_empleado(responsableactivofijo.getid_empleado());	
					responsableactivofijoLocal.setubicacion(responsableactivofijo.getubicacion());	
					responsableactivofijoLocal.setfecha(responsableactivofijo.getfecha());	
					responsableactivofijoLocal.setdescripcion(responsableactivofijo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!responsableactivofijo.getIsDeleted()) {
				if(!existe) {
					responsableactivofijos.add(responsableactivofijo);
				}
			} else {
				if(responsableactivofijoEncontrado!=null && permiteQuitar)  {
					responsableactivofijos.remove(responsableactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ResponsableActivoFijo responsableactivofijo,List<ResponsableActivoFijo> responsableactivofijos) throws Exception {
		try	{			
			for(ResponsableActivoFijo responsableactivofijoLocal:responsableactivofijos) {
				if(responsableactivofijoLocal.getId().equals(responsableactivofijo.getId())) {
					responsableactivofijoLocal.setIsSelected(responsableactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResponsableActivoFijo(List<ResponsableActivoFijo> responsableactivofijosAux) throws Exception {
		//this.responsableactivofijosAux=responsableactivofijosAux;
		
		for(ResponsableActivoFijo responsableactivofijoAux:responsableactivofijosAux) {
			if(responsableactivofijoAux.getIsChanged()) {
				responsableactivofijoAux.setIsChanged(false);
			}		
			
			if(responsableactivofijoAux.getIsNew()) {
				responsableactivofijoAux.setIsNew(false);
			}	
			
			if(responsableactivofijoAux.getIsDeleted()) {
				responsableactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResponsableActivoFijo(ResponsableActivoFijo responsableactivofijoAux) throws Exception {
		//this.responsableactivofijoAux=responsableactivofijoAux;
		
			if(responsableactivofijoAux.getIsChanged()) {
				responsableactivofijoAux.setIsChanged(false);
			}		
			
			if(responsableactivofijoAux.getIsNew()) {
				responsableactivofijoAux.setIsNew(false);
			}	
			
			if(responsableactivofijoAux.getIsDeleted()) {
				responsableactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ResponsableActivoFijo responsableactivofijoAsignar,ResponsableActivoFijo responsableactivofijo) throws Exception {
		responsableactivofijoAsignar.setId(responsableactivofijo.getId());	
		responsableactivofijoAsignar.setVersionRow(responsableactivofijo.getVersionRow());	
		responsableactivofijoAsignar.setid_empresa(responsableactivofijo.getid_empresa());
		responsableactivofijoAsignar.setempresa_descripcion(responsableactivofijo.getempresa_descripcion());	
		responsableactivofijoAsignar.setid_sucursal(responsableactivofijo.getid_sucursal());
		responsableactivofijoAsignar.setsucursal_descripcion(responsableactivofijo.getsucursal_descripcion());	
		responsableactivofijoAsignar.setid_detalle_activo_fijo(responsableactivofijo.getid_detalle_activo_fijo());
		responsableactivofijoAsignar.setdetalleactivofijo_descripcion(responsableactivofijo.getdetalleactivofijo_descripcion());	
		responsableactivofijoAsignar.setid_estructura(responsableactivofijo.getid_estructura());
		responsableactivofijoAsignar.setestructura_descripcion(responsableactivofijo.getestructura_descripcion());	
		responsableactivofijoAsignar.setid_empleado(responsableactivofijo.getid_empleado());
		responsableactivofijoAsignar.setempleado_descripcion(responsableactivofijo.getempleado_descripcion());	
		responsableactivofijoAsignar.setubicacion(responsableactivofijo.getubicacion());	
		responsableactivofijoAsignar.setfecha(responsableactivofijo.getfecha());	
		responsableactivofijoAsignar.setdescripcion(responsableactivofijo.getdescripcion());	
	}
	
	public static void inicializarResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo) throws Exception {
		try {
				responsableactivofijo.setId(0L);	
					
				responsableactivofijo.setid_empresa(-1L);	
				responsableactivofijo.setid_sucursal(-1L);	
				responsableactivofijo.setid_detalle_activo_fijo(-1L);	
				responsableactivofijo.setid_estructura(-1L);	
				responsableactivofijo.setid_empleado(-1L);	
				responsableactivofijo.setubicacion("");	
				responsableactivofijo.setfecha(new Date());	
				responsableactivofijo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResponsableActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_UBICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableActivoFijoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResponsableActivoFijo(String sTipo,Row row,Workbook workbook,ResponsableActivoFijo responsableactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getubicacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsableactivofijo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResponsableActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryResponsableActivoFijo() {
		return this.sFinalQueryResponsableActivoFijo;
	}
	
	public void setsFinalQueryResponsableActivoFijo(String sFinalQueryResponsableActivoFijo) {
		this.sFinalQueryResponsableActivoFijo= sFinalQueryResponsableActivoFijo;
	}
	
	public Border resaltarSeleccionarResponsableActivoFijo=null;
	
	public Border setResaltarSeleccionarResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResponsableActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResponsableActivoFijo() {
		return this.resaltarSeleccionarResponsableActivoFijo;
	}
	
	public void setResaltarSeleccionarResponsableActivoFijo(Border borderResaltarSeleccionarResponsableActivoFijo) {
		this.resaltarSeleccionarResponsableActivoFijo= borderResaltarSeleccionarResponsableActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResponsableActivoFijo=null;
	public Boolean mostraridResponsableActivoFijo=true;
	public Boolean activaridResponsableActivoFijo=true;

	public Border resaltarid_empresaResponsableActivoFijo=null;
	public Boolean mostrarid_empresaResponsableActivoFijo=true;
	public Boolean activarid_empresaResponsableActivoFijo=true;
	public Boolean cargarid_empresaResponsableActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaResponsableActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalResponsableActivoFijo=null;
	public Boolean mostrarid_sucursalResponsableActivoFijo=true;
	public Boolean activarid_sucursalResponsableActivoFijo=true;
	public Boolean cargarid_sucursalResponsableActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalResponsableActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoResponsableActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijoResponsableActivoFijo=true;
	public Boolean activarid_detalle_activo_fijoResponsableActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijoResponsableActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoResponsableActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_estructuraResponsableActivoFijo=null;
	public Boolean mostrarid_estructuraResponsableActivoFijo=true;
	public Boolean activarid_estructuraResponsableActivoFijo=true;
	public Boolean cargarid_estructuraResponsableActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraResponsableActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_empleadoResponsableActivoFijo=null;
	public Boolean mostrarid_empleadoResponsableActivoFijo=true;
	public Boolean activarid_empleadoResponsableActivoFijo=true;
	public Boolean cargarid_empleadoResponsableActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoResponsableActivoFijo=false;//ConEventDepend=true

	public Border resaltarubicacionResponsableActivoFijo=null;
	public Boolean mostrarubicacionResponsableActivoFijo=true;
	public Boolean activarubicacionResponsableActivoFijo=true;

	public Border resaltarfechaResponsableActivoFijo=null;
	public Boolean mostrarfechaResponsableActivoFijo=true;
	public Boolean activarfechaResponsableActivoFijo=false;

	public Border resaltardescripcionResponsableActivoFijo=null;
	public Boolean mostrardescripcionResponsableActivoFijo=true;
	public Boolean activardescripcionResponsableActivoFijo=true;

	
	

	public Border setResaltaridResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResponsableActivoFijo() {
		return this.resaltaridResponsableActivoFijo;
	}

	public void setResaltaridResponsableActivoFijo(Border borderResaltar) {
		this.resaltaridResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostraridResponsableActivoFijo() {
		return this.mostraridResponsableActivoFijo;
	}

	public void setMostraridResponsableActivoFijo(Boolean mostraridResponsableActivoFijo) {
		this.mostraridResponsableActivoFijo= mostraridResponsableActivoFijo;
	}

	public Boolean getActivaridResponsableActivoFijo() {
		return this.activaridResponsableActivoFijo;
	}

	public void setActivaridResponsableActivoFijo(Boolean activaridResponsableActivoFijo) {
		this.activaridResponsableActivoFijo= activaridResponsableActivoFijo;
	}

	public Border setResaltarid_empresaResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaResponsableActivoFijo() {
		return this.resaltarid_empresaResponsableActivoFijo;
	}

	public void setResaltarid_empresaResponsableActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaResponsableActivoFijo() {
		return this.mostrarid_empresaResponsableActivoFijo;
	}

	public void setMostrarid_empresaResponsableActivoFijo(Boolean mostrarid_empresaResponsableActivoFijo) {
		this.mostrarid_empresaResponsableActivoFijo= mostrarid_empresaResponsableActivoFijo;
	}

	public Boolean getActivarid_empresaResponsableActivoFijo() {
		return this.activarid_empresaResponsableActivoFijo;
	}

	public void setActivarid_empresaResponsableActivoFijo(Boolean activarid_empresaResponsableActivoFijo) {
		this.activarid_empresaResponsableActivoFijo= activarid_empresaResponsableActivoFijo;
	}

	public Boolean getCargarid_empresaResponsableActivoFijo() {
		return this.cargarid_empresaResponsableActivoFijo;
	}

	public void setCargarid_empresaResponsableActivoFijo(Boolean cargarid_empresaResponsableActivoFijo) {
		this.cargarid_empresaResponsableActivoFijo= cargarid_empresaResponsableActivoFijo;
	}

	public Border setResaltarid_sucursalResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalResponsableActivoFijo() {
		return this.resaltarid_sucursalResponsableActivoFijo;
	}

	public void setResaltarid_sucursalResponsableActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalResponsableActivoFijo() {
		return this.mostrarid_sucursalResponsableActivoFijo;
	}

	public void setMostrarid_sucursalResponsableActivoFijo(Boolean mostrarid_sucursalResponsableActivoFijo) {
		this.mostrarid_sucursalResponsableActivoFijo= mostrarid_sucursalResponsableActivoFijo;
	}

	public Boolean getActivarid_sucursalResponsableActivoFijo() {
		return this.activarid_sucursalResponsableActivoFijo;
	}

	public void setActivarid_sucursalResponsableActivoFijo(Boolean activarid_sucursalResponsableActivoFijo) {
		this.activarid_sucursalResponsableActivoFijo= activarid_sucursalResponsableActivoFijo;
	}

	public Boolean getCargarid_sucursalResponsableActivoFijo() {
		return this.cargarid_sucursalResponsableActivoFijo;
	}

	public void setCargarid_sucursalResponsableActivoFijo(Boolean cargarid_sucursalResponsableActivoFijo) {
		this.cargarid_sucursalResponsableActivoFijo= cargarid_sucursalResponsableActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijoResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoResponsableActivoFijo() {
		return this.resaltarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijoResponsableActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoResponsableActivoFijo() {
		return this.mostrarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijoResponsableActivoFijo(Boolean mostrarid_detalle_activo_fijoResponsableActivoFijo) {
		this.mostrarid_detalle_activo_fijoResponsableActivoFijo= mostrarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijoResponsableActivoFijo() {
		return this.activarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public void setActivarid_detalle_activo_fijoResponsableActivoFijo(Boolean activarid_detalle_activo_fijoResponsableActivoFijo) {
		this.activarid_detalle_activo_fijoResponsableActivoFijo= activarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijoResponsableActivoFijo() {
		return this.cargarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public void setCargarid_detalle_activo_fijoResponsableActivoFijo(Boolean cargarid_detalle_activo_fijoResponsableActivoFijo) {
		this.cargarid_detalle_activo_fijoResponsableActivoFijo= cargarid_detalle_activo_fijoResponsableActivoFijo;
	}

	public Border setResaltarid_estructuraResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_estructuraResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraResponsableActivoFijo() {
		return this.resaltarid_estructuraResponsableActivoFijo;
	}

	public void setResaltarid_estructuraResponsableActivoFijo(Border borderResaltar) {
		this.resaltarid_estructuraResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_estructuraResponsableActivoFijo() {
		return this.mostrarid_estructuraResponsableActivoFijo;
	}

	public void setMostrarid_estructuraResponsableActivoFijo(Boolean mostrarid_estructuraResponsableActivoFijo) {
		this.mostrarid_estructuraResponsableActivoFijo= mostrarid_estructuraResponsableActivoFijo;
	}

	public Boolean getActivarid_estructuraResponsableActivoFijo() {
		return this.activarid_estructuraResponsableActivoFijo;
	}

	public void setActivarid_estructuraResponsableActivoFijo(Boolean activarid_estructuraResponsableActivoFijo) {
		this.activarid_estructuraResponsableActivoFijo= activarid_estructuraResponsableActivoFijo;
	}

	public Boolean getCargarid_estructuraResponsableActivoFijo() {
		return this.cargarid_estructuraResponsableActivoFijo;
	}

	public void setCargarid_estructuraResponsableActivoFijo(Boolean cargarid_estructuraResponsableActivoFijo) {
		this.cargarid_estructuraResponsableActivoFijo= cargarid_estructuraResponsableActivoFijo;
	}

	public Border setResaltarid_empleadoResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empleadoResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoResponsableActivoFijo() {
		return this.resaltarid_empleadoResponsableActivoFijo;
	}

	public void setResaltarid_empleadoResponsableActivoFijo(Border borderResaltar) {
		this.resaltarid_empleadoResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empleadoResponsableActivoFijo() {
		return this.mostrarid_empleadoResponsableActivoFijo;
	}

	public void setMostrarid_empleadoResponsableActivoFijo(Boolean mostrarid_empleadoResponsableActivoFijo) {
		this.mostrarid_empleadoResponsableActivoFijo= mostrarid_empleadoResponsableActivoFijo;
	}

	public Boolean getActivarid_empleadoResponsableActivoFijo() {
		return this.activarid_empleadoResponsableActivoFijo;
	}

	public void setActivarid_empleadoResponsableActivoFijo(Boolean activarid_empleadoResponsableActivoFijo) {
		this.activarid_empleadoResponsableActivoFijo= activarid_empleadoResponsableActivoFijo;
	}

	public Boolean getCargarid_empleadoResponsableActivoFijo() {
		return this.cargarid_empleadoResponsableActivoFijo;
	}

	public void setCargarid_empleadoResponsableActivoFijo(Boolean cargarid_empleadoResponsableActivoFijo) {
		this.cargarid_empleadoResponsableActivoFijo= cargarid_empleadoResponsableActivoFijo;
	}

	public Border setResaltarubicacionResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarubicacionResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarubicacionResponsableActivoFijo() {
		return this.resaltarubicacionResponsableActivoFijo;
	}

	public void setResaltarubicacionResponsableActivoFijo(Border borderResaltar) {
		this.resaltarubicacionResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarubicacionResponsableActivoFijo() {
		return this.mostrarubicacionResponsableActivoFijo;
	}

	public void setMostrarubicacionResponsableActivoFijo(Boolean mostrarubicacionResponsableActivoFijo) {
		this.mostrarubicacionResponsableActivoFijo= mostrarubicacionResponsableActivoFijo;
	}

	public Boolean getActivarubicacionResponsableActivoFijo() {
		return this.activarubicacionResponsableActivoFijo;
	}

	public void setActivarubicacionResponsableActivoFijo(Boolean activarubicacionResponsableActivoFijo) {
		this.activarubicacionResponsableActivoFijo= activarubicacionResponsableActivoFijo;
	}

	public Border setResaltarfechaResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfechaResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaResponsableActivoFijo() {
		return this.resaltarfechaResponsableActivoFijo;
	}

	public void setResaltarfechaResponsableActivoFijo(Border borderResaltar) {
		this.resaltarfechaResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfechaResponsableActivoFijo() {
		return this.mostrarfechaResponsableActivoFijo;
	}

	public void setMostrarfechaResponsableActivoFijo(Boolean mostrarfechaResponsableActivoFijo) {
		this.mostrarfechaResponsableActivoFijo= mostrarfechaResponsableActivoFijo;
	}

	public Boolean getActivarfechaResponsableActivoFijo() {
		return this.activarfechaResponsableActivoFijo;
	}

	public void setActivarfechaResponsableActivoFijo(Boolean activarfechaResponsableActivoFijo) {
		this.activarfechaResponsableActivoFijo= activarfechaResponsableActivoFijo;
	}

	public Border setResaltardescripcionResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableactivofijoBeanSwingJInternalFrame.jTtoolBarResponsableActivoFijo.setBorder(borderResaltar);
		
		this.resaltardescripcionResponsableActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionResponsableActivoFijo() {
		return this.resaltardescripcionResponsableActivoFijo;
	}

	public void setResaltardescripcionResponsableActivoFijo(Border borderResaltar) {
		this.resaltardescripcionResponsableActivoFijo= borderResaltar;
	}

	public Boolean getMostrardescripcionResponsableActivoFijo() {
		return this.mostrardescripcionResponsableActivoFijo;
	}

	public void setMostrardescripcionResponsableActivoFijo(Boolean mostrardescripcionResponsableActivoFijo) {
		this.mostrardescripcionResponsableActivoFijo= mostrardescripcionResponsableActivoFijo;
	}

	public Boolean getActivardescripcionResponsableActivoFijo() {
		return this.activardescripcionResponsableActivoFijo;
	}

	public void setActivardescripcionResponsableActivoFijo(Boolean activardescripcionResponsableActivoFijo) {
		this.activardescripcionResponsableActivoFijo= activardescripcionResponsableActivoFijo;
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
		
		
		this.setMostraridResponsableActivoFijo(esInicial);
		this.setMostrarid_empresaResponsableActivoFijo(esInicial);
		this.setMostrarid_sucursalResponsableActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijoResponsableActivoFijo(esInicial);
		this.setMostrarid_estructuraResponsableActivoFijo(esInicial);
		this.setMostrarid_empleadoResponsableActivoFijo(esInicial);
		this.setMostrarubicacionResponsableActivoFijo(esInicial);
		this.setMostrarfechaResponsableActivoFijo(esInicial);
		this.setMostrardescripcionResponsableActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.ID)) {
				this.setMostraridResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.UBICACION)) {
				this.setMostrarubicacionResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.FECHA)) {
				this.setMostrarfechaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionResponsableActivoFijo(esAsigna);
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
		
		
		this.setActivaridResponsableActivoFijo(esInicial);
		this.setActivarid_empresaResponsableActivoFijo(esInicial);
		this.setActivarid_sucursalResponsableActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijoResponsableActivoFijo(esInicial);
		this.setActivarid_estructuraResponsableActivoFijo(esInicial);
		this.setActivarid_empleadoResponsableActivoFijo(esInicial);
		this.setActivarubicacionResponsableActivoFijo(esInicial);
		this.setActivarfechaResponsableActivoFijo(esInicial);
		this.setActivardescripcionResponsableActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.ID)) {
				this.setActivaridResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.UBICACION)) {
				this.setActivarubicacionResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.FECHA)) {
				this.setActivarfechaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionResponsableActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResponsableActivoFijo(esInicial);
		this.setResaltarid_empresaResponsableActivoFijo(esInicial);
		this.setResaltarid_sucursalResponsableActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijoResponsableActivoFijo(esInicial);
		this.setResaltarid_estructuraResponsableActivoFijo(esInicial);
		this.setResaltarid_empleadoResponsableActivoFijo(esInicial);
		this.setResaltarubicacionResponsableActivoFijo(esInicial);
		this.setResaltarfechaResponsableActivoFijo(esInicial);
		this.setResaltardescripcionResponsableActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.UBICACION)) {
				this.setResaltarubicacionResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.FECHA)) {
				this.setResaltarfechaResponsableActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionResponsableActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDetalleActivoFijoResponsableActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoResponsableActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoResponsableActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoResponsableActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoResponsableActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoResponsableActivoFijo=true;

	public Boolean getMostrarFK_IdEmpleadoResponsableActivoFijo() {
		return this.mostrarFK_IdEmpleadoResponsableActivoFijo;
	}

	public void setMostrarFK_IdEmpleadoResponsableActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoResponsableActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaResponsableActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaResponsableActivoFijo() {
		return this.mostrarFK_IdEmpresaResponsableActivoFijo;
	}

	public void setMostrarFK_IdEmpresaResponsableActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaResponsableActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraResponsableActivoFijo=true;

	public Boolean getMostrarFK_IdEstructuraResponsableActivoFijo() {
		return this.mostrarFK_IdEstructuraResponsableActivoFijo;
	}

	public void setMostrarFK_IdEstructuraResponsableActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraResponsableActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalResponsableActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalResponsableActivoFijo() {
		return this.mostrarFK_IdSucursalResponsableActivoFijo;
	}

	public void setMostrarFK_IdSucursalResponsableActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalResponsableActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleActivoFijoResponsableActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoResponsableActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoResponsableActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoResponsableActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoResponsableActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoResponsableActivoFijo=true;

	public Boolean getActivarFK_IdEmpleadoResponsableActivoFijo() {
		return this.activarFK_IdEmpleadoResponsableActivoFijo;
	}

	public void setActivarFK_IdEmpleadoResponsableActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoResponsableActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaResponsableActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaResponsableActivoFijo() {
		return this.activarFK_IdEmpresaResponsableActivoFijo;
	}

	public void setActivarFK_IdEmpresaResponsableActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaResponsableActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraResponsableActivoFijo=true;

	public Boolean getActivarFK_IdEstructuraResponsableActivoFijo() {
		return this.activarFK_IdEstructuraResponsableActivoFijo;
	}

	public void setActivarFK_IdEstructuraResponsableActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraResponsableActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalResponsableActivoFijo=true;

	public Boolean getActivarFK_IdSucursalResponsableActivoFijo() {
		return this.activarFK_IdSucursalResponsableActivoFijo;
	}

	public void setActivarFK_IdSucursalResponsableActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalResponsableActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleActivoFijoResponsableActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoResponsableActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoResponsableActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoResponsableActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoResponsableActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoResponsableActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoResponsableActivoFijo=null;

	public Border getResaltarFK_IdEmpleadoResponsableActivoFijo() {
		return this.resaltarFK_IdEmpleadoResponsableActivoFijo;
	}

	public void setResaltarFK_IdEmpleadoResponsableActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoResponsableActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoResponsableActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaResponsableActivoFijo=null;

	public Border getResaltarFK_IdEmpresaResponsableActivoFijo() {
		return this.resaltarFK_IdEmpresaResponsableActivoFijo;
	}

	public void setResaltarFK_IdEmpresaResponsableActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaResponsableActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaResponsableActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraResponsableActivoFijo=null;

	public Border getResaltarFK_IdEstructuraResponsableActivoFijo() {
		return this.resaltarFK_IdEstructuraResponsableActivoFijo;
	}

	public void setResaltarFK_IdEstructuraResponsableActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEstructuraResponsableActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraResponsableActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalResponsableActivoFijo=null;

	public Border getResaltarFK_IdSucursalResponsableActivoFijo() {
		return this.resaltarFK_IdSucursalResponsableActivoFijo;
	}

	public void setResaltarFK_IdSucursalResponsableActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalResponsableActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalResponsableActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableActivoFijoBeanSwingJInternalFrame responsableactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalResponsableActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}