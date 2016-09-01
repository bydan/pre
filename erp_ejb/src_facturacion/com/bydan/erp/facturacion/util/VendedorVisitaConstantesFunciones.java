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


import com.bydan.erp.facturacion.util.VendedorVisitaConstantesFunciones;
import com.bydan.erp.facturacion.util.VendedorVisitaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VendedorVisitaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VendedorVisitaConstantesFunciones extends VendedorVisitaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VendedorVisita";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VendedorVisita"+VendedorVisitaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VendedorVisitaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VendedorVisitaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VendedorVisitaConstantesFunciones.SCHEMA+"_"+VendedorVisitaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VendedorVisitaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VendedorVisitaConstantesFunciones.SCHEMA+"_"+VendedorVisitaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VendedorVisitaConstantesFunciones.SCHEMA+"_"+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VendedorVisitaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VendedorVisitaConstantesFunciones.SCHEMA+"_"+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorVisitaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorVisitaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorVisitaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VendedorVisitaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VendedorVisitaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VendedorVisitaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VendedorVisitaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vendedor Visitas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vendedor Visita";
	public static final String SCLASSWEBTITULO_LOWER="Vendedor Visita";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VendedorVisita";
	public static final String OBJECTNAME="vendedorvisita";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="vendedor_visita";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vendedorvisita from "+VendedorVisitaConstantesFunciones.SPERSISTENCENAME+" vendedorvisita";
	public static String QUERYSELECTNATIVE="select "+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".version_row,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_empresa,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_ejercicio,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_periodo,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_vendedor,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".visita_real,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".visita_propuesta,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_anio,"+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME+".id_mes from "+VendedorVisitaConstantesFunciones.SCHEMA+"."+VendedorVisitaConstantesFunciones.TABLENAME;//+" as "+VendedorVisitaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VendedorVisitaConstantesFuncionesAdditional vendedorvisitaConstantesFuncionesAdditional=null;
	
	public VendedorVisitaConstantesFuncionesAdditional getVendedorVisitaConstantesFuncionesAdditional() {
		return this.vendedorvisitaConstantesFuncionesAdditional;
	}
	
	public void setVendedorVisitaConstantesFuncionesAdditional(VendedorVisitaConstantesFuncionesAdditional vendedorvisitaConstantesFuncionesAdditional) {
		try {
			this.vendedorvisitaConstantesFuncionesAdditional=vendedorvisitaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String VISITAREAL= "visita_real";
    public static final String VISITAPROPUESTA= "visita_propuesta";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_VISITAREAL= "Visita Real";
		public static final String LABEL_VISITAREAL_LOWER= "Visita Real";
    	public static final String LABEL_VISITAPROPUESTA= "Visita Propuesta";
		public static final String LABEL_VISITAPROPUESTA_LOWER= "Visita Propuesta";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getVendedorVisitaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDPERIODO)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.VISITAREAL)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_VISITAREAL;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.VISITAPROPUESTA)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDANIO)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(VendedorVisitaConstantesFunciones.IDMES)) {sLabelColumna=VendedorVisitaConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getVendedorVisitaDescripcion(VendedorVisita vendedorvisita) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vendedorvisita !=null/* && vendedorvisita.getId()!=0*/) {
			if(vendedorvisita.getId()!=null) {
				sDescripcion=vendedorvisita.getId().toString();
			}//vendedorvisitavendedorvisita.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVendedorVisitaDescripcionDetallado(VendedorVisita vendedorvisita) {
		String sDescripcion="";
			
		sDescripcion+=VendedorVisitaConstantesFunciones.ID+"=";
		sDescripcion+=vendedorvisita.getId().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vendedorvisita.getVersionRow().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vendedorvisita.getid_empresa().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=vendedorvisita.getid_ejercicio().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=vendedorvisita.getid_periodo().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=vendedorvisita.getid_vendedor().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.VISITAREAL+"=";
		sDescripcion+=vendedorvisita.getvisita_real().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.VISITAPROPUESTA+"=";
		sDescripcion+=vendedorvisita.getvisita_propuesta().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDANIO+"=";
		sDescripcion+=vendedorvisita.getid_anio().toString()+",";
		sDescripcion+=VendedorVisitaConstantesFunciones.IDMES+"=";
		sDescripcion+=vendedorvisita.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVendedorVisitaDescripcion(VendedorVisita vendedorvisita,String sValor) throws Exception {			
		if(vendedorvisita !=null) {
			//vendedorvisitavendedorvisita.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVendedorVisita(VendedorVisita vendedorvisita,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosVendedorVisitas(List<VendedorVisita> vendedorvisitas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VendedorVisita vendedorvisita: vendedorvisitas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedorVisita(VendedorVisita vendedorvisita,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vendedorvisita.getConCambioAuxiliar()) {
			vendedorvisita.setIsDeleted(vendedorvisita.getIsDeletedAuxiliar());	
			vendedorvisita.setIsNew(vendedorvisita.getIsNewAuxiliar());	
			vendedorvisita.setIsChanged(vendedorvisita.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vendedorvisita.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vendedorvisita.setIsDeletedAuxiliar(false);	
			vendedorvisita.setIsNewAuxiliar(false);	
			vendedorvisita.setIsChangedAuxiliar(false);
			
			vendedorvisita.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedorVisitas(List<VendedorVisita> vendedorvisitas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VendedorVisita vendedorvisita : vendedorvisitas) {
			if(conAsignarBase && vendedorvisita.getConCambioAuxiliar()) {
				vendedorvisita.setIsDeleted(vendedorvisita.getIsDeletedAuxiliar());	
				vendedorvisita.setIsNew(vendedorvisita.getIsNewAuxiliar());	
				vendedorvisita.setIsChanged(vendedorvisita.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vendedorvisita.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vendedorvisita.setIsDeletedAuxiliar(false);	
				vendedorvisita.setIsNewAuxiliar(false);	
				vendedorvisita.setIsChangedAuxiliar(false);
				
				vendedorvisita.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVendedorVisita(VendedorVisita vendedorvisita,Boolean conEnteros) throws Exception  {
		vendedorvisita.setvisita_real(0.0);
		vendedorvisita.setvisita_propuesta(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVendedorVisitas(List<VendedorVisita> vendedorvisitas,Boolean conEnteros) throws Exception  {
		
		for(VendedorVisita vendedorvisita: vendedorvisitas) {
			vendedorvisita.setvisita_real(0.0);
			vendedorvisita.setvisita_propuesta(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVendedorVisita(List<VendedorVisita> vendedorvisitas,VendedorVisita vendedorvisitaAux) throws Exception  {
		VendedorVisitaConstantesFunciones.InicializarValoresVendedorVisita(vendedorvisitaAux,true);
		
		for(VendedorVisita vendedorvisita: vendedorvisitas) {
			if(vendedorvisita.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vendedorvisitaAux.setvisita_real(vendedorvisitaAux.getvisita_real()+vendedorvisita.getvisita_real());			
			vendedorvisitaAux.setvisita_propuesta(vendedorvisitaAux.getvisita_propuesta()+vendedorvisita.getvisita_propuesta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedorVisita(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VendedorVisitaConstantesFunciones.getArrayColumnasGlobalesVendedorVisita(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedorVisita(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorVisitaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorVisitaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorVisitaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorVisitaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorVisitaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorVisitaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVendedorVisita(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VendedorVisitaConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(VendedorVisitaConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VendedorVisita> vendedorvisitas,VendedorVisita vendedorvisita,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VendedorVisita vendedorvisitaAux: vendedorvisitas) {
			if(vendedorvisitaAux!=null && vendedorvisita!=null) {
				if((vendedorvisitaAux.getId()==null && vendedorvisita.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vendedorvisitaAux.getId()!=null && vendedorvisita.getId()!=null){
					if(vendedorvisitaAux.getId().equals(vendedorvisita.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVendedorVisita(List<VendedorVisita> vendedorvisitas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double visita_realTotal=0.0;
		Double visita_propuestaTotal=0.0;
	
		for(VendedorVisita vendedorvisita: vendedorvisitas) {			
			if(vendedorvisita.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			visita_realTotal+=vendedorvisita.getvisita_real();
			visita_propuestaTotal+=vendedorvisita.getvisita_propuesta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorVisitaConstantesFunciones.VISITAREAL);
		datoGeneral.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_VISITAREAL);
		datoGeneral.setdValorDouble(visita_realTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorVisitaConstantesFunciones.VISITAPROPUESTA);
		datoGeneral.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA);
		datoGeneral.setdValorDouble(visita_propuestaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVendedorVisita() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_ID, VendedorVisitaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_VERSIONROW, VendedorVisitaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDEMPRESA, VendedorVisitaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDEJERCICIO, VendedorVisitaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDPERIODO, VendedorVisitaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDVENDEDOR, VendedorVisitaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_VISITAREAL, VendedorVisitaConstantesFunciones.VISITAREAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA, VendedorVisitaConstantesFunciones.VISITAPROPUESTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDANIO, VendedorVisitaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorVisitaConstantesFunciones.LABEL_IDMES, VendedorVisitaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVendedorVisita() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.VISITAREAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.VISITAPROPUESTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorVisitaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorVisita() throws Exception  {
		return VendedorVisitaConstantesFunciones.getTiposSeleccionarVendedorVisita(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorVisita(Boolean conFk) throws Exception  {
		return VendedorVisitaConstantesFunciones.getTiposSeleccionarVendedorVisita(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorVisita(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_VISITAREAL);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_VISITAREAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorVisitaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(VendedorVisitaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVendedorVisita(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVendedorVisita(VendedorVisita vendedorvisitaAux) throws Exception {
		
			vendedorvisitaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorvisitaAux.getEmpresa()));
			vendedorvisitaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(vendedorvisitaAux.getEjercicio()));
			vendedorvisitaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(vendedorvisitaAux.getPeriodo()));
			vendedorvisitaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorvisitaAux.getVendedor()));
			vendedorvisitaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(vendedorvisitaAux.getAnio()));
			vendedorvisitaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(vendedorvisitaAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVendedorVisita(List<VendedorVisita> vendedorvisitasTemp) throws Exception {
		for(VendedorVisita vendedorvisitaAux:vendedorvisitasTemp) {
			
			vendedorvisitaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorvisitaAux.getEmpresa()));
			vendedorvisitaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(vendedorvisitaAux.getEjercicio()));
			vendedorvisitaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(vendedorvisitaAux.getPeriodo()));
			vendedorvisitaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorvisitaAux.getVendedor()));
			vendedorvisitaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(vendedorvisitaAux.getAnio()));
			vendedorvisitaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(vendedorvisitaAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVendedorVisita(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVendedorVisita(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedorVisita(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorVisitaConstantesFunciones.getClassesRelationshipsOfVendedorVisita(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedorVisita(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedorVisita(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorVisitaConstantesFunciones.getClassesRelationshipsFromStringsOfVendedorVisita(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedorVisita(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VendedorVisita vendedorvisita,List<VendedorVisita> vendedorvisitas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VendedorVisita vendedorvisitaEncontrado=null;
			
			for(VendedorVisita vendedorvisitaLocal:vendedorvisitas) {
				if(vendedorvisitaLocal.getId().equals(vendedorvisita.getId())) {
					vendedorvisitaEncontrado=vendedorvisitaLocal;
					
					vendedorvisitaLocal.setIsChanged(vendedorvisita.getIsChanged());
					vendedorvisitaLocal.setIsNew(vendedorvisita.getIsNew());
					vendedorvisitaLocal.setIsDeleted(vendedorvisita.getIsDeleted());
					
					vendedorvisitaLocal.setGeneralEntityOriginal(vendedorvisita.getGeneralEntityOriginal());
					
					vendedorvisitaLocal.setId(vendedorvisita.getId());	
					vendedorvisitaLocal.setVersionRow(vendedorvisita.getVersionRow());	
					vendedorvisitaLocal.setid_empresa(vendedorvisita.getid_empresa());	
					vendedorvisitaLocal.setid_ejercicio(vendedorvisita.getid_ejercicio());	
					vendedorvisitaLocal.setid_periodo(vendedorvisita.getid_periodo());	
					vendedorvisitaLocal.setid_vendedor(vendedorvisita.getid_vendedor());	
					vendedorvisitaLocal.setvisita_real(vendedorvisita.getvisita_real());	
					vendedorvisitaLocal.setvisita_propuesta(vendedorvisita.getvisita_propuesta());	
					vendedorvisitaLocal.setid_anio(vendedorvisita.getid_anio());	
					vendedorvisitaLocal.setid_mes(vendedorvisita.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!vendedorvisita.getIsDeleted()) {
				if(!existe) {
					vendedorvisitas.add(vendedorvisita);
				}
			} else {
				if(vendedorvisitaEncontrado!=null && permiteQuitar)  {
					vendedorvisitas.remove(vendedorvisitaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VendedorVisita vendedorvisita,List<VendedorVisita> vendedorvisitas) throws Exception {
		try	{			
			for(VendedorVisita vendedorvisitaLocal:vendedorvisitas) {
				if(vendedorvisitaLocal.getId().equals(vendedorvisita.getId())) {
					vendedorvisitaLocal.setIsSelected(vendedorvisita.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVendedorVisita(List<VendedorVisita> vendedorvisitasAux) throws Exception {
		//this.vendedorvisitasAux=vendedorvisitasAux;
		
		for(VendedorVisita vendedorvisitaAux:vendedorvisitasAux) {
			if(vendedorvisitaAux.getIsChanged()) {
				vendedorvisitaAux.setIsChanged(false);
			}		
			
			if(vendedorvisitaAux.getIsNew()) {
				vendedorvisitaAux.setIsNew(false);
			}	
			
			if(vendedorvisitaAux.getIsDeleted()) {
				vendedorvisitaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVendedorVisita(VendedorVisita vendedorvisitaAux) throws Exception {
		//this.vendedorvisitaAux=vendedorvisitaAux;
		
			if(vendedorvisitaAux.getIsChanged()) {
				vendedorvisitaAux.setIsChanged(false);
			}		
			
			if(vendedorvisitaAux.getIsNew()) {
				vendedorvisitaAux.setIsNew(false);
			}	
			
			if(vendedorvisitaAux.getIsDeleted()) {
				vendedorvisitaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VendedorVisita vendedorvisitaAsignar,VendedorVisita vendedorvisita) throws Exception {
		vendedorvisitaAsignar.setId(vendedorvisita.getId());	
		vendedorvisitaAsignar.setVersionRow(vendedorvisita.getVersionRow());	
		vendedorvisitaAsignar.setid_empresa(vendedorvisita.getid_empresa());
		vendedorvisitaAsignar.setempresa_descripcion(vendedorvisita.getempresa_descripcion());	
		vendedorvisitaAsignar.setid_ejercicio(vendedorvisita.getid_ejercicio());
		vendedorvisitaAsignar.setejercicio_descripcion(vendedorvisita.getejercicio_descripcion());	
		vendedorvisitaAsignar.setid_periodo(vendedorvisita.getid_periodo());
		vendedorvisitaAsignar.setperiodo_descripcion(vendedorvisita.getperiodo_descripcion());	
		vendedorvisitaAsignar.setid_vendedor(vendedorvisita.getid_vendedor());
		vendedorvisitaAsignar.setvendedor_descripcion(vendedorvisita.getvendedor_descripcion());	
		vendedorvisitaAsignar.setvisita_real(vendedorvisita.getvisita_real());	
		vendedorvisitaAsignar.setvisita_propuesta(vendedorvisita.getvisita_propuesta());	
		vendedorvisitaAsignar.setid_anio(vendedorvisita.getid_anio());
		vendedorvisitaAsignar.setanio_descripcion(vendedorvisita.getanio_descripcion());	
		vendedorvisitaAsignar.setid_mes(vendedorvisita.getid_mes());
		vendedorvisitaAsignar.setmes_descripcion(vendedorvisita.getmes_descripcion());	
	}
	
	public static void inicializarVendedorVisita(VendedorVisita vendedorvisita) throws Exception {
		try {
				vendedorvisita.setId(0L);	
					
				vendedorvisita.setid_empresa(-1L);	
				vendedorvisita.setid_ejercicio(-1L);	
				vendedorvisita.setid_periodo(-1L);	
				vendedorvisita.setid_vendedor(-1L);	
				vendedorvisita.setvisita_real(0.0);	
				vendedorvisita.setvisita_propuesta(0.0);	
				vendedorvisita.setid_anio(null);	
				vendedorvisita.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVendedorVisita(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_VISITAREAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_VISITAPROPUESTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorVisitaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVendedorVisita(String sTipo,Row row,Workbook workbook,VendedorVisita vendedorvisita,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getvisita_real());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getvisita_propuesta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorvisita.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVendedorVisita=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVendedorVisita() {
		return this.sFinalQueryVendedorVisita;
	}
	
	public void setsFinalQueryVendedorVisita(String sFinalQueryVendedorVisita) {
		this.sFinalQueryVendedorVisita= sFinalQueryVendedorVisita;
	}
	
	public Border resaltarSeleccionarVendedorVisita=null;
	
	public Border setResaltarSeleccionarVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVendedorVisita= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVendedorVisita() {
		return this.resaltarSeleccionarVendedorVisita;
	}
	
	public void setResaltarSeleccionarVendedorVisita(Border borderResaltarSeleccionarVendedorVisita) {
		this.resaltarSeleccionarVendedorVisita= borderResaltarSeleccionarVendedorVisita;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVendedorVisita=null;
	public Boolean mostraridVendedorVisita=true;
	public Boolean activaridVendedorVisita=true;

	public Border resaltarid_empresaVendedorVisita=null;
	public Boolean mostrarid_empresaVendedorVisita=true;
	public Boolean activarid_empresaVendedorVisita=true;
	public Boolean cargarid_empresaVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVendedorVisita=false;//ConEventDepend=true

	public Border resaltarid_ejercicioVendedorVisita=null;
	public Boolean mostrarid_ejercicioVendedorVisita=true;
	public Boolean activarid_ejercicioVendedorVisita=true;
	public Boolean cargarid_ejercicioVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioVendedorVisita=false;//ConEventDepend=true

	public Border resaltarid_periodoVendedorVisita=null;
	public Boolean mostrarid_periodoVendedorVisita=true;
	public Boolean activarid_periodoVendedorVisita=true;
	public Boolean cargarid_periodoVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoVendedorVisita=false;//ConEventDepend=true

	public Border resaltarid_vendedorVendedorVisita=null;
	public Boolean mostrarid_vendedorVendedorVisita=true;
	public Boolean activarid_vendedorVendedorVisita=true;
	public Boolean cargarid_vendedorVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorVendedorVisita=false;//ConEventDepend=true

	public Border resaltarvisita_realVendedorVisita=null;
	public Boolean mostrarvisita_realVendedorVisita=true;
	public Boolean activarvisita_realVendedorVisita=true;

	public Border resaltarvisita_propuestaVendedorVisita=null;
	public Boolean mostrarvisita_propuestaVendedorVisita=true;
	public Boolean activarvisita_propuestaVendedorVisita=true;

	public Border resaltarid_anioVendedorVisita=null;
	public Boolean mostrarid_anioVendedorVisita=true;
	public Boolean activarid_anioVendedorVisita=false;
	public Boolean cargarid_anioVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioVendedorVisita=false;//ConEventDepend=true

	public Border resaltarid_mesVendedorVisita=null;
	public Boolean mostrarid_mesVendedorVisita=true;
	public Boolean activarid_mesVendedorVisita=false;
	public Boolean cargarid_mesVendedorVisita=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesVendedorVisita=false;//ConEventDepend=true

	
	

	public Border setResaltaridVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltaridVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVendedorVisita() {
		return this.resaltaridVendedorVisita;
	}

	public void setResaltaridVendedorVisita(Border borderResaltar) {
		this.resaltaridVendedorVisita= borderResaltar;
	}

	public Boolean getMostraridVendedorVisita() {
		return this.mostraridVendedorVisita;
	}

	public void setMostraridVendedorVisita(Boolean mostraridVendedorVisita) {
		this.mostraridVendedorVisita= mostraridVendedorVisita;
	}

	public Boolean getActivaridVendedorVisita() {
		return this.activaridVendedorVisita;
	}

	public void setActivaridVendedorVisita(Boolean activaridVendedorVisita) {
		this.activaridVendedorVisita= activaridVendedorVisita;
	}

	public Border setResaltarid_empresaVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_empresaVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVendedorVisita() {
		return this.resaltarid_empresaVendedorVisita;
	}

	public void setResaltarid_empresaVendedorVisita(Border borderResaltar) {
		this.resaltarid_empresaVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_empresaVendedorVisita() {
		return this.mostrarid_empresaVendedorVisita;
	}

	public void setMostrarid_empresaVendedorVisita(Boolean mostrarid_empresaVendedorVisita) {
		this.mostrarid_empresaVendedorVisita= mostrarid_empresaVendedorVisita;
	}

	public Boolean getActivarid_empresaVendedorVisita() {
		return this.activarid_empresaVendedorVisita;
	}

	public void setActivarid_empresaVendedorVisita(Boolean activarid_empresaVendedorVisita) {
		this.activarid_empresaVendedorVisita= activarid_empresaVendedorVisita;
	}

	public Boolean getCargarid_empresaVendedorVisita() {
		return this.cargarid_empresaVendedorVisita;
	}

	public void setCargarid_empresaVendedorVisita(Boolean cargarid_empresaVendedorVisita) {
		this.cargarid_empresaVendedorVisita= cargarid_empresaVendedorVisita;
	}

	public Border setResaltarid_ejercicioVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioVendedorVisita() {
		return this.resaltarid_ejercicioVendedorVisita;
	}

	public void setResaltarid_ejercicioVendedorVisita(Border borderResaltar) {
		this.resaltarid_ejercicioVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioVendedorVisita() {
		return this.mostrarid_ejercicioVendedorVisita;
	}

	public void setMostrarid_ejercicioVendedorVisita(Boolean mostrarid_ejercicioVendedorVisita) {
		this.mostrarid_ejercicioVendedorVisita= mostrarid_ejercicioVendedorVisita;
	}

	public Boolean getActivarid_ejercicioVendedorVisita() {
		return this.activarid_ejercicioVendedorVisita;
	}

	public void setActivarid_ejercicioVendedorVisita(Boolean activarid_ejercicioVendedorVisita) {
		this.activarid_ejercicioVendedorVisita= activarid_ejercicioVendedorVisita;
	}

	public Boolean getCargarid_ejercicioVendedorVisita() {
		return this.cargarid_ejercicioVendedorVisita;
	}

	public void setCargarid_ejercicioVendedorVisita(Boolean cargarid_ejercicioVendedorVisita) {
		this.cargarid_ejercicioVendedorVisita= cargarid_ejercicioVendedorVisita;
	}

	public Border setResaltarid_periodoVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_periodoVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoVendedorVisita() {
		return this.resaltarid_periodoVendedorVisita;
	}

	public void setResaltarid_periodoVendedorVisita(Border borderResaltar) {
		this.resaltarid_periodoVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_periodoVendedorVisita() {
		return this.mostrarid_periodoVendedorVisita;
	}

	public void setMostrarid_periodoVendedorVisita(Boolean mostrarid_periodoVendedorVisita) {
		this.mostrarid_periodoVendedorVisita= mostrarid_periodoVendedorVisita;
	}

	public Boolean getActivarid_periodoVendedorVisita() {
		return this.activarid_periodoVendedorVisita;
	}

	public void setActivarid_periodoVendedorVisita(Boolean activarid_periodoVendedorVisita) {
		this.activarid_periodoVendedorVisita= activarid_periodoVendedorVisita;
	}

	public Boolean getCargarid_periodoVendedorVisita() {
		return this.cargarid_periodoVendedorVisita;
	}

	public void setCargarid_periodoVendedorVisita(Boolean cargarid_periodoVendedorVisita) {
		this.cargarid_periodoVendedorVisita= cargarid_periodoVendedorVisita;
	}

	public Border setResaltarid_vendedorVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_vendedorVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorVendedorVisita() {
		return this.resaltarid_vendedorVendedorVisita;
	}

	public void setResaltarid_vendedorVendedorVisita(Border borderResaltar) {
		this.resaltarid_vendedorVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_vendedorVendedorVisita() {
		return this.mostrarid_vendedorVendedorVisita;
	}

	public void setMostrarid_vendedorVendedorVisita(Boolean mostrarid_vendedorVendedorVisita) {
		this.mostrarid_vendedorVendedorVisita= mostrarid_vendedorVendedorVisita;
	}

	public Boolean getActivarid_vendedorVendedorVisita() {
		return this.activarid_vendedorVendedorVisita;
	}

	public void setActivarid_vendedorVendedorVisita(Boolean activarid_vendedorVendedorVisita) {
		this.activarid_vendedorVendedorVisita= activarid_vendedorVendedorVisita;
	}

	public Boolean getCargarid_vendedorVendedorVisita() {
		return this.cargarid_vendedorVendedorVisita;
	}

	public void setCargarid_vendedorVendedorVisita(Boolean cargarid_vendedorVendedorVisita) {
		this.cargarid_vendedorVendedorVisita= cargarid_vendedorVendedorVisita;
	}

	public Border setResaltarvisita_realVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarvisita_realVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvisita_realVendedorVisita() {
		return this.resaltarvisita_realVendedorVisita;
	}

	public void setResaltarvisita_realVendedorVisita(Border borderResaltar) {
		this.resaltarvisita_realVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarvisita_realVendedorVisita() {
		return this.mostrarvisita_realVendedorVisita;
	}

	public void setMostrarvisita_realVendedorVisita(Boolean mostrarvisita_realVendedorVisita) {
		this.mostrarvisita_realVendedorVisita= mostrarvisita_realVendedorVisita;
	}

	public Boolean getActivarvisita_realVendedorVisita() {
		return this.activarvisita_realVendedorVisita;
	}

	public void setActivarvisita_realVendedorVisita(Boolean activarvisita_realVendedorVisita) {
		this.activarvisita_realVendedorVisita= activarvisita_realVendedorVisita;
	}

	public Border setResaltarvisita_propuestaVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarvisita_propuestaVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvisita_propuestaVendedorVisita() {
		return this.resaltarvisita_propuestaVendedorVisita;
	}

	public void setResaltarvisita_propuestaVendedorVisita(Border borderResaltar) {
		this.resaltarvisita_propuestaVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarvisita_propuestaVendedorVisita() {
		return this.mostrarvisita_propuestaVendedorVisita;
	}

	public void setMostrarvisita_propuestaVendedorVisita(Boolean mostrarvisita_propuestaVendedorVisita) {
		this.mostrarvisita_propuestaVendedorVisita= mostrarvisita_propuestaVendedorVisita;
	}

	public Boolean getActivarvisita_propuestaVendedorVisita() {
		return this.activarvisita_propuestaVendedorVisita;
	}

	public void setActivarvisita_propuestaVendedorVisita(Boolean activarvisita_propuestaVendedorVisita) {
		this.activarvisita_propuestaVendedorVisita= activarvisita_propuestaVendedorVisita;
	}

	public Border setResaltarid_anioVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_anioVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioVendedorVisita() {
		return this.resaltarid_anioVendedorVisita;
	}

	public void setResaltarid_anioVendedorVisita(Border borderResaltar) {
		this.resaltarid_anioVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_anioVendedorVisita() {
		return this.mostrarid_anioVendedorVisita;
	}

	public void setMostrarid_anioVendedorVisita(Boolean mostrarid_anioVendedorVisita) {
		this.mostrarid_anioVendedorVisita= mostrarid_anioVendedorVisita;
	}

	public Boolean getActivarid_anioVendedorVisita() {
		return this.activarid_anioVendedorVisita;
	}

	public void setActivarid_anioVendedorVisita(Boolean activarid_anioVendedorVisita) {
		this.activarid_anioVendedorVisita= activarid_anioVendedorVisita;
	}

	public Boolean getCargarid_anioVendedorVisita() {
		return this.cargarid_anioVendedorVisita;
	}

	public void setCargarid_anioVendedorVisita(Boolean cargarid_anioVendedorVisita) {
		this.cargarid_anioVendedorVisita= cargarid_anioVendedorVisita;
	}

	public Border setResaltarid_mesVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorvisitaBeanSwingJInternalFrame.jTtoolBarVendedorVisita.setBorder(borderResaltar);
		
		this.resaltarid_mesVendedorVisita= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesVendedorVisita() {
		return this.resaltarid_mesVendedorVisita;
	}

	public void setResaltarid_mesVendedorVisita(Border borderResaltar) {
		this.resaltarid_mesVendedorVisita= borderResaltar;
	}

	public Boolean getMostrarid_mesVendedorVisita() {
		return this.mostrarid_mesVendedorVisita;
	}

	public void setMostrarid_mesVendedorVisita(Boolean mostrarid_mesVendedorVisita) {
		this.mostrarid_mesVendedorVisita= mostrarid_mesVendedorVisita;
	}

	public Boolean getActivarid_mesVendedorVisita() {
		return this.activarid_mesVendedorVisita;
	}

	public void setActivarid_mesVendedorVisita(Boolean activarid_mesVendedorVisita) {
		this.activarid_mesVendedorVisita= activarid_mesVendedorVisita;
	}

	public Boolean getCargarid_mesVendedorVisita() {
		return this.cargarid_mesVendedorVisita;
	}

	public void setCargarid_mesVendedorVisita(Boolean cargarid_mesVendedorVisita) {
		this.cargarid_mesVendedorVisita= cargarid_mesVendedorVisita;
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
		
		
		this.setMostraridVendedorVisita(esInicial);
		this.setMostrarid_empresaVendedorVisita(esInicial);
		this.setMostrarid_ejercicioVendedorVisita(esInicial);
		this.setMostrarid_periodoVendedorVisita(esInicial);
		this.setMostrarid_vendedorVendedorVisita(esInicial);
		this.setMostrarvisita_realVendedorVisita(esInicial);
		this.setMostrarvisita_propuestaVendedorVisita(esInicial);
		this.setMostrarid_anioVendedorVisita(esInicial);
		this.setMostrarid_mesVendedorVisita(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.ID)) {
				this.setMostraridVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAREAL)) {
				this.setMostrarvisita_realVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAPROPUESTA)) {
				this.setMostrarvisita_propuestaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesVendedorVisita(esAsigna);
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
		
		
		this.setActivaridVendedorVisita(esInicial);
		this.setActivarid_empresaVendedorVisita(esInicial);
		this.setActivarid_ejercicioVendedorVisita(esInicial);
		this.setActivarid_periodoVendedorVisita(esInicial);
		this.setActivarid_vendedorVendedorVisita(esInicial);
		this.setActivarvisita_realVendedorVisita(esInicial);
		this.setActivarvisita_propuestaVendedorVisita(esInicial);
		this.setActivarid_anioVendedorVisita(esInicial);
		this.setActivarid_mesVendedorVisita(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.ID)) {
				this.setActivaridVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAREAL)) {
				this.setActivarvisita_realVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAPROPUESTA)) {
				this.setActivarvisita_propuestaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDMES)) {
				this.setActivarid_mesVendedorVisita(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVendedorVisita(esInicial);
		this.setResaltarid_empresaVendedorVisita(esInicial);
		this.setResaltarid_ejercicioVendedorVisita(esInicial);
		this.setResaltarid_periodoVendedorVisita(esInicial);
		this.setResaltarid_vendedorVendedorVisita(esInicial);
		this.setResaltarvisita_realVendedorVisita(esInicial);
		this.setResaltarvisita_propuestaVendedorVisita(esInicial);
		this.setResaltarid_anioVendedorVisita(esInicial);
		this.setResaltarid_mesVendedorVisita(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.ID)) {
				this.setResaltaridVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAREAL)) {
				this.setResaltarvisita_realVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.VISITAPROPUESTA)) {
				this.setResaltarvisita_propuestaVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioVendedorVisita(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorVisitaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesVendedorVisita(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioVendedorVisita=true;

	public Boolean getMostrarFK_IdEjercicioVendedorVisita() {
		return this.mostrarFK_IdEjercicioVendedorVisita;
	}

	public void setMostrarFK_IdEjercicioVendedorVisita(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioVendedorVisita= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVendedorVisita=true;

	public Boolean getMostrarFK_IdEmpresaVendedorVisita() {
		return this.mostrarFK_IdEmpresaVendedorVisita;
	}

	public void setMostrarFK_IdEmpresaVendedorVisita(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVendedorVisita= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorVendedorVisita=true;

	public Boolean getMostrarFK_IdVendedorVendedorVisita() {
		return this.mostrarFK_IdVendedorVendedorVisita;
	}

	public void setMostrarFK_IdVendedorVendedorVisita(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorVendedorVisita= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioVendedorVisita=true;

	public Boolean getActivarFK_IdEjercicioVendedorVisita() {
		return this.activarFK_IdEjercicioVendedorVisita;
	}

	public void setActivarFK_IdEjercicioVendedorVisita(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioVendedorVisita= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVendedorVisita=true;

	public Boolean getActivarFK_IdEmpresaVendedorVisita() {
		return this.activarFK_IdEmpresaVendedorVisita;
	}

	public void setActivarFK_IdEmpresaVendedorVisita(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVendedorVisita= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorVendedorVisita=true;

	public Boolean getActivarFK_IdVendedorVendedorVisita() {
		return this.activarFK_IdVendedorVendedorVisita;
	}

	public void setActivarFK_IdVendedorVendedorVisita(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorVendedorVisita= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioVendedorVisita=null;

	public Border getResaltarFK_IdEjercicioVendedorVisita() {
		return this.resaltarFK_IdEjercicioVendedorVisita;
	}

	public void setResaltarFK_IdEjercicioVendedorVisita(Border borderResaltar) {
		this.resaltarFK_IdEjercicioVendedorVisita= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioVendedorVisita= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVendedorVisita=null;

	public Border getResaltarFK_IdEmpresaVendedorVisita() {
		return this.resaltarFK_IdEmpresaVendedorVisita;
	}

	public void setResaltarFK_IdEmpresaVendedorVisita(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVendedorVisita= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVendedorVisita= borderResaltar;
	}

	public Border resaltarFK_IdVendedorVendedorVisita=null;

	public Border getResaltarFK_IdVendedorVendedorVisita() {
		return this.resaltarFK_IdVendedorVendedorVisita;
	}

	public void setResaltarFK_IdVendedorVendedorVisita(Border borderResaltar) {
		this.resaltarFK_IdVendedorVendedorVisita= borderResaltar;
	}

	public void setResaltarFK_IdVendedorVendedorVisita(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorVisitaBeanSwingJInternalFrame vendedorvisitaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorVendedorVisita= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}